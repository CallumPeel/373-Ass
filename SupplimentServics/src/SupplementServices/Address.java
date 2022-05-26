package SupplementServices;

import java.io.Serializable;
import javafx.scene.control.TreeItem;

public class Address implements Serializable {

    int streetNumber, postCode;
    String streetName, suburb;

    public Address(int streetNumber, int postcode, String streetName, String suburb) {
        this.streetNumber = streetNumber;
        this.postCode = postcode;
        this.streetName = streetName;
        this.suburb = suburb;
    }

    public Address() {
        this.streetNumber = -1;
        this.postCode = -1;
        this.streetName = "Default Street";
        this.suburb = "Default Suburb";
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public void setPostcode(int postcode) {
        this.postCode = postcode;
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
        return postCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getSuburb() {
        return suburb;
    }

    public TreeItem<String> getAddressTreeView() {
        TreeItem<String> customerInformation = new TreeItem("Address");
        customerInformation.getChildren().add(new TreeItem(
                this.streetNumber
                + " "
                + this.streetName
                + " st\n"
                + this.suburb
                + "\nPost Code: " + this.postCode));
        return customerInformation;
    }
}
