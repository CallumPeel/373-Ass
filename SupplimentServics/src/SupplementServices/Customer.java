package SupplementServices;

import java.io.Serializable;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

/**
 * Contains customer attributes.
 *
 * @author Callum Peel
 */
public class Customer implements Cloneable, Serializable {

    public String payer;
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
        this.address = new Address();
        this.payer = "default";
        this.supplementSubscription = new ArrayList<Supplement>();
        this.supplementSubscription = supplementSubscription;
        setTotal();
    }

    public Customer(String name, String email, Address address, ArrayList<Supplement> supplementSubscription) {
        this.name = name;
        this.email = email;
        this.total = total;
        this.address = address;
        this.payer = "default";
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
        this.address = new Address();
        this.payer = "default";
        this.supplementSubscription = new ArrayList<Supplement>();
        setTotal();
    }

    public Customer(String name) {
        this.name = name;
        this.email = "Default";
        this.payer = "default";
        this.address = new Address();
        this.supplementSubscription = new ArrayList<Supplement>();
        setTotal();
    }

    public Customer() {
        this.name = "Default";
        this.email = "Default";
        this.payer = "default";
        this.address = new Address();
        this.supplementSubscription = new ArrayList<Supplement>();
        setTotal();
    }

    @Override
    public Customer clone() throws CloneNotSupportedException {
        return (Customer) super.clone();
    }

    public void setPayer(Customer payer) {
        this.payer = payer.name;
    }

    private void setTotal() {
        this.total = 0.0;
        for (int i = 0; i < this.supplementSubscription.size(); i++) {
            this.total += this.supplementSubscription.get(i).getCost();
        }
    }

    public String getTotal() {
        return "$" + String.format("%.2f", this.total);
    }

    public HBox getNameHBox() {
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

    public HBox getPayerHBox() {
        MyHBox payerBox = new MyHBox();
        payerBox.setButtonName("Set Payer Name");
        payerBox.setLabelText(this.payer);
        payerBox.button.setOnAction(
                s -> {
                    try {
                        this.payer = payerBox.inputText.getText();
                        payerBox.outputLabel.setText(this.payer);
                        System.out.println("Payer changed");

                    } catch (Exception e) {
                        System.out.println("Something Went Wrong...");
                    }
                });
        payerBox.formatBox();
        return payerBox.getBox();
    }

    public HBox getEmailHBox() {
        MyHBox emailBox = new MyHBox();
        emailBox.setButtonName("Set Email");
        emailBox.setLabelText(this.email);
        emailBox.button.setOnAction(
                s -> {
                    try {
                        this.email = emailBox.inputText.getText();
                        emailBox.outputLabel.setText(this.email);
                        System.out.println("Email changed");
                    } catch (Exception e) {
                        System.out.println("Something Went Wrong...");
                    }
                });
        emailBox.formatBox();
        return emailBox.getBox();
    }

    public HBox getAddressHBox() {
        MyHBox addressNumberBox = new MyHBox();
        addressNumberBox.setButtonName("Set Address Number");
        addressNumberBox.setLabelText(Integer.toString(this.address.streetNumber));
        addressNumberBox.button.setOnAction(
                s -> {
                    try {
                        this.address.streetNumber = parseInt(addressNumberBox.inputText.getText());
                        addressNumberBox.outputLabel.setText(Integer.toString(this.address.streetNumber));
                        System.out.println("Address Number changed");
                    } catch (Exception e) {
                        System.out.println("Something Went Wrong...");
                    }
                });
        addressNumberBox.formatBox();
        return addressNumberBox.getBox();
    }

    public HBox getPostCodeHBox() {
        MyHBox postCodeBox = new MyHBox();
        postCodeBox.setButtonName("Set Post Code");
        postCodeBox.setLabelText(Integer.toString(this.address.postCode));
        postCodeBox.button.setOnAction(
                s -> {
                    try {
                        this.address.postCode = parseInt(postCodeBox.inputText.getText());
                        postCodeBox.outputLabel.setText(Integer.toString(this.address.postCode));
                        System.out.println("Post Code changed");
                    } catch (Exception e) {
                        System.out.println("Something Went Wrong...");
                    }
                });
        postCodeBox.formatBox();
        return postCodeBox.getBox();
    }

    public HBox streetNameHBox() {
        MyHBox streetNameBox = new MyHBox();
        streetNameBox.setButtonName("Set Street Name");
        streetNameBox.setLabelText(this.address.streetName);
        streetNameBox.button.setOnAction(
                s -> {
                    try {
                        this.address.streetName = streetNameBox.inputText.getText();
                        streetNameBox.outputLabel.setText(this.address.streetName);
                        System.out.println("Street Name changed");
                    } catch (Exception e) {
                        System.out.println("Something Went Wrong...");
                    }
                });
        streetNameBox.formatBox();
        return streetNameBox.getBox();
    }

    public HBox suburbBoxHBox() {
        MyHBox suburbBox = new MyHBox();
        suburbBox.setButtonName("Set Suburb Name");
        suburbBox.setLabelText(this.address.suburb);
        suburbBox.button.setOnAction(
                s -> {
                    try {
                        this.address.suburb = suburbBox.inputText.getText();
                        suburbBox.outputLabel.setText(this.address.suburb);
                        System.out.println("Suburb Name changed");
                    } catch (Exception e) {
                        System.out.println("Something Went Wrong...");
                    }
                });
        suburbBox.formatBox();
        return suburbBox.getBox();
    }

    public HBox dropDown(ChoiceBox<String> choice) {
        MyHBox payerBox = new MyHBox(choice);
        payerBox.setButtonName("Set Paying Customer");
        payerBox.setLabelText(this.payer);
        payerBox.button.setOnAction(
                s -> {
                    try {
                        this.payer = payerBox.choice.getValue();
                        payerBox.outputLabel.setText(this.payer);
                        System.out.println("Payer changed");
                    } catch (Exception e) {
                        System.out.println("Something Went Wrong...");
                    }
                });
        payerBox.formatBox();
        return payerBox.getBox();
    }

    public MyVBox getVBox(ChoiceBox<String> choice) {
        return new MyVBox(
                getNameHBox(),
                getPayerHBox(),
                getEmailHBox(),
                getAddressHBox(),
                getPostCodeHBox(),
                streetNameHBox(),
                suburbBoxHBox(),
                dropDown(choice)
        );
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
            TreeItem<String> custSupplements = new TreeItem(this.supplementSubscription.get(i).getName());
            custSupplements.getChildren().add(new TreeItem("$" + String.format("%.2f", this.supplementSubscription.get(i).getCost())));
            supplementList.getChildren().add(custSupplements);
        }
        return supplementList;
    }
    
    public TreeItem<String> getCustomerDetails() {
        TreeItem<String> customerInformation = new TreeItem("Customer");
        customerInformation.getChildren().add(new TreeItem("Name: " + this.name));
        customerInformation.getChildren().add(new TreeItem("Payer Name: " + this.payer));
        customerInformation.getChildren().add(new TreeItem("Email: " + this.email));
        customerInformation.getChildren().add(new TreeItem("Total Cost: " + getTotal()));
        customerInformation.getChildren().add(this.address.getAddressTreeView());
        customerInformation.getChildren().add(getCustSupplementBreakdown());
        return customerInformation;
    }

    public MyVBox getDetails() {

        Label customer = new Label("Customer");
        MyVBox test = new MyVBox(customer);
        customer.setPadding(new Insets(15));
        customer.setFont(new Font("Arial", 20));

        TreeView details = new TreeView();
        details.setRoot(getCustomerDetails());
        details.setShowRoot(false);
        details.setPadding(new Insets(15));
        test.getChildren().add(details);
        return test;
    }

// add customer things to tree
}
