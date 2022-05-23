package SupplementServices;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

public class CenterPanelViewCustomer extends CenterPanel {

    public CenterPanelViewCustomer(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
        addTreeView();
    }

    private void addTreeView() {
        VBox test = new VBox(this.backEnd.getCustName(this.frontEnd.itemSelected).getDetails());
        centerSectionPane.setCenter(test);
        centerSectionPane.setBottom(this.centerBottomPane);
        centerSectionPane.setMargin(test, new Insets(30));
        setPane();
    }
}
