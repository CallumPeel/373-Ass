package SupplementServices.Panes.LeftPane;

import SupplementServices.BackEnd;
import SupplementServices.FrontEndGUI;
import SupplementServices.Panes.CenterPane.CenterPanelDeleteSupplement;
import SupplementServices.Panes.CenterPane.CenterPanelNewSupplement;
import SupplementServices.Panes.CenterPane.CenterPanelEditSupplement;
import SupplementServices.Panes.CenterPane.CenterPanelNewCustomer;
import SupplementServices.Panes.CenterPane.CenterPanelDeleteCustomer;
import SupplementServices.Panes.CenterPane.CenterPanelEditCustomer;
import SupplementServices.Panes.CenterPane.CenterPanelNewCustomerPaying;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Builds a template pane for editing fields.
 *
 * @author callu
 */
public class LeftPanelEdit extends LeftPanelView {

    /**
     * Constructs Tree Views and editing buttons.
     *
     * @param backEnd
     * @param frontEnd
     */
    public LeftPanelEdit(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
    }

    /**
     * Creates tree views and relevant editing buttons.
     */
    @Override
    public void buildPane() {
        Insets inset = new Insets(0, 0, 10, 30);
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

        Button newCustPayingButton = new Button();
        newCustPayingButton.setText("New Paying Customer");
        newCustPayingButton.setOnAction(
                s -> {
                    try {
                        onCustPayingNewButtonClick();
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
        HBox topButtons = new HBox(newCustButton, newCustPayingButton, deleteCustButton, editCustButton);
        HBox bottomButtons = new HBox(newSupButton, deleteSupButton, editSupButton);
        this.frontEnd.setLeftVBox(new VBox(
                topButtons,
                this.frontEnd.customerTreeView(),
                bottomButtons,
                this.frontEnd.getSupplementTreeView()
        ));
        topButtons.setAlignment(Pos.CENTER);
        topButtons.setPadding(new Insets(10, 10, 20, 30));
        topButtons.setSpacing(20);
        bottomButtons.setAlignment(Pos.CENTER);
        bottomButtons.setPadding(new Insets(20, 10, 20, 30));
        bottomButtons.setSpacing(20);
        this.frontEnd.getLeftVBox().setAlignment(Pos.CENTER);
        this.frontEnd.getLeftVBox().setMargin(this.frontEnd.customerTreeView(), inset);
        this.frontEnd.getLeftVBox().setMargin(this.frontEnd.getSupplementTreeView(), inset);

        setPane();
    }

    /**
     * Sets this Pane by passing to the back end.
     */
    @Override
    public void setPane() {
        this.backEnd.getEditPane().setLeft(this.frontEnd.getLeftVBox());
    }

    /**
     * Creates a center panel for creating a new Customer.
     */
    public void onCustNewButtonClick() {
        new CenterPanelNewCustomer(this.backEnd, this.frontEnd);
    }

    /**
     * Creates a center panel for creating a new Paying Customer.
     */
    public void onCustPayingNewButtonClick() {
        new CenterPanelNewCustomerPaying(this.backEnd, this.frontEnd);
    }

    /**
     * Creates a center panel for editing a new Paying Customer.
     */
    public void onCustEditButtonClick() {
        this.frontEnd.setSelectedCustomer();
        new CenterPanelEditCustomer(this.backEnd, this.frontEnd);
    }

    /**
     * Creates a center panel for deleting a new Paying Customer.
     */
    public void onCustDeleteButtonClick() {
        this.frontEnd.setSelectedCustomer();
        new CenterPanelDeleteCustomer(this.backEnd, this.frontEnd);
    }

    /**
     * Creates a center panel for creating a new Supplement.
     */
    public void onSupNewButtonClick() {
        new CenterPanelNewSupplement(this.backEnd, this.frontEnd);
        System.out.println("Creating new Supplement");
    }

    /**
     * Creates a center panel for editing a Supplement.
     */
    public void onSupEditButtonClick() {
        this.frontEnd.setSelectedSupplement();
        new CenterPanelEditSupplement(this.backEnd, this.frontEnd);
        System.out.println("Editing Supplement");
    }

    /**
     * Creates a center panel for deleting a Supplement.
     */
    public void onSupDeleteButtonClick() {
        this.frontEnd.setSelectedSupplement();
        new CenterPanelDeleteSupplement(this.backEnd, this.frontEnd);
    }

}
