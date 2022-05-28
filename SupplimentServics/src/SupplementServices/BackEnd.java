package SupplementServices;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * Stores arrays of customers and supplements.
 *
 * @author Callum Peel
 */
public class BackEnd implements Serializable {

    protected ArrayList<Customer> customers;
    protected ArrayList<Supplement> supplements;
    protected ArrayList<Magazine> magazines;
    protected Stage stage;
    protected Scene vScene, cScene, eScene;
    protected BorderPane viewPane;
    protected BorderPane createPane;
    protected BorderPane editPane;
    protected FlowPane topPane;
    protected MyVBox viewLeftPane, viewCenterPane, viewRightPane;
    protected String fileName;

    /**
     * Constructs and initializes a Back End.
     *
     * @param window
     * @throws java.io.IOException
     */
    public BackEnd(Stage window) throws IOException, FileNotFoundException, ClassNotFoundException {

        this.fileName = "database";

        this.customers = new ArrayList<Customer>();
        this.supplements = new ArrayList<Supplement>();
        this.magazines = new ArrayList<Magazine>();
        this.viewPane = new BorderPane();
        this.createPane = new BorderPane();
        this.editPane = new BorderPane();
        this.stage = window;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public ArrayList<Supplement> getSupplements() {
        return supplements;
    }

    public ArrayList<Magazine> getMags() {
        return magazines;
    }

    public Stage getStage() {
        return stage;
    }

    public Scene getvScene() {
        return vScene;
    }

    public Scene getcScene() {
        return cScene;
    }

    public Scene geteScene() {
        return eScene;
    }

    public BorderPane getViewPane() {
        return viewPane;
    }

    public BorderPane getCreatePane() {
        return createPane;
    }

    public BorderPane getEditPane() {
        return editPane;
    }

    public FlowPane getTopPane() {
        return topPane;
    }

    public MyVBox getViewLeftPane() {
        return viewLeftPane;
    }

    public MyVBox getViewCenterPane() {
        return viewCenterPane;
    }

    public MyVBox getViewRightPane() {
        return viewRightPane;
    }

    public Customer getCustomer(String name) {
        Customer result = null;
        for (Customer c : this.customers) {
            if (name.equalsIgnoreCase(c.getName())) {
                result = c;
                break;
            }
        }
        return result;
    }

    public Supplement getSupplement(String name) {
        Supplement result = null;
        for (Supplement c : this.supplements) {
            if (name.equalsIgnoreCase(c.getName())) {
                result = c;
                break;
            }
        }
        return result;
    }

    public Magazine getMagazine(String name) {
        if (getMagazineIndex(name) >= 0) {
            return magazines.get(getMagazineIndex(name));
        }
        return null;
    }

    protected String getCustName(int index) {
        return customers.get(index).name;
    }

    protected String getMagName(int index) {
        return magazines.get(index).name;
    }

    protected String getSupName(int index) {
        return supplements.get(index).name;
    }

    protected int getNumCust() {
        return customers.size();
    }

    protected int getNumSups() {
        return supplements.size();
    }

    protected int getNumMags() {
        return magazines.size();
    }

    public ChoiceBox<String> getPayingCustomerList() {
        ChoiceBox<String> choice = new ChoiceBox();
        CustomerPaying x = new CustomerPaying();
        for (int i = 0; i < this.customers.size(); i++) {
            if (this.customers.get(i).getClass() == x.getClass()) {
                choice.getItems().add(this.customers.get(i).name);
            }
        }
        return choice;
    }

    public ChoiceBox<String> getSupplementList() {
        ChoiceBox<String> choice = new ChoiceBox();
        for (int i = 0; i < this.supplements.size(); i++) {
            choice.getItems().add(this.supplements.get(i).name);
        }
        return choice;
    }

    public ChoiceBox<String> getCustomerList() {
        ChoiceBox<String> choice = new ChoiceBox();
        for (int i = 0; i < this.customers.size(); i++) {
            choice.getItems().add(this.customers.get(i).name);
        }
        return choice;
    }

    public ChoiceBox<String> getMagazineList() {
        ChoiceBox<String> choice = new ChoiceBox();
        for (int i = 0; i < this.magazines.size(); i++) {
            choice.getItems().add(this.magazines.get(i).name);
        }
        return choice;
    }

    /**
     * Takes a String name as a parameter and removes that customer from the
     * list of customers.
     *
     * @param name
     */
    public void removeCustomer(String name) {
        if (getCustomer(name) != null) {
            System.out.println("Customer Removed.\n");
            customers.remove(getCustomerIndex(name));
        } else {
            System.out.println("Customer not found.\n");
        }
    }

    /**
     * Takes a customer as a parameter and removes it from the customer list.
     *
     * @param customer
     */
    public void removeCustomer(Customer customer) {
        this.customers.remove(customer);
    }

    public void removeMagazine(String name) {
        if (getMagazine(name) != null) {
            System.out.println("Magazine Removed.\n");
            magazines.remove(getMagazineIndex(name));
        } else {
            System.out.println("Magazine not found.\n");
        }
    }

    public void removeMagazine(Magazine mag) {
        this.magazines.remove(mag);
    }

    /**
     * Takes a supplement as a parameter and removes it from the list of
     * supplements.
     *
     * @param supplement
     */
    public void removeSupplement(Supplement supplement) {
        this.supplements.remove(supplement);
    }

    private int getCustomerIndex(String name) {
        int counter = 0;
        int index = -1;
        for (Customer c : this.customers) {
            if (c.getName().equalsIgnoreCase(name)) {
                index = counter;
            }
            counter++;
        }
        return index;
    }

    private int getMagazineIndex(String name) {
        int counter = 0;
        int index = -1;
        for (Magazine c : this.magazines) {
            if (c.getName().equalsIgnoreCase(name)) {
                index = counter;
            }
            counter++;
        }
        return index;
    }

    /**
     * Takes a customer and adds it to the list of customers.
     *
     * @param customer
     */
    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    public void addCustomer(String customer) {
        this.customers.add(new Customer(customer));
    }

    /**
     * Takes a customer and some payment details as parameters, constructs a
     * paying customer and adds it to the list.
     *
     * @param customer
     * @param paymentMethod
     * @param associatedCustomers
     */
    public void addCustomer(Customer customer, PaymentMethod paymentMethod, ArrayList<Customer> associatedCustomers) {
        this.customers.add(new CustomerPaying(customer, paymentMethod, associatedCustomers));
    }

    public void addMagazine(Magazine mag) {
        this.magazines.add(mag);
    }

    public void addMagazine(String mag) {
        this.magazines.add(new Magazine(mag));
    }

    /**
     * Takes a supplement as a parameter and adds it to the list of supplements.
     *
     * @param supplement
     */
    public void addSupplement(Supplement supplement) {
        this.supplements.add(supplement);
    }

    public void addSupplement(String supplement) {
        this.supplements.add(new Supplement(supplement));
    }

    private void buildFullDatabase() {
        // Build suppliment database.
        addSupplement(new Supplement("One", 2.4));
        addSupplement(new Supplement("Two", 6.3));
        addSupplement(new Supplement("Three", 7));
        addSupplement(new Supplement("Four", 8));
        addSupplement(new Supplement("Five", 11));
        addSupplement(new Supplement("Six", 3.4));

        // Build customer database.
        ArrayList<Supplement> supplementList1 = new ArrayList<Supplement>();
        supplementList1.add(this.supplements.get(0));
        supplementList1.add(this.supplements.get(1));
        supplementList1.add(this.supplements.get(2));
        ArrayList<Supplement> supplementList2 = new ArrayList<Supplement>();
        supplementList2.add(this.supplements.get(0));
        supplementList2.add(this.supplements.get(3));
        supplementList2.add(this.supplements.get(5));
        ArrayList<Supplement> supplementList3 = new ArrayList<Supplement>();
        supplementList3.add(this.supplements.get(4));
        supplementList3.add(this.supplements.get(5));
        supplementList3.add(this.supplements.get(2));
        ArrayList<Supplement> supplementList4 = new ArrayList<Supplement>();
        supplementList4.add(this.supplements.get(3));
        supplementList4.add(this.supplements.get(4));
        supplementList4.add(this.supplements.get(5));

        // Add standard customers
        addCustomer(new Customer("Callum", "callum@gmail.com", new Address(), supplementList1));
        addCustomer(new Customer("Maddie", "Maddie@gmail.com", new Address(), supplementList2));
        addCustomer(new Customer("Dom", "Dom@gmail.com", new Address(), supplementList3));
        addCustomer(new Customer("Tim", "Tim@gmail.com", new Address(), supplementList4));
        addCustomer(new Customer("Sally", "Sally@gmail.com", new Address(), supplementList2));
        addCustomer(new Customer("Fin", "Fin@gmail.com", new Address(), supplementList4));
        // Create lists of associated customers
        ArrayList<Customer> customerList1 = new ArrayList<Customer>();
        customerList1.add(this.customers.get(0));
        customerList1.add(this.customers.get(1));
        customerList1.add(this.customers.get(2));
        ArrayList<Customer> customerList2 = new ArrayList<Customer>();
        customerList2.add(this.customers.get(0));
        customerList2.add(this.customers.get(2));
        customerList2.add(this.customers.get(3));
        ArrayList<Customer> customerList3 = new ArrayList<Customer>();
        customerList3.add(this.customers.get(1));
        customerList3.add(this.customers.get(2));
        customerList3.add(this.customers.get(3));
        ArrayList<Customer> customerList4 = new ArrayList<Customer>();
        customerList4.add(this.customers.get(3));
        customerList4.add(this.customers.get(4));
        customerList4.add(this.customers.get(5));

        // Create paying customers;
        this.addCustomer(
                new Customer("Matthew", "Matthew@gmail.com", supplementList1),
                new PaymentMethod(
                        "Bank of Australia",
                        new Card(
                                "Matthew",
                                "1234 1234 1234 1234",
                                "12/24",
                                232
                        ),
                        new Account(
                                "Matts account",
                                "1234 1234",
                                "1234"
                        )
                ),
                customerList1
        );

        this.addCustomer(new Customer("Steven", "Steven@gmail.com", supplementList2),
                new PaymentMethod("Bank of America", new Card("Steven", "1234 4444 1234 2222", "10/24", 513)), customerList2);
        this.addCustomer(new Customer("Mark", "Mark@gmail.com", supplementList3),
                new PaymentMethod("Bank of Brazil", new Card("Steven", "6666 4444 3333 2222", "11/25", 765)), customerList3);
        this.addCustomer(new Customer("Phil", "Phil@gmail.com", supplementList4),
                new PaymentMethod("Bank of Asia", new Card("Phil", "3233 1313 1111 4344", "12/23", 748)), customerList3);

        this.addMagazine(new Magazine("Doms mag", 10, supplementList1, customerList1));
        this.addMagazine(new Magazine("Callums mag", 10, supplementList2, customerList2));
        this.addMagazine(new Magazine("Some mag", 10, supplementList3, customerList3));
    }

    public void setAssociatedCustomerLists() {
        for (int i = 0; i < this.getNumCust(); i++) {
            this.customers.get(i).setAssociatedCustomerListToNull();
        }
        for (int i = 0; i < this.getNumCust(); i++) {
            try {
                getCustomer(this.customers.get(i).payer).addAssociatedCustomer(this.customers.get(i));
            } catch (Exception e) {
                System.out.println("Payer not found.");
            }
        }
    }

    public void save() throws FileNotFoundException, IOException {
        setAssociatedCustomerLists();
        ArrayList<Object> objects = new ArrayList<>();
        for (int i = 0; i < this.customers.size(); i++) {
            objects.add(this.customers.get(i));
        }
        for (int i = 0; i < this.supplements.size(); i++) {
            objects.add(this.supplements.get(i));
        }
        for (int i = 0; i < this.magazines.size(); i++) {
            objects.add(this.magazines.get(i));
        }
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(this.fileName));
        outputStream.writeObject(objects);
        outputStream.close();
    }

    public void save(String fName) throws FileNotFoundException, IOException {
        setAssociatedCustomerLists();
        ArrayList<Object> objects = new ArrayList<>();
        for (int i = 0; i < this.customers.size(); i++) {
            objects.add(this.customers.get(i));
            System.out.println(this.customers.get(i).name + " = PC = " + this.customers.get(i).payer);
        }
        for (int i = 0; i < this.supplements.size(); i++) {
            objects.add(this.supplements.get(i));
        }
        for (int i = 0; i < this.magazines.size(); i++) {
            objects.add(this.magazines.get(i));
        }
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fName));
        outputStream.writeObject(objects);
        outputStream.close();
    }

    public void setFileName(String newfilename) {
        this.fileName = newfilename;
    }

    void load() throws FileNotFoundException, IOException, ClassNotFoundException {

        ObjectInputStream is = new ObjectInputStream(new FileInputStream(this.fileName));
        List<Object> input = (List<Object>) is.readObject();
        List<Object> checkList = new ArrayList<>();
        for (Object obj : input) {
            checkList.add(obj.getClass().getSimpleName());
            if (obj instanceof Customer && !(obj instanceof CustomerPaying)) {
                Customer newCust = (Customer) obj;
                this.customers.add(newCust);
            }
            if (obj instanceof CustomerPaying) {
                CustomerPaying newCustPaying = (CustomerPaying) obj;
                this.customers.add(newCustPaying);
            }
            if (obj instanceof Supplement) {
                Supplement newSup = (Supplement) obj;
                this.supplements.add(newSup);
            }
            if (obj instanceof Magazine) {
                Magazine newMag = (Magazine) obj;
                this.magazines.add(newMag);
            }
        }
        is.close();
    }

}
