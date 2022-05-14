/*
 * Student Name: Callum Peel
 * Student ID: 34217062
 */
package SupplementServices;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

public class TextFieldTreeCellImpl extends TreeCell<String> {

    private TextField textField;
    private ContextMenu addMenu = new ContextMenu();

    public TextFieldTreeCellImpl(BackEnd backEnd) {
        MenuItem addCustomerItem = new MenuItem("Add Customer");
        MenuItem addSupplementItem = new MenuItem("Add Supplement");
        addMenu.getItems().add(addCustomerItem);
        addMenu.getItems().add(addSupplementItem);
        addCustomerItem.setOnAction(
                new EventHandler() {
            public void handle(Event t) {
                backEnd.createPane = new BorderPane();;
                String name = "ford";
                TreeItem newCustomer = new TreeItem<String>(name);
                getTreeItem().getChildren().add(newCustomer);
                backEnd.addCustomer(name);
            }
        }
        );
        addSupplementItem.setOnAction(
                new EventHandler() {
            public void handle(Event t) {
//                    TreeItem newCustomer = new TreeItem<String>("New Customer");
//                    getTreeItem().getChildren().add(newCustomer);
                System.out.println("tttttttttt");
            }
        }
        );
    }

    @Override
    public void startEdit() {
        super.startEdit();

        if (textField == null) {
            createTextField();
        }
        setText(null);
        setGraphic(textField);
        textField.selectAll();
    }

    @Override
    public void cancelEdit() {
        super.cancelEdit();

        setText((String) getItem());
        setGraphic(getTreeItem().getGraphic());
    }

    @Override
    public void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);

        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            if (isEditing()) {
                if (textField != null) {
                    textField.setText(getString());
                }
                setText(null);
                setGraphic(textField);
            } else {
                setText(getString());
                setGraphic(getTreeItem().getGraphic());
                if (!getTreeItem().isLeaf() && getTreeItem().getParent() != null) {
                    setContextMenu(addMenu);
                }
            }
        }
    }

    private void createTextField() {
        textField = new TextField(getString());
        textField.setOnKeyReleased(
                new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent t) {
                if (t.getCode() == KeyCode.ENTER) {
                    commitEdit(textField.getText());
                } else if (t.getCode() == KeyCode.ESCAPE) {
                    cancelEdit();
                }
            }
        }
        );
    }

    private String getString() {
        return getItem() == null ? "" : getItem().toString();
    }
}
