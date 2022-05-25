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

        HBox topButtons = new HBox(newCustButton, deleteCustButton, editCustButton);
        this.frontEnd.vbox = new VBox(
                topButtons,
                this.frontEnd.treeView1
        );
        topButtons.setAlignment(Pos.CENTER);
        topButtons.setPadding(new Insets(10));
        topButtons.setSpacing(10);
        this.frontEnd.vbox.setAlignment(Pos.CENTER);
        this.frontEnd.vbox.setMargin(this.frontEnd.treeView1, inset);

        setPane();
    }

}
