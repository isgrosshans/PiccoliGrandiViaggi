package it.univr.studyholiday.controller;

import it.univr.studyholiday.GlossaApplication;
import it.univr.studyholiday.model.UserType;
import it.univr.studyholiday.util.Database.Database;
import it.univr.studyholiday.util.Database.Fetch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

import it.univr.studyholiday.util.LoginUtil;

public class LoginController {
    @FXML private TextField Email;
    @FXML private PasswordField Password;
//    @FXML private Button signUpButton;
//    @FXML private Button loginButton;
    @FXML private Label loginFailedMessage;



    public void loginButtonAction() throws IOException {
        System.out.println(Password.getText());

        String psw = LoginUtil.encrypy(Password.getText());

        UserType.setMode();
        if (LoginUtil.emailIsAdmin(Email.getText())) {
            if(Database.adminLogin(Email.getText(), psw)) {
                //UserType.setMode(Fetch.travelAgent(Email.getText()));

                GlossaApplication.setRoot("staffHome-view");
                System.out.println("staff log in successful");
            }
            else loginFailedMessage.setVisible(true);
        }

        else {
            if (Database.studentLogin(Email.getText(), psw)) {
                //UserType.setMode(Fetch.student(Email.getText()));

                GlossaApplication.setRoot("student_menu_view_OLD");
            }
            else loginFailedMessage.setVisible(true);

        }
    }

    public void registratiButtonAction() throws IOException {
        GlossaApplication.setRoot("signup-view");
    }

    public void exitButtonAction(ActionEvent actionEvent) {

    }
}
