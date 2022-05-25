/*
 * Student Name: Callum Peel
 * Student ID: 34217062
 */
package SupplementServices.centerPane;

import SupplementServices.BackEnd;
import SupplementServices.Customer;
import SupplementServices.FrontEndGUI;
import javafx.scene.layout.VBox;

/**
 *
 * @author callum
 */
public class CenterPanelNewCustomer extends CenterPanelEdit {

    Customer customer;
    VBox labels;

    public CenterPanelNewCustomer(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
        this.customer = new Customer();
        this.labels = getLabels();
        setCenterPane();
    }

    private void setCenterPane() {
        this.centerSectionPane.setCenter(
                this.customer.getVBox(this.backEnd.getPayingCustomerList())
        );
        setPane();
    }

    private VBox getLabels() {
        VBox buttons = new VBox();
        return buttons;
    }

    @Override
    public void onSaveChangesButtonClick() {
        System.out.println("Save button clicked on new");
        this.backEnd.getCustomers().add(this.customer);
        this.frontEnd.setDefaultSelectedCustomer();
        this.frontEnd.refresh();

    }
}
