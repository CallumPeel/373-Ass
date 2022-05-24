/*
 * Student Name: Callum Peel
 * Student ID: 34217062
 */
package SupplementServices;

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
        VBox test = new VBox(this.backEnd.getSupName(this.frontEnd.supplementSelected).getDetails());
        this.centerSectionPane.setCenter(test);
        this.centerSectionPane.setBottom(this.centerBottomPane);
        this.centerSectionPane.setMargin(test, new Insets(30));
        setPane();
    }
}
