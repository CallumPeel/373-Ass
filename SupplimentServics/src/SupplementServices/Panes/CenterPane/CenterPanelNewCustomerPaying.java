package SupplementServices.Panes.CenterPane;

import SupplementServices.BackEnd;
import SupplementServices.CustomerPaying;
import SupplementServices.FrontEndGUI;
import java.io.IOException;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;

/**
 * Displays Paying Customer fields to be edited in the center pane.
 *
 * @author callum
 */
public class CenterPanelNewCustomerPaying extends CenterPanelEdit {

    CustomerPaying customer;
    VBox labels;

    /**
     * Constructs a center panel for input of new Paying Customer's fields.
     * @param backEnd
     * @param frontEnd
     */
    public CenterPanelNewCustomerPaying(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
        setCustomer();
        this.labels = new VBox();
        setCenterPane();
    }

    /**
     * Instantiates new instance of Customer Paying
     */
    public void setCustomer() {
        this.customer = new CustomerPaying();
    }

    /**
     * Sets this Pane by passing to the back end.
     */
    public void setCenterPane() {
        ChoiceBox<String> choice = this.backEnd.getPayingCustomerList();
        VBox content = this.customer.getVBox(choice);
        this.centerSectionPane.setCenter(content);
        setPane();
    }

    /**
     * Calls a save function in the back end.
     * @throws IOException
     */
    @Override
    public void onSaveButtonClick() throws IOException {
        System.out.println("Save button clicked on new");
        this.backEnd.addCustomer(this.customer);
        this.frontEnd.setDefaultSelectedCustomer();
        this.backEnd.save();
        this.frontEnd.refresh();
    }

    /**
     * Saves file in user specified directory.
     * @throws IOException
     */
    @Override
    public void onSaveAsButtonClick() throws IOException {
        this.backEnd.addCustomerPaying(this.customer);
        this.frontEnd.setDefaultSelectedCustomer();
        this.backEnd.save(this.frontEnd.getDirectory());
        this.frontEnd.refresh();
    }
}
