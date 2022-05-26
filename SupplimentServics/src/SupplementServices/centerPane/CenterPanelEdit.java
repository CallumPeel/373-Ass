package SupplementServices.centerPane;

import SupplementServices.BackEnd;
import SupplementServices.FrontEndGUI;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        this.saveButton.setText("Commit Changes");
        this.saveButton.setOnAction(e -> {
            try {
                onSaveChangesButtonClick();
            } catch (IOException ex) {
                Logger.getLogger(CenterPanelEdit.class.getName()).log(Level.SEVERE, null, ex);
            }
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

    public void onSaveChangesButtonClick() throws IOException {
        this.backEnd.save();
    }

    @Override
    public void setPane() {
        this.centerSectionPane.setPadding(new Insets(25, 0, 0, 50));
        this.backEnd.getEditPane().setCenter(this.centerSectionPane);
    }
}
