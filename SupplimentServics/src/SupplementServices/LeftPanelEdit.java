package SupplementServices;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LeftPanelEdit extends LeftPanel {

    LeftPanelEdit(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
    }

    @Override
    public void buildPane() {
        Insets inset = new Insets(0, 0, 10, 10);

        Button newCustButton = new Button();
        newCustButton.setText("New Customer");
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
        editCustButton.setText("Edit Customer");
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
        deleteCustButton.setText("Delete Customer");
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
        newSupButton.setText("New Supplement");
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
        editSupButton.setText("Edit Supplement");
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
        deleteSupButton.setText("Delete Supplement");
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
        this.frontEnd.vbox = new VBox(
                topButtons,
                this.frontEnd.treeView1,
                bottomButtons,
                this.frontEnd.treeView2
        );
        topButtons.setAlignment(Pos.CENTER);
        topButtons.setPadding(new Insets(10));
        topButtons.setSpacing(10);
        bottomButtons.setAlignment(Pos.CENTER);
        bottomButtons.setPadding(new Insets(10));
        bottomButtons.setSpacing(10);
        this.frontEnd.vbox.setAlignment(Pos.CENTER);
        this.frontEnd.vbox.setMargin(this.frontEnd.treeView1, inset);
        this.frontEnd.vbox.setMargin(this.frontEnd.treeView2, inset);

        setPane();
    }

    @Override
    public void setPane() {
        this.backEnd.editPane.setLeft(this.frontEnd.vbox);
    }

    private void onCustNewButtonClick() {
        this.frontEnd.itemSelected = this.frontEnd.treeView1.getSelectionModel().getSelectedItem().getValue();
    }

    public void onCustEditButtonClick() {
        this.frontEnd.itemSelected = this.frontEnd.treeView1.getSelectionModel().getSelectedItem().getValue();
        new CenterPanelEditCustomner(this.backEnd, this.frontEnd);
    }

    public void onCustDeleteButtonClick() {

        this.frontEnd.itemSelected = this.frontEnd.treeView1.getSelectionModel().getSelectedItem().getValue();
//        new CenterPanelEdit(this.backEnd, this.frontEnd);
        System.out.println("Deleting Customer");
        this.frontEnd.refresh();
    }

    public void onSupNewButtonClick() {
//        this.sceneTemplate.itemSelected = this.sceneTemplate.treeView2.getSelectionModel().getSelectedItem().getValue();

        System.out.println("Creating new Supplement");
        this.frontEnd.refresh();
    }

    public void onSupEditButtonClick() {
//        this.sceneTemplate.itemSelected = this.sceneTemplate.treeView2.getSelectionModel().getSelectedItem().getValue();

        System.out.println("Editing Supplement");
        this.frontEnd.refresh();
    }

    public void onSupDeleteButtonClick() {
//        this.sceneTemplate.itemSelected = this.sceneTemplate.treeView2.getSelectionModel().getSelectedItem().getValue();
        System.out.println("Deleting Supplement");
        this.frontEnd.refresh();
    }

}
