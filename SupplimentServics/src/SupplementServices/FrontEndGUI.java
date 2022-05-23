package SupplementServices;

import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class FrontEndGUI{

    protected BackEnd backEnd;
    protected int width, height;
    protected boolean isViewMode, isCreateMode, isEditMode;
    protected TreeView<String> treeView1, treeView2;
    protected String itemSelected;
    protected int buttonWidth;
    protected VBox vbox;

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

    private void setTree() {
        TreeItem<String> rootItem1 = new TreeItem("Customer Database");
        TreeItem<String> rootItem2 = new TreeItem("Supplement Database");
        for (int i = 0; i < backEnd.getNumCust(); i++) {
            rootItem1.getChildren().add(new TreeItem(backEnd.getCustName(i)));
        }
        for (int i = 0; i < backEnd.getNumSups(); i++) {
            rootItem2.getChildren().add(new TreeItem(backEnd.getSupName(i)));
        }
        this.treeView1 = new TreeView();
        this.treeView1.setRoot(rootItem1);
        this.treeView1.setShowRoot(false);
        this.treeView2 = new TreeView();
        this.treeView2.setRoot(rootItem2);
        this.treeView2.setShowRoot(false);
    }

    public void viewMode() {
        this.isViewMode = true;
        this.isCreateMode = false;
        this.isEditMode = false;
        refresh();
    }
    public void createMode() {
        this.isViewMode = false;
        this.isCreateMode = true;
        this.isEditMode = false;
        refresh();
    }
    public void editMode() {
        this.isViewMode = false;
        this.isCreateMode = false;
        this.isEditMode = true;
        refresh();
    }

    public void refresh() {
        this.backEnd.viewPane = new BorderPane();
        this.backEnd.createPane = new BorderPane();
        this.backEnd.editPane = new BorderPane();
        new TopPanel(this.backEnd, this);
        new BottomPanel(this.backEnd, this);
        if (isViewMode) {
            new LeftPanel(this.backEnd, this);
            new CenterPanel(this.backEnd, this);
            this.backEnd.vScene = new Scene(this.backEnd.viewPane, this.width, this.height);
            this.backEnd.stage.setScene(this.backEnd.vScene);
            this.backEnd.stage.show();
        }
        if (isCreateMode) {
            new LeftPanelCreate(this.backEnd, this);
            // Update once Create version is completed
//            new CenterPanel(this.backEnd, this);
            this.backEnd.cScene = new Scene(this.backEnd.createPane, this.width, this.height);
            this.backEnd.stage.setScene(this.backEnd.cScene);
            this.backEnd.stage.show();
        }
        if (isEditMode) {
            new LeftPanelEdit(this.backEnd, this);
            // Update once Edit version is completed
//            new CenterPanel(this.backEnd, this);
            this.backEnd.eScene = new Scene(this.backEnd.editPane, this.width, this.height);
            this.backEnd.stage.setScene(this.backEnd.eScene);
            this.backEnd.stage.show();
        }
    }
}
