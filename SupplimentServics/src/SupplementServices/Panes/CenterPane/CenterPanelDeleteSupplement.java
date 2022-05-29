/*
 * Student Name: Callum Peel
 * Student ID: 34217062
 */
package SupplementServices.Panes.CenterPane;

import SupplementServices.BackEnd;
import SupplementServices.FrontEndGUI;
import java.io.IOException;

/**
 * Extends default Delete class. Deletes selected supplement.
 * @author callum
 */
public class CenterPanelDeleteSupplement extends CenterPanelDelete {

    /**
     * Constructs a Delete Panel.
     * @param backEnd
     * @param frontEnd
     */
    public CenterPanelDeleteSupplement(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
    }

    /**
     * Calls a save function in the back end.
     * @throws IOException
     */
    @Override
    public void saveChange() throws IOException {
        System.out.println("Save button clicked on delete");
        try {
            this.backEnd.removeSupplement(this.backEnd.getSupplement(this.frontEnd.supplementSelected));
            this.frontEnd.setDefaultSelectedSupplement();
        } catch (Exception e) {
            System.out.println("Something Went Wrong");
        }
        this.backEnd.save();
        this.frontEnd.refresh();
    }
}
