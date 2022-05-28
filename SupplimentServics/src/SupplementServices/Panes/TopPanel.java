package SupplementServices.Panes;

import SupplementServices.BackEnd;
import SupplementServices.FrontEndGUI;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

public class TopPanel extends MyBPane {

    Label title;
    Button createButton, editButton, viewButton;
    int buttonWidth;
    Separator separator1;
    BorderPane topSectionPane;

    public TopPanel(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
        this.title = new Label("MAGAZINE SERVICES");
        this.title.setFont(new Font("Arial", 20));
        this.title.setPadding(new Insets(20));
        this.createButton = new Button();
        this.editButton = new Button();
        this.viewButton = new Button();
        this.buttonWidth = 150;
        this.separator1 = new Separator();
        this.topSectionPane = new BorderPane();
        buildPane();
    }

    public void buildPane() {
        this.viewButton.setText("View Mode");
        this.viewButton.setOnAction(e -> {
            this.frontEnd.viewMode();
        });
        this.createButton.setText("Create Mode");
        this.createButton.setOnAction(e -> {
            this.frontEnd.createMode();
        });
        this.editButton.setText("Edit Mode");
        this.editButton.setOnAction(e -> {
            this.frontEnd.editMode();
        });
        this.viewButton.setMinWidth(this.buttonWidth);
        this.createButton.setMinWidth(this.buttonWidth);
        this.editButton.setMinWidth(this.buttonWidth);
        this.topSectionPane.setTop(this.title);
        this.topSectionPane.setLeft(this.viewButton);
        this.topSectionPane.setCenter(this.createButton);
        this.topSectionPane.setRight(this.editButton);
        this.topSectionPane.setBottom(this.separator1);
        this.topSectionPane.setAlignment(this.title, Pos.CENTER);
        this.topSectionPane.setAlignment(this.viewButton, Pos.CENTER);
        this.topSectionPane.setAlignment(this.createButton, Pos.CENTER);
        this.topSectionPane.setAlignment(this.editButton, Pos.CENTER);
        this.topSectionPane.setMargin(this.title, new Insets(15, 0, 0, 0));
        Insets insets = new Insets(15, 50, 15, 50);
        this.topSectionPane.setMargin(this.viewButton, insets);
        this.topSectionPane.setMargin(this.createButton, insets);
        this.topSectionPane.setMargin(this.editButton, insets);
        this.topSectionPane.setMargin(this.separator1, insets);
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
