package SupplementServices.Panes;

import SupplementServices.BackEnd;
import SupplementServices.FrontEndGUI;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

/**
 * Template for Bottom panel.
 *
 * @author callum
 */
public class BottomPanel extends MyBPane {

    Button refreshButton;
    int buttonWidth;
    BorderPane bottomSectionPane;

    /**
     * Constructs a Bottom Panel with refresh button.
     *
     * @param backEnd
     * @param frontEnd
     */
    public BottomPanel(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
        this.refreshButton = new Button();
        this.buttonWidth = 150;
        this.bottomSectionPane = new BorderPane();
        buildPane();
    }

    /**
     * Constructs a Bottom Panel with refresh button.
     */
    public void buildPane() {
        this.refreshButton.setText("Refresh");
        this.refreshButton.setOnAction(e -> {
            this.frontEnd.refresh();
        });
        this.refreshButton.setMinWidth(this.buttonWidth);
        this.bottomSectionPane.setCenter(this.refreshButton);
        this.bottomSectionPane.setMargin(this.refreshButton,
                new Insets(30));
        setPane();
    }

    /**
     * Sets default pane to center pane.
     */
    private void setPane() {
        if (this.frontEnd.getIsViewMode()) {
            this.backEnd.viewPane.setBottom(this.bottomSectionPane);
        }
        if (this.frontEnd.getIsEditMode()) {
            this.backEnd.editPane.setBottom(this.bottomSectionPane);
        }
        if (this.frontEnd.getIsCreateMode()) {
            this.backEnd.createPane.setBottom(this.bottomSectionPane);
        }
    }
}
