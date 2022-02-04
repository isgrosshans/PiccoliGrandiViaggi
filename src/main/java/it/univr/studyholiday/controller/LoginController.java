package it.univr.studyholiday.controller;

import it.univr.studyholiday.pgvApplication;
//import it.univr.studyholiday.model.UserType;
import it.univr.studyholiday.model.User;
//import it.univr.studyholiday.util.Database.Fetch;
import it.univr.studyholiday.util.Database.LoginDB;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {
    @FXML private TextField Email;
    @FXML private PasswordField Password;
    @FXML private Label loginFailedMessage;



    public void loginButtonAction() throws IOException {
        User.setCurrentUser(LoginDB.login(Email.getText(), Password.getText()));

        if(User.isNull()) loginFailedMessage.setVisible(true);
        else if (User.isStaff()) pgvApplication.setRoot("StaffHome");
        else pgvApplication.setRoot("StudentHome");
    }

    public void registrationButtonAction() throws IOException {
        pgvApplication.setRoot("StudentRegistration1");
    }

    public void exitButtonAction(ActionEvent actionEvent) {
        pgvApplication.close();
    }
}
