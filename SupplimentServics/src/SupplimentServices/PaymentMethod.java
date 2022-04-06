package SupplimentServices;

public class PaymentMethod {

    String bankName;
    Card card;
    Account account;

    public PaymentMethod(String bankName, Card card, Account account) {
        this.bankName = bankName;
        this.card = card;
        this.account = account;
    }

    public PaymentMethod(String bankName, Account account) {
        this.bankName = bankName;
        this.card = new Card();
        this.account = account;
    }

    public PaymentMethod(String bankName, Card card) {
        this.bankName = bankName;
        this.card = card;
        this.account = new Account();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

}
