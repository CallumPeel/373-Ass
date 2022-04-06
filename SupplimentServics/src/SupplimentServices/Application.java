package SupplimentServices;

/**
 *
 * @author callu
 */
public class Application {
	private BackEnd backEnd;
	private FrontEndConsole uiConsole;

    /**
     *
     */
    public Application() {
		this.backEnd = new BackEnd();
		this.uiConsole = new FrontEndConsole(this.backEnd);
	}

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
		Application app = new Application();
	}
}
