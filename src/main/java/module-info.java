module it.univr.studytrip {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens it.univr.studyholiday.model to javafx.base;
    opens it.univr.studyholiday to javafx.fxml;
    opens it.univr.studyholiday.controller to javafx.fxml;
    exports it.univr.studyholiday;
}