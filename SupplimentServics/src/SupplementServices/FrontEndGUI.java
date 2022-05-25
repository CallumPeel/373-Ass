package SupplementServices;

import SupplementServices.LeftPane.LeftPanel;
import SupplementServices.LeftPane.LeftPanelEdit;
import SupplementServices.LeftPane.LeftPanelCreate;
import SupplementServices.centerPane.CenterPanelViewCustomer;
import SupplementServices.centerPane.CenterPanelEdit;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class FrontEndGUI {

    protected BackEnd backEnd;
    protected int width, height;
    protected boolean isViewMode, isCreateMode, isEditMode;
    public TreeView<String> customerTreeView, supplementTreeView, magazineTreeView;
    public String customerSelected, supplementSelected, magazineSelected;
    protected int buttonWidth;
    public VBox vbox;

    public FrontEndGUI(BackEnd backEnd, int width, int height) {
        this.backEnd = backEnd;
        this.backEnd.stage.setTitle("Program");
        this.width = width;
        this.height = height;
        this.buttonWidth = 150;
        this.customerSelected = this.backEnd.customers.get(0).name;
        this.supplementSelected = this.backEnd.supplements.get(0).getName();
        this.magazineSelected = this.backEnd.mags.get(0).getName();
        viewMode();
    }

    private void setMagTree() {
        TreeItem<String> rootItem1 = new TreeItem("Magazine Database");
        for (int i = 0; i < backEnd.getNumMags(); i++) {
            rootItem1.getChildren().add(new TreeItem(backEnd.getMagName(i)));
        }
        this.magazineTreeView = new TreeView();
        this.magazineTreeView.setRoot(rootItem1);
        this.magazineTreeView.setShowRoot(false);
        this.magazineTreeView.setPadding(new Insets(15));
    }

    private void setViewTree() {
        TreeItem<String> rootItem1 = new TreeItem("Customer Database");
        TreeItem<String> rootItem2 = new TreeItem("Supplement Database");
        for (int i = 0; i < backEnd.getNumCust(); i++) {
            rootItem1.getChildren().add(new TreeItem(backEnd.getCustName(i)));
        }
        for (int i = 0; i < backEnd.getNumSups(); i++) {
            rootItem2.getChildren().add(new TreeItem(backEnd.getSupName(i)));
        }

        this.customerTreeView = new TreeView();
        this.customerTreeView.setRoot(rootItem1);
        this.customerTreeView.setShowRoot(false);
        this.supplementTreeView = new TreeView();
        this.supplementTreeView.setRoot(rootItem2);
        this.supplementTreeView.setShowRoot(false);
        this.customerTreeView.setPadding(new Insets(15));
        this.supplementTreeView.setPadding(new Insets(15));
    }

    public void setSelectedCustomer() {
        this.customerSelected = this.customerTreeView.getSelectionModel().getSelectedItem().getValue();
    }

    public void setSelectedSupplement() {
        this.supplementSelected = this.supplementTreeView.getSelectionModel().getSelectedItem().getValue();
    }

    public void setSelectedMagazine() {
        this.magazineSelected = this.magazineTreeView.getSelectionModel().getSelectedItem().getValue();
    }

    public void setDefaultSelectedCustomer() {
        this.customerSelected = this.backEnd.customers.get(0).name;
    }

    public void setDefaultSelectedSupplement() {
        this.supplementSelected = this.backEnd.supplements.get(0).name;
    }

    public void setDefaultSelectedMagazine() {
        this.magazineSelected = this.backEnd.mags.get(0).name;
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
        setViewTree();
        setMagTree();
        this.backEnd.viewPane = new BorderPane();
        this.backEnd.createPane = new BorderPane();
        this.backEnd.editPane = new BorderPane();
        new TopPanel(this.backEnd, this);
        new BottomPanel(this.backEnd, this);
        if (isViewMode) {
            new LeftPanel(this.backEnd, this);
            new CenterPanelViewCustomer(this.backEnd, this);
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
            new CenterPanelEdit(this.backEnd, this);
            this.backEnd.eScene = new Scene(this.backEnd.editPane, this.width, this.height);
            this.backEnd.stage.setScene(this.backEnd.eScene);
            this.backEnd.stage.show();
        }
    }
}
