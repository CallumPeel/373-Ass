/*
 * Student Name: Callum Peel
 * Student ID: 34217062
 */
package SupplementServices.centerPane;

import SupplementServices.BackEnd;
import SupplementServices.FrontEndGUI;
import SupplementServices.MyVBox;
import SupplementServices.Supplement;
import java.io.IOException;
import javafx.scene.layout.VBox;

/**
 *
 * @author callum
 */
public class CenterPanelNewSupplement extends CenterPanelEdit {

    Supplement supplement;
    MyVBox labels;

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

    private MyVBox getLabels() {
        MyVBox buttons = new MyVBox();
        return buttons;
    }

    @Override
    public void onSaveAsChangesButtonClick() throws IOException {
        System.out.println("Save button clicked on new");
        this.backEnd.getSupplements().add(this.supplement);
        this.frontEnd.setDefaultSelectedSupplement();
        this.backEnd.save(getDirectory());
        this.frontEnd.refresh();
    }

    @Override
    public void onSaveChangesButtonClick() throws IOException {
        System.out.println("Save button clicked on new");
        this.backEnd.getSupplements().add(this.supplement);
        this.frontEnd.setDefaultSelectedSupplement();
        this.backEnd.save();
        this.frontEnd.refresh();
    }
}
