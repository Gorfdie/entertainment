package es.formacion.cip.diego;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class App extends Application {
        //Vamos a cambiar el proyecto
    public static void main (String...args){
        launch(args);
        /*
        Session session = HibernateUtil.getSession();
        Transaction tx = null;


        try {
            launch(args);

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
*/
    }


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/es/formacion/cip/diego/view/View.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

}

