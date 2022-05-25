package SupplementServices;

import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
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
    protected ArrayList<Magazine> mags;
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
        this.mags = new ArrayList<Magazine>();

        this.viewPane = new BorderPane();
        this.createPane = new BorderPane();
        this.editPane = new BorderPane();
        this.stage = window;
    }

    protected Customer getCustByName(String name) {
        Customer result = null;
        for (Customer c : this.customers) {
            if (name.equalsIgnoreCase(c.getName())) {
                result = c;
                break;
            }
        }
        return result;
    }

    private Magazine getMagazine(String name) {
        if (getMagazineIndex(name) >= 0) {
            return mags.get(getMagazineIndex(name));
        }
        return null;
    }

    protected String getCustName(int index) {
        return customers.get(index).name;
    }

    protected int getNumCust() {
        return customers.size();
    }

    protected int getNumSups() {
        return supplements.size();
    }

    protected String getSupName(int index) {
        return supplements.get(index).name;
    }

    protected Supplement getSupName(String name) {
        Supplement result = null;
        for (Supplement c : this.supplements) {
            if (name.equalsIgnoreCase(c.getName())) {
                result = c;
                break;
            }
        }
        return result;
    }

    public ChoiceBox<String> getPayingCustomerList() {
        ChoiceBox<String> choice = new ChoiceBox();
        CustomerPaying x = new CustomerPaying();
        for (int i = 0; i < this.customers.size(); i++) {
            if (this.customers.get(i).getClass() == x.getClass()) {
                choice.getItems().add(this.customers.get(i).name);
            }
        }
        return choice;
    }

    /**
     * Takes a String name as a parameter and removes that customer from the
     * list of customers.
     *
     * @param name
     */
    public void removeCustomer(String name) {
        if (getCustByName(name) != null) {
            System.out.println("Customer Removed.\n");
            customers.remove(getCustomerIndex(name));
        } else {
            System.out.println("Customer not found.\n");
        }
    }

    public void removeMagazine(String name) {
        if (getMagazine(name) != null) {
            System.out.println("Magazine Removed.\n");
            mags.remove(getMagazineIndex(name));
        } else {
            System.out.println("Magazine not found.\n");
        }
    }

    /**
     * Takes a customer as a parameter and removes it from the customer list.
     *
     * @param customer
     */
    public void removeCustomer(Customer customer) {
        this.customers.remove(customer);
    }

    public void removeMagazine(Magazine mag) {
        this.mags.remove(mag);
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

    private int getMagazineIndex(String name) {
        int counter = 0;
        int index = -1;
        for (Magazine c : this.mags) {
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

    public void addMagazine(Magazine mag) {
        this.mags.add(mag);
    }

    public void addCustomer(String customer) {
        this.customers.add(new Customer(customer));
    }

    public void addMagazine(String mag) {
        this.mags.add(new Magazine(mag));
    }

    /**
     * Takes a customer and some payment details as parameters, constructs a
     * paying customer and adds it to the list.
     *
     * @param customer
     * @param paymentMethod
     * @param associatedCustomers
     */
    public void addCustomer(Customer customer, PaymentMethod paymentMethod, ArrayList<Customer> associatedCustomers) {
        this.customers.add(new CustomerPaying(customer, paymentMethod, associatedCustomers));
    }

    /**
     * Takes a supplement as a parameter and adds it to the list of supplements.
     *
     * @param supplement
     */
    public void addSupplement(Supplement supplement) {
        this.supplements.add(supplement);
    }

    public void addSupplement(String supplement) {
        this.supplements.add(new Supplement(supplement));
    }

}
