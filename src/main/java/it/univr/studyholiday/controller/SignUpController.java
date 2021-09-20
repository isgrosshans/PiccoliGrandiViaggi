package it.univr.studyholiday.controller;

import it.univr.studyholiday.model.Student;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class SignUpController {
    @FXML private TextField email;
    @FXML private TextField password;
    @FXML private TextField confirmpassword;
    @FXML private TextField name;
    @FXML private TextField surname;
    @FXML private DatePicker birthday;
    @FXML private TextField birthplace;
    @FXML private RadioButton male;
    @FXML private RadioButton female;
    @FXML private TextField address;
    @FXML private TextField phonenumber;
    // USER MUST INSERT FOLLOWING INFORMATION
    //        email
    //        password
    //        conefrma password
    //        nome
    //        cognome
    //        data di nascita
    //        luogo di nascita
    //        indirizzo(via, CAP, città, provincia, paese)
    //        numero di telefono (opzionale)
    //        allergie e precauzioni
    //        +	(no limite max)
    //        hobby
    //        +	(no limite max)
    //        genitori (1 o 2) (nome, cognome, email, telefono)
    //
    // SYSTEM CHECKS IF EMAIL IS AVAILABLE
    //      if(Database.Database.emailInUse(email))
    //          ERROR
    //
    // SYSTEM CHECKS THAT ALL DATA HAS BEEN INSERTED
    // SYSTEM CHECKS THAT EMAIL IS VALID
    // if(!emailAddress.equals(!"(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])\n")){
    //            System.out.println("Errore: indirizzo email non valido.");
    //
    // IF THERE ARE NO PROBLEMS
    // BUTTON [COMPLETA REGISTRAZIONE]


    public void onFemaleRadioButtonClick(){
        male.disarm();
    }
    public void onMaleRadioButtonClick(){
        female.disarm();
    }


    public void onConfirmSignupClick(){
        String sex = "";
        if(male.isArmed()) sex = "M";
        if(female.isArmed()) sex = "F";

//        Student.singupStudent(new Student(
//                email.getText(),
//                password.getText(),
//                name.getText(),
//                surname.getText(),
//                birthday.getValue(),
//                birthplace.getText(),
//                sex,
//                phonenumber.getText(),
//                address.getText()));
    }
}
