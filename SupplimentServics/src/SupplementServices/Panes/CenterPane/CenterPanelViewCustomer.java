package SupplementServices.Panes.CenterPane;

import SupplementServices.BackEnd;
import SupplementServices.FrontEndGUI;
import SupplementServices.Panes.MyVBox;
import javafx.geometry.Insets;

/**
 * Displays Customer information to center pane.
 *
 * @author callum
 */
public class CenterPanelViewCustomer extends CenterPanel {

    /**
     * Constructs a center panel for viewing customer fields.
     *
     * @param backEnd
     * @param frontEnd
     */
    public CenterPanelViewCustomer(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
        addTreeView();
    }

    /**
     * Constructs a tree view of the customer's information.
     */
    private void addTreeView() {
        MyVBox customerBreakdownVBox = new MyVBox(this.backEnd.getCustomer(this.frontEnd.customerSelected).getDetails());
        this.centerSectionPane.setCenter(customerBreakdownVBox);
        this.centerSectionPane.setBottom(this.centerBottomPane);
        this.centerSectionPane.setMargin(customerBreakdownVBox, new Insets(15));
        setPane();
    }
}
