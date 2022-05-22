package SupplementServices;

import javafx.scene.layout.VBox;

public class MyPanel extends VBox {

    protected BackEnd backEnd;
    protected GUITemplate sceneTemplate;

    public MyPanel(BackEnd backEnd, GUITemplate sceneTemplate) {
        this.backEnd = backEnd;
        this.sceneTemplate = sceneTemplate;
    }
}
