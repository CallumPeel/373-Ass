package SupplimentServices;

/**
 * Contains payment details.
 * 
 * @author Callum Peel
 */
public class PaymentMethod {

    String bankName;
    Card card;
    Account account;

    /**
     * Takes payment information and constructs a Payment Method.
     * 
     * @param bankName
     * @param card
     * @param account
     */
    public PaymentMethod(String bankName, Card card, Account account) {
        this.bankName = bankName;
        this.card = card;
        this.account = account;
    }

    /**
     * Takes payment information and constructs a Payment Method.
     * 
     * @param bankName
     * @param account
     */
    public PaymentMethod(String bankName, Account account) {
        this.bankName = bankName;
        this.card = new Card();
        this.account = account;
    }

    /**
     * Takes payment information and constructs a Payment Method.
     * 
     * @param bankName
     * @param card
     */
    public PaymentMethod(String bankName, Card card) {
        this.bankName = bankName;
        this.card = card;
        this.account = new Account();
    }

    /**
     * Returns the bank name.
     * 
     * @return
     */
    public String getBankName() {
        return this.bankName;
    }

    /**
     * Sets the bank name.
     * 
     * @param bankName
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     * Returns a card.
     * 
     * @return
     */
    public Card getCard() {
        return card;
    }

    /**
     * Takes a card and initializes it to the corresponding global variable.
     * 
     * @param card
     */
    public void setCard(Card card) {
        this.card = card;
    }

}
