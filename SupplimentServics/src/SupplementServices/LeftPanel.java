package SupplementServices;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class LeftPanel extends VBox {

    BackEnd backEnd;
    SceneTemplate sceneTemplate;
    Button viewCustomerButton, viewSupplementButton;

    public LeftPanel(BackEnd backEnd, SceneTemplate sceneTemplate) {
        this.backEnd = backEnd;
        this.sceneTemplate = sceneTemplate;
        buildPane();
    }

    private void buildPane() {
        Insets inset = new Insets(0, 0, 15, 15);

        Button viewCustButton = new Button();
        viewCustButton.setText("View Customer");
        viewCustButton.setOnAction(
                e -> {
                    onCustButtonClick();
                }
        );
        Button viewSupButton = new Button();
        viewSupButton.setText("View Supplement");
        viewSupButton.setOnAction(
                e -> {
                    onSupButtonClick();
                }
        );
        this.sceneTemplate.vbox = new VBox(viewCustButton, this.sceneTemplate.treeView1, viewSupButton, this.sceneTemplate.treeView2);
        this.sceneTemplate.vbox.setAlignment(Pos.CENTER);
        this.sceneTemplate.vbox.setMargin(this.sceneTemplate.treeView1, inset);
        this.sceneTemplate.vbox.setMargin(this.sceneTemplate.treeView2, inset);
        this.sceneTemplate.vbox.setMargin(viewCustButton, inset);
        this.sceneTemplate.vbox.setMargin(viewSupButton, inset);
    }

    public void onCustButtonClick() {
        // Directly set center pane here with new CenterPanel Class.
        this.sceneTemplate.itemSelected = this.sceneTemplate.treeView1.getSelectionModel().getSelectedItem().getValue();
        this.sceneTemplate.refresh();
    }

    public void onSupButtonClick() {
        this.sceneTemplate.itemSelected = this.sceneTemplate.treeView2.getSelectionModel().getSelectedItem().getValue();
        this.sceneTemplate.refresh();
    }
}
