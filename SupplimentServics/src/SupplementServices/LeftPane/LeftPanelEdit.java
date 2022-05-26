package SupplementServices.LeftPane;

import SupplementServices.BackEnd;
import SupplementServices.FrontEndGUI;
import SupplementServices.MyVBox;
import SupplementServices.centerPane.CenterPanelDeleteSupplement;
import SupplementServices.centerPane.CenterPanelNewSupplement;
import SupplementServices.centerPane.CenterPanelEditSupplement;
import SupplementServices.centerPane.CenterPanelNewCustomer;
import SupplementServices.centerPane.CenterPanelDeleteCustomer;
import SupplementServices.centerPane.CenterPanelEditCustomer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LeftPanelEdit extends LeftPanel {

    public LeftPanelEdit(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
    }

    @Override
    public void buildPane() {
        Insets inset = new Insets(0, 0, 10, 30);

        Button newCustButton = new Button();
        newCustButton.setText("New");
        newCustButton.setOnAction(
                s -> {
                    try {
                        onCustNewButtonClick();
                    } catch (Exception e) {
                        System.out.println("Something Went Wrong...");
                    }
                }
        );
        Button editCustButton = new Button();
        editCustButton.setText("Edit");
        editCustButton.setOnAction(
                s -> {
                    try {
                        onCustEditButtonClick();
                    } catch (Exception e) {
                        System.out.println("Select a Customer to edit");
                    }
                }
        );
        Button deleteCustButton = new Button();
        deleteCustButton.setText("Delete");
        deleteCustButton.setOnAction(
                s -> {
                    try {
                        onCustDeleteButtonClick();
                    } catch (Exception e) {
                        System.out.println("Select a Customer to delete");
                    }
                }
        );
        Button newSupButton = new Button();
        newSupButton.setText("New");
        newSupButton.setOnAction(
                s -> {
                    try {
                        onSupNewButtonClick();
                    } catch (Exception e) {
                        System.out.println("Something went wrong...");
                    }

                }
        );
        Button editSupButton = new Button();
        editSupButton.setText("Edit");
        editSupButton.setOnAction(
                s -> {
                    try {
                        onSupEditButtonClick();
                    } catch (Exception e) {
                        System.out.println("Select a Supplement to edit");
                    }

                }
        );
        Button deleteSupButton = new Button();
        deleteSupButton.setText("Delete");
        deleteSupButton.setOnAction(
                s -> {
                    try {
                        onSupDeleteButtonClick();
                    } catch (Exception e) {
                        System.out.println("Select a Supplement to delete");
                    }

                }
        );
        HBox topButtons = new HBox(newCustButton, deleteCustButton, editCustButton);
        HBox bottomButtons = new HBox(newSupButton, deleteSupButton, editSupButton);
        this.frontEnd.vbox = new MyVBox(
                topButtons,
                this.frontEnd.customerTreeView,
                bottomButtons,
                this.frontEnd.supplementTreeView
        );
        topButtons.setAlignment(Pos.CENTER);
        topButtons.setPadding(new Insets(10,10,20,30));
        topButtons.setSpacing(20);
        bottomButtons.setAlignment(Pos.CENTER);
        bottomButtons.setPadding(new Insets(20,10,20,30));
        bottomButtons.setSpacing(20);
        this.frontEnd.vbox.setAlignment(Pos.CENTER);
        this.frontEnd.vbox.setMargin(this.frontEnd.customerTreeView, inset);
        this.frontEnd.vbox.setMargin(this.frontEnd.supplementTreeView, inset);

        setPane();
    }

    @Override
    public void setPane() {
        this.backEnd.getEditPane().setLeft(this.frontEnd.vbox);
    }

    public void onCustNewButtonClick() {
        new CenterPanelNewCustomer(this.backEnd, this.frontEnd);
    }

    public void onCustEditButtonClick() {
        this.frontEnd.setSelectedCustomer();
        new CenterPanelEditCustomer(this.backEnd, this.frontEnd);
    }

    public void onCustDeleteButtonClick() {
        this.frontEnd.setSelectedCustomer();
        new CenterPanelDeleteCustomer(this.backEnd, this.frontEnd);
    }

    public void onSupNewButtonClick() {
        new CenterPanelNewSupplement(this.backEnd, this.frontEnd);
        System.out.println("Creating new Supplement");
    }

    public void onSupEditButtonClick() {
        this.frontEnd.setSelectedSupplement();
        new CenterPanelEditSupplement(this.backEnd, this.frontEnd);
        System.out.println("Editing Supplement");
    }

    public void onSupDeleteButtonClick() {
        this.frontEnd.setSelectedSupplement();
        new CenterPanelDeleteSupplement(this.backEnd, this.frontEnd);
    }

}
