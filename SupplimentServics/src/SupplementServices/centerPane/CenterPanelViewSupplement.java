/*
 * Student Name: Callum Peel
 * Student ID: 34217062
 */
package SupplementServices.centerPane;

import SupplementServices.BackEnd;
import SupplementServices.FrontEndGUI;
import SupplementServices.MyVBox;
import javafx.geometry.Insets;

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
        MyVBox supplementBreakdownVBox = new MyVBox(this.backEnd.getSupplement(this.frontEnd.supplementSelected).getDetails());
        this.centerSectionPane.setCenter(supplementBreakdownVBox);
        this.centerSectionPane.setBottom(this.centerBottomPane);
        this.centerSectionPane.setMargin(supplementBreakdownVBox, new Insets(15));
        setPane();
    }
}
