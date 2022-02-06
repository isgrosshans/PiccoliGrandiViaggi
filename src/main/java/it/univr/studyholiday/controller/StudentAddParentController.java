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

public class StudentAddParentController implements Initializable {
    public TextField EmailTextField;
    public TextField FirstNameTextField;
    public TextField LastNameTextField;
    public TextField PhoneTextField;
    public Label ErrorMessage;

    private static Student student;
    public static void setStudent(Student student) {
        StudentAddParentController.student = student;
    }

    private static ArrayList<Allergy> allergies;
    public static void setAllergies(ArrayList<Allergy> allergies) {
        StudentAddParentController.allergies = allergies;
    }

    public void CancelButtonClick(ActionEvent actionEvent) throws IOException {
        pgvApplication.setRoot("Login");
    }

    public void AddParentButtonClick(ActionEvent actionEvent) throws IOException {
        if(allFilled()) {
            if (FetchFromDB.parentInfoConflict(new Parent(EmailTextField.getText(), FirstNameTextField.getText(), LastNameTextField.getText(), PhoneTextField.getText()))) {
                ErrorMessage.setText("Le informazioni sono in conflitto con il nostro database.");
            } else {
                    StudentAddParent2Controller.setStudent(student);
                StudentAddParent2Controller.setAllergies(allergies);
                StudentAddParent2Controller.setParent1(new Parent(EmailTextField.getText(), FirstNameTextField.getText(), LastNameTextField.getText(), PhoneTextField.getText()));
                pgvApplication.setRoot("StudentAddParent2");
            }
        }
    }

    public void ConfirmButtonClick(ActionEvent actionEvent) throws IOException {
        if(allFilled()){
            if(FetchFromDB.parentInfoConflict(new Parent(EmailTextField.getText(), FirstNameTextField.getText(), LastNameTextField.getText(), PhoneTextField.getText()))){
                ErrorMessage.setText("Le informazioni sono in conflitto con il nostro database.");
            }
            else {
                SaveToDB.registerStudent(student, new Parent(EmailTextField.getText(), FirstNameTextField.getText(), LastNameTextField.getText(), PhoneTextField.getText()), null, allergies);
                pgvApplication.setRoot("Login");
            }
        }
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
