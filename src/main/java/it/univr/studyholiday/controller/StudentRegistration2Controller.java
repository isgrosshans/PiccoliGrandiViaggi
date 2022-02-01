package it.univr.studyholiday.controller;

import it.univr.studyholiday.GlossaApplication;
import it.univr.studyholiday.model.entities.Allergy;
import it.univr.studyholiday.model.entities.Student;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StudentRegistration2Controller implements Initializable {
    @FXML private TextField AllergenTextField;
    @FXML private  TextField PrecautionTextField;
    @FXML private  Button AddButton;
    @FXML private  TableView<Allergy> AllergensTableView;
    @FXML private  TableColumn<Allergy,String> AllergensColumn;
    @FXML private  TableColumn<Allergy,String> PrecautionsColumn;

    private ArrayList<Allergy>  allergies;

    private static Student student;
    public static void setStudent(Student student) {
        StudentRegistration2Controller.student = student;
    }

    public void ReturnButtonClick(ActionEvent actionEvent) throws IOException {
        //todo remove
    }

    public void AddButtonClick(ActionEvent actionEvent) {
        if(!AllergenTextField.getText().isBlank()){
            allergies.add(new Allergy(AllergenTextField.getText(), PrecautionTextField.getText()));
            AllergensTableView.setItems(FXCollections.observableArrayList(allergies));
        }
    }

    public void AllergyTableClick(MouseEvent mouseEvent) {

    }

    public void CancelButtonClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("Login");
    }

    public void ConfirmButtonClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StudentAddParent");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        AllergensTableView.setPlaceholder(new Label(""));
        AllergensColumn.setCellValueFactory(new PropertyValueFactory<>("Allergen"));
        PrecautionsColumn.setCellValueFactory(new PropertyValueFactory<>("Precaution"));
    }
}
