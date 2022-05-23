package SupplementServices;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CenterPanelEditCustomer extends CenterPanelEdit {

    Customer customer;
    VBox labels;

    public CenterPanelEditCustomer(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
        this.customer = this.backEnd.getCustName(this.frontEnd.itemSelected);
        this.labels = getLabels();
        setCenterPane();
    }

    private void setCenterPane() {
        TextField textField = new TextField("This is a text");
        Button nameButton = this.customer.getNameButton(textField);
        HBox name = new HBox(textField, nameButton);
        this.centerSectionPane.setCenter(name);
        setPane();
    }

    private VBox getLabels() {
        VBox buttons = new VBox();

        return buttons;
    }
}
