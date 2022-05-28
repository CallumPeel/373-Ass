package SupplementServices.centerPane;

import SupplementServices.BackEnd;
import SupplementServices.CustomerPaying;
import SupplementServices.FrontEndGUI;
import SupplementServices.MyVBox;
import javafx.scene.control.ChoiceBox;

public class CenterPanelNewCustomerPaying extends CenterPanelNewCustomer {

    CustomerPaying customerPaying;

    public CenterPanelNewCustomerPaying(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
    }

    @Override
    public void setCustomer() {
        this.customerPaying = new CustomerPaying();
    }

    @Override
    public void setCenterPane() {
        ChoiceBox<String> choice = this.backEnd.getPayingCustomerList();
        MyVBox content = this.customerPaying.getVBox(choice);
        this.centerSectionPane.setCenter(content);
        setPane();
    }
}
