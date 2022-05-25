package SupplementServices;

import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

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
    public Magazine(String name, double cost, ArrayList<Supplement> supplements, ArrayList<Customer> customerSubscriptions) {
        this.name = name;
        this.cost = cost;
        this.supplements = supplements;
        this.customerSubscriptions = customerSubscriptions;
    }

    public Magazine(String name, double cost, ArrayList<Supplement> supplements) {
        this.name = name;
        this.cost = cost;
        this.supplements = supplements;
        this.customerSubscriptions = new ArrayList<Customer>();
    }

    public Magazine(String name, double cost) {
        this.name = name;
        this.cost = cost;
        this.supplements = new ArrayList<Supplement>();
        this.customerSubscriptions = new ArrayList<Customer>();
    }

    public Magazine(String mag) {
        this.name = mag;
        this.cost = -1;
        this.supplements = new ArrayList<Supplement>();
        this.customerSubscriptions = new ArrayList<Customer>();
    }

    /**
     * Default constructor initializes global variables too default values.
     */
    public Magazine() {
        this.name = "Defaut";
        this.cost = -1;
        this.supplements = new ArrayList<Supplement>();
        this.customerSubscriptions = new ArrayList<Customer>();
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

    public ChoiceBox<String> getSupplementList() {
        ChoiceBox<String> choice = new ChoiceBox();
        for (int i = 0; i < this.supplements.size(); i++) {
            choice.getItems().add(this.supplements.get(i).name);
        }
        return choice;
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

    private HBox getCostHBox() {
        MyHBox costBox = new MyHBox();
        costBox.setButtonName("Magazine Cost");
        costBox.setLabelText(Double.toString(this.cost));
        costBox.button.setOnAction(
                s -> {
                    try {
                        this.cost = Double.parseDouble(costBox.inputText.getText());
                        costBox.outputLabel.setText(Double.toString(this.cost));
                        System.out.println("Post Code changed");
                    } catch (Exception e) {
                        System.out.println("Something Went Wrong...");
                    }
                });
        costBox.formatBox();
        return costBox.getBox();
    }

    public HBox addSupDropDown(BackEnd backEnd, ChoiceBox<String> choice) {
        MyHBox supplementsBox = new MyHBox(choice);
        supplementsBox.setButtonName("add");
        supplementsBox.setLabelText("Choose a supplement to add");
        supplementsBox.button.setOnAction(
                s -> {
                    try {
                        String selection = supplementsBox.choice.getValue();
                        this.supplements.add(backEnd.getSupplement(selection));
                        supplementsBox.outputLabel.setText("Supplement \"" + selection + "\" added");
                        System.out.println("Supplement \"" + selection + "\" added to list");
                    } catch (Exception e) {
                        System.out.println("Something Went Wrong...");
                    }
                });
        supplementsBox.formatBox();
        return supplementsBox.getBox();
    }

    public HBox deleteSupDropDown(BackEnd backEnd) {

        MyHBox supplementsBox = new MyHBox(getSupplementList());
        supplementsBox.setButtonName("remove");
        supplementsBox.setLabelText("Choose a supplement to remove");
        supplementsBox.button.setOnAction(
                s -> {
                    try {
                        String selection = supplementsBox.choice.getValue();
                        this.supplements.remove(backEnd.getSupplement(selection));
                        supplementsBox.outputLabel.setText("Supplement \"" + selection + "\" removed");
                        System.out.println("Supplement \"" + selection + "\" removed from list");
                    } catch (Exception e) {
                        System.out.println("Something Went Wrong...");
                    }
                });
        supplementsBox.formatBox();
        return supplementsBox.getBox();
    }

    public HBox addCustDropDown(BackEnd backEnd, ChoiceBox<String> custDrop) {
        MyHBox custBox = new MyHBox(custDrop);
        custBox.setButtonName("add");
        custBox.setLabelText("Choose a customer to add");
        custBox.button.setOnAction(
                s -> {
                    try {
                        String selection = custBox.choice.getValue();
                        this.customerSubscriptions.add(backEnd.getCustomer(selection));
                        custBox.outputLabel.setText("Customer \"" + selection + "\" added");
                        System.out.println("Customer \"" + selection + "\" added to list");
                    } catch (Exception e) {
                        System.out.println("Something Went Wrong...");
                    }
                });
        custBox.formatBox();
        return custBox.getBox();
    }

    public VBox getVBox(BackEnd backEnd, ChoiceBox<String> supDrop, ChoiceBox<String> custDrop) {
        return new VBox(
                this.getNameHBox(),
                this.getCostHBox(),
                addSupDropDown(backEnd, supDrop),
                deleteSupDropDown(backEnd),
                addCustDropDown(backEnd, custDrop)
        );
    }

    public VBox getDetails() {
        Label magazine = new Label("Magazine");
        VBox test = new VBox(magazine);
        magazine.setPadding(new Insets(15));
        magazine.setFont(new Font("Arial", 20));

        TreeItem<String> supplementInformation = new TreeItem("Magazine");
        supplementInformation.getChildren().add(new TreeItem("Name: " + this.name));
        supplementInformation.getChildren().add(new TreeItem("Cost: $" + String.format("%.2f", this.cost)));

        TreeItem<String> supList = new TreeItem("Magazine Supplements");
        this.supplements.forEach((n) -> supList.getChildren().add(new TreeItem("" + n.name)));
        supplementInformation.getChildren().add(supList);
        TreeItem<String> custList = new TreeItem("Magazine Supplements");
        int size = this.customerSubscriptions.size();
        for (int i = 0; i < this.customerSubscriptions.size(); i++) {
            custList.getChildren().add(new TreeItem("" + this.customerSubscriptions.get(i).name));
        }
        supplementInformation.getChildren().add(custList);
        TreeView details = new TreeView();
        details.setRoot(supplementInformation);
        details.setShowRoot(false);
        details.setPadding(new Insets(15));
        test.getChildren().add(details);
        return test;
    }

}
