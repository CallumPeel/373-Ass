package SupplementServices;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class CenterPanel extends MyPanel {

    BorderPane centerSectionPane;
    BorderPane centerBottomPane;

    public CenterPanel(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
        this.centerSectionPane = new BorderPane();
        this.centerBottomPane = new BorderPane();
        buildPane();
    }

    public void buildPane() {
        this.centerSectionPane = new BorderPane();
        Label title = new Label("Customer Breakdown");
        this.centerSectionPane.setTop(title);
        this.centerSectionPane.setAlignment(title, Pos.TOP_CENTER);
        VBox test = new VBox(this.backEnd.getCustName(this.frontEnd.itemSelected).getDetails());
        centerSectionPane.setCenter(test);
        centerSectionPane.setBottom(this.centerBottomPane);
        centerSectionPane.setMargin(test, new Insets(30));
        setPane();
    }


    public void setPane() {
        // issue is here
        // this needs to be overriden and edit pane altered
        // and for create!!!!
        this.backEnd.viewPane.setCenter(centerSectionPane);
    }
}
