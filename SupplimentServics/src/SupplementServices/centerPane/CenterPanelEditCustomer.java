package SupplementServices.centerPane;

import SupplementServices.BackEnd;
import SupplementServices.Customer;
import SupplementServices.FrontEndGUI;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;

public class CenterPanelEditCustomer extends CenterPanelEdit {

    String initialName;
    Customer oldCustomer, newCustomer;
    VBox labels;

    public CenterPanelEditCustomer(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
        this.oldCustomer = this.backEnd.getCustomer(this.frontEnd.customerSelected);
        this.initialName = oldCustomer.getName();
        cloneCustomer();
        this.labels = getLabels();
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
        VBox content = this.newCustomer.getVBox(choice);
        this.centerSectionPane.setCenter(content);
        setPane();
    }

    private VBox getLabels() {
        VBox buttons = new VBox();
        return buttons;
    }

    @Override
    public void onSaveChangesButtonClick() {
        System.out.println("Save Changes button clicked on edit");
        int indexOfCustomerToChange = this.backEnd.getCustomers().indexOf(this.backEnd.getCustomer(initialName));
        this.backEnd.getCustomers().set(indexOfCustomerToChange, this.newCustomer);
        this.frontEnd.setDefaultSelectedCustomer();
        this.frontEnd.refresh();
    }
}