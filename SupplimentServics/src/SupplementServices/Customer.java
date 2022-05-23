package SupplementServices;

import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.HBox;

/**
 * Contains customer attributes.
 *
 * @author Callum Peel
 */
public class Customer implements Cloneable {

//    public String payer;
    protected String name;
    protected String email;
    protected Double total;
    protected Address address;
    protected ArrayList<Supplement> supplementSubscription;

    /**
     * Takes customer attributes, constructs and initializes the the global
     * variables.
     *
     * @param name
     * @param email
     * @param supplementSubscription
     */
    public Customer(String name, String email, ArrayList<Supplement> supplementSubscription) {
        this.name = name;
        this.email = email;
        this.supplementSubscription = new ArrayList<Supplement>();
        this.supplementSubscription = supplementSubscription;
        setTotal();
    }

    /**
     * Takes customer attributes, constructs and initializes the global
     * variables. Creates an empty supplementSubscription.
     *
     * @param name
     * @param email
     */
    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
        this.supplementSubscription = new ArrayList<Supplement>();
        setTotal();
    }

    public Customer(String name) {
        this.name = name;
        this.email = "";
        this.supplementSubscription = new ArrayList<Supplement>();
        setTotal();
    }

    public Customer() {
        this.name = "Default";
        this.email = "";
        this.supplementSubscription = new ArrayList<Supplement>();
        setTotal();
    }

    @Override
    public Customer clone() throws CloneNotSupportedException {
        return (Customer) super.clone();
    }

    public Customer getClone() throws CloneNotSupportedException {
        return (Customer) this.clone();
    }

    private void setTotal() {
        this.total = 0.0;
        for (int i = 0; i < this.supplementSubscription.size(); i++) {
            this.total += this.supplementSubscription.get(i).getCost();
        }
    }

    public double getTotal() {
        return this.total;
    }

    public HBox getCustHBox(String buttonName) {
        TextField inputTextBox = new TextField();
        inputTextBox.setMinWidth(120);
        inputTextBox.setMaxWidth(120);
        Label outputLabel = new Label("No value");
        switch (buttonName.toUpperCase()) {
            case "NAME":
                outputLabel.setText(this.name);
                break;
            case "EMAIL":
                outputLabel.setText(this.email);
                break;
        }
        Button setButton = new Button();
        setButton.setText("Set " + buttonName);
        setButton.setOnAction(
                s -> {
                    try {
                        switch (buttonName.toUpperCase()) {
                            case "NAME":
                                this.name = inputTextBox.getText();
                                outputLabel.setText(this.name);
                                System.out.println("Name changed");
                                break;
                            case "EMAIL":
                                this.email = inputTextBox.getText();
                                outputLabel.setText(this.email);
                                System.out.println("Email changed");
                                break;
                        }
                    } catch (Exception e) {
                        System.out.println("Something Went Wrong...");
                    }
                }
        );
        setButton.setMinWidth(100);
        setButton.setMaxWidth(100);
        HBox newBox = new HBox(inputTextBox, setButton, outputLabel);
        newBox.setAlignment(Pos.BASELINE_LEFT);
        newBox.setSpacing(20);
        newBox.setPadding(new Insets(5,30,5,30));
        newBox.setMinWidth(400);
//        newBox.setMaxWidth(400);
        return newBox;
    }

    /**
     * Takes a string name and initializes the global variable with it.
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Takes a string email and initializes the global variable with it.
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Takes an list of supplements and the global variable with it.
     *
     * @param supplementSubscription
     */
    public void setSupplementSubscription(ArrayList<Supplement> supplementSubscription) {
        this.supplementSubscription = supplementSubscription;
    }

    /**
     * Returns the String name.
     *
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the String email.
     *
     * @return
     */
    public String getEmailAddress() {
        return this.email;
    }

    /**
     * Returns a list of supplements.
     *
     * @return
     */
    public ArrayList<Supplement> getSupplementSubscription() {
        return this.supplementSubscription;
    }

    /**
     * Builds a "weekly email" String and returns it.
     *
     * @return
     */
    public String getWeeklyEmail() {
        String supplementString = this.name + " your magazine is ready to look at.\n";

        if (this.supplementSubscription.size() > 0) {
            supplementString += "Your supplements are:\n";
            int counter = 1;
            for (Supplement supplement : supplementSubscription) {
                supplementString += counter
                        + ". "
                        + supplement.getName()
                        + ".\n";
                counter++;
            }
        } else {
            supplementString += "You have no personal supplements.";
        }

        return supplementString;
    }

    /**
     * Returns an empty string.
     *
     * @return
     */
    public String getMonthlyEmail() {
        return "";
    }

    protected TreeItem<String> getCustSupplementBreakdown() {
        TreeItem<String> supplementList = new TreeItem(this.name + "'s Supplement Breakdown");

        supplementList.getChildren().add(new TreeItem("Total: " + "$" + String.format("%.2f", this.total)));
        for (int i = 0; i < this.supplementSubscription.size(); i++) {
            // Branch "Supplement Name"
            TreeItem<String> custSupplements = new TreeItem(this.supplementSubscription.get(i).getName());
            custSupplements.getChildren().add(new TreeItem("$" + String.format("%.2f", this.supplementSubscription.get(i).getCost())));
            supplementList.getChildren().add(custSupplements);
        }
        return supplementList;
    }

    public TreeView<String> getDetails() {
        TreeItem<String> customerInformation = new TreeItem("Customer");
        customerInformation.getChildren().add(new TreeItem("Name: " + this.name));
        customerInformation.getChildren().add(new TreeItem("Email: " + this.email));
        customerInformation.getChildren().add(getCustSupplementBreakdown());

        TreeView details = new TreeView();
        details.setRoot(customerInformation);
        details.setShowRoot(false);
        return details;
    }
}
