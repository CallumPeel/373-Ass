package SupplementServices;

import javafx.scene.control.Button;

public class CenterPanelEditCustomner extends CenterPanelEdit {

    public CenterPanelEditCustomner(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
        setCenterPane();
    }

    private void setCenterPane() {
        Button x = new Button(this.frontEnd.itemSelected);
        this.centerSectionPane.setCenter(x);
        setPane();
    }
}
