package SupplementServices.centerPane;

import SupplementServices.BackEnd;
import SupplementServices.FrontEndGUI;
import SupplementServices.MyVBox;
import SupplementServices.Supplement;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.VBox;

public class CenterPanelEditSupplement extends CenterPanelEdit {

    String initialName;
    Supplement oldSupplement, newSupplement;
    MyVBox labels;

    public CenterPanelEditSupplement(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
        this.oldSupplement = this.backEnd.getSupplement(this.frontEnd.supplementSelected);
        this.initialName = this.oldSupplement.getName();
        cloneSupplement();
        this.labels = getLabels();
        setCenterPane();
    }

    private void cloneSupplement() {
        try {
            this.newSupplement = this.oldSupplement.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(CenterPanelEditSupplement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setCenterPane() {
        MyVBox content = this.newSupplement.getVBox();
        this.centerSectionPane.setCenter(content);
        setPane();
    }

    private MyVBox getLabels() {
        MyVBox buttons = new MyVBox();
        return buttons;
    }

    @Override
    public void onSaveChangesButtonClick() throws IOException {
        System.out.println("Save button clicked on edit");
        int indexOfSupplementToChange = this.backEnd.getSupplements().indexOf(this.backEnd.getSupplement(initialName));
        this.backEnd.getSupplements().set(indexOfSupplementToChange, this.newSupplement);
        this.frontEnd.setDefaultSelectedSupplement();
        this.backEnd.save();
        this.frontEnd.refresh();
    }
}
