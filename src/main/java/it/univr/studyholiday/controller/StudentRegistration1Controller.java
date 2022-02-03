package it.univr.studyholiday.controller;

import it.univr.studyholiday.pgvApplication;
import it.univr.studyholiday.model.entities.Student;
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

public class StudentRegistration1Controller implements Initializable {
    @FXML private TextField EmailTextField; //mandatory
    @FXML private TextField PswTextField; //mandatory
    @FXML private TextField ConfirmPswTextField; //mandatory
    @FXML private TextField FirstNameTextField; //mandatory
    @FXML private TextField LastNameTextField; //mandatory
    @FXML private TextField AddressTextField; //mandatory
    @FXML private TextField PhoneTextField;
    @FXML private DatePicker BirthdayDatePicker; //mandatory
    @FXML private ChoiceBox<String> SexChoiceBox; //mandatory
    @FXML private TextArea HobbiesTextArea;
    @FXML private Label ErrorMessage;

    public void SexClick(MouseEvent mouseEvent) throws IOException {

    }

    public void CancelButtonClick(ActionEvent actionEvent) throws IOException {
            pgvApplication.setRoot("Login");

    }

    public void ConfirmButtonClick(ActionEvent actionEvent) throws IOException {
        if(EmailTextField.getText().isBlank()||
                PswTextField.getText().isBlank()||
                ConfirmPswTextField.getText().isBlank()||
                FirstNameTextField.getText().isBlank()||
                LastNameTextField.getText().isBlank()||
                AddressTextField.getText().isBlank()||
                BirthdayDatePicker.getValue()==null||
                SexChoiceBox.getValue()==null){
            ErrorMessage.setText("Compilare tutti i campi contrassegnati da *.");
        }
        else if(!PswTextField.getText().equals(ConfirmPswTextField.getText())){
            ErrorMessage.setText("Le password non coincidono.");
        }
        else if(!EmailTextField.getText().matches("^(.+)@(.+)$")){
            ErrorMessage.setText("Inserire un indirizzo email valido.");
        }
        else if(EmailTextField.getText().equals("@pgv.it")){ErrorMessage.setText("NO");}
        else if(PswTextField.getText().length()<8){
            ErrorMessage.setText("La password deve essere lunga almeno 8 caratteri.");
        }
        else {

            StudentRegistration2Controller.setStudent(new Student(
                            EmailTextField.getText(),//String email
                            PswTextField.getText(),//String psw
                            FirstNameTextField.getText(),//String firstName
                            LastNameTextField.getText(),//String lastName
                            BirthdayDatePicker.getValue(),//LocalDate birthday
                            SexChoiceBox.getValue(),//String sex
                            AddressTextField.getText(),//String address
                            PhoneTextField.getText(),//String phone
                            HobbiesTextArea.getText()//String hobbies
                    )
            );
            pgvApplication.setRoot("StudentRegistration2");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        BirthdayDatePicker.setEditable(false);
        BirthdayDatePicker.setDayCellFactory(picker -> new DateCell() {
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                setDisable(empty || date.isAfter(LocalDate.now().plusDays(1)) );
            }
        });
        SexChoiceBox.setItems(FXCollections.observableArrayList("Maschio","Femmina"));
    }
}
