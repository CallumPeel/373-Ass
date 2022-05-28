/*
 * Student Name: Callum Peel
 * Student ID: 34217062
 */
package SupplementServices.Panes.centerPane;

import SupplementServices.BackEnd;
import SupplementServices.FrontEndGUI;
import SupplementServices.Panes.MyVBox;
import javafx.geometry.Insets;

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
        MyVBox magazineBreakdownVBox = new MyVBox(this.backEnd.getMagazine(this.frontEnd.magazineSelected).getDetails());
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
