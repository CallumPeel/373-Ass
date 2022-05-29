package SupplementServices.Panes.LeftPane;

import SupplementServices.BackEnd;
import SupplementServices.FrontEndGUI;
import SupplementServices.Panes.CenterPane.CenterPanelDeleteMag;
import SupplementServices.Panes.CenterPane.CenterPanelEditMagazine;
import SupplementServices.Panes.CenterPane.CenterPanelNewMagazine;
import SupplementServices.Panes.CenterPane.CenterPanelViewMagazine;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Builds a template pane for creating fields.
 *
 * @author callum
 */
public class LeftPanelCreate extends LeftPanelEdit {

    /**
     * Constructs Tree Views and editing buttons.
     *
     * @param backEnd
     * @param frontEnd
     */
    public LeftPanelCreate(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
    }

    /**
     * Sets this Pane by passing to the back end.
     */
    @Override
    public void setPane() {
        this.backEnd.getCreatePane().setLeft(this.frontEnd.vbox);
    }

    /**
     * Creates tree views and relevant editing buttons.
     */
    @Override
    public void buildPane() {
        Insets inset = new Insets(0, 0, 10, 30);
        Button newButton = new Button();
        newButton.setText("New");
        newButton.setOnAction(
                s -> {
                    try {
                        onNewButtonClick();
                    } catch (Exception e) {
                        System.out.println("Something Went Wrong...");
                    }
                }
        );
        Button editButton = new Button();
        editButton.setText("Edit");
        editButton.setOnAction(
                s -> {
                    try {
                        onEditButtonClick();
                    } catch (Exception e) {
                        System.out.println("Select a Magazine to edit");
                    }
                }
        );
        Button deleteButton = new Button();
        deleteButton.setText("Delete");
        deleteButton.setOnAction(
                s -> {
                    try {
                        onDeleteButtonClick();
                    } catch (Exception e) {
                        System.out.println("Select a Magazine to delete");
                    }
                }
        );
        this.frontEnd.magazineTreeView.setOnMouseClicked(
                s -> {
                    try {
                        onMagViewMouseClick();
                    } catch (Exception e) {
                        System.out.println(this.frontEnd.magazineSelected);
                        System.out.println("Select a Customer to view");
                    }
                }
        );
        HBox topButtons = new HBox(newButton, deleteButton, editButton);
        this.frontEnd.vbox = new VBox(
                topButtons,
                this.frontEnd.magazineTreeView
        );
        topButtons.setAlignment(Pos.CENTER);
        topButtons.setPadding(new Insets(10));
        topButtons.setSpacing(20);
        this.frontEnd.vbox.setAlignment(Pos.CENTER);
        this.frontEnd.vbox.setMargin(this.frontEnd.magazineTreeView, inset);

        setPane();
    }

    /**
     * Creates a center panel for creating a new Magazine.
     */
    public void onNewButtonClick() {
        new CenterPanelNewMagazine(this.backEnd, this.frontEnd);
    }

    /**
     * Creates a center panel for editing a selected Magazine.
     */
    public void onEditButtonClick() {
        this.frontEnd.setSelectedMagazine();
        new CenterPanelEditMagazine(this.backEnd, this.frontEnd);
    }

    /**
     * Creates a center panel for deleting a selected Magazine.
     */
    public void onDeleteButtonClick() {
        this.frontEnd.setSelectedMagazine();
        new CenterPanelDeleteMag(this.backEnd, this.frontEnd);
    }

    /**
     * Creates a center panel for viewing a selected Magazine.
     */
    private void onMagViewMouseClick() {
        this.frontEnd.setSelectedMagazine();
        new CenterPanelViewMagazine(this.backEnd, this.frontEnd);
    }
}
