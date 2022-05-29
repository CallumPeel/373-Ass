/*
 * Student Name: Callum Peel
 * Student ID: 34217062
 */
package SupplementServices.Panes.CenterPane;

import SupplementServices.BackEnd;
import SupplementServices.FrontEndGUI;
import java.io.IOException;

/**
 * Extends default Delete class. Deletes selected customer.
 * @author callum
 */
public class CenterPanelDeleteCustomer extends CenterPanelDelete {

    /**
     * Constructs a Delete Panel.
     * @param backEnd
     * @param frontEnd
     */
    public CenterPanelDeleteCustomer(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
    }

    /**
     * Calls a save function in the back end.
     * @throws IOException
     */
    @Override
    public void saveChange() throws IOException {
        try {
            this.backEnd.removeCustomer(this.backEnd.getCustomer(this.frontEnd.customerSelected));
            this.frontEnd.setDefaultSelectedCustomer();
        } catch (Exception e) {
            System.out.println("Something Went Wrong");
        }
        this.backEnd.save();
        this.frontEnd.refresh();
    }
}
