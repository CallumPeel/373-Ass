package SupplementServices;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class LeftPanelCreate extends LeftPanel {

    LeftPanelCreate(BackEnd backEnd, FrontEndGUI sceneTemplate) {
        super(backEnd, sceneTemplate);
    }
    
    @Override
    public void buildPane() {
        Insets inset = new Insets(0, 0, 15, 15);

        this.sceneTemplate.vbox = new VBox(
                this.sceneTemplate.treeView1,
                this.sceneTemplate.treeView2
        );
        this.sceneTemplate.vbox.setAlignment(Pos.CENTER);
        this.sceneTemplate.vbox.setMargin(this.sceneTemplate.treeView1, inset);
        this.sceneTemplate.vbox.setMargin(this.sceneTemplate.treeView2, inset);
        setPane();
    }

    @Override
    public void setPane() {
        this.backEnd.createPane.setLeft(this.sceneTemplate.vbox);
    }

    @Override
    public void onCustViewButtonClick() {
        // Directly set center pane here with new CenterPanel Class.
        this.sceneTemplate.itemSelected = this.sceneTemplate.treeView1.getSelectionModel().getSelectedItem().getValue();
        System.out.println("Create Modeeee");
        this.sceneTemplate.refresh();
    }

    @Override
    public void onSupViewButtonClick() {
        this.sceneTemplate.itemSelected = this.sceneTemplate.treeView2.getSelectionModel().getSelectedItem().getValue();
        this.sceneTemplate.refresh();
    }
}
