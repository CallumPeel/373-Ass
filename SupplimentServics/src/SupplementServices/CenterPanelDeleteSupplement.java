/*
 * Student Name: Callum Peel
 * Student ID: 34217062
 */
package SupplementServices;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author callu
 */
public class CenterPanelDeleteSupplement extends CenterPanelEdit {

    VBox mainBox;
    HBox buttons;
    Label question;
    Button yesButton, noButton;

    public CenterPanelDeleteSupplement(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
        this.question = new Label("Delete Supplement?");
        this.yesButton = new Button("YES");
        this.yesButton.setOnAction(e -> {
            saveChange();
            System.out.println("Delete on\n");
        });
        this.noButton = new Button("NO");
        this.noButton.setOnAction(e -> {
            this.frontEnd.refresh();
            System.out.println("Delete off\n");
        });
        this.buttons = new HBox(this.yesButton, this.noButton);
        this.mainBox = new VBox(question, buttons);
        this.buttons.setAlignment(Pos.CENTER);
        this.buttons.setPadding(new Insets(20));
        this.buttons.setSpacing(20);
        this.mainBox.setAlignment(Pos.CENTER);

        setCenter();
        setPane();
    }

    private void setCenter() {
        this.centerSectionPane.setCenter(this.mainBox);
    }

    private void saveChange() {
        System.out.println("Save button clicked on delete");
        try {
            this.backEnd.supplements.remove(this.backEnd.getSupplement(this.frontEnd.supplementSelected));
            this.frontEnd.setDefaultSelectedSupplement();
        } catch (Exception e) {
            System.out.println("Something Went Wrong");
        }
        this.frontEnd.refresh();
    }

    @Override
    public void onSaveButtonClick() {
        System.out.println("Save button clicked on delete");
        try {
            this.backEnd.supplements.remove(this.backEnd.getSupplement(this.frontEnd.supplementSelected));
            this.frontEnd.setDefaultSelectedSupplement();
        } catch (Exception e) {
            System.out.println("Something Went Wrong");
        }
        this.frontEnd.refresh();
    }
    
    @Override
    public void setBottomPane() {
        
    }
}
