package SupplementServices;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

/**
 * Handles user input and displays prompts to the console.
 *
 * @author Callum Peel
 */
public class FrontEndGUI implements UserInterface, java.io.Serializable {

    private BackEnd backEnd;
    int width, height;
    boolean isViewMode, isCreateMode, isEditMode;
    TreeView<String> treeView1, treeView2;
    TreeItem<String> itemSelected;

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
        Label title = new Label("MAGAZINE SERVICES");
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

        topSectionPane.setMargin(title, new Insets(30, 0, 0, 0));
        Insets insets = new Insets(20, 40, 20, 40);
        topSectionPane.setMargin(vButton, insets);
        topSectionPane.setMargin(cButton, insets);
        topSectionPane.setMargin(mButton, insets);
        topSectionPane.setMargin(separator1, insets);

        return topSectionPane;
    }

    private VBox getLeftPane() {
        TreeItem<String> rootItem1 = new TreeItem("Customer Database");
        TreeItem<String> rootItem2 = new TreeItem("Supplement Database");

        TreeItem<String> customers = new TreeItem("Customers");
        for (int i = 0; i < backEnd.getNumCust(); i++) {
            customers.getChildren().add(new TreeItem(backEnd.getCustName(i)));
        }
        TreeItem<String> supplements = new TreeItem("Supplements");
        for (int i = 0; i < backEnd.getNumSups(); i++) {
            supplements.getChildren().add(new TreeItem(backEnd.getSupName(i)));
        }

        rootItem1.getChildren().add(customers);
        rootItem2.getChildren().add(supplements);

        this.treeView1 = new TreeView();
        treeView1.setRoot(rootItem1);
        treeView1.setShowRoot(false);

        this.treeView2 = new TreeView();
        treeView2.setRoot(rootItem2);
        treeView2.setShowRoot(false);
        
        if (!isViewMode) {
            treeView1.setEditable(true);
            treeView2.setEditable(true);
            treeView1.setCellFactory(new Callback<TreeView<String>, TreeCell<String>>() {
                @Override
                public TreeCell<String> call(TreeView<String> p) {
                    TextFieldTreeCellImpl thing = new TextFieldTreeCellImpl(backEnd, isEditMode);
                    return thing;
                }
            });
            treeView2.setCellFactory(new Callback<TreeView<String>, TreeCell<String>>() {
                @Override
                public TreeCell<String> call(TreeView<String> p) {
                    TextFieldTreeCellImpl thing = new TextFieldTreeCellImpl(backEnd, isEditMode);
                    return thing;
                }
            });
        }
        VBox vbox = new VBox(treeView1, treeView2);

        vbox.setMargin(treeView1,
                new Insets(0, 0, 20, 20));
        vbox.setMargin(treeView2,
                new Insets(0, 0, 20, 20));

//        this.itemSelected = treeView.getSelectionModel().getSelectedItem();
//        if (itemSelected == null) {
//            System.out.println("thing");
//        }
//        String name = thing.getValue();
//        System.out.println(name);
        return vbox;
    }

    private VBox getCenterPane() {
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

        ReadOnlyObjectProperty indexSelected = treeView.getSelectionModel().selectedItemProperty();
        VBox vbox = new VBox(treeView);
        vbox.setMargin(treeView, new Insets(0, 20, 20, 20));
        return vbox;
    }

    private BorderPane getBottomPane() {

        int buttonWidth = 150;
        Button vButton = new Button();
        Button refreshButton = new Button();
        refreshButton.setText("Refresh");
        refreshButton.setOnAction(
                e -> {
                    System.out.println("Page Refreshed\n");
                    refresh();
                }
        );

        refreshButton.setMinWidth(buttonWidth);
        BorderPane bottomSectionPane = new BorderPane();
        bottomSectionPane.setCenter(refreshButton);
        bottomSectionPane.setMargin(refreshButton, new Insets(0, 0, 30, 0));

        return bottomSectionPane;
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
    public void addCenterSection(BorderPane pane) {
        pane.setCenter(getCenterPane());
    }

    @Override
    public void addRightSection(BorderPane pane) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void viewMode() {
        this.isViewMode = true;
        this.isCreateMode = false;
        this.isEditMode = false;
        refresh();
    }

    @Override
    public void createMode() {
        this.isViewMode = false;
        this.isCreateMode = true;
        this.isEditMode = false;
        refresh();
    }

    @Override
    public void editMode() {
        this.isViewMode = false;
        this.isCreateMode = false;
        this.isEditMode = true;
        refresh();
    }

    @Override
    public void refresh() {
        if (isViewMode) {
            this.backEnd.viewPane = new BorderPane();
            this.backEnd.viewPane.setTop(getTopPane());
            this.backEnd.viewPane.setLeft(getLeftPane());
            this.backEnd.viewPane.setCenter(getCenterPane());
            this.backEnd.viewPane.setBottom(getBottomPane());
            this.backEnd.vScene = new Scene(this.backEnd.viewPane, this.width, this.height);
            this.backEnd.stage.setScene(this.backEnd.vScene);
            this.backEnd.stage.show();
        }
        if (isCreateMode) {
            this.backEnd.createPane = new BorderPane();
            this.backEnd.createPane.setTop(getTopPane());
            this.backEnd.createPane.setLeft(getLeftPane());
            this.backEnd.createPane.setCenter(getCenterPane());
            this.backEnd.createPane.setBottom(getBottomPane());
            this.backEnd.cScene = new Scene(this.backEnd.createPane, this.width, this.height);
            this.backEnd.stage.setScene(this.backEnd.cScene);
            this.backEnd.stage.show();
        }
        if (isEditMode) {
            this.backEnd.editPane = new BorderPane();
            this.backEnd.editPane.setTop(getTopPane());
            this.backEnd.editPane.setLeft(getLeftPane());
            this.backEnd.editPane.setCenter(getCenterPane());
            this.backEnd.editPane.setBottom(getBottomPane());
            this.backEnd.eScene = new Scene(this.backEnd.editPane, this.width, this.height);
            this.backEnd.stage.setScene(this.backEnd.eScene);
            this.backEnd.stage.show();
        }
    }
}
