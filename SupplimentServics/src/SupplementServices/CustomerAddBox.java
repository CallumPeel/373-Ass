/*
 * Student Name: Callum Peel
 * Student ID: 34217062
 */
package SupplementServices;

import java.io.Serializable;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;

public class CustomerAddBox implements Serializable {

    private TextField textField;
    private ContextMenu addMenu = new ContextMenu();
    private BackEnd backEnd;
    private boolean isEditMode;

    public CustomerAddBox(BackEnd backEnd, boolean isEdit) {

        MenuItem addCustomerItem = new MenuItem("Add Customer");
        addMenu.getItems().add(addCustomerItem);
        addCustomerItem.setOnAction(
                new EventHandler() {
            public void handle(Event t) {
                MenuItem mItem = (MenuItem) t.getSource();
                System.out.println(mItem.getText());
                String name = "New Customer";
                TreeItem newCustomer = new TreeItem<String>(name);
//                getTreeItem().getChildren().add(newCustomer);
                backEnd.addCustomer(name);
            }
        }
        );

        this.backEnd = backEnd;
        this.isEditMode = isEdit;
    }
}
