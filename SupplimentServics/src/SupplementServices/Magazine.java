package SupplementServices;

import java.util.ArrayList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Contains a list supplements and tracks cost.
 *
 * @author Callum Peel
 */
public class Magazine implements Cloneable {

    String name;
    double cost;
    ArrayList<Supplement> supplements;
    ArrayList<Customer> customerSubscriptions;

    /**
     * Takes a supplement list and cost then constructs and initializes a
     * Magazine object.
     *
     * @param supplements
     * @param cost
     */
    public Magazine(String name, double cost, ArrayList<Supplement> supplements) {
        this.name = name;
        this.cost = cost;
        this.supplements = supplements;
    }

    public Magazine(String name, double cost) {
        this.name = name;
        this.cost = cost;
        this.supplements = new ArrayList<Supplement>();
    }

    public Magazine(String mag) {
        this.name = mag;
        this.cost = -1;
        this.supplements = new ArrayList<Supplement>();
    }

    /**
     * Default constructor initializes global variables too default values.
     */
    public Magazine() {
        this.name = "Defaut";
        this.cost = -1;
        this.supplements = new ArrayList<Supplement>();
    }

    @Override
    public Magazine clone() throws CloneNotSupportedException {
        return (Magazine) super.clone();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomerSubscriptions() {
        return customerSubscriptions;
    }

    /**
     * Returns the cost of a list of supplements.
     *
     * @return
     */
    public double getCost() {
        return this.cost;
    }

    /**
     * Returns a list of supplements.
     *
     * @return
     */
    public ArrayList<Supplement> getSupplements() {
        return this.supplements;
    }

    /**
     * Calculates the total cost of a list of supplements.
     *
     * @return
     */
    private double getTotal() {
        double total = 0;
        for (Supplement supplement : this.supplements) {
            total += supplement.getCost();
        }
        return total + this.cost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCustomerSubscriptions(ArrayList<Customer> customerSubscriptions) {
        this.customerSubscriptions = customerSubscriptions;
    }

    /**
     * Sets the cost of a list of supplements.
     *
     * @param cost
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * Takes a list of supplements and initializes it to the global variable.
     *
     * @param supplements
     */
    public void setSupplementList(ArrayList<Supplement> supplements) {
        this.supplements = supplements;
    }

    /**
     * Takes a supplement and adds it to the magazines supplement list.
     *
     * @param supplement
     */
    public void addSupplement(Supplement supplement) {
        this.supplements.add(supplement);
    }

    /**
     * Takes a supplement and removes it from the magazines supplement list
     *
     * @param supplement
     */
    public void removeSupplement(Supplement supplement) {
        this.supplements.remove(supplement);
    }

    public HBox getNameHBox() {
        MyHBox nameBox = new MyHBox();
        nameBox.setButtonName("Name");
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

    // add cost method
    
    public HBox dropDown(BackEnd backEnd, ChoiceBox<String> choice) {
        MyHBox supplementsBox = new MyHBox(choice);
        supplementsBox.setButtonName("add");
        supplementsBox.setLabelText("Choose a supplement");
        supplementsBox.button.setOnAction(
                s -> {
                    try {
                        this.supplements.add(backEnd.getSupplement(supplementsBox.choice.getValue()));
                        supplementsBox.outputLabel.setText(supplementsBox.choice.getValue());
                        System.out.println("Supplement added");
                    } catch (Exception e) {
                        System.out.println("Something Went Wrong...");
                    }
                });
        supplementsBox.formatBox();
        return supplementsBox.getBox();
    }

    public VBox getVBox(BackEnd backEnd, ChoiceBox<String> choice) {
        return new VBox(
                this.getNameHBox(),
                dropDown(backEnd, choice)
        );
    }

}
