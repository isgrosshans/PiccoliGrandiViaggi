package it.univr.studyholiday;


import it.univr.studyholiday.model.*;
import it.univr.studyholiday.util.Database.Add;
import it.univr.studyholiday.util.Database.Fetch;
import it.univr.studyholiday.util.LoginUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class GlossaApplication extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = LoginView.getFxmlLoader();
//        scene = new Scene(loadFXML("Login-view"), 600, 430);
//
//        stage.setTitle("Piccoli Grandi Viaggi");
//        stage.setScene(scene);
//        stage.setResizable(true);
//        stage.show();

        //////////////////////////////////////////////////////////////////
        TableView tableView = new TableView();

        TableColumn<School, String> column1 = new TableColumn<>("First Name");
        column1.setCellValueFactory(new PropertyValueFactory<>("firstName"));


        TableColumn<School, String> column2 = new TableColumn<>("Last Name");
        column2.setCellValueFactory(new PropertyValueFactory<>("lastName"));


        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);

        tableView.getItems().add(new School("a", "a", "a"));
        tableView.getItems().add(new School("b", "b", "b"));

        VBox vbox = new VBox(tableView);

        scene = new Scene(vbox);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
        //////////////////////////////////////////////////////////////////


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