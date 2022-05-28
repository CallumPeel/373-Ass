/*
 * Student Name: Callum Peel
 * Student ID: 34217062
 */
package SupplementServices.Panes.centerPane;

import SupplementServices.BackEnd;
import SupplementServices.FrontEndGUI;
import java.io.IOException;

public class CenterPanelDeleteSupplement extends CenterPanelDelete {

    public CenterPanelDeleteSupplement(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
    }

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
