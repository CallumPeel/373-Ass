package SupplementServices;

import java.util.ArrayList;

/**
 * Stores arrays of customers and supplements.
 * @author Callum Peel
 */
public class BackEnd {

	ArrayList<Customer> customers;
	ArrayList<Supplement> supplements;

    /**
     * Constructs and initializes a Back End.
     */
    public BackEnd() {
		this.customers = new ArrayList<Customer>();
		this.supplements = new ArrayList<Supplement>();
	}

	private Customer getCustomer(String name) {
		if (getCustomerIndex(name) >= 0) {
			return customers.get(getCustomerIndex(name));
		}
		return null;
	}

    /**
     * Takes a String name as a parameter and removes that customer from the list of customers.
     * @param name
     */
    public void removeCustomer(String name) {
		if (getCustomer(name) != null) {
			System.out.println("Customer Removed.\n");
			customers.remove(getCustomerIndex(name));
		}
		else {
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
     * @param customer
     */
    public void addCustomer(Customer customer) {
		this.customers.add(customer);
	}

    /**
     * Takes a customer and some payment details as parameters,
     * constructs a paying customer and adds it to the list.
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
     *Takes a customer as a parameter and removes it from the customer list.
     * @param customer
     */
    public void removeCustomer(Customer customer) {
		this.customers.remove(customer);
	}

    /**
     * Takes a supplement as a parameter and adds it to the list of supplements.
     * @param supplement
     */
    public void addSupplement(Supplement supplement) {
		this.supplements.add(supplement);
	}

    /**
     * Takes a supplement as a parameter and removes it from the list of supplements.
     * @param supplement
     */
    public void removeSupplement(Supplement supplement) {
		this.supplements.remove(supplement);
	}

}
