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
 * Displays Magazine information to center pane.
 *
 * @author callum
 */
public class CenterPanelViewMagazine extends CenterPanel {

    /**
     * Constructs a center panel for viewing Magazine's fields.
     *
     * @param backEnd
     * @param frontEnd
     */
    public CenterPanelViewMagazine(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
        addTreeView();
    }

    /**
     * Constructs a tree view of the customer's information.
     */
    private void addTreeView() {
        VBox magazineBreakdownVBox = new VBox(this.backEnd.getMagazine(this.frontEnd.magazineSelected).getDetails());
        this.centerSectionPane.setCenter(magazineBreakdownVBox);
        this.centerSectionPane.setBottom(this.centerBottomPane);
        this.centerSectionPane.setMargin(magazineBreakdownVBox, new Insets(15));
        setPane();
    }

    /**
     * Sets this Pane by passing to the back end.
     */
    @Override
    public void setPane() {
        this.backEnd.getCreatePane().setCenter(centerSectionPane);
    }
}
