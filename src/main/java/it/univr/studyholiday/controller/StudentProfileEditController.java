package it.univr.studyholiday.controller;

import it.univr.studyholiday.model.User;
import it.univr.studyholiday.pgvApplication;
import it.univr.studyholiday.util.Database.UpdateDB;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class StudentProfileEditController implements Initializable {
    @FXML private TextField FirstNameTextField;
    @FXML private TextField LastNameTextField;
    @FXML private TextField AddressTextField;
    @FXML private TextField PhoneTextField;
    @FXML private DatePicker BirthdayDatePicker;
    @FXML private ChoiceBox SexChoiceBox;
    @FXML private TextArea HobbiesTextArea;
    @FXML private Label ErrorMessage;

    public void DateClick(MouseEvent mouseEvent) throws IOException {
    }

    public void SexClick(MouseEvent mouseEvent) throws IOException {
    }

    public void CancelButtonClick(ActionEvent actionEvent) throws IOException {
        pgvApplication.setRoot("StudentProfile");
    }

    public void ConfirmButtonClick(ActionEvent actionEvent) throws IOException {
        //check none blank
        if(FirstNameTextField.getText().isBlank()||
                LastNameTextField.getText().isBlank()||
                AddressTextField.getText().isBlank()||
                BirthdayDatePicker.getValue()==null||
                SexChoiceBox.getValue()==null){
            ErrorMessage.setText("Errore: Campi obbligatori lasciati vuoti");
        }
        //set values to student
        User.getCurrentStudent().setFirstName(FirstNameTextField.getText());
        User.getCurrentStudent().setLastName(LastNameTextField.getText());
        User.getCurrentStudent().setAddress(AddressTextField.getText());
        User.getCurrentStudent().setPhone(PhoneTextField.getText());
        User.getCurrentStudent().setBirthday(BirthdayDatePicker.getValue());
        User.getCurrentStudent().setSex((String) SexChoiceBox.getValue());
        User.getCurrentStudent().setHobbies(HobbiesTextArea.getText());

        //update db
        UpdateDB.editPersonalInfo(User.getCurrentStudent());

        //load page
        pgvApplication.setRoot("StudentProfile");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FirstNameTextField.setText(User.getCurrentStudent().getFirstName());
        LastNameTextField.setText(User.getCurrentStudent().getLastName());
        AddressTextField.setText(User.getCurrentStudent().getAddress());
        PhoneTextField.setText(User.getCurrentStudent().getPhone());
        HobbiesTextArea.setText(User.getCurrentStudent().getHobbies());

        BirthdayDatePicker.setEditable(false);
        BirthdayDatePicker.setDayCellFactory(picker -> new DateCell() {
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                setDisable(empty || date.isAfter(LocalDate.now().plusDays(1)) );
            }
        });
        BirthdayDatePicker.setValue(User.getCurrentStudent().getBirthday());

        SexChoiceBox.setItems(FXCollections.observableArrayList("Maschio","Femmina"));
        SexChoiceBox.setValue(User.getCurrentStudent().getSex());
    }
}
