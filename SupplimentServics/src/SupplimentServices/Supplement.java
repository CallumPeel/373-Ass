package SupplimentServices;

public class Supplement {

    private String name;
    private double cost;

    public Supplement(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getCost() {
        return this.cost;
    }
}
