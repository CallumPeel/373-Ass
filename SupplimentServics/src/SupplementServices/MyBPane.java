package SupplementServices;

import java.io.Serializable;
import javafx.scene.layout.BorderPane;

public class MyBPane extends BorderPane implements Serializable  {

    protected BackEnd backEnd;
    protected FrontEndGUI frontEnd;

    public MyBPane(BackEnd backEnd, FrontEndGUI frontEnd) {
        this.backEnd = backEnd;
        this.frontEnd = frontEnd;
    }
}
