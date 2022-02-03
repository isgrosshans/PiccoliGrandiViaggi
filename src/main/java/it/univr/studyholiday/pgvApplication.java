package it.univr.studyholiday;


import it.univr.studyholiday.util.Database.FetchFromDB;
import it.univr.studyholiday.model.entities.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

import java.io.IOException;

public class pgvApplication extends Application {

    private static Scene scene;
    private static ScrollPane scrollPane;
    private static Stage appStage;

    public static void close() {
        appStage.close();
    }

    @Override
    public void start(Stage stage) throws IOException, IllegalAccessException {
        this.appStage=stage;
        scene = new Scene(new ScrollPane(loadFXML("Login")), 605, 600);
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
        var fxmlLoader = new FXMLLoader(pgvApplication.class.getResource(fxml + "-view.fxml"));
        return fxmlLoader.load();
    }



}