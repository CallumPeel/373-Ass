package SupplementServices;

import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

/**
 * Contains supplement name and cost.
 *
 * @author Callum Peel
 */
public class Supplement {

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

    public TreeView<String> getDetails() {
        TreeItem<String> supplementInformation = new TreeItem("Supplement");
        supplementInformation.getChildren().add(new TreeItem("Name: " + this.name));
        supplementInformation.getChildren().add(new TreeItem("Cost: $" + String.format("%.2f", this.cost)));

        TreeView details = new TreeView();
        details.setRoot(supplementInformation);
        details.setShowRoot(false);
        return details;
    }
}
