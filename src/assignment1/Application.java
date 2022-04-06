
package assignment1;

public class Application {
	private BackEnd backEnd;
	private FrontEndConsole uiConsole;

	public Application() {
		this.backEnd = new BackEnd();
		this.uiConsole = new FrontEndConsole(this.backEnd);
	}

	public static void main(String[] args) {
		Application app = new Application();
	}
}
