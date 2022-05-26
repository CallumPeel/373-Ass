/*
 * Student Name: Callum Peel
 * Student ID: 34217062
 */
package SupplementServices.centerPane;

import SupplementServices.BackEnd;
import SupplementServices.FrontEndGUI;
import SupplementServices.MyVBox;
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
public class CenterPanelDeleteMag extends CenterPanelEdit {

    MyVBox mainBox;
    HBox buttons;
    Label question;
    Button yesButton, noButton;

    public CenterPanelDeleteMag(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
        this.question = new Label("Delete Magazine?");
        this.yesButton = new Button("YES");
        this.yesButton.setOnAction(e -> {
            onSaveChangesButtonClick();
            System.out.println("Delete on\n");
        });
        this.noButton = new Button("NO");
        this.noButton.setOnAction(e -> {
            this.frontEnd.refresh();
            System.out.println("Delete off\n");
        });
        this.buttons = new HBox(this.yesButton, this.noButton);
        this.mainBox = new MyVBox(question, buttons);
        this.buttons.setAlignment(Pos.CENTER);
        this.buttons.setPadding(new Insets(20));
        this.buttons.setSpacing(20);
        this.mainBox.setAlignment(Pos.CENTER);

        setCenter();
        setPane();
    }

    // use setpane instead
    private void setCenter() {
        this.centerSectionPane.setCenter(this.mainBox);
    }

    @Override
    public void onSaveChangesButtonClick() {
        System.out.println("Save button clicked on delete");
        try {
            this.backEnd.removeMagazine(this.backEnd.getMagazine(this.frontEnd.magazineSelected));
            this.frontEnd.setDefaultSelectedMagazine();
        } catch (Exception e) {
            System.out.println("Something Went Wrong");
        }
        this.frontEnd.refresh();
    }

    @Override
    public void setPane() {
        this.centerSectionPane.setPadding(new Insets(25, 0, 0, 50));
        this.backEnd.getCreatePane().setCenter(this.centerSectionPane);
    }

    @Override
    public void setBottomPane() {

    }
}
