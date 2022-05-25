package SupplementServices.centerPane;

import SupplementServices.BackEnd;
import SupplementServices.FrontEndGUI;
import SupplementServices.Magazine;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;

public class CenterPanelEditMagazine extends CenterPanelEdit {

    String initialName;
    Magazine oldMagazine, newMagazine;
    VBox labels;

    public CenterPanelEditMagazine(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
        this.oldMagazine = this.backEnd.getMagazine(this.frontEnd.magazineSelected);
        this.initialName = oldMagazine.getName();
        cloneMagazine();
        this.labels = new VBox();
        setCenterPane();
    }

    private void cloneMagazine() {
        try {
            this.newMagazine = this.oldMagazine.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(CenterPanelEditMagazine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setCenterPane() {
        ChoiceBox<String> supDrop = this.backEnd.getSupplementList();
        ChoiceBox<String> custDrop = this.backEnd.getCustomerList();
        VBox content = this.newMagazine.getVBox(this.backEnd, supDrop, custDrop);
        this.centerSectionPane.setCenter(content);
        setPane();
    }

    @Override
    public void onSaveChangesButtonClick() {
        System.out.println("Save Changes button clicked on edit");
        int indexOfMagazineToChange = this.backEnd.getMags().indexOf(this.backEnd.getMagazine(initialName));
        this.backEnd.getMags().set(indexOfMagazineToChange, this.newMagazine);
        this.frontEnd.setDefaultSelectedCustomer();
        this.frontEnd.refresh();
    }

    @Override
    public void setPane() {
        this.centerSectionPane.setPadding(new Insets(25, 0, 0, 50));
        this.backEnd.getCreatePane().setCenter(this.centerSectionPane);
    }
}
