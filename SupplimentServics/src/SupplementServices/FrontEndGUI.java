package SupplementServices;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
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

    private BorderPane getTopPane() {

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
        Separator separator1 = new Separator();
        BorderPane topSectionPane = new BorderPane();
        topSectionPane.setTop(title);
        topSectionPane.setLeft(vButton);
        topSectionPane.setCenter(cButton);
        topSectionPane.setRight(mButton);
        topSectionPane.setBottom(separator1);
        topSectionPane.setAlignment(title, Pos.CENTER);
        topSectionPane.setAlignment(vButton, Pos.CENTER);
        topSectionPane.setAlignment(cButton, Pos.CENTER);
        topSectionPane.setAlignment(mButton, Pos.CENTER);
        Insets insets = new Insets(10);
        topSectionPane.setMargin(title, insets);
        topSectionPane.setMargin(vButton, insets);
        topSectionPane.setMargin(cButton, insets);
        topSectionPane.setMargin(mButton, insets);
        topSectionPane.setMargin(separator1, insets);

        return topSectionPane;
    }

    private VBox getLeftPane() {
        TreeItem rootItem = new TreeItem("Database");

        TreeItem webItem = new TreeItem("Customers");
        for (int i = 0; i < backEnd.getNumCust(); i++) {
            webItem.getChildren().add(new TreeItem(backEnd.getCustName(i)));
        }
        rootItem.getChildren().add(webItem);

        TreeItem javaItem = new TreeItem("Supplements");
        for (int i = 0; i < backEnd.getNumSups(); i++) {
            javaItem.getChildren().add(new TreeItem(backEnd.getSupName(i)));
        }
        rootItem.getChildren().add(javaItem);

        TreeView treeView = new TreeView();
        treeView.setRoot(rootItem);

        treeView.setShowRoot(false);
//        treeView.setShowRoot(true);

        VBox vbox = new VBox(treeView);
        return vbox;
    }

    @Override
    public void addLeftSection(BorderPane pane) {
        pane.setLeft(getLeftPane());
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

        addLeftSection(this.backEnd.viewPane);
        addLeftSection(this.backEnd.createPane);
        addLeftSection(this.backEnd.editPane);
    }
}
