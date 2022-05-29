package SupplementServices;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Handles user input and displays prompts to the console.
 *
 * @author Callum Peel
 */
public class FrontEndConsole implements Serializable{

    private BackEnd backEnd;
    private InputHandler IH;
    String mainMenu;

    /**
     * Takes a back end as a parameter and constructs a front end. Takes a
     * BackEnd and initializes it to the global variable.
     *
     * @param backEnd
     */
    public FrontEndConsole(BackEnd backEnd) {

        displayStudentDetails();
        this.backEnd = backEnd;
        this.IH = new InputHandler();
        mainMenu = "\nMenu\n"
                + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
                + "[A] - Add a Customer\n"
                + "[B] - Add a Paying Customer\n"
                + "[C] - Delete a Customer\n"
                + "[D] - Print Customer List\n"
                + "[E] - Get Weekly Emials\n"
                + "[F] - Get Monthly Emails\n\n"
                + "[Q] - QUIT\n"
                + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";

//        buildDatabase();
//        assignmentQuestions();
//        loopMenu();
    }

    /**
     * Displays a menu loop.
     */
    private void loopMenu() {

        boolean orig = true;
        boolean val = false;

        boolean result = (orig == val);
        if (result) {
            System.out.println("\n\n\n\nwin\n\n\n\n");
        }

        char choice;
        do {
            choice = this.IH.getChar(mainMenu);

            switch (choice) {
                case 'a':
                    Customer customer = new Customer(
                            IH.getString("Please eneter a name: "),
                            IH.getString("Please enter an email address: "),
                            makeSupplementList());
                    this.backEnd.addCustomer(customer);
                    break;
                case 'b':
                    String name = IH.getString("Please eneter a name: ");
                    CustomerPaying payingCustomer = new CustomerPaying(
                            name,
                            IH.getString("Please enter an email address: "),
                            makeSupplementList(),
                            new PaymentMethod(IH.getString("Please enter the Bank Name."),
                                    new Card(name, IH.getString("Please enter the Account number"),
                                            IH.getString("Please enter the expiry"),
                                            IH.getInt("Please enter the CVV."))),
                            makeCustomerList());
                    this.backEnd.addCustomer(payingCustomer);
                    break;
                case 'c':
                    backEnd.removeCustomer(IH.getString("Which customer would you like to remove?\n"));
                    break;
                case 'd':
                    System.out.println();
                    printCustomers();
                    break;
                case 'e':
                    for (Customer cEmail : this.backEnd.customers) {
                        System.out.println(cEmail.getWeeklyEmail());
                    }
                    break;
                case 'f':
                    for (Customer cMonthlyEmail : this.backEnd.customers) {
                        System.out.println(cMonthlyEmail.getMonthlyEmail());
                    }
                    break;
            }
        } while (choice != 'q');
    }

    /**
     * Prints a list of names to the console.
     */
    private void printCustomers() {
        for (Customer cust : this.backEnd.customers) {
            System.out.println(cust.getName());
        }
        System.out.println();
    }

    /**
     * Loops a display menu that takes customer names and builds a list of
     * associated customers.
     *
     * @return
     */
    private ArrayList<Customer> makeCustomerList() {
        // Gets customer list from back end
        ArrayList<Customer> allCustomers = this.backEnd.customers;
        // Creates an empty list to add associated customers to
        ArrayList<Customer> associatedCustomers = new ArrayList<Customer>();
        // Building menu string
        String custMenu = "\nEnter the name of the customer to add.\n";
        for (Customer customer : allCustomers) {
            custMenu += customer.getName() + ".\n";
        }
        custMenu += "Type EXIT to finish.";
        String custChoice = "";
        // Takes a name from the user and adds it to a customer list
        do {
            custChoice = IH.getString(custMenu);
            boolean validInput = false;
            for (Customer cust : allCustomers) {
                if (cust.getName().equalsIgnoreCase(custChoice) && !associatedCustomers.contains(cust)) {
                    associatedCustomers.add(cust);
                    validInput = true;
                    System.out.println("Customer Added to list.\n");
                }
            }
            if (!validInput && !custChoice.equalsIgnoreCase("EXIT")) {
                System.out.println("Customer does not exist or is already an associated customer.\n");
            }
        } while (!custChoice.equalsIgnoreCase("EXIT"));
        return associatedCustomers;
    }

    /**
     * Creates a list of supplements from user input.
     *
     * @return
     */
    private ArrayList<Supplement> makeSupplementList() {
        ArrayList<Supplement> allSupplements = this.backEnd.supplements;
        ArrayList<Supplement> newCustomerSupplements = new ArrayList<Supplement>();
        String supMenu = "\nEnter the name of the supplement to add.\n";
        for (Supplement supplement : allSupplements) {
            supMenu += supplement.getName() + ".\n";
        }
        supMenu += "Type EXIT to finish.";
        String supChoice = "";
        do {
            supChoice = IH.getString(supMenu);
            boolean validInput = false;
            for (Supplement sup : allSupplements) {
                if (sup.getName().equalsIgnoreCase(supChoice) && !newCustomerSupplements.contains(sup)) {
                    newCustomerSupplements.add(sup);
                    validInput = true;
                    System.out.println("Supplement Added to list.\n");
                }
            }
            if (!validInput && !supChoice.equalsIgnoreCase("EXIT")) {
                System.out.println("Supplement does not exist or is already subscribed to.\n");
            }
        } while (!supChoice.equalsIgnoreCase("EXIT"));
        System.out.println();
        return newCustomerSupplements;
    }

    /**
     * Automatically tests assignment questions d - f
     */
    private void assignmentQuestions() {

        for (Customer customer : this.backEnd.customers) {
            System.out.println(customer.getWeeklyEmail());
        }
        // d. print out the text for the end of month emails for the paying customers, 
        for (Customer customer : this.backEnd.customers) {
            System.out.println(customer.getMonthlyEmail());
        }
        // e. add a new customer to the magazine service, 
        this.backEnd.addCustomer(new Customer("Bob", "Bob@gmail.com"));
        for (Customer customer : this.backEnd.customers) {
            System.out.println(customer.getName());
        }
        System.out.println();
        // f. remove an existing customer from the magazine service, 
        this.backEnd.removeCustomer("Maddie");
        for (Customer customer : this.backEnd.customers) {
            System.out.println(customer.getName());
        }
    }

    private void displayStudentDetails() {
        System.out.println(
                "Name: Callum Peel\n"
                + "Student Number: 34217062\n"
                + "Mode of Enrolement: Internal\n"
                + "Tutor: Ferdous Sohel\n"
                + "Tutorial attendance: Tuesdays 1630-1730\n\n"
        );
    }
}
