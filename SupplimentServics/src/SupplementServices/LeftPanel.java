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
        Insets inset = new Insets(0, 15, 15, 15);

        this.frontEnd.treeView1.setOnMouseClicked(
                s -> {
                    try {
                        onCustViewMouseClick();
                    } catch (Exception e) {
                        System.out.println("Select a Customer to view");
                    }
                }
        );
        this.frontEnd.treeView2.setOnMouseClicked(
                s -> {
                    try {
                        onSupViewButtonClick();
                    } catch (Exception e) {
                        System.out.println("Select a Supplement to view");
                    }

                }
        );
        this.frontEnd.vbox = new VBox(this.frontEnd.treeView1, this.frontEnd.treeView2);
        this.frontEnd.vbox.setAlignment(Pos.CENTER);
        this.frontEnd.vbox.setMargin(this.frontEnd.treeView1, inset);
        this.frontEnd.vbox.setMargin(this.frontEnd.treeView2, inset);
        setPane();
    }

    public void setPane() {
        this.backEnd.viewPane.setLeft(this.frontEnd.vbox);
    }

    private void onCustViewMouseClick() {
        this.frontEnd.customerSelected = this.frontEnd.treeView1.getSelectionModel().getSelectedItem().getValue();
        new CenterPanelViewCustomer(this.backEnd, this.frontEnd);
    }

    public void onSupViewButtonClick() {
        this.frontEnd.supplementSelected = this.frontEnd.treeView2.getSelectionModel().getSelectedItem().getValue();
        new CenterPanelViewSupplement(this.backEnd, this.frontEnd);
    }
}
