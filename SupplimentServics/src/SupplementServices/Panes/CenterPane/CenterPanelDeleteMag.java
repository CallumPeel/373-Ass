/*
 * Student Name: Callum Peel
 * Student ID: 34217062
 */
package SupplementServices.Panes.CenterPane;

import SupplementServices.BackEnd;
import SupplementServices.FrontEndGUI;
import java.io.IOException;

/**
 * Extends default Delete class. Deletes selected magazine.
 * @author callum
 */
public class CenterPanelDeleteMag extends CenterPanelDelete {

    /**
     * Constructs a Delete Panel.
     * @param backEnd
     * @param frontEnd
     */
    public CenterPanelDeleteMag(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
    }

    /**
     * Calls a save function in the back end.
     * @throws IOException
     */
    @Override
    public void saveChange() throws IOException {
        try {
            this.backEnd.removeMagazine(this.backEnd.getMagazine(this.frontEnd.magazineSelected));
            this.frontEnd.setDefaultSelectedMagazine();
        } catch (Exception e) {
            System.out.println("Something Went Wrong");
        }
        this.backEnd.save();
        this.frontEnd.refresh();
    }

    /**
     * Deletes unnecessary buttons by overriding initial method.
     */
    @Override
    public void setPane() {
    }
}
