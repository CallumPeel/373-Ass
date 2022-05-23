package SupplementServices;

import javafx.scene.layout.BorderPane;

public class CenterPanel extends MyBPane {

    BorderPane centerSectionPane;
    BorderPane centerBottomPane;

    public CenterPanel(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
        this.centerSectionPane = new BorderPane();
        this.centerBottomPane = new BorderPane();
//        buildPane();
    }

    public void buildPane() {
        centerSectionPane.setBottom(this.centerBottomPane);
        setPane();
    }

    public void setPane() {
        this.backEnd.viewPane.setCenter(centerSectionPane);
    }
}
