package SupplementServices;

import java.util.ArrayList;

/**
 * Contains a list supplements and tracks cost.
 * @author Callum Peel
 */
public class Magazine {

    String name;
    double cost;
    ArrayList<Supplement> supplements;
    ArrayList<Customer> customerSubscriptions;

    Magazine(String mag) {
        this.name = mag;
        this.cost = -1;
        this.supplements = new ArrayList<Supplement>();
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Customer> getCustomerSubscriptions() {
        return customerSubscriptions;
    }

    public void setCustomerSubscriptions(ArrayList<Customer> customerSubscriptions) {
        this.customerSubscriptions = customerSubscriptions;
    }
    
    
    /**
     * Default constructor initializes global variables too default values.
     */
    public Magazine() {
        this.cost = -1;
        this.supplements = new ArrayList<Supplement>();
    }

    /**
     * Takes a supplement list and cost then constructs and initializes a Magazine object.
     * @param supplements
     * @param cost
     */
    public Magazine(ArrayList<Supplement> supplements, double cost) {
            this.cost = cost;
            this.supplements = supplements;
    }

    /**
     * Calculates the total cost of a list of supplements.
     * @return
     */
    private double getTotal() {
        double total = 0;
        for (Supplement supplement : this.supplements) {
            total += supplement.getCost();
        }
        return total + this.cost;
    }

    /**
     * Sets the cost of a list of supplements.
     * @param cost
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * Takes a list of supplements and initializes it to the global variable.
     * @param supplements
     */
    public void setSupplementList(ArrayList<Supplement> supplements){
        this.supplements = supplements;
    }

    /**
     * Returns the cost of a list of supplements.
     * @return
     */
    public double getCost(){
        return this.cost;
    }

    /**
     * Returns a list of supplements.
     * @return
     */
    public ArrayList<Supplement> getSupplements(){
        return this.supplements;
    }

    /**
     * Takes a supplement and adds it to the magazines supplement list.
     * @param supplement
     */
    public void addSupplement(Supplement supplement) {
        this.supplements.add(supplement);
    }

    /**
     * Takes a supplement and removes it from the magazines supplement list
     * @param supplement
     */
    public void removeSupplement(Supplement supplement) {
        this.supplements.remove(supplement);
    }

}
