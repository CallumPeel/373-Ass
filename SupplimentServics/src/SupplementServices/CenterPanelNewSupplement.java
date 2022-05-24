/*
 * Student Name: Callum Peel
 * Student ID: 34217062
 */
package SupplementServices;

import javafx.scene.layout.VBox;

/**
 *
 * @author callum
 */
public class CenterPanelNewSupplement extends CenterPanelEdit {

    Supplement supplement;
    VBox labels;

    public CenterPanelNewSupplement(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
        this.supplement = new Supplement();
        this.labels = getLabels();
        setCenterPane();
    }

    private void setCenterPane() {
        this.centerSectionPane.setCenter(
                this.supplement.getVBox()
        );
        setPane();
    }

    private VBox getLabels() {
        VBox buttons = new VBox();
        return buttons;
    }

    @Override
    public void onSaveButtonClick() {
        System.out.println("Save button clicked on new");
        this.backEnd.supplements.add(this.supplement);
        this.frontEnd.setDefaultSelectedSupplement();
        this.frontEnd.refresh();

    }
}
