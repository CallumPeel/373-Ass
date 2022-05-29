/*
 * Student Name: Callum Peel
 * Student ID: 34217062
 */
package SupplementServices.Panes.CenterPane;

import SupplementServices.BackEnd;
import SupplementServices.FrontEndGUI;
import SupplementServices.Panes.MyVBox;
import SupplementServices.Supplement;
import java.io.IOException;

/**
 * Displays Supplement fields to be created in the center pane.
 * @author callum
 */
public class CenterPanelNewSupplement extends CenterPanelEdit {

    Supplement supplement;
    MyVBox labels;

    /**
     * Constructs a center panel for input of new Supplement's fields.
     * @param backEnd
     * @param frontEnd
     */
    public CenterPanelNewSupplement(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
        this.supplement = new Supplement();
        this.labels = new MyVBox();
        setCenterPane();
    }
    
    /**
     * Sets this Pane by passing to the back end.
     */
    private void setCenterPane() {
        this.centerSectionPane.setCenter(
                this.supplement.getVBox()
        );
        setPane();
    }

    /**
     * Saves file in user specified directory.
     * @throws IOException
     */
    @Override
    public void onSaveAsChangesButtonClick() throws IOException {
        System.out.println("Save button clicked on new");
        this.backEnd.getSupplements().add(this.supplement);
        this.frontEnd.setDefaultSelectedSupplement();
        this.backEnd.save(this.frontEnd.getDirectory());
        this.frontEnd.refresh();
    }

    /**
     * Calls a save function in the back end.
     * @throws IOException
     */
    @Override
    public void onSaveChangesButtonClick() throws IOException {
        System.out.println("Save button clicked on new");
        this.backEnd.getSupplements().add(this.supplement);
        this.frontEnd.setDefaultSelectedSupplement();
        this.backEnd.save();
        this.frontEnd.refresh();
    }
}
