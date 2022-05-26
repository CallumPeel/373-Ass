package SupplementServices;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    BackEnd backEnd;
    FrontEndConsole console;
    FrontEndGUI gui;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage window) throws Exception {
        this.backEnd = new BackEnd(window);
        this.console = new FrontEndConsole(backEnd);
        this.gui = new FrontEndGUI(backEnd, 900, 850);
    }

//    public void writeToFile() throws FileNotFoundException, IOException {
//        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("bend.bin"));
//        outputStream.writeObject(this.backEnd);
//    }
//
//    public void readFile() throws FileNotFoundException, IOException, ClassNotFoundException {
//        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("bend.bin"));
//        this.backEnd = (BackEnd) inputStream.readObject();
////        System.out.println(nbend.get(0).name + " read in");
////        newCustomers.forEach(result -> System.out.println(result.name));
//    }
}
