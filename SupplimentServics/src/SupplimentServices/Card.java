package SupplimentServices;

/**
 *
 * @author callu
 */
public class Card {

    String name;
    String cardNumber;
    String exp;
    int cvv;

    /**
     *
     * @param name
     * @param cardNumber
     * @param exp
     * @param cvv
     */
    public Card(String name, String cardNumber, String exp, int cvv) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.exp = exp;
        this.cvv = cvv;
    }

    /**
     *
     */
    public Card() {
        this.name = "Card not active";
        this.cardNumber = "Card not active";
        this.exp = "Card not active";
        this.cvv = -1;
    }

    /**
     *
     * @return
     */
    public String getExp() {
        return exp;
    }

    /**
     *
     * @param exp
     */
    public void setExp(String exp) {
        this.exp = exp;
    }

    /**
     *
     * @return
     */
    public int getCvv() {
        return cvv;
    }

    /**
     *
     * @param cvv
     */
    public void setCvv(int cvv) {
        this.cvv = cvv;
    }
}
