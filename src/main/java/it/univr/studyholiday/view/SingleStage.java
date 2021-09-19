package it.univr.studyholiday.view;

import javafx.stage.Stage;

public class SingleStage {
    private static  SingleStage instance = new SingleStage();
    public Stage stage;

    public SingleStage() {
        stage = new Stage();

    }

    public static SingleStage getInstance() {
        return instance;
    }
}
