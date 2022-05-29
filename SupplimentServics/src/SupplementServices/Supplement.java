package SupplementServices;

import SupplementServices.Panes.MyHBox;
import java.io.Serializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 * Contains supplement name and cost.
 *
 * @author Callum Peel
 */
public class Supplement implements Cloneable, Serializable {

    private String name;
    private double cost;

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

    /**
     * Constructs a Supplement from name with default values.
     *
     * @param name
     */
    public Supplement(String name) {
        this.name = name;
        this.cost = -1;
    }

    /**
     * Constructs a Supplement with default values.
     *
     */
    public Supplement() {
        this.name = "Default";
        this.cost = -1;
    }

    /**
     * Sets name.
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

    /**
     * Gets formatted label.
     *
     * @return
     */
    public VBox getSupplementLabelVBox() {
        Label supplementLabel = new Label("Supplement");
        supplementLabel.setPadding(new Insets(10));
        supplementLabel.setFont(new Font("Arial", 20));
        VBox test = new VBox(supplementLabel);
        return test;
    }

    /**
     * Returns a VBox containing this Supplement's details.
     *
     * @return
     */
    public VBox getDetails() {
        VBox test = new VBox(getSupplementLabelVBox());

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

    /**
     * Returns an HBox containing elements to set this field.
     *
     * @return
     */
    private HBox getNameHBox() {
        MyHBox nameBox = new MyHBox();
        nameBox.setButtonName("Set Name");
        nameBox.setLabelText(this.name);
        nameBox.button.setOnAction(
                s -> {
                    try {
                        this.name = nameBox.inputText.getText();
                        nameBox.outputLabel.setText(this.name);
                    } catch (Exception e) {
                        System.out.println("Something Went Wrong...");
                    }
                });
        nameBox.formatBox();
        return nameBox.getBox();
    }

    /**
     * Returns an HBox containing elements to set this field.
     *
     * @return
     */
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
                    } catch (Exception e) {
                        System.out.println("Something Went Wrong...");
                    }
                });
        costBox.formatBox();
        return costBox.getBox();
    }

    /**
     * Returns a VBox containing editing HBoxes.
     *
     * @return
     */
    public VBox getVBox() {
        return new VBox(
                getSupplementLabelVBox(),
                this.getNameHBox(),
                this.getCostHBox()
        );
    }

    /**
     * Returns a deep copy of a this Supplement.
     *
     * @return @throws CloneNotSupportedException
     */
    @Override
    public Supplement clone() throws CloneNotSupportedException {
        return (Supplement) super.clone();
    }
}
