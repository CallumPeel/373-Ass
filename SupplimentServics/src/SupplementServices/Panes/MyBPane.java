package SupplementServices.Panes;

import SupplementServices.BackEnd;
import SupplementServices.FrontEndGUI;
import java.io.Serializable;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author callum
 */
public class MyBPane extends BorderPane implements Serializable  {

    /**
     *
     */
    protected BackEnd backEnd;

    /**
     *
     */
    protected FrontEndGUI frontEnd;

    /**
     *
     * @param backEnd
     * @param frontEnd
     */
    public MyBPane(BackEnd backEnd, FrontEndGUI frontEnd) {
        this.backEnd = backEnd;
        this.frontEnd = frontEnd;
    }
}
