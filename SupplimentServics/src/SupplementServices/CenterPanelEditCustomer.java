package SupplementServices;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
        TextField textField = new TextField();
        textField.setMinWidth(120);
        textField.setMaxWidth(120);
        Label currentName = new Label(this.initialName);
        currentName.setMinWidth(120);
        currentName.setMaxWidth(120);
        Button nameButton = this.newCustomer.getNameButton(textField, currentName);
        nameButton.setMinWidth(120);
        nameButton.setMaxWidth(120);
        HBox nameFieldsHBox = new HBox(textField, nameButton, currentName);
        nameFieldsHBox.setAlignment(Pos.BASELINE_CENTER);
        nameFieldsHBox.setSpacing(20);
        nameFieldsHBox.setPadding(new Insets(10));
        this.centerSectionPane.setCenter(nameFieldsHBox);
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
