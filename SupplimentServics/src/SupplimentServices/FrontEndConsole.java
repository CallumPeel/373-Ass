package SupplimentServices;

import java.util.ArrayList;

/**
 * Handles user input and displays prompts to the console.
 *
 * @author Callum Peel
 */
public class FrontEndConsole {

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

        buildDatabase();

        assignmentQuestions();

        loopMenu();
    }

/**
 * Displays a menu loop.
 */
    private void loopMenu() {
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
                    PayingCustomer payingCustomer = new PayingCustomer(
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
            System.out.println(cust.name);
        }
    }

    /**
     * Loops a display menu that takes customer names and builds a list of associated customers.
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
            System.out.println(customer.name);
        }
        System.out.println();
        // f. remove an existing customer from the magazine service, 
        this.backEnd.removeCustomer("Maddie");
        for (Customer customer : this.backEnd.customers) {
            System.out.println(customer.name);
        }
    }

    /**
     * This function builds an example back end database.
     * This consists of customers, paying customers, supplement details, etc.
     *
     * a. construct a magazine with an array of 3-4 supplements-
     *    with made-up details built in to the program
     * b. construct an array of 5-6 different customers of various 
     *    types with made-up details built in to the program, 
     * c. print out the text of all the e-mails for all customers for four weeks of magazines,
     */
    private void buildDatabase() {
        // Build suppliment database.
        this.backEnd.addSupplement(new Supplement("One", 2.4));
        this.backEnd.addSupplement(new Supplement("Two", 6.3));
        this.backEnd.addSupplement(new Supplement("Three", 7));
        this.backEnd.addSupplement(new Supplement("Four", 8));
        this.backEnd.addSupplement(new Supplement("Five", 11));
        this.backEnd.addSupplement(new Supplement("Six", 3.4));

        // Build customer database.
        ArrayList<Supplement> supplementList1 = new ArrayList<Supplement>();
        supplementList1.add(backEnd.supplements.get(0));
        supplementList1.add(backEnd.supplements.get(1));
        supplementList1.add(backEnd.supplements.get(2));
        ArrayList<Supplement> supplementList2 = new ArrayList<Supplement>();
        supplementList2.add(backEnd.supplements.get(0));
        supplementList2.add(backEnd.supplements.get(3));
        supplementList2.add(backEnd.supplements.get(5));
        ArrayList<Supplement> supplementList3 = new ArrayList<Supplement>();
        supplementList3.add(backEnd.supplements.get(4));
        supplementList3.add(backEnd.supplements.get(5));
        supplementList3.add(backEnd.supplements.get(2));
        ArrayList<Supplement> supplementList4 = new ArrayList<Supplement>();
        supplementList4.add(backEnd.supplements.get(3));
        supplementList4.add(backEnd.supplements.get(4));
        supplementList4.add(backEnd.supplements.get(5));

        // Add standard customers
        this.backEnd.addCustomer(new Customer("Callum", "callum@gmail.com", supplementList1));
        this.backEnd.addCustomer(new Customer("Maddie", "Maddie@gmail.com", supplementList2));
        this.backEnd.addCustomer(new Customer("Dom", "Dom@gmail.com", supplementList3));
        this.backEnd.addCustomer(new Customer("Tim", "Tim@gmail.com", supplementList4));
        this.backEnd.addCustomer(new Customer("Sally", "Sally@gmail.com", supplementList2));
        this.backEnd.addCustomer(new Customer("Fin", "Fin@gmail.com", supplementList4));

        // Create lists of associated customers
        ArrayList<Customer> customerList1 = new ArrayList<Customer>();
        customerList1.add(backEnd.customers.get(0));
        customerList1.add(backEnd.customers.get(1));
        customerList1.add(backEnd.customers.get(2));
        ArrayList<Customer> customerList2 = new ArrayList<Customer>();
        customerList2.add(backEnd.customers.get(0));
        customerList2.add(backEnd.customers.get(1));
        customerList2.add(backEnd.customers.get(2));
        ArrayList<Customer> customerList3 = new ArrayList<Customer>();
        customerList3.add(backEnd.customers.get(0));
        customerList3.add(backEnd.customers.get(1));
        customerList3.add(backEnd.customers.get(2));
        ArrayList<Customer> customerList4 = new ArrayList<Customer>();
        customerList4.add(backEnd.customers.get(0));
        customerList4.add(backEnd.customers.get(1));
        customerList4.add(backEnd.customers.get(2));

        // Create paying customers;
        this.backEnd.addCustomer(new Customer("Matthew", "Matthew@gmail.com", supplementList1),
                new PaymentMethod("", new Card("Matthew", "1234 1234 1234 1234", "12/24", 232)), customerList1);
        this.backEnd.addCustomer(new Customer("Steven", "Steven@gmail.com", supplementList2),
                new PaymentMethod("", new Card("Steven", "1234 4444 1234 2222", "10/24", 513)), customerList2);
        this.backEnd.addCustomer(new Customer("Mark", "Mark@gmail.com", supplementList3),
                new PaymentMethod("", new Card("Steven", "6666 4444 3333 2222", "11/25", 765)), customerList3);
        this.backEnd.addCustomer(new Customer("Phil", "Phil@gmail.com", supplementList4),
                new PaymentMethod("", new Card("Phil", "3233 1313 1111 4344", "12/23", 748)), customerList3);
    }

}
