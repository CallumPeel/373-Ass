package SupplementServices.centerPane;

import SupplementServices.BackEnd;
import SupplementServices.FrontEndGUI;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

public class CenterPanelViewCustomer extends CenterPanel {

    public CenterPanelViewCustomer(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
        addTreeView();
    }

    private void addTreeView() {
        VBox customerBreakdownVBox = new VBox(this.backEnd.getCustomer(this.frontEnd.customerSelected).getDetails());
        this.centerSectionPane.setCenter(customerBreakdownVBox);
        this.centerSectionPane.setBottom(this.centerBottomPane);
        this.centerSectionPane.setMargin(customerBreakdownVBox, new Insets(15));        
        setPane();
    }
}