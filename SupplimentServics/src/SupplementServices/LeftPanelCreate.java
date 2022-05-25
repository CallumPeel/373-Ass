package SupplementServices;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LeftPanelCreate extends LeftPanelEdit {

    LeftPanelCreate(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
    }

    @Override
    public void setPane() {
        this.backEnd.createPane.setLeft(this.frontEnd.vbox);
    }

    @Override
    public void buildPane() {
        Insets inset = new Insets(0, 0, 10, 30);

        Button newButton = new Button();
        newButton.setText("New");
        newButton.setOnAction(
                s -> {
                    try {
                        onCustNewButtonClick();
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
                        onCustEditButtonClick();
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
                        onCustDeleteButtonClick();
                    } catch (Exception e) {
                        System.out.println("Select a Magazine to delete");
                    }
                }
        );

        HBox topButtons = new HBox(newButton, deleteButton, editButton);
        this.frontEnd.vbox = new VBox(
                topButtons,
                this.frontEnd.magazineTreeView
        );
        topButtons.setAlignment(Pos.CENTER);
        topButtons.setPadding(new Insets(10));
        topButtons.setSpacing(10);
        this.frontEnd.vbox.setAlignment(Pos.CENTER);
        this.frontEnd.vbox.setMargin(this.frontEnd.magazineTreeView, inset);

        setPane();
    }

    @Override
    public void onCustNewButtonClick() {
        // new CenterPanelNewMagazine
        new CenterPanelNewCustomer(this.backEnd, this.frontEnd);
    }

    @Override
    public void onCustEditButtonClick() {
        // new CenterPanelEditMagazine
        this.frontEnd.setSelectedCustomer();
        new CenterPanelEditCustomer(this.backEnd, this.frontEnd);
    }

    @Override
    public void onCustDeleteButtonClick() {
        // new CenterPanelDeleteMagazine
        this.frontEnd.setSelectedCustomer();
        new CenterPanelDeleteCustomer(this.backEnd, this.frontEnd);
    }
}
