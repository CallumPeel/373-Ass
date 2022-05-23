package SupplementServices;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class CenterPanel extends MyBPane {

    BorderPane centerSectionPane;
    BorderPane centerBottomPane;

    public CenterPanel(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
        this.centerSectionPane = new BorderPane();
        this.centerBottomPane = new BorderPane();
        buildPane();
    }

    public void buildPane() {
        Label title = new Label("Customer Breakdown");
        this.centerSectionPane.setTop(title);
        this.centerSectionPane.setAlignment(title, Pos.TOP_CENTER);
        centerSectionPane.setBottom(this.centerBottomPane);
        setPane();
    }

    public void setPane() {
        this.backEnd.viewPane.setCenter(centerSectionPane);
    }
}
