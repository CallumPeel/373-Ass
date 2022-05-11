package SupplementServices;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

/**
 * Handles user input and displays prompts to the console.
 *
 * @author Callum Peel
 */
public class FrontEndGUI implements UserInterface, java.io.Serializable{

    private BackEnd backEnd;

    /**
     * Takes a back end as a parameter and constructs a front end. Takes a
     * BackEnd and initializes it to the global variable.
     *
     * @param backEnd
     */
    public FrontEndGUI(BackEnd backEnd) {
        this.backEnd = backEnd;
        viewMode();
    }

    @Override
    public void viewMode() {
        this.backEnd.window.setTitle("Program");
        Button button = new Button();
        button.setText("Click me");
        button.setOnAction(e -> System.out.println("sup?\n"));
        this.backEnd.viewPane.getChildren().add(button);
        
        this.backEnd.scene = new Scene(this.backEnd.viewPane, 300,250);
        this.backEnd.window.setScene(this.backEnd.scene);
        this.backEnd.window.show();
    }
    
    @Override
    public void createMode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editMode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void refresh() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
