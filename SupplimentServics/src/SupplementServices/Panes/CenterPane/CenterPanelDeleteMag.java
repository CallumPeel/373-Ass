/*
 * Student Name: Callum Peel
 * Student ID: 34217062
 */
package SupplementServices.Panes.CenterPane;

import SupplementServices.BackEnd;
import SupplementServices.FrontEndGUI;
import java.io.IOException;

/**
 *
 * @author callum
 */
public class CenterPanelDeleteMag extends CenterPanelDelete {

    public CenterPanelDeleteMag(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
    }

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

    @Override
    public void setPane() {
    }
}
