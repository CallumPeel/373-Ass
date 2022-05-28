package SupplementServices;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class BottomPanel extends MyBPane{

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
