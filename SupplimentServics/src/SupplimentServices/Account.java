package SupplimentServices;

/**
 *
 * @author callu
 */
public class Account {

    String name;
    String accNum;
    String BSB;

    /**
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
     *
     */
    public Account() {
        this.name = "Account not active";
        this.accNum = "Account not active";
        this.BSB = "Account not active";
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getAccNum() {
        return accNum;
    }

    /**
     *
     * @param accNum
     */
    public void setAccNum(String accNum) {
        this.accNum = accNum;
    }

    /**
     *
     * @return
     */
    public String getBSB() {
        return BSB;
    }

    /**
     *
     * @param BSB
     */
    public void setBSB(String BSB) {
        this.BSB = BSB;
    }

}
