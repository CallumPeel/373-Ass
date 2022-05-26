package SupplementServices.centerPane;

import SupplementServices.BackEnd;
import SupplementServices.FrontEndGUI;
import SupplementServices.MyVBox;
import javafx.geometry.Insets;

public class CenterPanelViewCustomer extends CenterPanel {

    public CenterPanelViewCustomer(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
        addTreeView();
    }

    private void addTreeView() {
        MyVBox customerBreakdownVBox = new MyVBox(this.backEnd.getCustomer(this.frontEnd.customerSelected).getDetails());
        this.centerSectionPane.setCenter(customerBreakdownVBox);
        this.centerSectionPane.setBottom(this.centerBottomPane);
        this.centerSectionPane.setMargin(customerBreakdownVBox, new Insets(15));        
        setPane();
    }
}
