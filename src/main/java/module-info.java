module it.univr.studytrip {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.postgresql.jdbc;

    opens it.univr.studyholiday.model to javafx.base;
    opens it.univr.studyholiday to javafx.fxml;
    opens it.univr.studyholiday.controller to javafx.fxml;
    exports it.univr.studyholiday;
    opens it.univr.studyholiday.model.entities to javafx.base;
}