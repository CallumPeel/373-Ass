package SupplementServices;

import javafx.scene.layout.VBox;

public class MyPanel extends VBox {

    protected BackEnd backEnd;
    protected FrontEndGUI sceneTemplate;

    public MyPanel(BackEnd backEnd, FrontEndGUI sceneTemplate) {
        this.backEnd = backEnd;
        this.sceneTemplate = sceneTemplate;
    }
}
