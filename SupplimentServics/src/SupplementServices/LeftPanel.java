package SupplementServices;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class LeftPanel extends MyPanel {

    Button viewCustomerButton, viewSupplementButton;

    public LeftPanel(BackEnd backEnd, FrontEndGUI sceneTemplate) {
        super(backEnd, sceneTemplate);
        buildPane();
    }

    public void buildPane() {
        Insets inset = new Insets(0, 0, 15, 15);

        Button viewCustButton = new Button();
        viewCustButton.setText("View Customer");
        viewCustButton.setOnAction(
                s -> {
                    try {
                        onCustViewButtonClick();
                    } catch (Exception e) {
                        System.out.println("Select a Customer to view");
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
        this.frontEnd.vbox = new VBox(viewCustButton, this.frontEnd.treeView1, viewSupButton, this.frontEnd.treeView2);
        this.frontEnd.vbox.setAlignment(Pos.CENTER);
        this.frontEnd.vbox.setMargin(this.frontEnd.treeView1, inset);
        this.frontEnd.vbox.setMargin(this.frontEnd.treeView2, inset);
        this.frontEnd.vbox.setMargin(viewCustButton, inset);
        this.frontEnd.vbox.setMargin(viewSupButton, inset);
        setPane();
    }

    public void setPane() {
        this.backEnd.viewPane.setLeft(this.frontEnd.vbox);
    }

    public void onCustViewButtonClick() {
        // Directly set center pane here with new CenterPanel Class.
        this.frontEnd.itemSelected = this.frontEnd.treeView1.getSelectionModel().getSelectedItem().getValue();
        System.out.println("View Modeeee");
        this.frontEnd.refresh();
    }

    public void onSupViewButtonClick() {
        this.frontEnd.itemSelected = this.frontEnd.treeView2.getSelectionModel().getSelectedItem().getValue();
        this.frontEnd.refresh();
    }
}
