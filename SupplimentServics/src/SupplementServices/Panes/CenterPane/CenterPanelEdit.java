package SupplementServices.Panes.CenterPane;

import SupplementServices.BackEnd;
import SupplementServices.FrontEndGUI;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/**
 * Builds a template pane for editing fields.
 * @author callum
 */
public class CenterPanelEdit extends CenterPanel {

    private Button saveButton, saveAsButton;
    private int buttonWidth;

    /**
     * Constructs a center panel that contains save buttons.
     * @param backEnd
     * @param frontEnd
     */
    public CenterPanelEdit(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
        this.saveButton = new Button();
        this.saveAsButton = new Button();
        this.buttonWidth = 150;
        setBottomPane();
    }

    /**
     * Adds buttons to bottom section.
     */
    public void setBottomPane() {
        this.saveButton.setText("Save");
        this.saveButton.setOnAction(e -> {
            try {
                onSaveButtonClick();
            } catch (IOException ex) {
                Logger.getLogger(CenterPanelEdit.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        this.saveButton.setMinWidth(this.buttonWidth);
        
        this.saveAsButton.setMinWidth(this.buttonWidth);
        this.saveAsButton.setText("Save As");
        this.saveAsButton.setOnAction(e -> {
            try {
                onSaveAsButtonClick();
            } catch (IOException ex) {
                Logger.getLogger(CenterPanelEdit.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        this.saveAsButton.setMinWidth(this.buttonWidth);

        HBox bottomButtons = new HBox(this.saveButton, saveAsButton);
        bottomButtons.setAlignment(Pos.CENTER);
        bottomButtons.setPadding(new Insets(15, 0, 0, 10));
        bottomButtons.setSpacing(10);
        this.centerBottomPane.setCenter(bottomButtons);
        this.centerBottomPane.setMargin(this.saveButton, new Insets(0, 0, 30, 0));
        this.centerSectionPane.setBottom(this.centerBottomPane);
    }

    /**
     * Saves file in user specified directory.
     * @throws IOException
     */
    public void onSaveAsButtonClick() throws IOException {
        this.backEnd.save(this.frontEnd.getDirectory());
    }

    /**
     * Calls a save function in the back end.
     * @throws IOException
     */
    public void onSaveButtonClick() throws IOException {
        this.backEnd.save();
    }

    /**
     * Sets this Pane by passing to the back end.
     */
    @Override
    public void setPane() {
        this.centerSectionPane.setPadding(new Insets(0, 0, 0, 15));
        this.backEnd.getEditPane().setCenter(this.centerSectionPane);
    }
}
