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
import javafx.scene.control.ChoiceBox;

/**
 *
 * @author callum
 */
public class CenterPanelNewCustomer extends CenterPanelEdit {

    Customer customer;
    MyVBox labels;

    public CenterPanelNewCustomer(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
        setCustomer();
        this.labels = new MyVBox();
        setCenterPane();
    }

    public void setCustomer() {
        this.customer = new Customer();
    }

    public void setCenterPane() {
        ChoiceBox<String> choice = this.backEnd.getPayingCustomerList();
        MyVBox content = this.customer.getVBox(choice);
        this.centerSectionPane.setCenter(content);
        setPane();
    }

    @Override
    public void onSaveChangesButtonClick() throws IOException {
        System.out.println("Save button clicked on new");
        this.backEnd.getCustomers().add(this.customer);
        this.frontEnd.setDefaultSelectedCustomer();
        this.backEnd.save();
        this.frontEnd.refresh();
    }

    @Override
    public void onSaveAsChangesButtonClick() throws IOException {
        System.out.println("Save button clicked on new");
        this.backEnd.getCustomers().add(this.customer);
        this.frontEnd.setDefaultSelectedCustomer();
        this.backEnd.save(this.frontEnd.getDirectory());
        this.frontEnd.refresh();
    }
}
