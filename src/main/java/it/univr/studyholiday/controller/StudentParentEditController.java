package it.univr.studyholiday.controller;

import it.univr.studyholiday.pgvApplication;
import it.univr.studyholiday.model.User;
import it.univr.studyholiday.model.entities.Parent;
import it.univr.studyholiday.util.Database.FetchFromDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StudentParentEditController implements Initializable {
    @FXML private TextField EmailTextField;
    @FXML private TextField FirstNameTextField;
    @FXML private TextField LastnameTextField;
    @FXML private TextField PhoneTextField;
    @FXML private TextField EmailTextField1;
    @FXML private TextField FirstNameTextField1;
    @FXML private TextField LastnameTextField1;
    @FXML private TextField PhoneTextField1;
    @FXML private Label ErrorMessage;

    ArrayList<Parent> parents=new ArrayList<>();

    public void CancelButtonClick(ActionEvent actionEvent) throws IOException {
        pgvApplication.setRoot("StudentProfile");
    }

    public void ConfirmButtonClick(ActionEvent actionEvent) throws IOException {
        if(parents.size()==2){
            if (EmailTextField.getText().isBlank() ||
                FirstNameTextField.getText().isBlank() ||
                LastnameTextField.getText().isBlank() ||
                PhoneTextField.getText().isBlank() ||
                EmailTextField1.getText().isBlank() ||
                FirstNameTextField1.getText().isBlank() ||
                LastnameTextField1.getText().isBlank() ||
                PhoneTextField1.getText().isBlank()){
                ErrorMessage.setText("Non lasciare campi vuoti");
            }
            else{
                //todo update table
                pgvApplication.setRoot("StudentProfile");
            }
        }
        if(parents.size()==1){
            if (!EmailTextField.getText().isBlank() &&          //parent 1 all filled
                    !FirstNameTextField.getText().isBlank() &&
                    !LastnameTextField.getText().isBlank() &&
                    !PhoneTextField.getText().isBlank()){
                if (EmailTextField1.getText().isBlank() &&      //parent 2 all blank
                    FirstNameTextField1.getText().isBlank() &&
                    LastnameTextField1.getText().isBlank() &&
                    PhoneTextField1.getText().isBlank()){
                    //update parent 1
                    pgvApplication.setRoot("StudentProfile");
                }
                else if(!EmailTextField1.getText().isBlank() &&      //parent 2 all filled
                        !FirstNameTextField1.getText().isBlank() &&
                        !LastnameTextField1.getText().isBlank() &&
                        !PhoneTextField1.getText().isBlank()){
                    //update parent 1 and insert parent 2
                    pgvApplication.setRoot("StudentProfile");
                }
                else ErrorMessage.setText("Compilare tutti i campi (o svuotarli sul secondo genitore)");
            }
            else ErrorMessage.setText("Compilare tutti i campi (o svuotarli sul secondo genitore)");

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            parents= FetchFromDB.Parents(User.getCurrentStudent().getParent1id(), User.getCurrentStudent().getParent2id());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        EmailTextField.setText(parents.get(0).getEmail());
        FirstNameTextField.setText(parents.get(0).getFirstName());
        LastnameTextField.setText(parents.get(0).getLastName());
        PhoneTextField.setText(parents.get(0).getPhone());

        if(parents.size()==2) {
            EmailTextField1.setText(parents.get(1).getEmail());
            FirstNameTextField1.setText(parents.get(1).getFirstName());
            LastnameTextField1.setText(parents.get(1).getLastName());
            PhoneTextField1.setText(parents.get(1).getPhone());
        }
    }
}
