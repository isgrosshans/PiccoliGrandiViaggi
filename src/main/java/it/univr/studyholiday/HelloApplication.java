package it.univr.studyholiday;

import it.univr.studyholiday.view.LoginView;
import it.univr.studyholiday.view.SingleStage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = LoginView.getFxmlLoader();
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Glossa");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException {
        launch();
        //start(SingleStage.getInstance().stage);
    }
}