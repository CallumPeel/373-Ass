package SupplimentServices;

/**
 *
 * @author callu
 */
public class PaymentMethod {

    String bankName;
    Card card;
    Account account;

    /**
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
     *
     * @return
     */
    public String getBankName() {
        return bankName;
    }

    /**
     *
     * @param bankName
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     *
     * @return
     */
    public Card getCard() {
        return card;
    }

    /**
     *
     * @param card
     */
    public void setCard(Card card) {
        this.card = card;
    }

}
