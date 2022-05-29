/*
 * Student Name: Callum Peel
 * Student ID: 34217062
 */
package SupplementServices.Panes;

import java.io.Serializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * Creates a horizontal box containing editing elements such as a set button.
 * @author callum
 */
public class MyHBox implements Serializable {

    /**
     * Holds an HBox for further editing.
     */
    public HBox box;

    /**
     * Holds a Label for further editing.
     */
    public Label outputLabel;

    /**
     * Used to set fields.
     */
    public Button button;

    /**
     * Used in conjunction with the button to set fields.
     */
    public TextField inputText;

    /**
     * Used in conjunction with the button to set fields.
     */
    public ChoiceBox<String> choice;

    /**
     * Constructs a horizontal box containing editing elements such as a set button.
     * @param box
     * @param outputLabel
     * @param button
     * @param inputText
     * @param choice
     */
    public MyHBox(HBox box, Label outputLabel, Button button, TextField inputText, ChoiceBox<String> choice) {
        this.box = box;
        this.outputLabel = outputLabel;
        this.button = button;
        this.inputText = inputText;
        this.choice = choice;
    }

    /**
     * Constructs a horizontal box containing editing elements such as a set button.
     */
    public MyHBox() {
        this.outputLabel = new Label();
        this.button = new Button();
        this.inputText = new TextField();
        this.box = new HBox(this.inputText, this.button, this.outputLabel);
        this.choice = new ChoiceBox<String>();
    }

    /**
     * Constructs a horizontal box containing editing elements such as a set button.
     * @param choice
     */
    public MyHBox(ChoiceBox<String> choice) {
        this.outputLabel = new Label();
        this.button = new Button();
        this.inputText = new TextField();
        this.choice = choice;
        this.box = new HBox(this.choice, this.button, this.outputLabel);
    }
    
    
    /**
     * Returns the output label.
     * @return
     */
    public Label getOutputLabel() {
        return this.outputLabel;
    }

    /**
     * Sets the output label.
     * @param outputLabel
     */
    public void setOutputLabel(Label outputLabel) {
        this.outputLabel = outputLabel;
    }

    /**
     * Returns this button
     * @return
     */
    public Button getButton() {
        return button;
    }

    /**
     * Sets button value.
     * @param button
     */
    public void setButton(Button button) {
        this.button = button;
    }

    /**
     * Returns the Input text.
     * @return
     */
    public TextField getInputText() {
        return inputText;
    }

    /**
     * Sets the input text.
     * @param inputText
     */
    public void setInputText(TextField inputText) {
        this.inputText = inputText;
    }

    /**
     * Returns a drop down box.
     * @return
     */
    public ChoiceBox<String> getChoice() {
        return choice;
    }

    /**
     * Sets the drop down box.
     * @param choice
     */
    public void setChoice(ChoiceBox<String> choice) {
        this.choice = choice;
    }


    /**
     * Sets the button text.
     * @param name
     */
    public void setButtonName(String name) {
        this.button.setText(name);
    }

    /**
     * Sets the label text.
     * @param fieldValue
     */
    public void setLabelText(String fieldValue) {
        this.outputLabel.setText(fieldValue);
    }

    /**
     * Applies formatting to the HBox elements.
     */
    public void formatBox() {
        this.box.setAlignment(Pos.BASELINE_LEFT);
        this.box.setSpacing(20);
        this.box.setPadding(new Insets(5, 30, 5, 30));
        this.box.setMinWidth(400);
        this.button.setMinWidth(150);
        this.button.setMaxWidth(150);
        this.inputText.setMinWidth(100);
        this.inputText.setMaxWidth(100);
        this.choice.setMinWidth(100);
        this.choice.setMaxWidth(100);
    }

    /**
     * Returns this box.
     * @return
     */
    public HBox getBox() {
        return this.box;
    }
}
