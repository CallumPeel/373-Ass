package SupplementServices;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    private BackEnd backEnd;
    private FrontEndConsole console;
    private FrontEndGUI gui;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage window) throws Exception {
        this.backEnd = new BackEnd(window);
        this.console = new FrontEndConsole(backEnd);
        this.gui = new FrontEndGUI(backEnd, 900, 850);
    }
}
