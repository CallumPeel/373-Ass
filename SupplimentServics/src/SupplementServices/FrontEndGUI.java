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
    String itemSelected;
    int buttonWidth;

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
    
    private VBox editModeLeftPanel(VBox vbox) {
        Button editCustomerButton = new Button();
        editCustomerButton.setText("View Customer");
        editCustomerButton.setOnAction(
                e -> {
                    this.itemSelected = treeView1.getSelectionModel().getSelectedItem().getValue();
                    refresh();
                }
        );
        Button editSupplementButton = new Button();
        editSupplementButton.setText("View Supplement");
        editSupplementButton.setOnAction(
                e -> {
                    System.out.println(treeView2.getSelectionModel().getSelectedItem().getValue());
                    refresh();
                }
        );
        vbox = new VBox(editCustomerButton, treeView1, editSupplementButton, treeView2);
        
        vbox.setAlignment(Pos.CENTER);
        Insets inset = new Insets(0, 0, 15, 15);
        vbox.setMargin(editSupplementButton, inset);
        vbox.setMargin(editCustomerButton, inset);
        vbox.setMargin(treeView1, inset);
        vbox.setMargin(treeView2, inset);
        return vbox;
    }
    
    private VBox viewModeLeftPanel(VBox vbox) {
        vbox = new VBox(this.treeView1, this.treeView2);
        vbox.setMargin(this.treeView1,
                new Insets(0, 0, 20, 20));
        vbox.setMargin(this.treeView2,
                new Insets(0, 0, 20, 20));
        return vbox;
    }
    
    private VBox getLeftPane() {
        VBox vbox = new VBox();
        if (!this.isViewMode) {
            vbox = editModeLeftPanel(vbox);
        } else {
            vbox = viewModeLeftPanel(vbox);
        }
        return vbox;
    }
    
    private BorderPane viewCenterPane(BorderPane topSectionPane) {
        Label title = new Label("Customer Breakdown");
        topSectionPane.setTop(title);
        topSectionPane.setAlignment(title, Pos.TOP_CENTER);

//        VBox test = new VBox(this.backEnd.getCustName("Callum").getDetails());
        VBox test = new VBox(this.backEnd.getCustName(this.itemSelected).getDetails());
        topSectionPane.setCenter(test);
        topSectionPane.setMargin(test, new Insets(30));
        
        return topSectionPane;
    }
    
    private BorderPane getCenterPane() {
        BorderPane topSectionPane = new BorderPane();
        topSectionPane = viewCenterPane(topSectionPane);
        return topSectionPane;
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
