package SupplementServices;

import java.io.Serializable;
import javafx.scene.control.TreeItem;

/**
 *
 * @author callu
 */
public class Address implements Serializable {

    int streetNumber, postCode;
    String streetName, suburb;

    /**
     *
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
     *
     */
    public Address() {
        this.streetNumber = -1;
        this.postCode = -1;
        this.streetName = "Default";
        this.suburb = "Default";
    }

    /**
     *
     * @param streetNumber
     */
    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    /**
     *
     * @param postcode
     */
    public void setPostcode(int postcode) {
        this.postCode = postcode;
    }

    /**
     *
     * @param streetName
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    /**
     *
     * @param suburb
     */
    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    /**
     *
     * @return
     */
    public int getStreetNumber() {
        return streetNumber;
    }

    /**
     *
     * @return
     */
    public int getPostcode() {
        return postCode;
    }

    /**
     *
     * @return
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     *
     * @return
     */
    public String getSuburb() {
        return suburb;
    }

    /**
     *
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
