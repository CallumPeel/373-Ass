package SupplementServices.centerPane;

import SupplementServices.BackEnd;
import SupplementServices.Customer;
import SupplementServices.FrontEndGUI;
import SupplementServices.MyVBox;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class CenterPanelEditCustomer extends CenterPanelEdit {

    String initialName;
    Customer oldCustomer, newCustomer;
    MyVBox labels;

    public CenterPanelEditCustomer(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
        this.oldCustomer = this.backEnd.getCustomer(this.frontEnd.customerSelected);
        this.initialName = oldCustomer.getName();
        cloneCustomer();
        this.labels = new MyVBox();
        setCenterPane();
    }

    private void cloneCustomer() {
        try {
            this.newCustomer = this.oldCustomer.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(CenterPanelEditCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setCenterPane() {
        ChoiceBox<String> choice = this.backEnd.getPayingCustomerList();
        MyVBox content = this.newCustomer.getVBox(choice);        
        this.centerSectionPane.setCenter(content);
        setPane();
    }

    @Override
    public void onSaveChangesButtonClick() throws IOException {
        int indexOfCustomerToChange = this.backEnd.getCustomers().indexOf(this.backEnd.getCustomer(initialName));
        this.backEnd.getCustomers().set(indexOfCustomerToChange, this.newCustomer);
        this.frontEnd.setDefaultSelectedCustomer();
        this.backEnd.save();
        this.frontEnd.refresh();
    }
}
