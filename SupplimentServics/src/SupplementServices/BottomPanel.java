package SupplementServices;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class BottomPanel extends MyPanel {

    Button refreshButton;
    int buttonWidth;
    BorderPane bottomSectionPane;

    public BottomPanel(BackEnd backEnd, FrontEndGUI sceneTemplate) {
        super(backEnd, sceneTemplate);
        this.refreshButton = new Button();
        this.buttonWidth = 150;
        this.bottomSectionPane = new BorderPane();
        buildPane();
    }

    private void buildPane() {
        refreshButton.setText("Refresh");
        refreshButton.setOnAction(e -> {
            System.out.println("Page Refreshed\n");
            this.sceneTemplate.refresh();
        });
        refreshButton.setMinWidth(buttonWidth);
        bottomSectionPane.setCenter(refreshButton);
        bottomSectionPane.setMargin(refreshButton,
                new Insets(0, 0, 30, 0));
        setPane();
    }

    private void setPane() {
        if (this.sceneTemplate.isViewMode) {
            this.backEnd.viewPane.setBottom(this.bottomSectionPane);
        }
        if (this.sceneTemplate.isEditMode) {
            this.backEnd.editPane.setBottom(this.bottomSectionPane);
        }
        if (this.sceneTemplate.isCreateMode) {
            this.backEnd.createPane.setBottom(this.bottomSectionPane);
        }
    }
}
