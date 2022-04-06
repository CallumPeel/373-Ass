package SupplimentServices;

import java.util.ArrayList;

public class BackEnd {

	ArrayList<Customer> customers;
	ArrayList<Supplement> supplements;

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

	public void addCustomer(Customer customer) {
		this.customers.add(customer);
	}

	public void addCustomer(
			Customer customer,
			PaymentMethod paymentMethod,
			ArrayList<Customer> associatedCustomers) {
		this.customers.add(new PayingCustomer(customer, paymentMethod, associatedCustomers));
	}

	public void removeCustomer(Customer customer) {
		this.customers.remove(customer);
	}

	public void addSupplement(Supplement supplement) {
		this.supplements.add(supplement);
	}

	public void removeSupplement(Supplement supplement) {
		this.supplements.remove(supplement);
	}

}
