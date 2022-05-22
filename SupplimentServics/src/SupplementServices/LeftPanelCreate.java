package SupplementServices;

public class LeftPanelCreate extends LeftPanel {

    LeftPanelCreate(BackEnd backEnd, FrontEndGUI sceneTemplate) {
        super(backEnd, sceneTemplate);
    }

    @Override
    public void setPane() {
        this.backEnd.createPane.setLeft(this.sceneTemplate.vbox);
    }

    @Override
    public void onCustButtonClick() {
        // Directly set center pane here with new CenterPanel Class.
        this.sceneTemplate.itemSelected = this.sceneTemplate.treeView1.getSelectionModel().getSelectedItem().getValue();
        System.out.println("Create Modeeee");
        this.sceneTemplate.refresh();
    }

    @Override
    public void onSupButtonClick() {
        this.sceneTemplate.itemSelected = this.sceneTemplate.treeView2.getSelectionModel().getSelectedItem().getValue();
        this.sceneTemplate.refresh();
    }
}
