package SupplementServices;

import javafx.scene.layout.VBox;

public class MyPanel extends VBox {

    protected BackEnd backEnd;
    protected FrontEndGUI frontEnd;

    public MyPanel(BackEnd backEnd, FrontEndGUI frontEnd) {
        this.backEnd = backEnd;
        this.frontEnd = frontEnd;
    }
}
