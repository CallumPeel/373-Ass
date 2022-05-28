/*
 * Student Name: Callum Peel
 * Student ID: 34217062
 */
package SupplementServices.centerPane;

import SupplementServices.BackEnd;
import SupplementServices.FrontEndGUI;
import java.io.IOException;
import javafx.geometry.Insets;

/**
 *
 * @author callu
 */
public class CenterPanelDeleteMag extends CenterPanelDelete {

    public CenterPanelDeleteMag(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
    }

    public void saveChange() throws IOException {
        System.out.println("Save button clicked on delete");
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
        this.backEnd.getCreatePane().setCenter(this.centerSectionPane);
    }
}
