package SupplementServices;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class CenterPanelView extends MyPanel {

    BorderPane centerSectionPane;
    BorderPane centerBottomPane;

    public CenterPanelView(BackEnd backEnd, FrontEndGUI frontEnd) {
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
        addTreeView();
        setPane();
    }

    private void addTreeView() {
        VBox test = new VBox(this.backEnd.getCustName(this.frontEnd.itemSelected).getDetails());
        centerSectionPane.setCenter(test);
        centerSectionPane.setBottom(this.centerBottomPane);
        centerSectionPane.setMargin(test, new Insets(30));
    }

    public void setPane() {
        this.backEnd.viewPane.setCenter(centerSectionPane);
    }
}
