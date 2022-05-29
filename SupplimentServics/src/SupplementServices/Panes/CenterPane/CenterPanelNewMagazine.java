/*
 * Student Name: Callum Peel
 * Student ID: 34217062
 */
package SupplementServices.Panes.CenterPane;

import SupplementServices.BackEnd;
import SupplementServices.FrontEndGUI;
import SupplementServices.Magazine;
import java.io.IOException;
import javafx.geometry.Insets;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 * Displays Magazine fields to be created in the center pane.
 *
 * @author callum
 */
public class CenterPanelNewMagazine extends CenterPanelEdit {

    Magazine magazine;
    VBox labels;

    /**
     * Constructs a center panel for input of new Magazines's fields.
     *
     * @param backEnd
     * @param frontEnd
     */
    public CenterPanelNewMagazine(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
        this.magazine = new Magazine();
        this.labels = new VBox();
        setCenterPane();
    }

    /**
     * Sets this Pane by passing to the back end.
     */
    private void setCenterPane() {
        ChoiceBox<String> supDrop = this.backEnd.getSupplementList();
        ChoiceBox<String> custDrop = this.backEnd.getCustomerList();
        VBox content = this.magazine.getVBox(this.backEnd, supDrop, custDrop);
        Label magazine = new Label("Create New Magazine");
        magazine.setPadding(new Insets(15));
        magazine.setFont(new Font("Arial", 20));
        content.getChildren().add(0, magazine);
        this.centerSectionPane.setCenter(content);
        setPane();
    }

    /**
     * Saves file in user specified directory.
     *
     * @throws IOException
     */
    @Override
    public void onSaveAsChangesButtonClick() throws IOException {
        System.out.println("Save button clicked on new");
        this.backEnd.addMagazine(this.magazine);
        this.frontEnd.setDefaultSelectedMagazine();
        this.backEnd.save(this.frontEnd.getDirectory());
        this.frontEnd.refresh();
    }

    /**
     * Calls a save function in the back end.
     *
     * @throws IOException
     */
    @Override
    public void onSaveChangesButtonClick() throws IOException {
        System.out.println("Save button clicked on new");
        this.backEnd.addMagazine(this.magazine);
        this.frontEnd.setDefaultSelectedMagazine();
        this.backEnd.save();
        this.frontEnd.refresh();
    }

    /**
     * Sets this Pane by passing to the back end.
     */
    @Override
    public void setPane() {
        this.centerSectionPane.setPadding(new Insets(25, 0, 0, 50));
        this.backEnd.getCreatePane().setCenter(this.centerSectionPane);
    }
}
