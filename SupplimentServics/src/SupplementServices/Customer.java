package SupplementServices;

import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

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
        return (Customer)super.clone();
    }
    
    public Customer getClone() throws CloneNotSupportedException {
        return (Customer)this.clone();
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

    public Button getNameButton(TextField text) {
        Button nameButton = new Button();
        nameButton.setText("Set Name");
        nameButton.setOnAction(
                s -> {
                    try {
                        this.name = text.getText();
                        System.out.println("name changed");
                    } catch (Exception e) {
                        System.out.println("Something Went Wrong...");
                    }
                }
        );
        return nameButton;
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
