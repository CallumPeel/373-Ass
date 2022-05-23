package SupplementServices;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class CenterPanelEdit extends CenterPanelView {

    private Button editButton, deleteButton;
    private int buttonWidth;

    public CenterPanelEdit(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
        this.editButton = new Button();
        this.deleteButton = new Button();
        this.buttonWidth = 150;
        setBottomPane();
        setCenterPane();
    }
    
    private void setCenterPane() {
        Button x = new Button();
        this.centerSectionPane.setCenter(x);
        setPane();
    }

    private void setBottomPane() {
        this.editButton.setText("Edit");
        this.editButton.setOnAction(e -> {
            System.out.println("Edit button clicked\n");
//            this.sceneTemplate.refresh();
        });
        this.editButton.setMinWidth(this.buttonWidth);

        this.deleteButton.setText("Delete");
        this.deleteButton.setOnAction(e -> {
            System.out.println("Delete button clicked\n");
//            this.sceneTemplate.refresh();
        });
        this.deleteButton.setMinWidth(this.buttonWidth);
        HBox bottomButtons = new HBox(this.editButton, this.deleteButton);
        bottomButtons.setAlignment(Pos.CENTER);
        bottomButtons.setPadding(new Insets(20));
        bottomButtons.setSpacing(10);
        this.centerBottomPane.setCenter(bottomButtons);
        this.centerBottomPane.setMargin(this.editButton, new Insets(0, 0, 30, 0));
        this.centerSectionPane.setBottom(this.centerBottomPane);
    }
    
    @Override
    public void setPane() {
        this.backEnd.editPane.setCenter(centerSectionPane);
    }
}
