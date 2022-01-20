//package it.univr.studyholiday.controller;
//
//import it.univr.studyholiday.GlossaApplication;
//import it.univr.studyholiday.model.*;
//import it.univr.studyholiday.util.Database.Add;
//import javafx.fxml.FXML;
//import javafx.scene.control.*;
//
//import java.io.IOException;
//import java.util.ArrayList;
//
//public class AdminAddCollegeController {
//    @FXML private TextField nomecollege;
//    @FXML private TextField indirizzocollege;
//    @FXML private TextField codicepostalecollege;
//    @FXML private TextField provinciacollege;
//    @FXML private TextField paesecollege;
//    @FXML private TextField linguacollege;
//    @FXML private TextField attivitacollege;
//    @FXML private Button confermabutton;
//    @FXML private Button escibutton;
//    @FXML private Button aggiungiattivitacollege;
//    @FXML private TextField emailfamiglia;
//    @FXML private TextField nomefamiglia;
//    @FXML private TextField tripledorm;
//    @FXML private TextField cognomefamiglia;
//    @FXML private TextField singoledorm;
//    @FXML private TextField doppiedorm;
//    @FXML private TextField membrifamiglia;
//    @FXML private TextField distancacittafamiglia;
//    @FXML private CheckBox animalifamiglia;
//    @FXML private TextField nbagnifamiglia;
//    @FXML private TextField ncamerefamiglia;
//    @FXML private Button piufamigliel;
//
//    ArrayList<Family> fams=new ArrayList<Family>();
//    ArrayList<Activity> att=new ArrayList<Activity>();
//    ArrayList<DormRoom> dorms=new ArrayList<DormRoom>();
//
//    public void onpiufamiglie(){
//        fams.add(new Family(emailfamiglia.getText(),
//                nomefamiglia.getText(),
//                cognomefamiglia.getText(),
//                //"",
//                Integer.parseInt(membrifamiglia.getText()),
//                animalifamiglia.isSelected(),
//                Integer.parseInt(ncamerefamiglia.getText()),
//                Integer.parseInt(nbagnifamiglia.getText()),
//                distancacittafamiglia.getText()
//        ));
//    }
//
//    public void onAttivitaclick(){
//        att.add(new Activity("", attivitacollege.getText(), ""));
//        attivitacollege.clear();
//    }
//
//    public void onEsciClicked() throws IOException {
//        GlossaApplication.setRoot("admin-view");
//    }
//
//    public void onanimaliclicked() {
//    }
//
//    public void onConfermaClicked() throws IOException {
//        onpiufamiglie();
//        onAttivitaclick();
//
//        College college = new College(
//                nomecollege.getText(),
//                linguacollege.getText(),
//                new Address(indirizzocollege.getText(),
//                        codicepostalecollege.getText(),
//                        "",
//                        provinciacollege.getText(),
//                        paesecollege.getText()));
//
//        for (int i = 0; i < Integer.parseInt(singoledorm.getText()); i++) {
//            dorms.add(new DormRoom(college.getId(), "s"+i+" "+college.getName(), 1));
//        }
//        for (int i = 0; i < Integer.parseInt(doppiedorm.getText()); i++) {
//            dorms.add(new DormRoom(college.getId(), "d"+i+" "+college.getName(), 2));
//        }
//        for (int i = 0; i < Integer.parseInt(tripledorm.getText()); i++) {
//            dorms.add(new DormRoom(college.getId(), "t"+i+" "+college.getName(), 3));
//        }
//        for (Activity a : att) {
//            a.setCollege(college);
//        }
//        for (Family f : fams) {
//            f.setCollege(college);
//        }
//
//        Add.add(college);
//        for (DormRoom d : dorms) {
//            Add.add(d);
//        }
//        for (Family f : fams) {
//            Add.add(f);
//        }
//        for (Activity a : att) {
//            Add.add(a);
//        }
//
//        GlossaApplication.setRoot("admin-view");
//    }
//}
