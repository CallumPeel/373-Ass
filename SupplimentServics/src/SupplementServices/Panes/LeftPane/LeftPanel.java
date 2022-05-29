package SupplementServices.Panes.LeftPane;

import SupplementServices.BackEnd;
import SupplementServices.FrontEndGUI;
import SupplementServices.Panes.MyBPane;
import SupplementServices.Panes.CenterPane.CenterPanelViewSupplement;
import SupplementServices.Panes.CenterPane.CenterPanelViewCustomer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 * Template for left panel.
 *
 * @author callum
 */
public class LeftPanel extends MyBPane {

    /**
     * Constructs a Left Panel.
     *
     * @param backEnd
     * @param sceneTemplate
     */
    public LeftPanel(BackEnd backEnd, FrontEndGUI sceneTemplate) {
        super(backEnd, sceneTemplate);
        buildPane();
    }

    /**
     * Creates tree views of customers and supplement information.
     */
    public void buildPane() {
        Insets inset = new Insets(0, 15, 10, 30);
        Label customerLabel = new Label("Customers");
        customerLabel.setFont(new Font("Arial", 15));
        customerLabel.setPadding(new Insets(0, 15, 10, 30));
        Label supplementLabel = new Label("Supplements");
        supplementLabel.setFont(new Font("Arial", 15));
        supplementLabel.setPadding(new Insets(20, 15, 10, 30));
        this.frontEnd.customerTreeView.setOnMouseClicked(
                s -> {
                    try {
                        onCustViewMouseClick();
                    } catch (Exception e) {
                        System.out.println("Select a Customer to view");
                    }
                }
        );
        this.frontEnd.supplementTreeView.setOnMouseClicked(
                s -> {
                    try {
                        onSupViewButtonClick();
                    } catch (Exception e) {
                        System.out.println("Select a Supplement to view");
                    }

                }
        );
        this.frontEnd.vbox = new VBox(customerLabel, this.frontEnd.customerTreeView, supplementLabel, this.frontEnd.supplementTreeView);
        this.frontEnd.vbox.setAlignment(Pos.CENTER);
        this.frontEnd.vbox.setMargin(this.frontEnd.customerTreeView, inset);
        this.frontEnd.vbox.setMargin(this.frontEnd.supplementTreeView, inset);
        setPane();
    }

    /**
     * Sets default pane to center pane.
     */
    public void setPane() {
        this.backEnd.getViewPane().setLeft(this.frontEnd.vbox);
    }

    /**
     * Creates a new instance of CenterPanelViewCustomer.
     */
    private void onCustViewMouseClick() {
        this.frontEnd.customerSelected = this.frontEnd.customerTreeView.getSelectionModel().getSelectedItem().getValue();
        new CenterPanelViewCustomer(this.backEnd, this.frontEnd);
    }

    /**
     * Creates a new instance of CenterPanelViewSupplement.
     */
    public void onSupViewButtonClick() {
        this.frontEnd.supplementSelected = this.frontEnd.supplementTreeView.getSelectionModel().getSelectedItem().getValue();
        new CenterPanelViewSupplement(this.backEnd, this.frontEnd);
    }
}
