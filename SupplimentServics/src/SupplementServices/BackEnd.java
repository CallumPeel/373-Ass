package SupplementServices;

import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Stores arrays of customers and supplements.
 *
 * @author Callum Peel
 */
public class BackEnd {

    protected ArrayList<Customer> customers;
    protected ArrayList<Supplement> supplements;
    protected Stage stage;
    protected Scene vScene, cScene, eScene;
    protected BorderPane viewPane, createPane, editPane;
    protected FlowPane topPane;
    protected VBox viewLeftPane, viewCenterPane, viewRightPane;

    /**
     * Constructs and initializes a Back End.
     */
    public BackEnd(Stage window) {
        this.customers = new ArrayList<Customer>();
        this.supplements = new ArrayList<Supplement>();

        this.viewPane = new BorderPane();
        this.createPane = new BorderPane();
        this.editPane = new BorderPane();
        this.stage = window;
    }

    private Customer getCustomer(String name) {
        if (getCustomerIndex(name) >= 0) {
            return customers.get(getCustomerIndex(name));
        }
        return null;
    }

    /**
     * Takes a String name as a parameter and removes that customer from the
     * list of customers.
     *
     * @param name
     */
    public void removeCustomer(String name) {
        if (getCustomer(name) != null) {
            System.out.println("Customer Removed.\n");
            customers.remove(getCustomerIndex(name));
        } else {
            System.out.println("Customer not found.\n");
        }
    }

    private int getCustomerIndex(String name) {
        int counter = 0;
        int index = -1;
        for (Customer c : this.customers) {
            if (c.getName().equalsIgnoreCase(name)) {
                index = counter;
            }
            counter++;
        }
        return index;
    }

    /**
     * Takes a customer and adds it to the list of customers.
     *
     * @param customer
     */
    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    public void addCustomer(String customer) {
        this.customers.add(new Customer(customer));
    }

    /**
     * Takes a customer and some payment details as parameters, constructs a
     * paying customer and adds it to the list.
     *
     * @param customer
     * @param paymentMethod
     * @param associatedCustomers
     */
    public void addCustomer(
            Customer customer,
            PaymentMethod paymentMethod,
            ArrayList<Customer> associatedCustomers) {
        this.customers.add(new PayingCustomer(customer, paymentMethod, associatedCustomers));
    }

    /**
     * Takes a customer as a parameter and removes it from the customer list.
     *
     * @param customer
     */
    public void removeCustomer(Customer customer) {
        this.customers.remove(customer);
    }

    /**
     * Takes a supplement as a parameter and adds it to the list of supplements.
     *
     * @param supplement
     */
    public void addSupplement(Supplement supplement) {
        this.supplements.add(supplement);
    }

    /**
     * Takes a supplement as a parameter and removes it from the list of
     * supplements.
     *
     * @param supplement
     */
    public void removeSupplement(Supplement supplement) {
        this.supplements.remove(supplement);
    }

    protected int getNumCust() {
        return customers.size();
    }

    protected String getCustName(int index) {
        return customers.get(index).name;
    }

    protected Customer getCustName(String name) {
        Customer result = null;
        for (Customer c : this.customers) {
            if (name.equalsIgnoreCase(c.getName())) {
                result = c;
                break;
            }
        }
        return result;
    }

    protected int getNumSups() {
        return supplements.size();
    }

    protected String getSupName(int index) {
        return supplements.get(index).getName();
    }
}
