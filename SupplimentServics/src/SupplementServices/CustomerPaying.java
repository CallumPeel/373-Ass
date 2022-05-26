package SupplementServices;

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
 * Contains a customer with payment information. Extends the customer class
 *
 * @author Callum Peel
 */
public class CustomerPaying extends Customer {

    PaymentMethod paymentMethod;
    ArrayList<Customer> associatedCustomers;

    /**
     * Constructs a paying customer. Takes customer information and a payment
     * method.
     *
     * @param name
     * @param email
     * @param paymentMethod
     * @param supplementSubscription
     */
    public CustomerPaying(
            String name,
            String email,
            PaymentMethod paymentMethod,
            ArrayList<Supplement> supplementSubscription
    ) {
        super(name, email, supplementSubscription);
        this.paymentMethod = paymentMethod;
        this.associatedCustomers = new ArrayList<Customer>();
    }

    public CustomerPaying() {
        super();
        this.paymentMethod = new PaymentMethod("Default", new Card("Default", "Default", "Default", -1));
        this.associatedCustomers = new ArrayList<Customer>();

    }

    /**
     * Constructs a paying customer.
     *
     * @param customer
     * @param paymentMethod
     * @param associatedCustomers
     */
    public CustomerPaying(Customer customer,
            PaymentMethod paymentMethod,
            ArrayList<Customer> associatedCustomers) {
        super(customer.name, customer.email, customer.getSupplementSubscription());
        this.paymentMethod = paymentMethod;
        this.associatedCustomers = new ArrayList<Customer>();
        this.associatedCustomers = associatedCustomers;
    }

    /**
     * Constructs a paying customer.
     *
     * @param name
     * @param email
     * @param supplementSubscription
     * @param paymentMethod
     * @param associatedCustomers
     */
    public CustomerPaying(
            String name,
            String email,
            ArrayList<Supplement> supplementSubscription,
            PaymentMethod paymentMethod,
            ArrayList<Customer> associatedCustomers) {
        super(name, email, supplementSubscription);
        this.associatedCustomers = new ArrayList<Customer>();
        this.paymentMethod = paymentMethod;
        this.associatedCustomers = associatedCustomers;
    }

    /**
     * Takes a payment method and initializes it's corresponding global
     * variable.
     *
     * @param paymentMethod
     */
    public void setPaymentMethods(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /**
     * Returns a payment method.
     *
     * @return
     */
    public PaymentMethod getPaymentMethods() {
        return this.paymentMethod;
    }

    /**
     * Takes a customer and adds it to the list of associated customers.
     *
     * @param customer
     */
    public void addCustomer(Customer customer) {
        this.associatedCustomers.add(customer);
    }

    public double getAssociatedCustomerTotal() {
        double total = 0;
        for (int i = 0; i < this.associatedCustomers.size(); i++) {
            total += this.associatedCustomers.get(i).total;
        }
        return total;
    }

    /**
     * Builds and returns a string that contains the monthly e-mails.
     *
     * @return
     */
    public String getMonthlyEmail() {
        double multiplier = 52 / 12;
        ArrayList<Supplement> mySubscription = getSupplementSubscription();
        String monthlyEmail = "";
        int counter = 1;
        double total = 0;
        if (mySubscription.size() > 0) {
            monthlyEmail = this.name + ", your personal subscription totals are as follows:\n";
            for (Supplement supplement : mySubscription) {
                monthlyEmail += counter + ". " + supplement.getName() + " - $" + (supplement.getCost() * multiplier)
                        + ".\n";
                total += supplement.getCost();
                counter++;
            }
        } else {
            monthlyEmail += this.name + ", You have no personal Supplements.\n";
        }

        counter = 1;
        monthlyEmail += "\n\nYour associated customer's supplement totals are as follows:";
        for (Customer associatedCustomer : associatedCustomers) {
            monthlyEmail += "\n" + associatedCustomer.name + "'s supplements are:\n";
            for (Supplement supplement : associatedCustomer.getSupplementSubscription()) {
                monthlyEmail += counter + ". " + supplement.getName() + " - $" + (supplement.getCost() * multiplier)
                        + ".\n";
                total += supplement.getCost();
                counter++;
            }
        }
        monthlyEmail += "\nThe total charged to your account is: $" + total * multiplier + ".\n\n\n";
        return monthlyEmail;
    }

//    public String getTotal() {
//        return "$" + String.format("%.2f", this.total);
//    }
    @Override
    public String getTotal() {
        return "$" + String.format("%.2f", this.total + getAssociatedCustomerTotal());
    }

    @Override
    public MyVBox getCustomerLabelVBox() {
        Label customerLabel = new Label("Paying Customer");
        customerLabel.setPadding(new Insets(10));
        customerLabel.setFont(new Font("Arial", 20));
        MyVBox test = new MyVBox(customerLabel);
        return test;
    }

    @Override
    public MyVBox getDetails() {

        MyVBox test = new MyVBox(getCustomerLabelVBox());

        TreeItem<String> subList = new TreeItem("Associated Customers");
        subList.getChildren().add(
                new TreeItem("Total: " + "$" + String.format("%.2f", this.getAssociatedCustomerTotal()))
        );
        for (int i = 0; i < this.associatedCustomers.size(); i++) {
            subList.getChildren().add(this.associatedCustomers.get(i).getCustSupplementBreakdown());
        }
        TreeItem<String> customerInformation = getCustomerDetails();
        customerInformation.getChildren().add(subList);

        TreeView details = new TreeView();
        details.setRoot(customerInformation);
        details.setShowRoot(false);
        details.setPadding(new Insets(10));
        test.getChildren().add(details);
        return test;
    }

    public HBox getBankNameHBox() {
        MyHBox bankNameBox = new MyHBox();
        bankNameBox.setButtonName("Set Bank Name");
        bankNameBox.setLabelText(this.paymentMethod.bankName);
        bankNameBox.button.setOnAction(
                s -> {
                    try {
                        this.paymentMethod.bankName = bankNameBox.inputText.getText();
                        bankNameBox.outputLabel.setText(this.paymentMethod.bankName);
                        System.out.println("Bank Name changed");

                    } catch (Exception e) {
                        System.out.println("Something Went Wrong...");
                    }
                });
        bankNameBox.formatBox();
        return bankNameBox.getBox();
    }

    public HBox getCardNameHBox() {
        MyHBox bankNameBox = new MyHBox();
        bankNameBox.setButtonName("Set Card Name");
        bankNameBox.setLabelText(this.paymentMethod.card.name);
        bankNameBox.button.setOnAction(
                s -> {
                    try {
                        this.paymentMethod.card.name = bankNameBox.inputText.getText();
                        bankNameBox.outputLabel.setText(this.paymentMethod.card.name);
                        System.out.println("Card Name changed");

                    } catch (Exception e) {
                        System.out.println("Something Went Wrong...");
                    }
                });
        bankNameBox.formatBox();
        return bankNameBox.getBox();
    }

    public HBox getCardNumberHBox() {
        MyHBox bankNameBox = new MyHBox();
        bankNameBox.setButtonName("Set Card Number");
        bankNameBox.setLabelText(this.paymentMethod.card.cardNumber);
        bankNameBox.button.setOnAction(
                s -> {
                    try {
                        this.paymentMethod.card.cardNumber = bankNameBox.inputText.getText();
                        bankNameBox.outputLabel.setText(this.paymentMethod.card.cardNumber);
                        System.out.println("Card Number changed");

                    } catch (Exception e) {
                        System.out.println("Something Went Wrong...");
                    }
                });
        bankNameBox.formatBox();
        return bankNameBox.getBox();
    }

    public HBox getCardExpHBox() {
        MyHBox bankNameBox = new MyHBox();
        bankNameBox.setButtonName("Set Card Expiry");
        bankNameBox.setLabelText(this.paymentMethod.card.exp);
        bankNameBox.button.setOnAction(
                s -> {
                    try {
                        this.paymentMethod.card.exp = bankNameBox.inputText.getText();
                        bankNameBox.outputLabel.setText(this.paymentMethod.card.exp);
                        System.out.println("Card Expiry changed");

                    } catch (Exception e) {
                        System.out.println("Something Went Wrong...");
                    }
                });
        bankNameBox.formatBox();
        return bankNameBox.getBox();
    }

    public HBox getCardCVVHBox() {
        MyHBox cvvBox = new MyHBox();
        cvvBox.setButtonName("Set Card CVV");
        cvvBox.setLabelText(Integer.toString(this.paymentMethod.card.cvv));
        if (this.paymentMethod.card.cvv == -1) {
            cvvBox.setLabelText("Default");
        }
        cvvBox.button.setOnAction(
                s -> {
                    try {
                        this.paymentMethod.card.cvv = parseInt(cvvBox.inputText.getText());
                        cvvBox.outputLabel.setText(Integer.toString(this.paymentMethod.card.cvv));
                        System.out.println("Card CVV changed");
                    } catch (Exception e) {
                        System.out.println("Something Went Wrong...");
                    }
                });
        cvvBox.formatBox();
        return cvvBox.getBox();
    }

    public HBox getAccountNameHBox() {
        MyHBox accNameBox = new MyHBox();
        accNameBox.setButtonName("Set Account Name");
        accNameBox.setLabelText(this.paymentMethod.account.name);
        accNameBox.button.setOnAction(
                s -> {
                    try {
                        this.paymentMethod.account.name = accNameBox.inputText.getText();
                        accNameBox.outputLabel.setText(this.paymentMethod.account.name);
                        System.out.println("Account Name changed");

                    } catch (Exception e) {
                        System.out.println("Something Went Wrong...");
                    }
                });
        accNameBox.formatBox();
        return accNameBox.getBox();
    }

    public HBox getAccountNumHBox() {
        MyHBox accNameBox = new MyHBox();
        accNameBox.setButtonName("Set Account Num");
        accNameBox.setLabelText(this.paymentMethod.account.accNum);
        accNameBox.button.setOnAction(
                s -> {
                    try {
                        this.paymentMethod.account.accNum = accNameBox.inputText.getText();
                        accNameBox.outputLabel.setText(this.paymentMethod.account.accNum);
                        System.out.println("Account Num changed");

                    } catch (Exception e) {
                        System.out.println("Something Went Wrong...");
                    }
                });
        accNameBox.formatBox();
        return accNameBox.getBox();
    }

    public HBox getAccountBSBHBox() {
        MyHBox accNameBox = new MyHBox();
        accNameBox.setButtonName("Set Account BSB");
        accNameBox.setLabelText(this.paymentMethod.account.BSB);
        accNameBox.button.setOnAction(
                s -> {
                    try {
                        this.paymentMethod.account.BSB = accNameBox.inputText.getText();
                        accNameBox.outputLabel.setText(this.paymentMethod.account.BSB);
                        System.out.println("Account BSB changed");

                    } catch (Exception e) {
                        System.out.println("Something Went Wrong...");
                    }
                });
        accNameBox.formatBox();
        return accNameBox.getBox();
    }

    @Override
    public MyVBox getVBox(ChoiceBox<String> choice) {
        return new MyVBox(
                getCustomerLabelVBox(),
                getNameHBox(),
                getEmailHBox(),
                getAddressHBox(),
                getPostCodeHBox(),
                streetNameHBox(),
                suburbBoxHBox(),
                dropDown(choice),
                getBankNameHBox(),
                getCardNameHBox(),
                getCardNumberHBox(),
                getCardExpHBox(),
                getCardCVVHBox(),
                getAccountNameHBox(),
                getAccountNumHBox(),
                getAccountBSBHBox()
        );
    }

    @Override
    public void setAssociatedCustomerListToNull() {
        this.associatedCustomers = new ArrayList<Customer>();
    }

    public void addAssociatedCustomer(Customer associateCustomer) {
        this.associatedCustomers.add(associateCustomer);
    }
}
