/*
 * Student Name: Callum Peel
 * Student ID: 34217062
 */
package SupplementServices.Panes.CenterPane;

import SupplementServices.BackEnd;
import SupplementServices.Customer;
import SupplementServices.FrontEndGUI;
import SupplementServices.Panes.MyVBox;
import java.io.IOException;
import javafx.scene.control.ChoiceBox;

/**
 * Displays customer fields to be created in the center pane.
 * @author callum
 */
public class CenterPanelNewCustomer extends CenterPanelEdit {

    Customer customer;
    MyVBox labels;

    /**
     * Constructs a center panel for input of new Customer's fields.
     * @param backEnd
     * @param frontEnd
     */
    public CenterPanelNewCustomer(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
        setCustomer();
        this.labels = new MyVBox();
        setCenterPane();
    }

    /**
     * Overridable method used when assigning different types of Customers.
     */
    public void setCustomer() {
        this.customer = new Customer();
    }

    /**
     * Sets this Pane by passing to the back end.
     */
    public void setCenterPane() {
        ChoiceBox<String> choice = this.backEnd.getPayingCustomerList();
        MyVBox content = this.customer.getVBox(choice);
        this.centerSectionPane.setCenter(content);
        setPane();
    }

    /**
     * Calls a save function in the back end.
     * @throws IOException
     */
    @Override
    public void onSaveChangesButtonClick() throws IOException {
        System.out.println("Save button clicked on new");
        this.backEnd.getCustomers().add(this.customer);
        this.frontEnd.setDefaultSelectedCustomer();
        this.backEnd.save();
        this.frontEnd.refresh();
    }

    /**
     * Saves file in user specified directory.
     * @throws IOException
     */
    @Override
    public void onSaveAsChangesButtonClick() throws IOException {
        System.out.println("Save button clicked on new");
        this.backEnd.getCustomers().add(this.customer);
        this.frontEnd.setDefaultSelectedCustomer();
        this.backEnd.save(this.frontEnd.getDirectory());
        this.frontEnd.refresh();
    }
}
