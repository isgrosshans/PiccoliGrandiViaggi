package it.univr.studyholiday.controller;

import it.univr.studyholiday.GlossaApplication;
import it.univr.studyholiday.model.entities.Allergy;
import it.univr.studyholiday.model.entities.Parent;
import it.univr.studyholiday.model.entities.Student;
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

    private static Parent parent1;

    public static void setParent1(Parent parent1) {
        StudentAddParentController.parent1 = parent1;
    }

    private static ArrayList<Allergy> allergies;
    public static void setAllergies(ArrayList<Allergy> allergies) {
        StudentAddParentController.allergies = allergies;
    }

    public void CancelButtonClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("Login");
    }

    public void AddParentButtonClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StudentAddParent2");
    }

    public void ConfirmButtonClick(ActionEvent actionEvent) throws IOException {
        if(allFilled()){
            //save with both parents
        }
        GlossaApplication.setRoot("StudentHome");
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
