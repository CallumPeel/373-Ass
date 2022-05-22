package SupplementServices;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class FrontEndGUI extends SceneTemplate {
        
    public FrontEndGUI(BackEnd backEnd, int width, int height) {
        super(backEnd, width, height);
    }
    
    private BorderPane viewCenterPane(BorderPane topSectionPane) {
        Label title = new Label("Customer Breakdown");
        topSectionPane.setTop(title);
        topSectionPane.setAlignment(title, Pos.TOP_CENTER);

//        VBox test = new VBox(this.backEnd.getCustName("Callum").getDetails());
        VBox test = new VBox(this.backEnd.getCustName(this.itemSelected).getDetails());
        topSectionPane.setCenter(test);
        topSectionPane.setMargin(test, new Insets(30));
        
        return topSectionPane;
    }
    
    private BorderPane getCenterPane() {
        BorderPane topSectionPane = new BorderPane();
        topSectionPane = viewCenterPane(topSectionPane);
        return topSectionPane;
    }
    
    public void addCenterSection(BorderPane pane) {
        pane.setCenter(getCenterPane());
    }
    
}
