package SupplementServices.Panes;

import SupplementServices.BackEnd;
import SupplementServices.FrontEndGUI;
import java.io.Serializable;
import javafx.scene.layout.BorderPane;

/**
 * Creates BorderPane that takes Front End and Back End information.
 * @author callum
 */
public class MyBPane extends BorderPane implements Serializable  {

    /**
     * For use in set pane functions.
     */
    protected BackEnd backEnd;

    /**
     * For use in set pane functions.
     */
    protected FrontEndGUI frontEnd;

    /**
     * Constructs a BorderPane.
     * This class was made to deal with serializing issues but is now redundant.
     * Given more time I would remove it.
     * 
     * @param backEnd
     * @param frontEnd
     */
    public MyBPane(BackEnd backEnd, FrontEndGUI frontEnd) {
        this.backEnd = backEnd;
        this.frontEnd = frontEnd;
    }
}
