/*
 * Student Name: Callum Peel
 * Student ID: 34217062
 */
package SupplementServices.centerPane;

import SupplementServices.BackEnd;
import SupplementServices.Customer;
import SupplementServices.FrontEndGUI;
import SupplementServices.Magazine;
import javafx.geometry.Insets;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author callu
 */
public class CenterPanelNewMagazine extends CenterPanelEdit {

    Magazine magazine;
    VBox labels;

    public CenterPanelNewMagazine(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
        this.magazine = new Magazine();
        this.labels = getLabels();
        setCenterPane();
    }

    private void setCenterPane() {
        ChoiceBox<String> supDrop = this.backEnd.getSupplementList();
        ChoiceBox<String> custDrop = this.backEnd.getCustomerList();
        VBox content = this.magazine.getVBox(this.backEnd, supDrop, custDrop);
        this.centerSectionPane.setCenter(content);
        setPane();
    }

    private VBox getLabels() {
        VBox buttons = new VBox();
        return buttons;
    }

    @Override
    public void onSaveChangesButtonClick() {
        System.out.println("Save button clicked on new");
        this.backEnd.addMagazine(this.magazine);
        this.frontEnd.setDefaultSelectedMagazine();
        this.frontEnd.refresh();
    }

    @Override
    public void setPane() {
        this.centerSectionPane.setPadding(new Insets(25, 0, 0, 50));
        this.backEnd.getCreatePane().setCenter(this.centerSectionPane);
    }
}
