package SupplementServices;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.BorderPane;

public class TopPanel extends MyPanel {

    Label title;
    Button cButton, eButton, vButton;
    int buttonWidth;
    Separator separator1;
    BorderPane topSectionPane;

    public TopPanel(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
        this.title = new Label("MAGAZINE SERVICES");
        this.cButton = new Button();
        this.eButton = new Button();
        this.vButton = new Button();
        this.buttonWidth = 150;
        this.separator1 = new Separator();
        this.topSectionPane = new BorderPane();
        buildPane();
    }

    private void buildPane() {
        vButton.setText("View Mode");
        vButton.setOnAction(e -> {
            onViewButtonClick();
            System.out.println("View Mode Activated\n");
        });
        cButton.setText("Create Mode");
        cButton.setOnAction(e -> {
            onCreateButtonClick();
            System.out.println("Create Mode Activated\n");
        });
        eButton.setText("Edit Mode");
        eButton.setOnAction(e -> {
            onEditButtonClick();
            System.out.println("Edit Mode Activated\n");
        });
        vButton.setMinWidth(buttonWidth);
        cButton.setMinWidth(buttonWidth);
        eButton.setMinWidth(buttonWidth);

        topSectionPane.setTop(title);
        topSectionPane.setLeft(vButton);
        topSectionPane.setCenter(cButton);
        topSectionPane.setRight(eButton);
        topSectionPane.setBottom(separator1);
        topSectionPane.setAlignment(title, Pos.CENTER);
        topSectionPane.setAlignment(vButton, Pos.CENTER);
        topSectionPane.setAlignment(cButton, Pos.CENTER);
        topSectionPane.setAlignment(eButton, Pos.CENTER);
        topSectionPane.setMargin(title, new Insets(15, 0, 0, 0));
        Insets insets = new Insets(15, 40, 15, 40);
        topSectionPane.setMargin(vButton, insets);
        topSectionPane.setMargin(cButton, insets);
        topSectionPane.setMargin(eButton, insets);
        topSectionPane.setMargin(separator1, insets);
        setPane();
    }

    public void onViewButtonClick() {
        this.frontEnd.viewMode();
    }

    public void onCreateButtonClick() {
        this.frontEnd.createMode();
    }

    public void onEditButtonClick() {
        this.frontEnd.editMode();
    }

    private void setPane() {
        if (this.frontEnd.isViewMode) {
            this.backEnd.viewPane.setTop(this.topSectionPane);
        }
        if (this.frontEnd.isEditMode) {
            this.backEnd.editPane.setTop(this.topSectionPane);
        }
        if (this.frontEnd.isCreateMode) {
            this.backEnd.createPane.setTop(this.topSectionPane);
        }
    }
}
