package SupplementServices;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{
        
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage window) throws Exception {
        BackEnd backEnd = new BackEnd(window);
        FrontEndConsole console = new FrontEndConsole(backEnd);
        FrontEndGUI gui = new FrontEndGUI(backEnd, 900, 850);
    }
}
