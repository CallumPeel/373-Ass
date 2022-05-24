package SupplementServices;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.VBox;

public class CenterPanelEditSupplement extends CenterPanelEdit {

    String initialName;
    Supplement oldSupplement, newSupplement;
    VBox labels;

    public CenterPanelEditSupplement(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
        this.oldSupplement = this.backEnd.getSupName(this.frontEnd.supplementSelected);
        this.initialName = this.oldSupplement.name;
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
//        ChoiceBox<String> choice = this.backEnd.getPayingCustomerList();
        VBox content = this.newSupplement.getVBox();
        this.centerSectionPane.setCenter(content);
        setPane();
    }

    private VBox getLabels() {
        VBox buttons = new VBox();
        return buttons;
    }

    @Override
    public void onSaveButtonClick() {
        System.out.println("Save button clicked on edit");
        int indexOfSupplementToChange = this.backEnd.supplements.indexOf(this.backEnd.getSupName(initialName));
        this.backEnd.supplements.set(indexOfSupplementToChange, this.newSupplement);
        this.frontEnd.setDefaultSelectedSupplement();
        this.frontEnd.refresh();
    }
}