/*
 * Student Name: Callum Peel
 * Student ID: 34217062
 */
package SupplementServices;

import javafx.scene.layout.BorderPane;

/**
 *
 * @author Callum Peel
 */
public interface UserInterface {
    void addTopSection(BorderPane pane);
    void addLeftSection(BorderPane pane);
    void viewMode();
    void createMode();
    void editMode();
    void refresh();
}
