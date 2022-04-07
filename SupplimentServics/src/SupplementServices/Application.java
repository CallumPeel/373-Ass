package SupplementServices;

/**
 * Main entry to the program. Contains Front and Back End.
 * 
 * @author Callum Peel
 */
public class Application {
	private BackEnd backEnd;
	private FrontEndConsole uiConsole;
        
    /**
     * Constructs and initializes a new Application so that it has a new BackEnd and new FrontEnd
     */
    public Application() {
		this.backEnd = new BackEnd();
		this.uiConsole = new FrontEndConsole(this.backEnd);
                BackEnd d = new BackEnd();
	}

    /**
     * The main entry to the program
     * @param args
     */
    public static void main(String[] args) {
		Application app = new Application();
	}
}
