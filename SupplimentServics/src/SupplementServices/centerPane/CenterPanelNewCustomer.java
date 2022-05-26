/*
 * Student Name: Callum Peel
 * Student ID: 34217062
 */
package SupplementServices.centerPane;

import SupplementServices.BackEnd;
import SupplementServices.Customer;
import SupplementServices.FrontEndGUI;
import SupplementServices.MyVBox;
import java.io.IOException;
import javafx.scene.layout.VBox;

/**
 *
 * @author callum
 */
public class CenterPanelNewCustomer extends CenterPanelEdit {

    Customer customer;
    MyVBox labels;

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

    private MyVBox getLabels() {
        MyVBox buttons = new MyVBox();
        return buttons;
    }

    @Override
    public void onSaveChangesButtonClick() throws IOException {
        System.out.println("Save button clicked on new");
        this.backEnd.getCustomers().add(this.customer);
        this.frontEnd.setDefaultSelectedCustomer();
        this.backEnd.save();
        this.frontEnd.refresh();

    }
}
