package SupplementServices;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
        try {
            this.newCustomer = this.oldCustomer.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(CenterPanelEditCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.labels = getLabels();
        setCenterPane();
    }

    private void setCenterPane() {
        TextField textField = new TextField("This is a text");
        Button nameButton = this.newCustomer.getNameButton(textField);
        HBox name = new HBox(textField, nameButton);
        this.centerSectionPane.setCenter(name);
        setPane();
    }

    private VBox getLabels() {
        VBox buttons = new VBox();
        return buttons;
    }

    @Override
    public void onSaveButtonClick() {
        System.out.println("Save button clicked on edit");
        int index = this.backEnd.customers.indexOf(this.backEnd.getCustName(initialName));
        this.backEnd.customers.set(index, this.newCustomer);
        this.frontEnd.setDefaultSelectedCustomer();
//        new CenterPanelEdit(this.backEnd, this.frontEnd);
        
    }
}
