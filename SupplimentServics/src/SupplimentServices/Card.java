package SupplimentServices;

/**
 * Contains card details.
 * @author Callum Peel
 */
public class Card {

    String name;
    String cardNumber;
    String exp;
    int cvv;

    /**
     * Takes card details, constructs a card object then initializes it.
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
     * Constructs a card object and initializes it with default values.
     */
    public Card() {
        this.name = "Card not active";
        this.cardNumber = "Card not active";
        this.exp = "Card not active";
        this.cvv = -1;
    }

    /**
     * Returns the string expiry date.
     * @return
     */
    public String getExp() {
        return exp;
    }

    /**
     * Takes a String expiry and initializes the expiry global variable.
     * @param exp
     */
    public void setExp(String exp) {
        this.exp = exp;
    }

    /**
     * Returns an int cvv.
     * @return
     */
    public int getCvv() {
        return cvv;
    }

    /**
     * Takes an int cvv and initializes the global cvv.
     * @param cvv
     */
    public void setCvv(int cvv) {
        this.cvv = cvv;
    }
}
