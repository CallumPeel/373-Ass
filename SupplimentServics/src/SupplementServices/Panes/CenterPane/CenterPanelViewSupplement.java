/*
 * Student Name: Callum Peel
 * Student ID: 34217062
 */
package SupplementServices.Panes.CenterPane;

import SupplementServices.BackEnd;
import SupplementServices.FrontEndGUI;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

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
        VBox supplementBreakdownVBox = new VBox(this.backEnd.getSupplement(this.frontEnd.supplementSelected).getDetails());
        this.centerSectionPane.setCenter(supplementBreakdownVBox);
        this.centerSectionPane.setBottom(this.centerBottomPane);
        this.centerSectionPane.setMargin(supplementBreakdownVBox, new Insets(15));
        setPane();
    }
}
