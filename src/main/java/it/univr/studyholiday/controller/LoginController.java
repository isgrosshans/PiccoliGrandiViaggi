package it.univr.studyholiday.controller;

import it.univr.studyholiday.model.UserType;
import it.univr.studyholiday.util.Database.Database;
import it.univr.studyholiday.util.Database.Fetch;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

import it.univr.studyholiday.util.LoginUtil;

public class LoginController {
    @FXML private TextField email;
    @FXML private PasswordField password;
    @FXML private Button signUpButton;
    @FXML private Button loginButton;
    @FXML private Label message;

    public void loginClick(){
        //TODO email
        if(LoginUtil.emailIsAdmin(email.getText())){
            if(Database.adminLogin(email.getText(), LoginUtil.encrypy(password.getText()))) {
                UserType.setMode(Fetch.travelAgent(email.getText()));

                //TODO
                //Go to next page
            }
            else message.setText("Email o password errata");
        }
        else{
            if(Database.studentLogin(email.getText(), LoginUtil.encrypy(password.getText()))){
                UserType.setMode(Fetch.student(email.getText()));

                //TODO
                //Go to next page
            }
            else message.setText("Email o password errata");

        }
    }

    public void signUpClick(){
        //TODO
        //Go to sign up page

    }

}
