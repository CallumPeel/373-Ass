package SupplementServices;

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
        this.oldCustomer = this.backEnd.getCustByName(this.frontEnd.customerSelected);
        this.initialName = oldCustomer.name;
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
    public void onSaveButtonClick() {
        System.out.println("Save button clicked on edit");
        int indexOfCustomerToChange = this.backEnd.customers.indexOf(this.backEnd.getCustByName(initialName));
        this.backEnd.customers.set(indexOfCustomerToChange, this.newCustomer);
        this.frontEnd.setDefaultSelectedCustomer();
        this.frontEnd.refresh();
    }
}
