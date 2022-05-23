package SupplementServices;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class BottomPanel extends MyPanel {

    Button refreshButton;
    int buttonWidth;
    BorderPane bottomSectionPane;

    public BottomPanel(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
        this.refreshButton = new Button();
        this.buttonWidth = 150;
        this.bottomSectionPane = new BorderPane();
        buildPane();
    }

    private void buildPane() {
        refreshButton.setText("Refresh");
        refreshButton.setOnAction(e -> {
            System.out.println("Page Refreshed\n");
            this.frontEnd.refresh();
        });
        refreshButton.setMinWidth(buttonWidth);
        bottomSectionPane.setCenter(refreshButton);
        bottomSectionPane.setMargin(refreshButton,
                new Insets(0, 20, 30, 0));
        setPane();
    }

    private void setPane() {
        if (this.frontEnd.isViewMode) {
            this.backEnd.viewPane.setBottom(this.bottomSectionPane);
        }
        if (this.frontEnd.isEditMode) {
            this.backEnd.editPane.setBottom(this.bottomSectionPane);
        }
        if (this.frontEnd.isCreateMode) {
            this.backEnd.createPane.setBottom(this.bottomSectionPane);
        }
    }
}
