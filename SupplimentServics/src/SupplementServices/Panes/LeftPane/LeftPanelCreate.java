package SupplementServices.Panes.LeftPane;

import SupplementServices.BackEnd;
import SupplementServices.FrontEndGUI;
import SupplementServices.Panes.MyVBox;
import SupplementServices.Panes.CenterPane.CenterPanelDeleteMag;
import SupplementServices.Panes.CenterPane.CenterPanelEditMagazine;
import SupplementServices.Panes.CenterPane.CenterPanelNewMagazine;
import SupplementServices.Panes.CenterPane.CenterPanelViewMagazine;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class LeftPanelCreate extends LeftPanelEdit {

    public LeftPanelCreate(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
    }

    @Override
    public void setPane() {
        this.backEnd.getCreatePane().setLeft(this.frontEnd.vbox);
    }

    @Override
    public void buildPane() {
        Insets inset = new Insets(0, 0, 10, 30);

        Button newButton = new Button();
        newButton.setText("New");
        newButton.setOnAction(
                s -> {
                    try {
                        onNewButtonClick();
                    } catch (Exception e) {
                        System.out.println("Something Went Wrong...");
                    }
                }
        );
        Button editButton = new Button();
        editButton.setText("Edit");
        editButton.setOnAction(
                s -> {
                    try {
                        onEditButtonClick();
                    } catch (Exception e) {
                        System.out.println("Select a Magazine to edit");
                    }
                }
        );
        Button deleteButton = new Button();
        deleteButton.setText("Delete");
        deleteButton.setOnAction(
                s -> {
                    try {
                        onDeleteButtonClick();
                    } catch (Exception e) {
                        System.out.println("Select a Magazine to delete");
                    }
                }
        );
        this.frontEnd.magazineTreeView.setOnMouseClicked(
                s -> {
                    try {
                        onMagViewMouseClick();
                    } catch (Exception e) {
                        System.out.println(this.frontEnd.magazineSelected);
                        System.out.println("Select a Customer to view");
                    }
                }
        );
        HBox topButtons = new HBox(newButton, deleteButton, editButton);
        this.frontEnd.vbox = new MyVBox(
                topButtons,
                this.frontEnd.magazineTreeView
        );
        topButtons.setAlignment(Pos.CENTER);
        topButtons.setPadding(new Insets(10));
        topButtons.setSpacing(20);
        this.frontEnd.vbox.setAlignment(Pos.CENTER);
        this.frontEnd.vbox.setMargin(this.frontEnd.magazineTreeView, inset);

        setPane();
    }

    public void onNewButtonClick() {
        new CenterPanelNewMagazine(this.backEnd, this.frontEnd);
    }

    public void onEditButtonClick() {
        this.frontEnd.setSelectedMagazine();
        new CenterPanelEditMagazine(this.backEnd, this.frontEnd);
    }

    public void onDeleteButtonClick() {
        this.frontEnd.setSelectedMagazine();
        new CenterPanelDeleteMag(this.backEnd, this.frontEnd);
    }

    private void onMagViewMouseClick() {
        this.frontEnd.setSelectedMagazine();
        new CenterPanelViewMagazine(this.backEnd, this.frontEnd);
    }
}
