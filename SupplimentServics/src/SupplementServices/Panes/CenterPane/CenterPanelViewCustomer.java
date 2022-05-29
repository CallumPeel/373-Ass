package SupplementServices.Panes.CenterPane;

import SupplementServices.BackEnd;
import SupplementServices.FrontEndGUI;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

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
        VBox customerBreakdownVBox = new VBox(this.backEnd.getCustomer(this.frontEnd.customerSelected).getDetails());
        this.centerSectionPane.setCenter(customerBreakdownVBox);
        this.centerSectionPane.setBottom(this.centerBottomPane);
        this.centerSectionPane.setMargin(customerBreakdownVBox, new Insets(15));
        setPane();
    }
}
