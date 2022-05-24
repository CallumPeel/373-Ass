/*
 * Student Name: Callum Peel
 * Student ID: 34217062
 */
package SupplementServices;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 *
 * @author callum
 */
class MyHBox {

    public HBox box;
    public Label outputLabel;
    public Button button;
    public TextField inputText;
    ChoiceBox<String> choice;

    public MyHBox() {
        this.outputLabel = new Label();
        this.button = new Button();
        this.inputText = new TextField();
        this.box = new HBox(this.inputText, this.button, this.outputLabel);
        this.choice = new ChoiceBox<String>();
    }

    public MyHBox(ChoiceBox<String> choice) {
        this.outputLabel = new Label();
        this.button = new Button();
        this.inputText = new TextField();
        this.choice = new ChoiceBox<String>();
        this.box = new HBox(this.choice, this.button, this.outputLabel);
    }

    public void setButtonName(String name) {
        this.button.setText(name);
    }

    public void setLabelText(String fieldValue) {
        this.outputLabel.setText(fieldValue);
    }

    void formatBox() {
        this.box.setAlignment(Pos.BASELINE_LEFT);
        this.box.setSpacing(20);
        this.box.setPadding(new Insets(5, 30, 5, 30));
        this.box.setMinWidth(400);
        this.button.setMinWidth(120);
        this.button.setMaxWidth(120);
        this.inputText.setMinWidth(100);
        this.inputText.setMaxWidth(100);
    }

    public HBox getBox() {
        return this.box;
    }
}
