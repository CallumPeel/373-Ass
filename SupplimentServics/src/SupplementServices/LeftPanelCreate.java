package SupplementServices;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class LeftPanelCreate extends LeftPanel {

    LeftPanelCreate(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
    }
    
//    @Override
//    public void buildPane() {
//        Insets inset = new Insets(0, 0, 15, 15);
//        this.frontEnd.vbox = new VBox(
//                this.frontEnd.treeView1,
//                this.frontEnd.treeView2
//        );
//        this.frontEnd.vbox.setAlignment(Pos.CENTER);
//        this.frontEnd.vbox.setMargin(this.frontEnd.treeView1, inset);
//        this.frontEnd.vbox.setMargin(this.frontEnd.treeView2, inset);
//        setPane();
//    }

    @Override
    public void setPane() {
        this.backEnd.createPane.setLeft(this.frontEnd.vbox);
    }

//    @Override
//    public void onCustViewButtonClick() {
//        // Directly set center pane here with new CenterPanel Class.
//        this.frontEnd.itemSelected = this.frontEnd.treeView1.getSelectionModel().getSelectedItem().getValue();
//        System.out.println("Create Modeeee");
//        this.frontEnd.refresh();
//    }

    @Override
    public void onSupViewButtonClick() {
        this.frontEnd.customerSelected = this.frontEnd.treeView2.getSelectionModel().getSelectedItem().getValue();
        this.frontEnd.refresh();
    }
}
