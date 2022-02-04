package it.univr.studyholiday.controller;

import it.univr.studyholiday.pgvApplication;
import it.univr.studyholiday.model.User;
import it.univr.studyholiday.model.entities.Allergy;
import it.univr.studyholiday.model.entities.Parent;
import it.univr.studyholiday.model.entities.Student;
import it.univr.studyholiday.util.Database.FetchFromDB;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class StudentProfileController implements Initializable {
    @FXML private Label AddressLabel;
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
        pgvApplication.setRoot("StudentHome");
    }

    public void EditMenuClick(ActionEvent actionEvent) throws IOException {

    }

    public void EditPersonalDataClick(ActionEvent actionEvent) throws IOException {
        pgvApplication.setRoot("StudentProfileEdit");
    }

    public void EditEmailPswClick(ActionEvent actionEvent) throws IOException {
        pgvApplication.setRoot("StudentEmailPswEdit");
    }

    public void EditAllergyClick(ActionEvent actionEvent) throws IOException {
        pgvApplication.setRoot("StudentAllergyEdit");
    }

    public void EditParentsClick(ActionEvent actionEvent) throws IOException {
        StudentParentEditController.setParent1(parent1);
        if(parent2bool) {
            StudentParentEditController.setParent2(parent2);
        }
        pgvApplication.setRoot("StudentParentEdit");
    }

    public void AllergiesTableClick(MouseEvent mouseEvent) throws IOException {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(User.getCurrentUser().getClass().equals(Student.class))
            student=FetchFromDB.student(User.getCurrentStudent().getId());
        FetchFromDB.StudentProfileSetParents(student.getParent1id(),student.getParent2id());
        loadinfo();

        if(parent2bool)Parent2Label.setText(parent2.toString());
        AllergenTable.setPlaceholder(new Label("Nessuna allergia."));
        AllergenColumn.setCellValueFactory(new PropertyValueFactory<>("Allergen"));
        PrecautionColumn.setCellValueFactory(new PropertyValueFactory<>("Precaution"));
        try {
            AllergenTable.setItems(FXCollections.observableArrayList(FetchFromDB.Allergies(User.getCurrentStudent().getId())));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        AllergenTable.setEditable(false);

        TableView.TableViewSelectionModel<Allergy> selectionModel = AllergenTable.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);
    }

    private void loadinfo(){
        IdLabel.setText(String.valueOf(student.getId()));
        EmailLabel.setText(student.getEmail());
        PhoneLabel.setText(student.getPhone());
        FirstNameLabel.setText(student.getFirstName());
        LastNameLabel.setText(student.getLastName());
        SexLabel.setText(student.getSex());
        HobbiesLabel.setText(student.getHobbies());
        BirthdayLabel.setText(student.getBirthdayString());
        AddressLabel.setText(student.getAddress());
        Parent1Label.setText(parent1.toString());
    }
}
