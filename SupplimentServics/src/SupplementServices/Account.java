package SupplementServices;

import java.io.Serializable;

/**
 * Holds a customer's account details.
 * @author Callum Peel
 */
public class Account implements Serializable {

    String name;
    String accNum;
    String BSB;

    /**
     * Constructs an Account object.
     * Takes their name, account number and BSB as parameters and initializes them.
     * 
     * @param name
     * @param accNum
     * @param BSB
     */
    public Account(String name, String accNum, String BSB) {
        this.name = name;
        this.accNum = accNum;
        this.BSB = BSB;
    }

    /**
     * Initializes an account to default values.
     */
    public Account() {
        this.name = "Default";
        this.accNum = "Default";
        this.BSB = "Default";
    }

    /**
     * Returns account name.
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Sets account name.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns account number
     * @return
     */
    public String getAccNum() {
        return accNum;
    }

    /**
     * Sets the account number
     * @param accNum
     */
    public void setAccNum(String accNum) {
        this.accNum = accNum;
    }

    /**
     * Returns BSB
     * @return
     */
    public String getBSB() {
        return BSB;
    }

    /**
     * Sets BSB
     * @param BSB
     */
    public void setBSB(String BSB) {
        this.BSB = BSB;
    }

}
