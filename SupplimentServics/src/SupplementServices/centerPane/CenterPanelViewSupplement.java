/*
 * Student Name: Callum Peel
 * Student ID: 34217062
 */
package SupplementServices.centerPane;

import SupplementServices.BackEnd;
import SupplementServices.FrontEndGUI;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

/**
 *
 * @author callu
 */
public class CenterPanelViewSupplement extends CenterPanel {

    public CenterPanelViewSupplement(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
        addTreeView();
    }
    private void addTreeView() {
        VBox supplementBreakdownVBox = new VBox(this.backEnd.getSupplement(this.frontEnd.supplementSelected).getDetails());
        this.centerSectionPane.setCenter(supplementBreakdownVBox);
        this.centerSectionPane.setBottom(this.centerBottomPane);
        this.centerSectionPane.setMargin(supplementBreakdownVBox, new Insets(15));
        setPane();
    }
}
