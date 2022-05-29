package SupplementServices.Panes.CenterPane;

import SupplementServices.BackEnd;
import SupplementServices.FrontEndGUI;
import SupplementServices.Supplement;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.VBox;

/**
 * Constructs a center panel for editing supplement fields.
 *
 * @author callum
 */
public class CenterPanelEditSupplement extends CenterPanelEdit {

    String initialName;
    Supplement oldSupplement, newSupplement;
    VBox labels;

    /**
     * Constructs a center panel for editing Supplement fields.
     * @param backEnd
     * @param frontEnd
     */
    public CenterPanelEditSupplement(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
        this.oldSupplement = this.backEnd.getSupplement(this.frontEnd.supplementSelected);
        this.initialName = this.oldSupplement.getName();
        cloneSupplement();
        this.labels = new VBox();
        setCenterPane();
    }

    /**
     * Performs a deep copy of a Supplement.
     */
    private void cloneSupplement() {
        try {
            this.newSupplement = this.oldSupplement.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(CenterPanelEditSupplement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Sets this Pane by passing to the back end.
     */
    private void setCenterPane() {
        VBox content = this.newSupplement.getVBox();
        this.centerSectionPane.setCenter(content);
        setPane();
    }

    /**
     * Saves file in user specified directory.
     *
     * @throws IOException
     */
    @Override
    public void onSaveAsChangesButtonClick() throws IOException {
        System.out.println("Save button clicked on edit");
        int indexOfSupplementToChange = this.backEnd.getSupplements().indexOf(this.backEnd.getSupplement(initialName));
        this.backEnd.getSupplements().set(indexOfSupplementToChange, this.newSupplement);
        this.frontEnd.setDefaultSelectedSupplement();
        this.backEnd.save(this.frontEnd.getDirectory());
        this.frontEnd.refresh();
    }

    /**
     * Calls a save function in the back end.
     *
     * @throws IOException
     */
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
