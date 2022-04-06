package SupplimentServices;

import java.util.ArrayList;

/**
 *
 * @author callu
 */
public class Magazine {
    
    double cost;
    ArrayList<Supplement> supplements;

    /**
     *
     */
    public Magazine() {
        
    }

    /**
     *
     * @param supplements
     * @param cost
     */
    public Magazine(ArrayList<Supplement> supplements, double cost) {
            this.cost = cost;
            this.supplements = supplements;
    }

    /**
     *
     * @return
     */
    public double getTotal() {
        double total = 0;
        for (Supplement supplement : this.supplements) {
            total += supplement.getCost();
        }
        return total + this.cost;
    }

    /**
     *
     * @param cost
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     *
     * @param supplements
     */
    public void setSupplementList(ArrayList<Supplement> supplements){
        this.supplements = supplements;
    }

    /**
     *
     * @return
     */
    public double getCost(){
        return this.cost;
    }

    /**
     *
     * @return
     */
    public ArrayList<Supplement> getSupplements(){
        return this.supplements;
    }

    /**
     *
     * @param supplement
     */
    public void addSupplement(Supplement supplement) {
        this.supplements.add(supplement);
    }

    /**
     *
     * @param supplement
     */
    public void removeSupplement(Supplement supplement) {
        this.supplements.remove(supplement);
    }

}
