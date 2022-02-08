package it.univr.studyholiday.controller;

import it.univr.studyholiday.model.User;
import it.univr.studyholiday.model.entities.Allergy;
import it.univr.studyholiday.pgvApplication;
import it.univr.studyholiday.util.Database.DeleteFromDB;
import it.univr.studyholiday.util.Database.FetchFromDB;
import it.univr.studyholiday.util.Database.SaveToDB;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StudentAllergyEditController implements Initializable {
    @FXML private Label ErrorMessage;
    @FXML private TextField AllergenTextField;
    @FXML private TextField PrecautionTextField;
    @FXML private TableView<Allergy> AllergenTable;
    @FXML private TableColumn<Allergy,String> AllergenColumn;
    @FXML private TableColumn<Allergy,String> PrecautionColumn;

    private static ArrayList<Allergy> allergies;
    private static ArrayList<Allergy> deletedallergies;
    private static ArrayList<Allergy> newallergies;

    public void SaveButtonClick(ActionEvent actionEvent) throws IOException {
        if(AllergenTextField.getText().isBlank()||PrecautionTextField.getText().isBlank())
            ErrorMessage.setText("Inserire allergene e precauzione.");
        else{
            ErrorMessage.setText("");
            allergies.add(new Allergy(User.getCurrentStudent().getId(), AllergenTextField.getText(), PrecautionTextField.getText()));
            newallergies.add(new Allergy(User.getCurrentStudent().getId(), AllergenTextField.getText(), PrecautionTextField.getText()));
            AllergenTable.setItems(FXCollections.observableArrayList(allergies));
        }

//
//        else{
//            SaveToDB.insert(new Allergy(User.getCurrentStudent().getId(), AllergenTextField.getText(), PrecautionTextField.getText()));
//            try {
//                AllergenTable.setItems(FXCollections.observableArrayList(FetchFromDB.Allergies(User.getCurrentStudent().getId())));
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            ErrorMessage.setText("");
//        }
    }

    public void DeleteButtonClick(ActionEvent actionEvent) throws IOException {
        ErrorMessage.setText("");
        deletedallergies.add(AllergenTable.getSelectionModel().getSelectedItem());
        System.out.println(deletedallergies.size());
        allergies.remove(AllergenTable.getSelectionModel().getSelectedItem());
        AllergenTable.setItems(FXCollections.observableArrayList(allergies));
//        DeleteFromDB.delete(AllergenTable.getSelectionModel().getSelectedItem());
//        try {
//            AllergenTable.setItems(FXCollections.observableArrayList(FetchFromDB.Allergies(User.getCurrentStudent().getId())));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    public void AllergyTableClick(MouseEvent mouseEvent) throws IOException {
        //pgvApplication.setRoot("");
    }

    public void CancelButtonClick(ActionEvent actionEvent) throws IOException {
        pgvApplication.setRoot("StudentProfile");
    }

    public void ConfirmButtonClick(ActionEvent actionEvent) throws IOException {
        if (deletedallergies.isEmpty()){}
        else{
            for (Allergy a : deletedallergies) {
                DeleteFromDB.delete(a);
            }
        }
        if (newallergies.isEmpty()){}
        else{
            for (Allergy a : newallergies) {
                SaveToDB.insert(a);
            }
        }

        pgvApplication.setRoot("StudentProfile");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        deletedallergies=new ArrayList<>();
        newallergies=new ArrayList<>();
        AllergenTable.setPlaceholder(new Label("Nessuna allergia."));
        AllergenColumn.setCellValueFactory(new PropertyValueFactory<>("Allergen"));
        PrecautionColumn.setCellValueFactory(new PropertyValueFactory<>("Precaution"));
        try {
            allergies=FetchFromDB.Allergies(User.getCurrentStudent().getId());
            AllergenTable.setItems(FXCollections.observableArrayList(allergies));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        AllergenTable.setEditable(false);

        TableView.TableViewSelectionModel<Allergy> selectionModel = AllergenTable.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);

    }
}
