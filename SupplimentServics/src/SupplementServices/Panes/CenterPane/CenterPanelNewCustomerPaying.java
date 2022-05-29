package SupplementServices.Panes.CenterPane;

import SupplementServices.BackEnd;
import SupplementServices.CustomerPaying;
import SupplementServices.FrontEndGUI;
import SupplementServices.Panes.MyVBox;
import javafx.scene.control.ChoiceBox;

/**
 * Displays Paying Customer fields to be edited in the center pane.
 * @author callum
 */
public class CenterPanelNewCustomerPaying extends CenterPanelNewCustomer {

    CustomerPaying customerPaying;

    /**
     * Constructs a center panel for input of new Paying Customer's fields.
     * @param backEnd
     * @param frontEnd
     */
    public CenterPanelNewCustomerPaying(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
    }

    /**
     * Method overrides parent class method. Creates global Customer.
     */
    @Override
    public void setCustomer() {
        this.customerPaying = new CustomerPaying();
    }

    /**
     * Sets this Pane by passing to the back end.
     */
    @Override
    public void setCenterPane() {
        ChoiceBox<String> choice = this.backEnd.getPayingCustomerList();
        MyVBox content = this.customerPaying.getVBox(choice);
        this.centerSectionPane.setCenter(content);
        setPane();
    }
}
