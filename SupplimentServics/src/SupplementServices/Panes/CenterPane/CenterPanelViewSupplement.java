/*
 * Student Name: Callum Peel
 * Student ID: 34217062
 */
package SupplementServices.Panes.CenterPane;

import SupplementServices.BackEnd;
import SupplementServices.FrontEndGUI;
import SupplementServices.Panes.MyVBox;
import javafx.geometry.Insets;

/**
 * Displays Supplement information to center pane.
 *
 * @author callum
 */
public class CenterPanelViewSupplement extends CenterPanel {

    /**
     * Constructs a center panel for viewing Supplement's fields.
     *
     * @param backEnd
     * @param frontEnd
     */
    public CenterPanelViewSupplement(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
        addTreeView();
    }

    /**
     * Constructs a tree view of the customer's information.
     */
    private void addTreeView() {
        MyVBox supplementBreakdownVBox = new MyVBox(this.backEnd.getSupplement(this.frontEnd.supplementSelected).getDetails());
        this.centerSectionPane.setCenter(supplementBreakdownVBox);
        this.centerSectionPane.setBottom(this.centerBottomPane);
        this.centerSectionPane.setMargin(supplementBreakdownVBox, new Insets(15));
        setPane();
    }
}
