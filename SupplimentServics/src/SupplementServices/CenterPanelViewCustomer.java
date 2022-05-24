package SupplementServices;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

public class CenterPanelViewCustomer extends CenterPanel {

    public CenterPanelViewCustomer(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
        addTreeView();
    }

    private void addTreeView() {
        VBox test = new VBox(this.backEnd.getCustName(this.frontEnd.customerSelected).getDetails());
        this.centerSectionPane.setCenter(test);
        this.centerSectionPane.setBottom(this.centerBottomPane);
        this.centerSectionPane.setMargin(test, new Insets(0,15,15,15));
        setPane();
    }
}
