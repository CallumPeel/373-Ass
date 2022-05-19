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

public class SupplementAddBox extends TreeCell<String> {

    private TextField textField;
    private ContextMenu addMenu = new ContextMenu();
    private BackEnd backEnd;
    private boolean isEditMode;

    public SupplementAddBox(BackEnd backEnd, boolean isEdit) {

        MenuItem addSupplementItem = new MenuItem("Add Supplement");
        addMenu.getItems().add(addSupplementItem);
        addSupplementItem.setOnAction(
                new EventHandler() {
            public void handle(Event t) {
                String name = "New Supplement";
                TreeItem newSupplement = new TreeItem<String>(name);
                getTreeItem().getChildren().add(newSupplement);
                backEnd.addSupplement(name);
            }
        }
        // make an event handler that changes the center pane?
        );
        this.backEnd = backEnd;
        this.isEditMode = isEdit;
    }

    @Override
    public void startEdit() {
        if (isEditMode) {
            super.startEdit();

            if (textField == null) {
                createTextField();
            }
            setText(null);
            setGraphic(textField);
            textField.selectAll();
        }
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
                    String name = getString();
                    textField.setText(name);
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
                    String name = textField.getText();
                    backEnd.getCustName(getItem()).setName(name);
                    commitEdit(name);
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
