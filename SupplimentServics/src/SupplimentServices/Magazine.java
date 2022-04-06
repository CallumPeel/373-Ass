package SupplimentServices;

import java.util.ArrayList;

public class Magazine {
    
    double cost;
    ArrayList<Supplement> supplements;

    public Magazine() {
        
    }

    public Magazine(ArrayList<Supplement> supplements, double cost) {
            this.cost = cost;
            this.supplements = supplements;
    }

    public double getTotal() {
        double total = 0;
        for (Supplement supplement : this.supplements) {
            total += supplement.getCost();
        }
        return total + this.cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setSupplementList(ArrayList<Supplement> supplements){
        this.supplements = supplements;
    }

    public double getCost(){
        return this.cost;
    }

    public ArrayList<Supplement> getSupplements(){
        return this.supplements;
    }

    public void addSupplement(Supplement supplement) {
        this.supplements.add(supplement);
    }

    public void removeSupplement(Supplement supplement) {
        this.supplements.remove(supplement);
    }

}
