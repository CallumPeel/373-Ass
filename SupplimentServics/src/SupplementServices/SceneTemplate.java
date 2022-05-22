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
import javafx.scene.layout.VBox;

public class SceneTemplate implements UserInterface, java.io.Serializable {

    protected BackEnd backEnd;
    protected int width, height;
    protected boolean isViewMode, isCreateMode, isEditMode;
    protected TreeView<String> treeView1, treeView2;
    protected String itemSelected;
    protected int buttonWidth;
    protected VBox vbox;

    public SceneTemplate(BackEnd backEnd, int width, int height) {
        this.backEnd = backEnd;
        this.backEnd.stage.setTitle("Program");
        this.width = width;
        this.height = height;
        this.buttonWidth = 150;
        this.itemSelected = "Callum";
        setTree();
        viewMode();
    }

    private BorderPane getTopPane() {
        Label title = new Label("MAGAZINE SERVICES");
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

    private void setTree() {
        // create tree items
        TreeItem<String> rootItem1 = new TreeItem("Customer Database");
        TreeItem<String> rootItem2 = new TreeItem("Supplement Database");
        TreeItem<String> customers = new TreeItem("Customers");
        TreeItem<String> supplements = new TreeItem("Supplements");

        // set tree items
        for (int i = 0; i < backEnd.getNumCust(); i++) {
            customers.getChildren().add(new TreeItem(backEnd.getCustName(i)));
        }
        for (int i = 0; i < backEnd.getNumSups(); i++) {
            supplements.getChildren().add(new TreeItem(backEnd.getSupName(i)));
        }

        // add tree items to root
        rootItem1.getChildren().add(customers);
        rootItem2.getChildren().add(supplements);
        this.treeView1 = new TreeView();
        treeView1.setRoot(rootItem1);
        treeView1.setShowRoot(false);
        this.treeView2 = new TreeView();
        treeView2.setRoot(rootItem2);
        treeView2.setShowRoot(false);
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

    public void setLeftPane() {
        if (isViewMode) {
            new LeftPanel(this.backEnd, this);

        }
        if (isEditMode) {
            new LeftPanelEdit(this.backEnd, this);
        }
        if (isCreateMode) {
            // This is a place holder till LeftPanelEditcreate class
            new LeftPanelCreate(this.backEnd, this);
        }
    }

    @Override
    public void addTopSection(BorderPane pane) {
        pane.setTop(getTopPane());
    }

    @Override
    public void addCenterSection(BorderPane pane) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

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
            setLeftPane();
            this.backEnd.viewPane.setBottom(getBottomPane());
            this.backEnd.vScene = new Scene(this.backEnd.viewPane, this.width, this.height);
            this.backEnd.stage.setScene(this.backEnd.vScene);
            this.backEnd.stage.show();
        }
        if (isCreateMode) {
            this.backEnd.createPane = new BorderPane();
            this.backEnd.createPane.setTop(getTopPane());
            setLeftPane();
            this.backEnd.createPane.setBottom(getBottomPane());
            this.backEnd.cScene = new Scene(this.backEnd.createPane, this.width, this.height);
            this.backEnd.stage.setScene(this.backEnd.cScene);
            this.backEnd.stage.show();
        }
        if (isEditMode) {
            this.backEnd.editPane = new BorderPane();
            this.backEnd.editPane.setTop(getTopPane());
            setLeftPane();
            this.backEnd.editPane.setBottom(getBottomPane());
            this.backEnd.eScene = new Scene(this.backEnd.editPane, this.width, this.height);
            this.backEnd.stage.setScene(this.backEnd.eScene);
            this.backEnd.stage.show();
        }
    }

    @Override
    public void addLeftSection(BorderPane pane) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
