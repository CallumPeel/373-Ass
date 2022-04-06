package SupplimentServices;



public class Card {

    String name;
    String cardNumber;
    String exp;
    int cvv;

    public Card(String name, String cardNumber, String exp, int cvv) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.exp = exp;
        this.cvv = cvv;
    }

    public Card() {
        this.name = "Card not active";
        this.cardNumber = "Card not active";
        this.exp = "Card not active";
        this.cvv = -1;
    }


    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }
}
