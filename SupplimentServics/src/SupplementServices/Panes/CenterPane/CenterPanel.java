package SupplementServices.Panes.CenterPane;

import SupplementServices.BackEnd;
import SupplementServices.FrontEndGUI;
import SupplementServices.Panes.MyBPane;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;

public class CenterPanel extends MyBPane {

    BorderPane centerSectionPane;
    BorderPane centerBottomPane;

    public CenterPanel(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
        this.centerSectionPane = new BorderPane();
        this.centerBottomPane = new BorderPane();
        this.centerSectionPane.setPadding(new Insets(15));
    }

    public void buildPane() {
        this.centerSectionPane.setBottom(this.centerBottomPane);
        setPane();
    }

    public void setPane() {
        this.backEnd.getViewPane().setCenter(centerSectionPane);
    }
}
