package SupplementServices;

/**
 * Contains supplement name and cost.
 * 
 * @author Callum Peel
 */
public class Supplement {

    private String name;
    private double cost;

    /**
     * Takes a name and cost, constructs and initializes those values.
     * @param name
     * @param cost
     */
    public Supplement(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    /**
     * Takes a name and initializes it.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the supplement name.
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     *  Takes a supplement cost and initializes it.
     * @param cost
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * Returns the supplement cost.
     * @return
     */
    public double getCost() {
        return this.cost;
    }
}
