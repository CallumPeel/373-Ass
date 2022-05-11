package SupplementServices;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 * Handles user input and displays prompts to the console.
 *
 * @author Callum Peel
 */
public class FrontEndGUI implements UserInterface, java.io.Serializable {

    private BackEnd backEnd;

    /**
     * Takes a back end as a parameter and constructs a front end. Takes a
     * BackEnd and initializes it to the global variable.
     *
     * @param backEnd
     */
    public FrontEndGUI(BackEnd backEnd) {
        this.backEnd = backEnd;
        this.backEnd.window.setTitle("Program");
        viewMode();
    }

    @Override
    public void menuItems(VBox pane) {

        Button ViewModeButton = new Button();
        ViewModeButton.setText("View Mode");
        ViewModeButton.setOnAction(
                e -> {
                    System.out.println("View Mode Activated\n");
                    viewMode();
                }
        );
        pane.getChildren().add(ViewModeButton);

        Button createModeButton = new Button();
        createModeButton.setText("Create Mode");
        createModeButton.setOnAction(
                e -> {
                    System.out.println("Create Mode Activated\n");
                    createMode();
                }
        );
        pane.getChildren().add(createModeButton);

        Button editModeButton = new Button();
        editModeButton.setText("Edit Mode");
        editModeButton.setOnAction(
                e -> {
                    System.out.println("Edit Mode Activated\n");
                    editMode();
                }
        );
        pane.getChildren().add(editModeButton);
    }

    @Override
    public void viewMode() {
        refresh();
        menuItems(this.backEnd.viewPane);

        this.backEnd.scene = new Scene(this.backEnd.viewPane, 200, 250);
        this.backEnd.window.setScene(this.backEnd.scene);
        this.backEnd.window.show();
    }

    @Override
    public void createMode() {
        refresh();
        menuItems(this.backEnd.createPane);

        this.backEnd.scene = new Scene(this.backEnd.createPane, 200, 250);
        this.backEnd.window.setScene(this.backEnd.scene);
        this.backEnd.window.show();
    }

    @Override
    public void editMode() {
        refresh();
        menuItems(this.backEnd.editPane);

        this.backEnd.scene = new Scene(this.backEnd.editPane, 200, 250);
        this.backEnd.window.setScene(this.backEnd.scene);
        this.backEnd.window.show();
    }

    @Override
    public void refresh() {
        this.backEnd.viewPane = new VBox();
        this.backEnd.createPane = new VBox();
        this.backEnd.editPane = new VBox();
    }
}
