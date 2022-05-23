package SupplementServices;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CenterPanelEditCustomer extends CenterPanelEdit {

    String initialName;
    Customer oldCustomer, newCustomer;
    VBox labels;

    public CenterPanelEditCustomer(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
        this.oldCustomer = this.backEnd.getCustName(this.frontEnd.itemSelected);
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
        this.centerSectionPane.setCenter(new VBox(
                this.newCustomer.getCustHBox("Name"),
                this.newCustomer.getCustHBox("Email")
                
        )
        );
        setPane();
    }

    private VBox getLabels() {
        VBox buttons = new VBox();
        return buttons;
    }

    @Override
    public void onSaveButtonClick() {
        System.out.println("Save button clicked on edit");
        int indexOfCustomerToChange = this.backEnd.customers.indexOf(this.backEnd.getCustName(initialName));
        this.backEnd.customers.set(indexOfCustomerToChange, this.newCustomer);
        this.frontEnd.setDefaultSelectedCustomer();
        this.frontEnd.refresh();

    }
}
