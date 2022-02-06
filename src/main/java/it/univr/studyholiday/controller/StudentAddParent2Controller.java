package it.univr.studyholiday.controller;

import it.univr.studyholiday.pgvApplication;
import it.univr.studyholiday.model.entities.Allergy;
import it.univr.studyholiday.model.entities.Parent;
import it.univr.studyholiday.model.entities.Student;
import it.univr.studyholiday.util.Database.FetchFromDB;
import it.univr.studyholiday.util.Database.SaveToDB;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StudentAddParent2Controller implements Initializable {
    public TextField EmailTextField;
    public TextField FirstNameTextField;
    public TextField LastNameTextField;
    public TextField PhoneTextField;
    public Label ErrorMessage;


    private static Student student;
    public static void setStudent(Student student) {
        StudentAddParent2Controller.student = student;
    }

    private static ArrayList<Allergy> allergies;
    public static void setAllergies(ArrayList<Allergy> allergies) {
        StudentAddParent2Controller.allergies = allergies;
    }

    private static Parent parent1;
    public static void setParent1(Parent parent1) {
        StudentAddParent2Controller.parent1 = parent1;
    }

    private static Parent parent2=null;

    public void CancelButtonClick(ActionEvent actionEvent) throws IOException {
        pgvApplication.setRoot("Login");
    }

    public void ConfirmButtonClick(ActionEvent actionEvent) throws IOException {
        if(allFilled()) {
            parent2=new Parent(EmailTextField.getText(), FirstNameTextField.getText(), LastNameTextField.getText(), PhoneTextField.getText());
            if(parent2.sameAs(parent1)){
                ErrorMessage.setText("Hai già inserito le informazioni di questo genitore.");
            }
            else if (parent2.getEmail().equals(parent1.getEmail())){
                ErrorMessage.setText("Non puoi inserire la stessa email per entrambi i genitori.");
            }
            else if (FetchFromDB.parentInfoConflict(parent2)){
                ErrorMessage.setText("Le informazioni sono in conflitto con il nostro database.");
            }
            else{
                SaveToDB.registerStudent(student,parent1,parent2,allergies);
                pgvApplication.setRoot("Login");
            }
        }
        if(allBlank()){
            SaveToDB.registerStudent(student,parent1,null,allergies);
            pgvApplication.setRoot("Login");
        }
    }

    private boolean allBlank() {
        return (EmailTextField.getText().isBlank() &&
                FirstNameTextField.getText().isBlank() &&
                LastNameTextField.getText().isBlank() &&
                PhoneTextField.getText().isBlank());
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
