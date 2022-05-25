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
public class CenterPanelViewMagazine extends CenterPanel {

    public CenterPanelViewMagazine(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
        addTreeView();
    }

    private void addTreeView() {
        VBox v = this.backEnd.getMagazine(this.frontEnd.magazineSelected).getDetails();
        VBox magazineBreakdownVBox = new VBox(this.backEnd.getMagazine(this.frontEnd.magazineSelected).getDetails());
        this.centerSectionPane.setCenter(magazineBreakdownVBox);
        this.centerSectionPane.setBottom(this.centerBottomPane);
        this.centerSectionPane.setMargin(magazineBreakdownVBox, new Insets(15));
        setPane();
    }

    @Override
    public void setPane() {
        this.backEnd.getCreatePane().setCenter(centerSectionPane);
    }
}
