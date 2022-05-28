/*
 * Student Name: Callum Peel
 * Student ID: 34217062
 */
package SupplementServices.centerPane;

import SupplementServices.BackEnd;
import SupplementServices.FrontEndGUI;
import java.io.IOException;

/**
 *
 * @author callu
 */
public class CenterPanelDeleteCustomer extends CenterPanelDelete {

    public CenterPanelDeleteCustomer(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
    }

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
