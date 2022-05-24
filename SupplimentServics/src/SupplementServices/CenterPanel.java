package SupplementServices;

import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;

public class CenterPanel extends MyBPane {

    BorderPane centerSectionPane;
    BorderPane centerBottomPane;

    public CenterPanel(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
        this.centerSectionPane = new BorderPane();
        this.centerBottomPane = new BorderPane();
        this.centerSectionPane.setPadding(new Insets(15));
    }

    public void buildPane() {
        centerSectionPane.setBottom(this.centerBottomPane);
        setPane();
    }

    public void setPane() {
        this.backEnd.viewPane.setCenter(centerSectionPane);
    }
}
