package it.univr.studyholiday.controller;

import it.univr.studyholiday.GlossaApplication;
import it.univr.studyholiday.model.Allergy;
import it.univr.studyholiday.model.Hobby;
import it.univr.studyholiday.model.Parent;
import it.univr.studyholiday.model.Student;
import it.univr.studyholiday.util.Database.Add;
import it.univr.studyholiday.util.LoginUtil;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {

    @FXML private TextField email;
    @FXML private TextField password;
    @FXML private TextField confirmpassword;
    @FXML private TextField nome;
    @FXML private TextField cognome;
    @FXML private DatePicker datadinascita;
    @FXML private TextField luogodinascita;
    @FXML private RadioButton maschio;
    @FXML private RadioButton femmina;
    @FXML private TextField indirizzo;
    @FXML private TextField telefono;
    @FXML private TextField emailgenitore;
    @FXML private TextField nomegenitore;
    @FXML private TextField cognomegenitore;
    @FXML private TextField telefonogenitore;
    @FXML private TextField allergia;
    @FXML private Button aggiungiallergia;
    @FXML private TextField hobby;
    @FXML private Button aggiungihobby;
    @FXML private Button aggiungialtrogenitore;
    @FXML private Button escibutton;
    @FXML private Button registratibutton;
    @FXML private ComboBox sex;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sex.getItems().addAll("Maschio", "Femmina");
        aggiungialtrogenitore.setDisable(true);
        aggiungialtrogenitore.setVisible(false);
    }


    private ArrayList<String> hobbies=new ArrayList<String>();
    private int countparents=0;
    private ArrayList<String> allergies=new ArrayList<String>();
    private String stremailgenitore;
    private String strnomegenitore;
    private String strcognomegenitore;
    private String strtelefonogenitore;


    public void OnAddParentClicked(){
//        if(countparents==1) aggiungialtrogenitore.setDisable(true);
//        stremailgenitore[countparents]=emailgenitore.getText();
//        strnomegenitore[countparents]=nomegenitore.getText();
//        strcognomegenitore[countparents]=cognomegenitore.getText();
//        strtelefonogenitore[countparents]=telefonogenitore.getText();
//        emailgenitore.setText("");
//        nomegenitore.setText("");
//        cognomegenitore.setText("");
//        telefonogenitore.setText("");
//        countparents++;
    }

    public void onAddAllergiylicked(){
//        allergies.add(allergia.getText());
//        //allergia.
    }
    public void OnAddHobbyClicked(){
//        hobbies.add(hobby.getText());
//       // hobby.setText("");
    }

    public void onRegisterClicked() throws IOException {
        String studentemail=email.getText();
        String sexval= (String) sex.getValue();
        sexval=""+sexval.charAt(0);

        Student student=new Student(studentemail,
                LoginUtil.encrypy(password.getText()),
                nome.getText(),
                cognome.getText(),
                datadinascita.getValue(),
                luogodinascita.getText(),
                sexval,
                telefono.getText(),
                indirizzo.getText());
        student.add();

        Add.add(new Allergy(student,allergia.getText(), " "));
        Add.add(new Hobby(student,hobby.getText()));

        ArrayList<Allergy> a=new ArrayList<Allergy>();
        for (String s:allergies) {
            a.add(new Allergy(email.getText(),s, " "));
        }
        Add.add(a);

        ArrayList<Hobby> h=new ArrayList<Hobby>();
        for (String s:hobbies) {
            Add.add(new Hobby(email.getText(), s));
        }



        Add.add(new Parent(emailgenitore.getText(),nomegenitore.getText(), cognomegenitore.getText(),telefonogenitore.getText(), student));


//        if(countparents>1){
//
//
//                Add.add(new Parent(stremailgenitore[1],
//                        strnomegenitore[1], strcognomegenitore[1],
//                        strtelefonogenitore[1], email.getText()));
//        }
        GlossaApplication.setRoot("login-view");
    }
    public void onExitClicked() throws IOException {
        GlossaApplication.setRoot("login-view");
    }

}
