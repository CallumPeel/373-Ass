package SupplementServices;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class CenterPanelEdit extends CenterPanel {

    private Button saveButton;
    private int buttonWidth;

    public CenterPanelEdit(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
        this.saveButton = new Button();
        this.buttonWidth = 150;
        setBottomPane();
    }

    public void setBottomPane() {
        this.saveButton.setText("Save");
        this.saveButton.setOnAction(e -> {
            onSaveButtonClick();
        });
        this.saveButton.setMinWidth(this.buttonWidth);

        HBox bottomButtons = new HBox(this.saveButton);
        bottomButtons.setAlignment(Pos.CENTER);
        bottomButtons.setPadding(new Insets(15, 0, 0, 10));
        bottomButtons.setSpacing(10);
        this.centerBottomPane.setCenter(bottomButtons);
        this.centerBottomPane.setMargin(this.saveButton, new Insets(0, 0, 30, 0));
        this.centerSectionPane.setBottom(this.centerBottomPane);
    }

    public void onSaveButtonClick() {
        System.out.println("Save button clicked");
    }

    @Override
    public void setPane() {
        this.backEnd.editPane.setCenter(centerSectionPane);
    }
}
