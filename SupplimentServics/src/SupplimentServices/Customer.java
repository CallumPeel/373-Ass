package SupplimentServices;

import java.util.ArrayList;

public class Customer {
    String name;
    String email;
    private ArrayList<Supplement> supplementSubscription;

    public Customer(String name, String email, ArrayList<Supplement> supplementSubscription) {
        this.name = name;
        this.email = email;
        this.supplementSubscription = new ArrayList<Supplement>();
        this.supplementSubscription = supplementSubscription;
    }

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
        this.supplementSubscription = new ArrayList<Supplement>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSupplementSubscription(ArrayList<Supplement> supplementSubscription) {
        this.supplementSubscription = supplementSubscription;
    }

    public String getName() {
        return this.name;
    }

    public String getEmailAddress() {
        return this.email;
    }

    public ArrayList<Supplement> getSupplementSubscription() {
        return this.supplementSubscription;
    }

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

    public String getMonthlyEmail() {
        return "";
    }

}
