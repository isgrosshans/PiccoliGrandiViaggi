package it.univr.studyholiday.controller;

import it.univr.studyholiday.model.User;
import it.univr.studyholiday.pgvApplication;
import it.univr.studyholiday.util.Database.LoginDB;
import it.univr.studyholiday.util.Database.UpdateDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentEmailPswEditController implements Initializable {
    @FXML private TextField EmailTextField;
    @FXML private PasswordField OldPswField;
    @FXML private PasswordField NewPswField;
    @FXML private PasswordField ConfirmNewPswField;
    @FXML private Label ErrorMessage;

    public void CancelButtonClick(ActionEvent actionEvent) throws IOException {
        pgvApplication.setRoot("StudentProfile");
    }

    public void ConfirmButtonClick(ActionEvent actionEvent) throws IOException {
        if (EmailTextField.getText().isBlank()){
            ErrorMessage.setText("Compilare campo email.");
        } //email filled
        else if (!EmailTextField.getText().matches("^(.+)@(.+)$")){
            ErrorMessage.setText("Inserire un indirizzo email valido.");
        } //and email matched regex
        else if(EmailTextField.getText().equals("@pgv.it")){
            ErrorMessage.setText("NO");
        }
        else if (OldPswField.getText().isBlank()
                && NewPswField.getText().isBlank()
                && ConfirmNewPswField.getText().isBlank()){
            UpdateDB.editEmail(User.getCurrentStudent(), EmailTextField.getText());
        } //and user wants to fuck with the password
        else {
            if (OldPswField.getText().isBlank()){
                ErrorMessage.setText("Inserire vecchia password.");
            }
            else if (NewPswField.getText().isBlank() || ConfirmNewPswField.getText().isBlank()){
                ErrorMessage.setText("Inserire nuova password due volte.");
            }
            else if (!NewPswField.getText().equals(ConfirmNewPswField.getText())){
                ErrorMessage.setText("Conferma password non coincide con password.");
            }
            else if(NewPswField.getText().length()<8){
                ErrorMessage.setText("La password deve essere lunga almeno 8 caratteri.");
            }
            else if (LoginDB.checkPsw(OldPswField.getText())
                    && NewPswField.getText().equals(ConfirmNewPswField.getText())){
                UpdateDB.editEmailAndPassword(User.getCurrentStudent(), EmailTextField.getText(), NewPswField.getText() );
                pgvApplication.setRoot("StudentProfile");
            }
            else ErrorMessage.setText("Errore.");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        EmailTextField.setText(User.getCurrentStudent().getEmail());
    }
}
