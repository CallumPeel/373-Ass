package SupplementServices;

import javafx.geometry.Insets;
import javafx.scene.control.Button;

public class CenterPanelEdit extends CenterPanel {

    private Button editButton, deleteButton;
    private int buttonWidth;

    public CenterPanelEdit(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
        this.editButton = new Button();
        this.deleteButton = new Button();
        this.buttonWidth = 150;
        setBottomPane();
    }

    public void setBottomPane() {
        this.editButton.setText("Edit");
        this.editButton.setOnAction(e -> {
            System.out.println("Edit button clicked\n");
//            this.sceneTemplate.refresh();
        });
        this.editButton.setMinWidth(this.buttonWidth);
        this.centerBottomPane.setCenter(this.editButton);
        this.centerBottomPane.setMargin(this.editButton, new Insets(0, 0, 30, 0));
        this.centerSectionPane.setBottom(this.centerBottomPane);
    }

    @Override
    public void setPane() {
        this.backEnd.editPane.setCenter(centerSectionPane);
    }
}
