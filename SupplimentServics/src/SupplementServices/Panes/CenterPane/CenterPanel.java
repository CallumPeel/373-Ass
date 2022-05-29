/*
 * Student Name: Callum Peel
 * Student ID: 34217062
 */
package SupplementServices.Panes.CenterPane;

import SupplementServices.BackEnd;
import SupplementServices.FrontEndGUI;
import SupplementServices.Panes.MyBPane;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;

/**
 * Template for center panel.
 * 
 * @author callum
 */
public class CenterPanel extends MyBPane {

    BorderPane centerSectionPane;
    BorderPane centerBottomPane;

    /**
     *  Instantiates Center Panel.
     * 
     * @param backEnd
     * @param frontEnd
     */
    public CenterPanel(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
        this.centerSectionPane = new BorderPane();
        this.centerBottomPane = new BorderPane();
        this.centerSectionPane.setPadding(new Insets(15));
    }

    /**
     * Creates default pane.
     */
    public void buildPane() {
        this.centerSectionPane.setBottom(this.centerBottomPane);
        setPane();
    }

    /**
     * Sets default pane to center pane.
     */
    public void setPane() {
        this.backEnd.getViewPane().setCenter(centerSectionPane);
    }
}
