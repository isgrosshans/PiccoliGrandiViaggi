module it.univr.studytrip {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens it.univr.studyholiday to javafx.fxml;
    exports it.univr.studyholiday;
}