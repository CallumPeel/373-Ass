package SupplementServices;

public class Address {

    int streetNumber, postcode;
    String streetName, suburb;

    public Address(int streetNumber, int postcode, String streetName, String suburb) {
        this.streetNumber = streetNumber;
        this.postcode = postcode;
        this.streetName = streetName;
        this.suburb = suburb;
    }

    public Address() {
        this.streetNumber = -1;
        this.postcode = -1;
        this.streetName = "Default Street";
        this.suburb = "Default Suburb";
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public int getPostcode() {
        return postcode;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getSuburb() {
        return suburb;
    }

}