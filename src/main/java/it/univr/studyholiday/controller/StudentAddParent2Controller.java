package it.univr.studyholiday.controller;

import it.univr.studyholiday.GlossaApplication;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentAddParent2Controller implements Initializable {
    public TextField EmailTextField;
    public TextField FirstNameTextField;
    public TextField LastNameTextField;
    public TextField PhoneTextField;
    public Label ErrorMessage;

    public void CancelButtonClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("Login");
    }

    public void ConfirmButtonClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StudentHome");
    }

    public void ReturnButtonClick(ActionEvent actionEvent) throws IOException {
        //todo remove
    }

    private Boolean allFilled(){
        if(EmailTextField.getText().isBlank()||
                FirstNameTextField.getText().isBlank()||
                LastNameTextField.getText().isBlank()||
                PhoneTextField.getText().isBlank()
        ){
            ErrorMessage.setText("Compilare tutti i campi.");
            return false;
        }
        else
            return true;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
