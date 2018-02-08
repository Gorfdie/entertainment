package es.formacion.cip.diego.entertainment;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Iterator;
import java.util.List;

public class Utilidades {
    /* Method to CREATE an film in the database */
    public static void addFilm(String name, String date, double rate){
        Session session = HibernateUtil.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Films alumno = new Films(name, date, rate);
            session.save(alumno);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to  READ all the films */
    public static void listTable(String table){
        Session session = HibernateUtil.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List tables = session.createQuery("FROM "+ table).list();
            System.out.println("-----------------------------------------------");
            for (Iterator iterator = tables.iterator(); iterator.hasNext();){
                Films film = (Films) iterator.next();
                System.out.print("| Nombre: " + film.getName());
                System.out.print("| Puntuación: " + film.getRate());
                System.out.println(" | Fecha: " + film.getDate()+" |");

            }
            System.out.println("-----------------------------------------------");
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to UPDATE name for an Film */
    public static void updateAlumno(Integer ID, String name ){
        Session session = HibernateUtil.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Films film = (Films) session.get(Films.class, ID);
            film.setName( name );
            session.update(film);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to DELETE an Film from the records */
    public static void deleteAlumno(Integer ID){
        Session session = HibernateUtil.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Films film = (Films) session.get(Films.class, ID);
            session.delete(film);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
