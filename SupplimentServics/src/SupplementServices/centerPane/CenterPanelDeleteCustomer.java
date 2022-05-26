/*
 * Student Name: Callum Peel
 * Student ID: 34217062
 */
package SupplementServices.centerPane;

import SupplementServices.BackEnd;
import SupplementServices.FrontEndGUI;
import SupplementServices.MyVBox;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class CenterPanelDeleteCustomer extends CenterPanelEdit {

    MyVBox mainBox;
    HBox buttons;
    Label question;
    Button yesButton, noButton;

    public CenterPanelDeleteCustomer(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
        this.question = new Label("Delete Customer?");
        this.yesButton = new Button("YES");
        this.yesButton.setOnAction(e -> {
            try {
                saveChange();
            } catch (IOException ex) {
                Logger.getLogger(CenterPanelDeleteCustomer.class.getName()).log(Level.SEVERE, null, ex);
            }
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

    private void setCenter() {
        this.centerSectionPane.setCenter(this.mainBox);
    }

    private void saveChange() throws IOException {
        System.out.println("Save button clicked on delete");
        try {
            this.backEnd.removeCustomer(this.backEnd.getCustomer(this.frontEnd.customerSelected));
            this.frontEnd.setDefaultSelectedCustomer();
        } catch (Exception e) {
            System.out.println("Something Went Wrong");
        }
        this.backEnd.save();
        this.frontEnd.refresh();
    }

    @Override
    public void setBottomPane() {

    }
}
