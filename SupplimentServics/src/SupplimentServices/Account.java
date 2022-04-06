package SupplimentServices;

public class Account {

    String name;
    String accNum;
    String BSB;

    public Account(String name, String accNum, String BSB) {
        this.name = name;
        this.accNum = accNum;
        this.BSB = BSB;
    }

    public Account() {
        this.name = "Account not active";
        this.accNum = "Account not active";
        this.BSB = "Account not active";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccNum() {
        return accNum;
    }

    public void setAccNum(String accNum) {
        this.accNum = accNum;
    }

    public String getBSB() {
        return BSB;
    }

    public void setBSB(String BSB) {
        this.BSB = BSB;
    }

}
