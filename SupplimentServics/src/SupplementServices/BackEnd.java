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
import javafx.stage.Stage;

/**
 * Stores arrays of Customers, Supplements and Magazines.
 *
 * @author Callum Peel
 */
public class BackEnd implements Serializable {

    /**
     * Array List of Customers.
     */
    protected ArrayList<Customer> customers;

    /**
     * Array List of Supplements.
     */
    protected ArrayList<Supplement> supplements;

    /**
     * Array List of Magazines.
     */
    protected ArrayList<Magazine> magazines;

    /**
     * Holds a Stage.
     */
    protected Stage stage;

    /**
     * Holds a View Scene.
     */
    protected Scene vScene,
            /**
             * Holds an Create Scene.
             */
            cScene,
            /**
             * Holds an Edit Scene.
             */
            eScene;

    /**
     * Holds a View Pane.
     */
    public BorderPane viewPane;

    /**
     * Holds a Create Pane.
     */
    public BorderPane createPane;

    /**
     * Holds an Edit Pane.
     */
    public BorderPane editPane;

    /**
     *
     */
    protected String fileName;

    /**
     * Constructs and initializes a Back End.
     *
     * @param window
     * @throws java.io.IOException
     * @throws java.io.FileNotFoundException
     * @throws java.lang.ClassNotFoundException
     */
    public BackEnd(Stage window) throws IOException, FileNotFoundException, ClassNotFoundException {
        this.customers = new ArrayList<>();
        this.supplements = new ArrayList<>();
        this.magazines = new ArrayList<>();
        buildFullDatabase();
        this.viewPane = new BorderPane();
        this.createPane = new BorderPane();
        this.editPane = new BorderPane();
        this.stage = window;
    }

    /**
     * Returns a list of Customers.
     *
     * @return
     */
    public ArrayList<Customer> getCustomers() {
        return this.customers;
    }

    /**
     * Returns a list of Supplements.
     *
     * @return
     */
    public ArrayList<Supplement> getSupplements() {
        return this.supplements;
    }

    /**
     * Returns a list of Magazines
     *
     * @return
     */
    public ArrayList<Magazine> getMags() {
        return this.magazines;
    }

    /**
     * Returns a stage.
     *
     * @return
     */
    public Stage getStage() {
        return this.stage;
    }

    /**
     * Returns the view scene.
     *
     * @return
     */
    public Scene getvScene() {
        return this.vScene;
    }

    /**
     * Returns the create scene.
     *
     * @return
     */
    public Scene getcScene() {
        return this.cScene;
    }

    /**
     * Returns the edit scene.
     *
     * @return
     */
    public Scene geteScene() {
        return this.eScene;
    }

    /**
     * Returns the view pane.
     *
     * @return
     */
    public BorderPane getViewPane() {
        return this.viewPane;
    }

    /**
     * Returns the create pane.
     *
     * @return
     */
    public BorderPane getCreatePane() {
        return this.createPane;
    }

    /**
     * Returns the edit pane.
     *
     * @return
     */
    public BorderPane getEditPane() {
        return this.editPane;
    }

    /**
     * Takes the name of a Customer and returns a Customer
     *
     * @param name
     * @return
     */
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

    /**
     * Takes the name of a Supplement and returns a Supplement
     *
     * @param name
     * @return
     */
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

    /**
     * Takes the name of a Magazine and returns a Magazine.
     *
     * @param name
     * @return
     */
    public Magazine getMagazine(String name) {
        if (getMagazineIndex(name) >= 0) {
            return magazines.get(getMagazineIndex(name));
        }
        return null;
    }

    /**
     * Takes the index of a Customer and returns a Customer
     *
     * @param index
     * @return
     */
    protected String getCustName(int index) {
        return this.customers.get(index).getName();
    }

    /**
     * Takes the index of a Magazine and returns a Magazine.
     *
     * @param index
     * @return
     */
    protected String getMagName(int index) {
        return this.magazines.get(index).name;
    }

    /**
     * Takes the index of a Supplement and returns a Supplement.
     *
     * @param index
     * @return
     */
    protected String getSupName(int index) {
        return this.supplements.get(index).getName();
    }

    /**
     * Returns the number of customers in the database.
     *
     * @return
     */
    protected int getNumCust() {
        return this.customers.size();
    }

    /**
     * Returns the number of supplements in the database.
     *
     * @return
     */
    protected int getNumSups() {
        return this.supplements.size();
    }

    /**
     * Returns the number of magazines in the database.
     *
     * @return
     */
    protected int getNumMags() {
        return this.magazines.size();
    }

    /**
     * Returns a drop down box of all the Paying Customers.
     *
     * @return
     */
    public ChoiceBox<String> getPayingCustomerList() {
        ChoiceBox<String> choice = new ChoiceBox();
        CustomerPaying x = new CustomerPaying();
        for (int i = 0; i < this.customers.size(); i++) {
            if (this.customers.get(i).getClass() == x.getClass()) {
                choice.getItems().add(this.customers.get(i).getName());
            }
        }
        return choice;
    }

    /**
     * Returns a drop down box of all the Supplements.
     *
     * @return
     */
    public ChoiceBox<String> getSupplementList() {
        ChoiceBox<String> choice = new ChoiceBox();
        for (int i = 0; i < this.supplements.size(); i++) {
            choice.getItems().add(this.supplements.get(i).getName());
        }
        return choice;
    }

    /**
     * Returns a drop down box of all the Customers.
     *
     * @return
     */
    public ChoiceBox<String> getCustomerList() {
        ChoiceBox<String> choice = new ChoiceBox();
        for (int i = 0; i < this.customers.size(); i++) {
            choice.getItems().add(this.customers.get(i).getName());
        }
        return choice;
    }

    /**
     * Returns a drop down box of all the Magazines.
     *
     * @return
     */
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
            customers.remove(getCustomerIndex(name));
        }
    }

    /**
     * Takes a customer as a parameter and removes it from the customer list.
     *
     * @param customer
     */
    public void removeCustomer(Customer customer) {
        if (customer != null) {
            this.customers.remove(customer);
        }
    }

    /**
     * Takes the name of a magazine and removes it.
     *
     * @param name
     */
    public void removeMagazine(String name) {
        if (getMagazine(name) != null) {
            this.magazines.remove(getMagazineIndex(name));
        }
    }

    /**
     * Takes Magazine and removes it.
     *
     * @param mag
     */
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

    /**
     * Takes a String name and returns the index of that Customer.
     *
     * @param name
     */
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

    /**
     * Takes a String name and returns the index of that Magazine.
     *
     * @param name
     */
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

    /**
     * Adds a new customer to the list, instantiated with a String name passed
     * in.
     *
     * @param customer
     */
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

    /**
     * Takes a Magazine as a parameter and adds it to the database.
     *
     * @param mag
     */
    public void addMagazine(Magazine mag) {
        this.magazines.add(mag);
    }

    /**
     * Adds a new Magazine to the list, instantiated with a String name passed
     * in.
     *
     * @param mag
     */
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

    /**
     * Adds a new Supplement to the list, instantiated with a String name passed
     * in.
     *
     * @param supplement
     */
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

    /**
     * Adds customers to corresponding Associated Customer Lists.
     */
    public void setAssociatedCustomerLists() {
        for (int i = 0; i < this.getNumCust(); i++) {
            this.customers.get(i).setAssociatedCustomerListToNull();
        }
        for (int i = 0; i < this.getNumCust(); i++) {
            try {
                getCustomer(this.customers.get(i).getPayer()).addAssociatedCustomer(this.customers.get(i));
            } catch (Exception e) {
                System.out.println("Payer not found.");
            }
        }
    }

    /**
     * Combines and returns object list
     */
    private ArrayList<Object> getObjects() {
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
        return objects;
    }

    /**
     * Saves object list as binary file.
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void save() throws FileNotFoundException, IOException {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(this.fileName));
        outputStream.writeObject(getObjects());
        outputStream.close();
    }

    /**
     * Saves object list, to user specified file, as binary file.
     *
     * @param fName
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void save(String fName) throws FileNotFoundException, IOException {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fName));
        outputStream.writeObject(getObjects());
        outputStream.close();
    }

    /**
     * Sets current file name.
     *
     * @param newfilename
     */
    public void setFileName(String newfilename) {
        this.fileName = newfilename;
    }

    /**
     * Loads in objects from binary file and assigns them to classes.
     */
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
