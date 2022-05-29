package SupplementServices;

import SupplementServices.Panes.BottomPanel;
import SupplementServices.Panes.TopPanel;
import SupplementServices.Panes.LeftPane.LeftPanel;
import SupplementServices.Panes.LeftPane.LeftPanelEdit;
import SupplementServices.Panes.LeftPane.LeftPanelCreate;
import SupplementServices.Panes.CenterPane.CenterPanelViewCustomer;
import SupplementServices.Panes.CenterPane.CenterPanelEdit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author callum
 */
public class FrontEndGUI {

    private BackEnd backEnd;
    private int width, height;
    private boolean isViewMode;
    private boolean isCreateMode;
    private boolean isEditMode;
    private TreeView<String> customerTreeView,
            supplementTreeView,
            magazineTreeView;
    private String customerSelected,
            supplementSelected,
            magazineSelected;
    private int buttonWidth;
    private VBox leftVBox;

    /**
     * Constructs a Front End.
     *
     * @param backEnd
     * @param width
     * @param height
     * @throws IOException
     * @throws FileNotFoundException
     */
    public FrontEndGUI(BackEnd backEnd, int width, int height) throws IOException, FileNotFoundException {
        this.backEnd = backEnd;
        this.backEnd.stage.setTitle("Program");
        this.width = width;
        this.height = height;
        this.buttonWidth = 150;
        this.backEnd.setFileName(getDirectory());
//        try {
//            this.backEnd.load();
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(FrontEndGUI.class.getName()).log(Level.SEVERE, null, ex);
//        }
        this.customerSelected = this.backEnd.customers.get(0).getName();
        this.supplementSelected = this.backEnd.supplements.get(0).getName();
        this.magazineSelected = this.backEnd.magazines.get(0).getName();
        viewMode();
    }

    /**
     * Builds a Tree View of all the Magazines
     */
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

    /**
     * Returns the current Customer details in a Tree View.
     *
     * @return
     */
    public TreeView<String> getCustomerTreeView() {
        return customerTreeView;
    }

    /**
     * Sets the current Customer Tree View.
     *
     * @param customerTreeView
     */
    public void setCustomerTreeView(TreeView<String> customerTreeView) {
        this.customerTreeView = customerTreeView;
    }

    /**
     * Returns button width.
     *
     * @return
     */
    public int getButtonWidth() {
        return buttonWidth;
    }

    /**
     * sets Button width.
     *
     * @param buttonWidth
     */
    public void setButtonWidth(int buttonWidth) {
        this.buttonWidth = buttonWidth;
    }

    /**
     * Returns the current Customer Tree View.
     *
     * @return
     */
    public TreeView<String> customerTreeView() {
        return this.customerTreeView;
    }

    /**
     * Returns the current Magazine Tree View.
     *
     * @return
     */
    public TreeView<String> getMagazineTreeView() {
        return this.magazineTreeView;
    }

    /**
     * Returns the current Supplement Tree View.
     *
     * @return
     */
    public TreeView<String> getSupplementTreeView() {
        return this.supplementTreeView;
    }

    /**
     * Returns the current Left Hand Customer and Supplement lists.
     *
     * @return
     */
    public VBox getLeftVBox() {
        return this.leftVBox;
    }

    /**
     * Sets the left hand side panel.
     *
     * @param newBox
     */
    public void setLeftVBox(VBox newBox) {
        this.leftVBox = newBox;
    }

    /**
     * Collates then sets Customer and Supplement information into TreeViews.
     */
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

    /**
     * Returns true or false state for View Mode
     *
     * @return
     */
    public boolean getIsViewMode() {
        return isViewMode;
    }

    /**
     * Sets true or false state for View Mode
     *
     * @param isViewMode
     */
    public void setIsViewMode(boolean isViewMode) {
        this.isViewMode = isViewMode;
    }

    /**
     * Returns true or false state for Create Mode
     *
     * @return
     */
    public boolean getIsCreateMode() {
        return isCreateMode;
    }

    /**
     * Sets true or false state for Create Mode
     *
     * @param isCreateMode
     */
    public void setIsCreateMode(boolean isCreateMode) {
        this.isCreateMode = isCreateMode;
    }

    /**
     * Returns true or false state for Edit Mode
     *
     * @return
     */
    public boolean getIsEditMode() {
        return isEditMode;
    }

    /**
     * Sets true or false state for Edit Mode
     *
     * @param isEditMode
     */
    public void setIsEditMode(boolean isEditMode) {
        this.isEditMode = isEditMode;
    }

    /**
     * Returns the current Customer selected in Customer Tree View.
     *
     * @return
     */
    public String getCustomerSelected() {
        return customerSelected;
    }

    /**
     * Sets current selected Customer.
     */
    public void setSelectedCustomer() {
        this.customerSelected = this.customerTreeView.getSelectionModel().getSelectedItem().getValue();
    }

    /**
     * Returns the currently selected supplement.
     *
     * @return
     */
    public String getSupplementSelected() {
        return this.supplementSelected;
    }

    /**
     * Returns the current selected magazine.
     *
     * @return
     */
    public String getMagazineSelected() {
        return magazineSelected;
    }

    /**
     * Sets the current Supplement selected.
     */
    public void setSelectedSupplement() {
        this.supplementSelected = this.supplementTreeView.getSelectionModel().getSelectedItem().getValue();
    }

    /**
     * Sets the current Magazine selected.
     */
    public void setSelectedMagazine() {
        this.magazineSelected = this.magazineTreeView.getSelectionModel().getSelectedItem().getValue();
    }

    /**
     * Sets the current Customer selected to the first element in the array.
     */
    public void setDefaultSelectedCustomer() {
        if (this.backEnd.getNumCust() < 1) this.backEnd.addCustomer("Default");
        this.customerSelected = this.backEnd.customers.get(0).getName();
    }

    /**
     * Sets the current Supplement selected to the first element in the array.
     */
    public void setDefaultSelectedSupplement() {
        if (this.backEnd.getNumCust() < 1) this.backEnd.addSupplement("Default");
        this.supplementSelected = this.backEnd.supplements.get(0).name;
    }

    /**
     * Sets the current Magazine selected to the first element in the array.
     */
    public void setDefaultSelectedMagazine() {
        if (this.backEnd.getNumCust() < 1) this.backEnd.addMagazine("Default");
        this.magazineSelected = this.backEnd.magazines.get(0).name;
    }

    /**
     * Set global boolean values to View Mode.
     */
    public void viewMode() {
        this.isViewMode = true;
        this.isCreateMode = false;
        this.isEditMode = false;
        refresh();
    }

    /**
     * Set global boolean values to Create Mode.
     */
    public void createMode() {
        this.isViewMode = false;
        this.isCreateMode = true;
        this.isEditMode = false;
        refresh();
    }

    /**
     * Set global boolean values to Edit Mode.
     */
    public void editMode() {
        this.isViewMode = false;
        this.isCreateMode = false;
        this.isEditMode = true;
        refresh();
    }

    /**
     * Resets all panes.
     */
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

    /**
     * Prompts user to input a file name.
     * 
     * Returns this as correct file name format.
     * @return
     */
    public String getDirectory() {
        String fileName = "";
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("."));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Binary Files", "bin");
        fileChooser.setFileFilter(filter);
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            System.out.println(file);
            fileName = file.toString();
            if (!fileName.endsWith("bin")) {
                fileName += ".bin";
            }
        } else {
            fileName = getDirectory();
        }
        return fileName;
    }
}
