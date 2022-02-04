package it.univr.studyholiday.controller;

import it.univr.studyholiday.pgvApplication;
import it.univr.studyholiday.model.User;
import it.univr.studyholiday.model.entities.Parent;
import it.univr.studyholiday.util.Database.FetchFromDB;
import it.univr.studyholiday.util.Database.SaveToDB;
import it.univr.studyholiday.util.Database.UpdateTable;
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
    @FXML private TextField EmailTextField2;
    @FXML private TextField FirstNameTextField2;
    @FXML private TextField LastnameTextField2;
    @FXML private TextField PhoneTextField2;
    @FXML private Label ErrorMessage;
    
    private static Parent parent1;
    public static void setParent1(Parent p){parent1=p;}
    private static Parent parent2;
    private static boolean parent2bool=false;
    public static void setParent2(Parent p){
        parent2=p;
        parent2bool=true;}

    public void CancelButtonClick(ActionEvent actionEvent) throws IOException {
        pgvApplication.setRoot("StudentProfile");
    }

    public void ConfirmButtonClick(ActionEvent actionEvent) throws IOException {
        if(parent2bool){
            if (parent1AllFilled() && parent2AllFilled()){
                //update both parents
                UpdateTable.editParent(new Parent(parent1.getId(),EmailTextField.getText(),
                        FirstNameTextField.getText(),
                        LastnameTextField.getText(),
                        PhoneTextField.getText()));
                UpdateTable.editParent(new Parent(parent2.getId(),EmailTextField2.getText(),
                        FirstNameTextField2.getText(),
                        LastnameTextField2.getText(),
                        PhoneTextField2.getText()));
                pgvApplication.setRoot("StudentProfile");
            }
        }
        else{
            if(parent1AllFilled() && parent2AllBlank()){
                //update parent 1
                UpdateTable.editParent(new Parent(parent1.getId(),EmailTextField.getText(),
                        FirstNameTextField.getText(),
                        LastnameTextField.getText(),
                        PhoneTextField.getText()));
                pgvApplication.setRoot("StudentProfile");
            }
            if (parent1AllFilled() && parent2AllFilled()){
                //update parent 1 and add parent 2
                UpdateTable.editParent(new Parent(parent1.getId(),EmailTextField.getText(),
                        FirstNameTextField.getText(),
                        LastnameTextField.getText(),
                        PhoneTextField.getText()));
                SaveToDB.insertParent(new Parent(EmailTextField2.getText(),
                        FirstNameTextField2.getText(),
                        LastnameTextField2.getText(),
                        PhoneTextField2.getText()));
                pgvApplication.setRoot("StudentProfile");
            }
        }
        ErrorMessage.setText("Errore inserimento dati");

    }

    private boolean parent1AllFilled(){
        return !(EmailTextField.getText().isBlank() ||
                FirstNameTextField.getText().isBlank() ||
                LastnameTextField.getText().isBlank() ||
                PhoneTextField.getText().isBlank());
    }

    private boolean parent2AllFilled(){
        return !(EmailTextField2.getText().isBlank() ||
                FirstNameTextField2.getText().isBlank() ||
                LastnameTextField2.getText().isBlank() ||
                PhoneTextField2.getText().isBlank());
    }

    private boolean parent2AllBlank(){
        return (EmailTextField2.getText().isBlank() &&
                FirstNameTextField2.getText().isBlank() &&
                LastnameTextField2.getText().isBlank() &&
                PhoneTextField2.getText().isBlank());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        EmailTextField.setText(parent1.getEmail());
        FirstNameTextField.setText(parent1.getFirstName());
        LastnameTextField.setText(parent1.getLastName());
        PhoneTextField.setText(parent1.getPhone());

        if(parent2bool) {
            EmailTextField2.setText(parent2.getEmail());
            FirstNameTextField2.setText(parent2.getFirstName());
            LastnameTextField2.setText(parent2.getLastName());
            PhoneTextField2.setText(parent2.getPhone());
        }
        else
        {
            EmailTextField2.setText("");
            FirstNameTextField2.setText("");
            LastnameTextField2.setText("");
            PhoneTextField2.setText("");
        }
    }
}
