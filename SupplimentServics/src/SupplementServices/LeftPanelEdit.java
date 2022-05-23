package SupplementServices;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class LeftPanelEdit extends LeftPanel {

    LeftPanelEdit(BackEnd backEnd, FrontEndGUI sceneTemplate) {
        super(backEnd, sceneTemplate);
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
        this.sceneTemplate.vbox = new VBox(
                viewCustButton,
                editCustButton,
                this.sceneTemplate.treeView1,
                viewSupButton,
                editSupButton,
                this.sceneTemplate.treeView2
        );
        this.sceneTemplate.vbox.setAlignment(Pos.CENTER);
        this.sceneTemplate.vbox.setMargin(this.sceneTemplate.treeView1, inset);
        this.sceneTemplate.vbox.setMargin(this.sceneTemplate.treeView2, inset);
        this.sceneTemplate.vbox.setMargin(viewCustButton, inset);
        this.sceneTemplate.vbox.setMargin(viewSupButton, inset);
        this.sceneTemplate.vbox.setMargin(editCustButton, inset);
        this.sceneTemplate.vbox.setMargin(editSupButton, inset);
        setPane();
    }

    @Override
    public void setPane() {
        this.backEnd.editPane.setLeft(this.sceneTemplate.vbox);
    }

    @Override
    public void onCustViewButtonClick() {
        // Directly set center pane here with new CenterPanel Class.
        this.sceneTemplate.itemSelected = this.sceneTemplate.treeView1.getSelectionModel().getSelectedItem().getValue();
        System.out.println("viewing customer");
        this.sceneTemplate.refresh();
    }

    public void onCustEditButtonClick() {
        // Directly set center pane here with new CenterPanel Class.
//        this.sceneTemplate.itemSelected = this.sceneTemplate.treeView1.getSelectionModel().getSelectedItem().getValue();
        System.out.println("Editing Customer");
        this.sceneTemplate.refresh();
    }

    @Override
    public void onSupViewButtonClick() {
        this.sceneTemplate.itemSelected = this.sceneTemplate.treeView2.getSelectionModel().getSelectedItem().getValue();
        this.sceneTemplate.refresh();
    }

    public void onSupEditButtonClick() {
//        this.sceneTemplate.itemSelected = this.sceneTemplate.treeView2.getSelectionModel().getSelectedItem().getValue();
        this.sceneTemplate.refresh();
    }
}
