package SupplementServices;

import java.util.ArrayList;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

/**
 * Contains a customer with payment information. Extends the customer class
 *
 * @author Callum Peel
 */
public class PayingCustomer extends Customer {

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
    public PayingCustomer(
            String name,
            String email,
            PaymentMethod paymentMethod,
            ArrayList<Supplement> supplementSubscription) {
        super(name, email, supplementSubscription);
        this.paymentMethod = paymentMethod;
        this.associatedCustomers = new ArrayList<Customer>();
    }

    /**
     * Constructs a paying customer.
     *
     * @param customer
     * @param paymentMethod
     * @param associatedCustomers
     */
    public PayingCustomer(Customer customer,
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
    public PayingCustomer(
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

    @Override
    protected TreeItem<String> getCustSupplementBreakdown() {
        TreeItem<String> supplementList = new TreeItem("Supplements");
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
            customerInformation.getChildren().add(new TreeItem(this.name));
            customerInformation.getChildren().add(new TreeItem(this.email));
            customerInformation.getChildren().add(getCustSupplementBreakdown());

        TreeItem<String> subList = new TreeItem("Associated Customers");
            for (int i = 0; i < this.associatedCustomers.size(); i++) {
                subList.getChildren().add(this.associatedCustomers.get(i).getCustSupplementBreakdown());
            }
            customerInformation.getChildren().add(subList);
            
        TreeView details = new TreeView();
        details.setRoot(customerInformation);
        details.setShowRoot(false);
        return details;
    }
}
