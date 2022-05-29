package SupplementServices;

import java.io.Serializable;
import javafx.scene.control.TreeItem;

/**
 * Holds Address information.
 * @author callum
 */
public class Address implements Serializable {

    private int streetNumber, postCode;
    private String streetName, suburb;

    /**
     * Constructs an Address using parameters.
     * @param streetNumber
     * @param postcode
     * @param streetName
     * @param suburb
     */
    public Address(int streetNumber, int postcode, String streetName, String suburb) {
        this.streetNumber = streetNumber;
        this.postCode = postcode;
        this.streetName = streetName;
        this.suburb = suburb;
    }

    /**
     * Constructs a default Address.
     */
    public Address() {
        this.streetNumber = -1;
        this.postCode = -1;
        this.streetName = "Default";
        this.suburb = "Default";
    }

    /**
     * Sets Street Number
     * @param streetNumber
     */
    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    /**
     * Sets Post Code
     * @param postcode
     */
    public void setPostcode(int postcode) {
        this.postCode = postcode;
    }

    /**
     * Sets Street Name.
     * @param streetName
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    /**
     * Sets Suburb name.
     * @param suburb
     */
    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    /**
     * Returns Street Number.
     * @return
     */
    public int getStreetNumber() {
        return streetNumber;
    }

    /**
     * Returns Post Code.
     * @return
     */
    public int getPostcode() {
        return postCode;
    }

    /**
     * Returns Street Name.
     * @return
     */
    public String getStreetName() {
        return streetName;
    }

    /** 
     * Returns Suburb Name.
     * @return
     */
    public String getSuburb() {
        return suburb;
    }

    /**
     * Returns a Tree View of Address information.
     * @return
     */
    public TreeItem<String> getAddressTreeView() {
        TreeItem<String> customerInformation = new TreeItem("Address");
        customerInformation.getChildren().add(new TreeItem(
                this.streetNumber
                + " "
                + this.streetName
                + "\n"
                + this.suburb
                + "\n" + this.postCode));
        return customerInformation;
    }
}
