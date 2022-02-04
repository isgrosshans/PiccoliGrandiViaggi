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
import java.util.ResourceBundle;

public class StudentAllergyEditController implements Initializable {
    @FXML private Label ErrorMessage;
    @FXML private TextField AllergenTextField;
    @FXML private TextField PrecautionTextField;
    @FXML private TableView<Allergy> AllergenTable;
    @FXML private TableColumn<Allergy,String> AllergenColumn;
    @FXML private TableColumn<Allergy,String> PrecautionColumn;

    public void ReturnButtonClick(ActionEvent actionEvent) throws IOException {
        //todo remove
    }

    public void SaveButtonClick(ActionEvent actionEvent) throws IOException {
        if(AllergenTextField.getText().isBlank()||PrecautionTextField.getText().isBlank())
            ErrorMessage.setText("Inserire allergene e precauzione.");
        else{
            SaveToDB.insert(new Allergy(User.getCurrentStudent().getId(), AllergenTextField.getText(), PrecautionTextField.getText()));
            try {
                AllergenTable.setItems(FXCollections.observableArrayList(FetchFromDB.Allergies(User.getCurrentStudent().getId())));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ErrorMessage.setText("");
        }
    }

    public void DeleteButtonClick(ActionEvent actionEvent) throws IOException {
        ErrorMessage.setText("");
        DeleteFromDB.delete(AllergenTable.getSelectionModel().getSelectedItem());
        try {
            AllergenTable.setItems(FXCollections.observableArrayList(FetchFromDB.Allergies(User.getCurrentStudent().getId())));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void AllergyTableClick(MouseEvent mouseEvent) throws IOException {
        //pgvApplication.setRoot("");
    }

    public void CancelButtonClick(ActionEvent actionEvent) throws IOException {
        pgvApplication.setRoot("StudentProfile");
    }

    public void ConfirmButtonClick(ActionEvent actionEvent) throws IOException {
        pgvApplication.setRoot("StudentProfile");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
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
}
