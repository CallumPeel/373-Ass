package SupplimentServices;

import java.util.ArrayList;

public class PayingCustomer extends Customer {

    PaymentMethod paymentMethod;
    ArrayList<Customer> associatedCustomers;

    public PayingCustomer(
            String name,
            String email,
            PaymentMethod paymentMethod,
            ArrayList<Supplement> supplementSubscription) {
        super(name, email, supplementSubscription);
        this.paymentMethod = paymentMethod;
        this.associatedCustomers = new ArrayList<Customer>();
    }

    public PayingCustomer(Customer customer,
            PaymentMethod paymentMethod,
            ArrayList<Customer> associatedCustomers) {
        super(customer.name, customer.email, customer.getSupplementSubscription());
        this.paymentMethod = paymentMethod;
        this.associatedCustomers = new ArrayList<Customer>();
        this.associatedCustomers = associatedCustomers;
    }

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

    public void setPaymentMethods(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentMethod getPaymentMethods() {
        return this.paymentMethod;
    }

    public void addCustomer(Customer customer) {
        this.associatedCustomers.add(customer);
    }

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

}
