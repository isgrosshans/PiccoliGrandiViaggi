package it.univr.studyholiday.controller;

import it.univr.studyholiday.GlossaApplication;
import it.univr.studyholiday.model.User;
import it.univr.studyholiday.model.entities.Allergy;
import it.univr.studyholiday.model.entities.Parent;
import it.univr.studyholiday.model.entities.Student;
import it.univr.studyholiday.util.Database.FetchFromDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentProfileController implements Initializable {
    @FXML private Label IdLabel;
    @FXML private Label EmailLabel;
    @FXML private Label PhoneLabel;
    @FXML private Label FirstNameLabel;
    @FXML private Label LastNameLabel;
    @FXML private Label SexLabel;
    @FXML private Label HobbiesLabel;
    @FXML private Label BirthdayLabel;
    @FXML private TableView<Allergy> AllergenTable;
    @FXML private TableColumn<Allergy,String> AllergenColumn;
    @FXML private TableColumn<Allergy,String> PrecautionColumn;
    @FXML private Label Parent1Label;
    @FXML private Label Parent2Label;

    private static Student student;
    private static Parent parent1;
    public static void setParent1(Parent p){parent1=p;}
    private static Parent parent2;
    private static boolean parent2bool=false;
    public static void setParent2(Parent p){
        parent2=p;
        parent2bool=true;}



    public void ReturnHomeButtonClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StudentHome");
    }

    public void EditMenuClick(ActionEvent actionEvent) throws IOException {

    }

    public void EditPersonalDataClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StudentProfileEdit");
    }

    public void EditEmailPswClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StudentEmailPswEdit");
    }

    public void EditAllergyClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StudentAllergyEdit");
    }

    public void EditParentsClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StudentParentEdit");
    }

    public void AllergiesTableClick(MouseEvent mouseEvent) throws IOException {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(User.getCurrentUser().getClass().equals(Student.class))
            student= (Student) User.getCurrentUser();
        FetchFromDB.parents(student.getParent1id(),student.getParent2id());
        IdLabel.setText(String.valueOf(student.getId()));
        EmailLabel.setText(student.getEmail());
        PhoneLabel.setText(student.getPhone());
        FirstNameLabel.setText(student.getFirstName());
        LastNameLabel.setText(student.getLastName());
        SexLabel.setText(student.getSex());
        HobbiesLabel.setText(student.getHobbies());
        BirthdayLabel.setText(student.getBirthdayString());
        Parent1Label.setText(parent1.toString());
        if(parent2bool)Parent2Label.setText(parent2.toString());
        AllergenTable.setPlaceholder(new Label("Nessuna allergia."));


    }
}
