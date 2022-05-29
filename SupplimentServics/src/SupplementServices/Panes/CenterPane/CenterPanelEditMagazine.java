package SupplementServices.Panes.CenterPane;

import SupplementServices.BackEnd;
import SupplementServices.FrontEndGUI;
import SupplementServices.Magazine;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 * Constructs a center panel for editing magazine fields.
 *
 * @author callum
 */
public class CenterPanelEditMagazine extends CenterPanelEdit {

    String initialName;
    Magazine oldMagazine, newMagazine;
    VBox labels;

    /**
     * Constructs a center panel for editing Magazine fields.
     *
     * @param backEnd
     * @param frontEnd
     */
    public CenterPanelEditMagazine(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
        this.oldMagazine = this.backEnd.getMagazine(this.frontEnd.magazineSelected);
        this.initialName = oldMagazine.getName();
        cloneMagazine();
        this.labels = new VBox();
        setCenterPane();
    }

    /**
     * Performs a deep copy of a Magazine.
     */
    private void cloneMagazine() {
        try {
            this.newMagazine = this.oldMagazine.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(CenterPanelEditMagazine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Sets this Pane by passing to the back end.
     */
    private void setCenterPane() {
        ChoiceBox<String> supDrop = this.backEnd.getSupplementList();
        ChoiceBox<String> custDrop = this.backEnd.getCustomerList();
        VBox content = this.newMagazine.getVBox(this.backEnd, supDrop, custDrop);
        Label magazine = new Label("Edit Magazine");
        magazine.setPadding(new Insets(15));
        magazine.setFont(new Font("Arial", 20));
        content.getChildren().add(0, magazine);
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
        System.out.println("Save Changes button clicked on edit");
        int indexOfMagazineToChange = this.backEnd.getMags().indexOf(this.backEnd.getMagazine(initialName));
        this.backEnd.getMags().set(indexOfMagazineToChange, this.newMagazine);
        this.frontEnd.setDefaultSelectedCustomer();
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
        System.out.println("Save Changes button clicked on edit");
        int indexOfMagazineToChange = this.backEnd.getMags().indexOf(this.backEnd.getMagazine(initialName));
        this.backEnd.getMags().set(indexOfMagazineToChange, this.newMagazine);
        this.frontEnd.setDefaultSelectedCustomer();
        this.backEnd.save();
        this.frontEnd.refresh();
    }

    /**
     * Sets this Pane by passing to the back end.
     */
    @Override
    public void setPane() {
        this.centerSectionPane.setPadding(new Insets(25, 0, 0, 50));
        this.backEnd.getCreatePane().setCenter(this.centerSectionPane);
    }
}
