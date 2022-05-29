package SupplementServices;

import SupplementServices.Panes.MyHBox;
import java.io.Serializable;
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
public class Magazine implements Cloneable, Serializable {

    String name;
    double cost;
    ArrayList<Supplement> supplements;
    ArrayList<Customer> customers;

    /**
     * Takes a supplement list and cost then constructs and initializes a
     * Magazine object.
     *
     * @param name
     * @param supplements
     * @param cost
     * @param customerSubscriptions
     */
    public Magazine(String name, double cost, ArrayList<Supplement> supplements, ArrayList<Customer> customerSubscriptions) {
        this.name = name;
        this.cost = cost;
        this.supplements = supplements;
        this.customers = customerSubscriptions;
    }

    /**
     * Takes some values and constructs a new Magazine with other default
     * values.
     *
     * @param name
     * @param cost
     * @param supplements
     */
    public Magazine(String name, double cost, ArrayList<Supplement> supplements) {
        this.name = name;
        this.cost = cost;
        this.supplements = supplements;
        this.customers = new ArrayList<>();
    }

    /**
     * Takes some values and constructs a new Magazine with other default
     * values.
     *
     * @param name
     * @param cost
     */
    public Magazine(String name, double cost) {
        this.name = name;
        this.cost = cost;
        this.supplements = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    /**
     * Takes some values and constructs a new Magazine with other default
     * values.
     *
     * @param mag
     */
    public Magazine(String mag) {
        this.name = mag;
        this.cost = -1;
        this.supplements = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    /**
     * Default constructor initializes global variables to default values.
     */
    public Magazine() {
        this.name = "Defaut";
        this.cost = -1;
        this.supplements = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    /**
     * Returns a deep copy of aMagazine.
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public Magazine clone() throws CloneNotSupportedException {
        return (Magazine) super.clone();
    }

    /**
     * Returns this Magazines name.
     *
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns this Magazines customer subscriptions.
     *
     * @return
     */
    public ArrayList<Customer> getCustomerSubscriptions() {
        return this.customers;
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
     * Sets this Magazines name.
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets this Magazines customer subscriptions.
     *
     * @param customerSubscriptions
     */
    public void setCustomerSubscriptions(ArrayList<Customer> customerSubscriptions) {
        this.customers = customerSubscriptions;
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

    /**
     * Returns this Magazines Customer List as a drop down menu.
     *
     * @return
     */
    public ChoiceBox<String> getCustomerList() {
        ChoiceBox<String> choice = new ChoiceBox();
        for (int i = 0; i < this.customers.size(); i++) {
            choice.getItems().add(this.customers.get(i).getName());
        }
        return choice;
    }

    /**
     * Returns this Magazines Supplement List as a drop down menu.
     *
     * @return
     */
    public ChoiceBox<String> getSupplementList() {
        ChoiceBox<String> choice = new ChoiceBox();
        for (int i = 0; i < this.supplements.size(); i++) {
            choice.getItems().add(this.supplements.get(i).getName());
        }
        return choice;
    }

    /**
     * Returns an HBox containing elements to set this field.
     *
     * @return
     */
    private HBox getNameHBox() {
        MyHBox nameBox = new MyHBox();
        nameBox.setButtonName("Name");
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
        costBox.setButtonName("Magazine Cost");
        costBox.setLabelText(Double.toString(this.cost));
        if (this.cost == -1) {
            costBox.setLabelText("Default");
        }
        costBox.button.setOnAction(s -> {
            try {
                this.cost = Double.parseDouble(costBox.inputText.getText());
                costBox.outputLabel.setText(Double.toString(this.cost));
            } catch (Exception e) {
                System.out.println("Something Went Wrong...");
            }
        });
        costBox.formatBox();
        return costBox.getBox();
    }

    /**
     * Returns an HBox containing elements to set this field.
     * @param backEnd
     * @param choice
     * @return
     */
    private HBox addSupDropDown(BackEnd backEnd, ChoiceBox<String> choice) {
        MyHBox supplementsBox = new MyHBox(choice);
        supplementsBox.setButtonName("add");
        supplementsBox.setLabelText("Choose a supplement to add");
        supplementsBox.button.setOnAction(
                s -> {
                    try {
                        String selection = supplementsBox.choice.getValue();
                        this.supplements.add(backEnd.getSupplement(selection));
                        supplementsBox.outputLabel.setText("Supplement \"" + selection + "\" added");
                    } catch (Exception e) {
                        System.out.println("Something Went Wrong...");
                    }
                });
        supplementsBox.formatBox();
        return supplementsBox.getBox();
    }

    /**
     * Returns an HBox containing elements to set this field.
     * @param backEnd
     * @return
     */
    private HBox deleteSupDropDown(BackEnd backEnd) {
        MyHBox supplementsBox = new MyHBox(getSupplementList());
        supplementsBox.setButtonName("remove");
        supplementsBox.setLabelText("Choose a supplement to remove");
        supplementsBox.button.setOnAction(
                s -> {
                    try {
                        String selection = supplementsBox.choice.getValue();
                        this.supplements.remove(backEnd.getSupplement(selection));
                        supplementsBox.outputLabel.setText("Supplement \"" + selection + "\" removed");
                    } catch (Exception e) {
                        System.out.println("Something Went Wrong...");
                    }
                });
        supplementsBox.formatBox();
        return supplementsBox.getBox();
    }

    /**
     * Returns an HBox containing elements to set this field.
     * @param backEnd
     * @return
     */
    private HBox deleteCustDropDown(BackEnd backEnd) {
        MyHBox custBox = new MyHBox(getCustomerList());
        custBox.setButtonName("remove");
        custBox.setLabelText("Choose a customer to remove");
        custBox.button.setOnAction(
                s -> {
                    try {
                        String selection = custBox.choice.getValue();
                        this.customers.remove(backEnd.getCustomer(selection));
                        custBox.outputLabel.setText("Customer \"" + selection + "\" removed");
                    } catch (Exception e) {
                        System.out.println("Something Went Wrong...");
                    }
                });
        custBox.formatBox();
        return custBox.getBox();
    }

    /**
     * Returns an HBox containing elements to set this field.
     * @param backEnd
     * @param custDrop
     * @return
     */
    private HBox addCustDropDown(BackEnd backEnd, ChoiceBox<String> custDrop) {
        MyHBox custBox = new MyHBox(custDrop);
        custBox.setButtonName("add");
        custBox.setLabelText("Choose a customer to add");
        custBox.button.setOnAction(s -> {
            try {
                String selection = custBox.getChoice().getValue();
                this.customers.add(backEnd.getCustomer(selection));
                custBox.outputLabel.setText("Customer \"" + selection + "\" added");
            } catch (Exception e) {
                System.out.println("Something Went Wrong...");
            }
        });
        custBox.formatBox();
        return custBox.getBox();
    }

    /**
     * Returns an VBox containing all elements to set for this Magazine.
     * @param backEnd
     * @param supDrop
     * @param custDrop
     * @return
     */
    public VBox getVBox(BackEnd backEnd, ChoiceBox<String> supDrop, ChoiceBox<String> custDrop) {
        return new VBox(
                this.getNameHBox(),
                this.getCostHBox(),
                addSupDropDown(backEnd, supDrop),
                deleteSupDropDown(backEnd),
                addCustDropDown(backEnd, custDrop),
                deleteCustDropDown(backEnd)
        );
    }

    /**
     * Returns a tree view of this magazines information.
     * @return
     */
    public VBox getDetails() {
        Label magazine = new Label("Magazine");
        VBox test = new VBox(magazine);
        magazine.setPadding(new Insets(10));
        magazine.setFont(new Font("Arial", 20));
        TreeItem<String> supplementInformation = new TreeItem("Magazine");
        supplementInformation.getChildren().add(new TreeItem("Name: " + this.name));
        supplementInformation.getChildren().add(new TreeItem("Cost: $" + String.format("%.2f", this.cost)));
        TreeItem<String> supList = new TreeItem("Magazine Supplements");
        this.supplements.forEach((n) -> supList.getChildren().add(new TreeItem("" + n.getName())));
        supplementInformation.getChildren().add(supList);
        TreeItem<String> custList = new TreeItem("Magazine Customers");
        for (int i = 0; i < this.customers.size(); i++) {
            custList.getChildren().add(new TreeItem("" + this.customers.get(i).getName()));
        }
        supplementInformation.getChildren().add(custList);
        TreeView details = new TreeView();
        details.setRoot(supplementInformation);
        details.setShowRoot(false);
        details.setPadding(new Insets(10));
        test.getChildren().add(details);
        return test;
    }
}
