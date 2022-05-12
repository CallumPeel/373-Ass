package SupplementServices;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * Handles user input and displays prompts to the console.
 *
 * @author Callum Peel
 */
public class FrontEndGUI implements UserInterface, java.io.Serializable {

    private BackEnd backEnd;
    int width, height;

    /**
     * Takes a back end as a parameter and constructs a front end. Takes a
     * BackEnd and initializes it to the global variable.
     *
     * @param backEnd
     */
    public FrontEndGUI(BackEnd backEnd, int width, int height) {
        this.backEnd = backEnd;
        this.backEnd.stage.setTitle("Program");
        this.width = width;
        this.height = height;
        viewMode();
    }

    private FlowPane getTopPane(){
        Label title = new Label("Hello");

        int buttonWidth = 150;
        Button vButton = new Button();
        vButton.setText("View Mode");
        vButton.setOnAction(
                e -> {
                    System.out.println("View Mode Activated\n");
                    viewMode();
                }
        );

        Button cButton = new Button();
        cButton.setText("Create Mode");
        cButton.setOnAction(
                e -> {
                    System.out.println("Create Mode Activated\n");
                    createMode();
                }
        );

        Button mButton = new Button();
        mButton.setText("Edit Mode");
        mButton.setOnAction(
                e -> {
                    System.out.println("Edit Mode Activated\n");
                    editMode();
                }
        );
        vButton.setMinWidth(buttonWidth);
        cButton.setMinWidth(buttonWidth);
        mButton.setMinWidth(buttonWidth);

        FlowPane topPane = new FlowPane(vButton, cButton, mButton);
        return topPane;
    }
    
    @Override
    public void addTopSection(BorderPane pane) {
        pane.setTop(getTopPane());
    }

    @Override
    public void viewMode() {
        refresh();
        this.backEnd.vScene = new Scene(this.backEnd.viewPane, this.width, this.height);
        this.backEnd.stage.setScene(this.backEnd.vScene);
        this.backEnd.stage.show();
    }

    @Override
    public void createMode() {
        refresh();
        this.backEnd.cScene = new Scene(this.backEnd.createPane, this.width, this.height);
        this.backEnd.stage.setScene(this.backEnd.cScene);
        this.backEnd.stage.show();
    }

    @Override
    public void editMode() {
        refresh();
        this.backEnd.eScene = new Scene(this.backEnd.editPane, this.width, this.height);
        this.backEnd.stage.setScene(this.backEnd.eScene);
        this.backEnd.stage.show();
    }

    @Override
    public void refresh() {
        this.backEnd.viewPane = new BorderPane();
        this.backEnd.createPane = new BorderPane();
        this.backEnd.editPane = new BorderPane();

        addTopSection(this.backEnd.viewPane);
        addTopSection(this.backEnd.createPane);
        addTopSection(this.backEnd.editPane);
    }
}
