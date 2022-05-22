package SupplementServices;

import javafx.scene.layout.VBox;

public class MyPanel extends VBox {

    protected BackEnd backEnd;
    protected SceneTemplate sceneTemplate;

    public MyPanel(BackEnd backEnd, SceneTemplate sceneTemplate) {
        this.backEnd = backEnd;
        this.sceneTemplate = sceneTemplate;
    }
}
