package SupplementServices;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class LeftPanel extends MyBPane {

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

    private void onCustViewButtonClick() {
        this.frontEnd.itemSelected = this.frontEnd.treeView1.getSelectionModel().getSelectedItem().getValue();
        new CenterPanelViewCustomer(this.backEnd, this.frontEnd);
    }

    public void onSupViewButtonClick() {
        this.frontEnd.itemSelected = this.frontEnd.treeView2.getSelectionModel().getSelectedItem().getValue();
        // new CenterPanelViewSupplement(this.backEnd, this.frontEnd);
    }
}
