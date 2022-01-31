package it.univr.studyholiday;


import it.univr.studyholiday.util.Database.LoginDB;
import it.univr.studyholiday.util.Database.SaveToDB;
import it.univr.studyholiday.model.entities.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class GlossaApplication extends Application {

    private static Scene scene;
    private static ScrollPane scrollPane;

    @Override
    public void start(Stage stage) throws IOException, IllegalAccessException {
////        FXMLLoader fxmlLoader = LoginView.getFxmlLoader();
//        Student stud = new Student("afdsafd","asdf","afdsafd","afdsafd", LocalDate.of(2016, 9, 23),"afdsafd","afdsafd","afdsafd","afdsafd","afdsafd","afdsafd");
//        System.out.println(SaveToDB.getValuesFor(stud));

//        Student boi = new Student ("giovi@mail.it","giovanni", "Giovanni", "Cerva", LocalDate.of(2006, 10, 10), "M", "via Roma 1, Verona", "", "calcio, lego", "0", "0");
//        SaveToDB.insert(boi);

//        SaveToDB.insert(new Staff("ilaria@pgv.it","ilaria","Ilaria","Piccoli","348784524"));
//        SaveToDB.insert(new it.univr.studyholiday.model.entities.Parent("annarossi@posta.it", "Anna", "Rossi", "3401234567"));
//        SaveToDB.insert(new Student("marcobianchi@posta.it","marcobianchi",
//                "marco","bianchi",LocalDate.of(2007,5,7),
//                "M","via Roma 1, 1234 Cittadina","","nuoto, film, chitarra",1));
        //scene = new Scene(loadFXML("Login"), 600, 430);
        scene = new Scene(new ScrollPane(loadFXML("Login")), 605, 600);

        //scrollPane.setContent(loadFXML("StaffSchools"));

        stage.setTitle("Piccoli Grandi Viaggi");

        stage.setScene(scene);
        stage.setResizable(false);
        stage.setMinWidth(610);
        stage.show();
    }

    public static void main(String[] args) throws IOException {
        launch();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(new ScrollPane(loadFXML(fxml)));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        var fxmlLoader = new FXMLLoader(GlossaApplication.class.getResource(fxml + "-view.fxml"));
        return fxmlLoader.load();
    }



}