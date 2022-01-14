package it.univr.studyholiday;

import it.univr.studyholiday.model.Address;
import it.univr.studyholiday.model.College;
import it.univr.studyholiday.model.Holiday;
import it.univr.studyholiday.model.TravelAgent;
import it.univr.studyholiday.util.Database.Add;
import it.univr.studyholiday.util.Database.Fetch;
import it.univr.studyholiday.util.LoginUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class GlossaApplication extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = LoginView.getFxmlLoader();
        //scene = new Scene(loadFXML("Login-view"), 600, 430);
        scene = new Scene(loadFXML("StaffSchools-view"), 600, 430);

        stage.setTitle("Piccoli Grandi Viaggi");
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }

    public static void main(String[] args) throws IOException {
        launch();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        var fxmlLoader = new FXMLLoader(GlossaApplication.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }



}