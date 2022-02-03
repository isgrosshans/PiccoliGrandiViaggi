package it.univr.studyholiday.controller;

import it.univr.studyholiday.pgvApplication;
//import it.univr.studyholiday.model.UserType;
import it.univr.studyholiday.model.User;
//import it.univr.studyholiday.util.Database.Fetch;
import it.univr.studyholiday.util.Database.LoginDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {
    @FXML private TextField Email;
    @FXML private PasswordField Password;
//    @FXML private Button signUpButton;
//    @FXML private Button loginButton;
    @FXML private Label loginFailedMessage;



    public void loginButtonAction() throws IOException {
        System.out.println(Password.getText());
        String psw = Password.getText();

        User.setCurrentUser(LoginDB.login(Email.getText(), Password.getText()));

        if(User.isNull()) loginFailedMessage.setVisible(true);
        else if (User.isStaff()) pgvApplication.setRoot("StaffHome");
        else pgvApplication.setRoot("StudentHome");
//
//        //UserType.setMode();
//        if (LoginUtil.emailIsAdmin(Email.getText())) {
//            if(Database.adminLogin(Email.getText(), psw)) {
//                //UserType.setMode(Fetch.travelAgent(Email.getText()));
//
//                pgvApplication.setRoot("StaffHome");
//                System.out.println("staff log in successful");
//            }
//            else loginFailedMessage.setVisible(true);
//        }
//
//        else {
//            if (Database.studentLogin(Email.getText(), psw)) {
//                //UserType.setMode(Fetch.student(Email.getText()));
//
//                pgvApplication.setRoot("student_menu_view_OLD");
//            }
//            else loginFailedMessage.setVisible(true);
//
//        }
    }

    public void registrationButtonAction() throws IOException {
        pgvApplication.setRoot("StudentRegistration1");
    }

    public void exitButtonAction(ActionEvent actionEvent) {

    }
}
