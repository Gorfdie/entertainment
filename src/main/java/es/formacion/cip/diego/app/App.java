package es.formacion.cip.diego.app;

import es.formacion.cip.diego.controller.HibernateUtil;
import es.formacion.cip.diego.controller.Utilidades;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {
        //Vamos a cambiar el proyecto
    public static void main (String...args){
        Session session = HibernateUtil.getSession();
        Transaction tx = null;

        try {

            Utilidades.addFilm("Pieles", "08/02/2018", 3.8);
            Utilidades.addFilm("Star Wars ", "28/12/2017", 8);
            Utilidades.addFilm("Geostorm", "08/02/2018", 6.5);
            Utilidades.addFilm("Crudo", "08/02/2018", 7);

            Utilidades.addSerie("Breaking bad", "hoy", 8, 2);

            Utilidades.listTable("Films");
            Utilidades.listTable("Series");


        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            HibernateUtil.shutdown();
        }

    }


}
