package SupplementServices;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class MyPopup {

    public MyPopup(String msg) {
        Stage newstage = new Stage();
        newstage.setTitle("");
        final Popup popup = new Popup();
        popup.setX(300);
        popup.setY(200);
        HBox layout = new HBox(10);
        Label error = new Label(msg);
        layout.getChildren().add(error);
        error.setPadding(new Insets(10));
        error.setFont(new Font("Arial", 20));
        newstage.setScene(new Scene(layout));
        newstage.show();
    }
}
