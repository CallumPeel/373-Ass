package SupplementServices.Panes.CenterPane;

import SupplementServices.BackEnd;
import SupplementServices.Customer;
import SupplementServices.FrontEndGUI;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;

/**
 * Displays Customer fields to be edited in the center pane.
 *
 * @author callum
 */
public class CenterPanelEditCustomer extends CenterPanelEdit {

    String initialName;
    Customer oldCustomer, newCustomer;
    VBox labels;

    /**
     * Constructs a center panel for editing customer fields.
     *
     * @param backEnd
     * @param frontEnd
     */
    public CenterPanelEditCustomer(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
        this.oldCustomer = this.backEnd.getCustomer(this.frontEnd.getCustomerSelected());
        this.initialName = oldCustomer.getName();
        cloneCustomer();
        this.labels = new VBox();
        setCenterPane();
    }

    /**
     * Performs a deep copy of a Customer.
     */
    private void cloneCustomer() {
        try {
            this.newCustomer = this.oldCustomer.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(CenterPanelEditCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Sets this Pane by passing to the back end.
     */
    private void setCenterPane() {
        ChoiceBox<String> choice = this.backEnd.getPayingCustomerList();
        VBox content = this.newCustomer.getVBox(choice);
        this.centerSectionPane.setCenter(content);
        setPane();
    }

    /**
     * Saves file in user specified directory.
     *
     * @throws IOException
     */
    @Override
    public void onSaveAsChangesButtonClick() throws IOException {
        int indexOfCustomerToChange = this.backEnd.getCustomers().indexOf(this.backEnd.getCustomer(initialName));
        this.backEnd.getCustomers().set(indexOfCustomerToChange, this.newCustomer);
        this.frontEnd.setDefaultSelectedCustomer();
        this.backEnd.save(this.frontEnd.getDirectory());
        this.frontEnd.refresh();
    }

    /**
     * Calls a save function in the back end.
     *
     * @throws IOException
     */
    @Override
    public void onSaveChangesButtonClick() throws IOException {
        int indexOfCustomerToChange = this.backEnd.getCustomers().indexOf(this.backEnd.getCustomer(initialName));
        this.backEnd.getCustomers().set(indexOfCustomerToChange, this.newCustomer);
        this.frontEnd.setDefaultSelectedCustomer();
        this.backEnd.save();
        this.frontEnd.refresh();
    }
}
