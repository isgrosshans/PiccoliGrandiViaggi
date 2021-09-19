package it.univr.studyholiday.view;

import it.univr.studyholiday.HelloApplication;
import javafx.fxml.FXMLLoader;

public class LoginView {
    private static FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login-view.fxml"));

    public static FXMLLoader getFxmlLoader() {
        return fxmlLoader;
    }
}
