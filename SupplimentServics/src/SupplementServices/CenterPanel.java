package SupplementServices;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class CenterPanel extends MyPanel {

    BorderPane centerSectionPane;
    Button viewCustomerButton, viewSupplementButton;

    public CenterPanel(BackEnd backEnd, FrontEndGUI sceneTemplate) {
        super(backEnd, sceneTemplate);
        buildPane();
    }

    private void buildPane() {
        this.centerSectionPane = new BorderPane();
        Label title = new Label("Customer Breakdown");
        this.centerSectionPane.setTop(title);
        this.centerSectionPane.setAlignment(title, Pos.TOP_CENTER);
//        VBox test = new VBox(this.backEnd.getCustName("Callum").getDetails());
        VBox test = new VBox(this.backEnd.getCustName(this.sceneTemplate.itemSelected).getDetails());
        centerSectionPane.setCenter(test);
        centerSectionPane.setMargin(test, new Insets(30));
        setPane();
    }

    public void setPane() {
        // issue is here
        this.backEnd.viewPane.setCenter(centerSectionPane);
    }
}
