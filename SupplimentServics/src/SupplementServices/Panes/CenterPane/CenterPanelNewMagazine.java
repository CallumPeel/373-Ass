/*
 * Student Name: Callum Peel
 * Student ID: 34217062
 */
package SupplementServices.Panes.CenterPane;

import SupplementServices.BackEnd;
import SupplementServices.FrontEndGUI;
import SupplementServices.Magazine;
import SupplementServices.Panes.MyVBox;
import java.io.IOException;
import javafx.geometry.Insets;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

/**
 *
 * @author callu
 */
public class CenterPanelNewMagazine extends CenterPanelEdit {

    Magazine magazine;
    MyVBox labels;

    public CenterPanelNewMagazine(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
        this.magazine = new Magazine();
        this.labels = getLabels();
        setCenterPane();
    }

    private void setCenterPane() {
        ChoiceBox<String> supDrop = this.backEnd.getSupplementList();
        ChoiceBox<String> custDrop = this.backEnd.getCustomerList();
        MyVBox content = this.magazine.getVBox(this.backEnd, supDrop, custDrop);
        Label magazine = new Label("Create New Magazine");
        magazine.setPadding(new Insets(15));
        magazine.setFont(new Font("Arial", 20));
        content.getChildren().add(0, magazine);
        this.centerSectionPane.setCenter(content);
        setPane();
    }

    private MyVBox getLabels() {
        MyVBox buttons = new MyVBox();
        return buttons;
    }

    @Override
    public void onSaveAsChangesButtonClick() throws IOException {
        System.out.println("Save button clicked on new");
        this.backEnd.addMagazine(this.magazine);
        this.frontEnd.setDefaultSelectedMagazine();
        this.backEnd.save(this.frontEnd.getDirectory());
        this.frontEnd.refresh();
    }

    @Override
    public void onSaveChangesButtonClick() throws IOException {
        System.out.println("Save button clicked on new");
        this.backEnd.addMagazine(this.magazine);
        this.frontEnd.setDefaultSelectedMagazine();
        this.backEnd.save();
        this.frontEnd.refresh();
    }

    @Override
    public void setPane() {
        this.centerSectionPane.setPadding(new Insets(25, 0, 0, 50));
        this.backEnd.getCreatePane().setCenter(this.centerSectionPane);
    }
}
