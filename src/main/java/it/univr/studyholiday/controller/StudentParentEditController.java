package it.univr.studyholiday.controller;

import it.univr.studyholiday.model.User;
import it.univr.studyholiday.pgvApplication;
import it.univr.studyholiday.model.entities.Parent;
import it.univr.studyholiday.util.Database.FetchFromDB;
import it.univr.studyholiday.util.Database.SaveToDB;
import it.univr.studyholiday.util.Database.UpdateDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentParentEditController implements Initializable {
    @FXML private TextField EmailTextField;
    @FXML private TextField FirstNameTextField;
    @FXML private TextField LastNameTextField;
    @FXML private TextField PhoneTextField;
    @FXML private TextField EmailTextField2;
    @FXML private TextField FirstNameTextField2;
    @FXML private TextField LastNameTextField2;
    @FXML private TextField PhoneTextField2;
    @FXML private Label ErrorMessage;

    private static boolean errorMessageIsSet=false;
    private static Parent parent1;
    public static void setParent1(Parent p){parent1=p;}
    private static Parent parent2;
    private static boolean parent2bool=false;
    public static void setParent2(Parent p){
        parent2=p;
        parent2bool=true;}

    public void CancelButtonClick(ActionEvent actionEvent) throws IOException {
        pgvApplication.setRoot("StudentProfile");
    }

    public void ConfirmButtonClick(ActionEvent actionEvent) throws IOException, IllegalAccessException {
        if (parent1AllFilled() && parent2AllFilled()){
            if(EmailTextField.getText().equals(EmailTextField2.getText()) &&
                    FirstNameTextField.getText().equals(FirstNameTextField2.getText()) &&
                    LastNameTextField.getText().equals(LastNameTextField2.getText()) &&
                    PhoneTextField.getText().equals(PhoneTextField2.getText())
            ){
                ErrorMessage.setText("Inserire due genitori diversi.");
            }
            else if(EmailTextField.getText().equals(EmailTextField2.getText())){ErrorMessage.setText("Non puoi dare lo stesso indirizzo email per entrambi i genitori");}
            else{
                    if (parent2bool){updateParent1();updateParent2();}
                    else {updateParent1();insertParent2();}
                pgvApplication.setRoot("StudentProfile");
            }
        }
        else if (parent1AllFilled() && parent2AllBlank()){
            if(parent2bool) ErrorMessage.setText("Compilare tutti i campi.");
            else{updateParent1();pgvApplication.setRoot("StudentProfile");}
        }
        else ErrorMessage.setText("Compilare tutti i campi.");

    }


//    public void ConfirmButtonClick(ActionEvent actionEvent) throws IOException {
//
//        Parent tempParent;
//
//        if (parent1AllFilled() && parent2AllFilled()){
//            if(EmailTextField.getText().equals(EmailTextField2.getText()) &&
//                    FirstNameTextField.getText().equals(FirstNameTextField2.getText()) &&
//                    LastNameTextField.getText().equals(LastNameTextField2.getText()) &&
//                    PhoneTextField.getText().equals(PhoneTextField2.getText())
//            ){
//                ErrorMessage.setText("Inserire due genitori diversi.");
//            }
//        }
//        else if (parent1unEdited() && parent2unEdited()){
//            System.out.println("parent1unEdited() && parent2unEdited()");
//            pgvApplication.setRoot("StudentProfile");
//        }
//        else if(parent2unEdited()){
//            System.out.println("parent2unedited");
//            if(parent1AllFilled()){
//                tempParent =new Parent(EmailTextField.getText(), FirstNameTextField.getText(), LastNameTextField.getText(), PhoneTextField.getText());
//                if(parent2bool && tempParent.sameAs(parent2)) {
//                    System.out.println("");
//                    ErrorMessage.setText("Inserire due genitori diversi.");
//                }
//                else if(FetchFromDB.parentInfoConflict(tempParent)){
//                    System.out.println("");
//                    ErrorMessage.setText("Le informazioni vanno in conflitto con i nostri database.");
//                }
//                else {updateParent1(); pgvApplication.setRoot("StudentProfile");}
//            }
//            else ErrorMessage.setText("Compilare tutti i campi");
//        }
//        else if(parent1unEdited()){
//            System.out.println("parent1unedited");
//            if(parent2AllFilled()){
//                System.out.println("parent2AllFilled");
//                tempParent=new Parent(EmailTextField2.getText(), FirstNameTextField2.getText(), LastNameTextField2.getText(), PhoneTextField2.getText());
//                if(parent2bool && tempParent.sameAs(parent1)) {
//                    ErrorMessage.setText("Inserire due genitori diversi.");
//                }
//                else if(parent2bool && FetchFromDB.parentInfoConflict(tempParent)){
//                    ErrorMessage.setText("Le informazioni vanno in conflitto con i nostri database.");
//                }
//                else{System.out.println("gonna update or insert parent2");
//                    if (parent2bool) updateParent2(); else insertParent2();}
//            }
//            else ErrorMessage.setText("Compilare tutti i campi");
//        }
//        else { //both parents edited
//            if(parent1AllFilled() && parent2AllFilled()){
//                if(EmailTextField.getText().equals(EmailTextField2.getText()) &&
//                        FirstNameTextField.getText().equals(FirstNameTextField2.getText()) &&
//                        LastNameTextField.getText().equals(LastNameTextField2.getText()) &&
//                        PhoneTextField.getText().equals(PhoneTextField2.getText())
//                ) ErrorMessage.setText("Inserire due genitori diversi");
//                else if(
//                        FetchFromDB.parentInfoConflict(new Parent(EmailTextField.getText(), FirstNameTextField.getText(), LastNameTextField.getText(), PhoneTextField.getText())) ||
//                                FetchFromDB.parentInfoConflict(new Parent(EmailTextField2.getText(), FirstNameTextField2.getText(), LastNameTextField2.getText(), PhoneTextField2.getText()))
//                ){ErrorMessage.setText("Le informazioni vanno in conflitto con i nostri database.");}
//                else{
//                    updateParent1();
//                    if (parent2bool) updateParent2();
//                    else insertParent2();
//                }
//            }
//            else ErrorMessage.setText("Compilare tutti i campi");
//        }
//    }

//    public void ConfirmButtonClick(ActionEvent actionEvent) throws IOException {
//        errorMessageIsSet=false;
//
//        //same parent twice
//        if (parent1AllFilled() && parent2AllFilled()){
//            if(EmailTextField.getText().equals(EmailTextField2.getText()) &&
//                    FirstNameTextField.getText().equals(FirstNameTextField2.getText()) &&
//                    LastNameTextField.getText().equals(LastNameTextField2.getText()) &&
//                    PhoneTextField.getText().equals(PhoneTextField2.getText())
//            ){
//                ErrorMessage.setText("Vec...");
//                errorMessageIsSet=true;
//            }
//        }
//        else if (!EmailTextField.getText().isBlank() && EmailTextField.getText().equals(EmailTextField2.getText())){
//            ErrorMessage.setText("I due genitori non possono avere lo stesso indirizzo email.");
//            errorMessageIsSet=true;
//        }
//        else {
//            //both parents already in the db
//            if (parent2bool) {
//                if (parent1AllFilled() && parent2AllFilled()) {
//                    //update both parents
//                    UpdateDB.editParent(new Parent(parent1.getId(), EmailTextField.getText(),
//                            FirstNameTextField.getText(),
//                            LastNameTextField.getText(),
//                            PhoneTextField.getText()));
//                    UpdateDB.editParent(new Parent(parent2.getId(), EmailTextField2.getText(),
//                            FirstNameTextField2.getText(),
//                            LastNameTextField2.getText(),
//                            PhoneTextField2.getText()));
//                    pgvApplication.setRoot("StudentProfile");
//                }
//            } else {    //only one parent in db
//                //only updating parent
//                if (parent1AllFilled() && parent2AllBlank()) {
//                    //update parent 1
//                    UpdateDB.editParent(new Parent(parent1.getId(), EmailTextField.getText(),
//                            FirstNameTextField.getText(),
//                            LastNameTextField.getText(),
//                            PhoneTextField.getText()));
//                    pgvApplication.setRoot("StudentProfile");
//                }
//                //update parent 1, insert parent 2
//                else if (parent1AllFilled() && parent2AllFilled()) {
//                    if (FetchFromDB.parentInfoConflict(new Parent(EmailTextField2.getText(),
//                            FirstNameTextField2.getText(),
//                            LastNameTextField2.getText(),
//                            PhoneTextField2.getText()))) {
//                        ErrorMessage.setText("Le informazioni sono in conflitto con il nostro Database.");
//                        errorMessageIsSet=true;
//                    }
//                    else if (FetchFromDB.parentInfoConflict(new Parent(EmailTextField.getText(),
//                            FirstNameTextField.getText(),
//                            LastNameTextField.getText(),
//                            PhoneTextField.getText()))) {
//                        ErrorMessage.setText("Le informazioni sono in conflitto con il nostro Database.");
//                        errorMessageIsSet=true;
//                    }
//                    else if (UpdateDB.editParent(new Parent(parent1.getId(), EmailTextField.getText(),
//                            FirstNameTextField.getText(),
//                            LastNameTextField.getText(),
//                            PhoneTextField.getText()))) {
//
//                        if (FetchFromDB.parentInfoConflict(new Parent(EmailTextField2.getText(),
//                                FirstNameTextField2.getText(),
//                                LastNameTextField2.getText(),
//                                PhoneTextField2.getText()))) {
//                            ErrorMessage.setText("Le informazioni del secondo genitore sono in conflitto con il nostro Database.");
//                            errorMessageIsSet=true;
//                        } else {
//                            SaveToDB.insertParent2(new Parent(EmailTextField2.getText(),
//                                    FirstNameTextField2.getText(),
//                                    LastNameTextField2.getText(),
//                                    PhoneTextField2.getText()));
//                            pgvApplication.setRoot("StudentProfile");
//                        }
//                    } //else {
////                        ErrorMessage.setText(EmailTextField.getText() + " non disponibile.");
////                        errorMessageIsSet=true;
////                    }
//                }
//            }
//        }
        //if(!errorMessageIsSet){
        //    ErrorMessage.setText("Errore inserimento dati");
            //I probably just need an else instead of a flag, but I am very tired
        //}
//    }

    private void updateParent1(){
        UpdateDB.editParent(new Parent(
                parent1.getId(), EmailTextField.getText(), FirstNameTextField.getText(), LastNameTextField.getText(), PhoneTextField.getText()));
    }
    private void updateParent2(){
        UpdateDB.editParent(new Parent(
                parent2.getId(), EmailTextField2.getText(), FirstNameTextField2.getText(), LastNameTextField2.getText(), PhoneTextField2.getText()));
    }
    private void insertParent2() throws IllegalAccessException {
        SaveToDB.insertParent2(new Parent(
                EmailTextField2.getText(), FirstNameTextField2.getText(), LastNameTextField2.getText(), PhoneTextField2.getText()));
        User.getCurrentStudent().setParent2id(FetchFromDB.fetchID(new Parent(
                EmailTextField2.getText(), FirstNameTextField2.getText(), LastNameTextField2.getText(), PhoneTextField2.getText())));
    }

    private boolean parent1unEdited(){
        return (EmailTextField.getText().equals(parent1.getEmail()) &&
                FirstNameTextField.getText().equals(parent1.getFirstName()) &&
                LastNameTextField.getText().equals(parent1.getLastName()) &&
                PhoneTextField.getText().equals(parent1.getPhone()));
    }
    private boolean parent2unEdited(){
        if(parent2bool)
            return (EmailTextField2.getText().equals(parent2.getEmail()) &&
                FirstNameTextField2.getText().equals(parent2.getFirstName()) &&
                LastNameTextField2.getText().equals(parent2.getLastName()) &&
                PhoneTextField2.getText().equals(parent2.getPhone()));
        else
            return parent2AllBlank();
    }

    private boolean parent1AllFilled(){
        return !(EmailTextField.getText().isBlank() ||
                FirstNameTextField.getText().isBlank() ||
                LastNameTextField.getText().isBlank() ||
                PhoneTextField.getText().isBlank());
    }
    private boolean parent2AllFilled(){
        if (EmailTextField2.getText().isBlank() ||
                FirstNameTextField2.getText().isBlank() ||
                LastNameTextField2.getText().isBlank() ||
                PhoneTextField2.getText().isBlank()) return false;
        else return true;
    }
    private boolean parent2AllBlank(){
        return (EmailTextField2.getText().isBlank() &&
                FirstNameTextField2.getText().isBlank() &&
                LastNameTextField2.getText().isBlank() &&
                PhoneTextField2.getText().isBlank());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        EmailTextField.setText(parent1.getEmail());
        FirstNameTextField.setText(parent1.getFirstName());
        LastNameTextField.setText(parent1.getLastName());
        PhoneTextField.setText(parent1.getPhone());

        if(parent2bool) {
            EmailTextField2.setText(parent2.getEmail());
            FirstNameTextField2.setText(parent2.getFirstName());
            LastNameTextField2.setText(parent2.getLastName());
            PhoneTextField2.setText(parent2.getPhone());
        }
        else
        {
            EmailTextField2.setText("");
            FirstNameTextField2.setText("");
            LastNameTextField2.setText("");
            PhoneTextField2.setText("");
        }
    }
}
