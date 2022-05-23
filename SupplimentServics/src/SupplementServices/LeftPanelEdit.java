package SupplementServices;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class LeftPanelEdit extends LeftPanel {

    LeftPanelEdit(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
    }

    @Override
    public void buildPane() {
        Insets inset = new Insets(0, 0, 10, 10);

        Button viewCustButton = new Button();
        viewCustButton.setText("View Customer");
        viewCustButton.setOnAction(
                s -> {
                    try {
                        onCustViewButtonClick();
                    } catch (Exception e) {
                        System.out.println("Select a Customer");
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
        Button viewSupButton = new Button();
        viewSupButton.setText("View Supplement");
        viewSupButton.setOnAction(
                s -> {
                    try {
                        onSupViewButtonClick();
                    } catch (Exception e) {
                        System.out.println("Select a Supplement to view");
                    }

                }
        );
        Button editSupButton = new Button();
        editSupButton.setText("Edit Supplement");
        editSupButton.setOnAction(
                s -> {
                    try {
                        onSupViewButtonClick();
                    } catch (Exception e) {
                        System.out.println("Select a Supplement to edit");
                    }

                }
        );
        this.frontEnd.vbox = new VBox(
                viewCustButton,
                editCustButton,
                this.frontEnd.treeView1,
                viewSupButton,
                editSupButton,
                this.frontEnd.treeView2
        );
        this.frontEnd.vbox.setAlignment(Pos.CENTER);
        this.frontEnd.vbox.setMargin(this.frontEnd.treeView1, inset);
        this.frontEnd.vbox.setMargin(this.frontEnd.treeView2, inset);
        this.frontEnd.vbox.setMargin(viewCustButton, inset);
        this.frontEnd.vbox.setMargin(viewSupButton, inset);
        this.frontEnd.vbox.setMargin(editCustButton, inset);
        this.frontEnd.vbox.setMargin(editSupButton, inset);
        setPane();
    }

    @Override
    public void setPane() {
        this.backEnd.editPane.setLeft(this.frontEnd.vbox);
    }

    public void onCustEditButtonClick() {
        
        this.frontEnd.itemSelected = this.frontEnd.treeView1.getSelectionModel().getSelectedItem().getValue();
//        new CenterPanelEdit(this.backEnd, this.frontEnd);
        System.out.println("Editing Customer");
        this.frontEnd.refresh();
    }

    public void onSupEditButtonClick() {
//        this.sceneTemplate.itemSelected = this.sceneTemplate.treeView2.getSelectionModel().getSelectedItem().getValue();
        this.frontEnd.refresh();
    }
}
