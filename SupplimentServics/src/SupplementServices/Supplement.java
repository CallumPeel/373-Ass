package SupplementServices;

import java.io.Serializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

/**
 * Contains supplement name and cost.
 *
 * @author Callum Peel
 */
public class Supplement implements Cloneable, Serializable {

    protected String name;
    protected double cost;

    /**
     * Takes a name and cost, constructs and initializes those values.
     *
     * @param name
     * @param cost
     */
    public Supplement(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public Supplement(String name) {
        this.name = name;
        this.cost = -1;
    }

    public Supplement() {
        this.name = "Default";
        this.cost = -1;
    }

    /**
     * Takes a name and initializes it.
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the supplement name.
     *
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     * Takes a supplement cost and initializes it.
     *
     * @param cost
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * Returns the supplement cost.
     *
     * @return
     */
    public double getCost() {
        return this.cost;
    }

    public MyVBox getSupplementLabelVBox() {
        Label supplementLabel = new Label("Supplement");
        supplementLabel.setPadding(new Insets(10));
        supplementLabel.setFont(new Font("Arial", 20));
        MyVBox test = new MyVBox(supplementLabel);
        return test;
    }

    public MyVBox getDetails() {
        MyVBox test = new MyVBox(getSupplementLabelVBox());

        TreeItem<String> supplementInformation = new TreeItem("Supplement");
        supplementInformation.getChildren().add(new TreeItem("Name: " + this.name));
        supplementInformation.getChildren().add(new TreeItem("Cost: $" + String.format("%.2f", this.cost)));

        TreeView details = new TreeView();
        details.setRoot(supplementInformation);
        details.setShowRoot(false);
        details.setPadding(new Insets(10));
        test.getChildren().add(details);
        return test;
    }

    // implement for sups
    private HBox getNameHBox() {
        MyHBox nameBox = new MyHBox();
        nameBox.setButtonName("Set Name");
        nameBox.setLabelText(this.name);
        nameBox.button.setOnAction(
                s -> {
                    try {
                        this.name = nameBox.inputText.getText();
                        nameBox.outputLabel.setText(this.name);
                        System.out.println("Name changed");

                    } catch (Exception e) {
                        System.out.println("Something Went Wrong...");
                    }
                });
        nameBox.formatBox();
        return nameBox.getBox();
    }

    private HBox getCostHBox() {
        MyHBox costBox = new MyHBox();
        costBox.setButtonName("Set Cost");
        costBox.setLabelText("$" + String.format("%.2f", this.cost));
        if (this.cost == -1) {
            costBox.setLabelText("Default");
        }
        costBox.button.setOnAction(
                s -> {
                    try {
                        this.cost = Double.parseDouble(costBox.inputText.getText());
                        costBox.outputLabel.setText("$" + String.format("%.2f", this.getCost()));
                        System.out.println("Cost changed");
                    } catch (Exception e) {
                        System.out.println("Something Went Wrong...");
                    }
                });
        costBox.formatBox();
        return costBox.getBox();
    }

    public MyVBox getVBox() {
        return new MyVBox(
                getSupplementLabelVBox(),
                this.getNameHBox(),
                this.getCostHBox()
        );
    }

    @Override
    public Supplement clone() throws CloneNotSupportedException {
        return (Supplement) super.clone();
    }
}
