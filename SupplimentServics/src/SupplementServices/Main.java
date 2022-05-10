package SupplementServices;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{
    
    private static BackEnd backEnd;
    private FrontEndConsole console;
    private FrontEndGUI GUI;
        
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage window) throws Exception {
        this.backEnd = new BackEnd(window);
        this.console = new FrontEndConsole(this.backEnd);
        this.GUI = new FrontEndGUI(this.backEnd);
    }
}
