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
 *
 * @author callu
 */
public class MyHBox implements Serializable {

    /**
     *
     * @return
     */
    public Label getOutputLabel() {
        return outputLabel;
    }

    /**
     *
     * @param outputLabel
     */
    public void setOutputLabel(Label outputLabel) {
        this.outputLabel = outputLabel;
    }

    /**
     *
     * @return
     */
    public Button getButton() {
        return button;
    }

    /**
     *
     * @param button
     */
    public void setButton(Button button) {
        this.button = button;
    }

    /**
     *
     * @return
     */
    public TextField getInputText() {
        return inputText;
    }

    /**
     *
     * @param inputText
     */
    public void setInputText(TextField inputText) {
        this.inputText = inputText;
    }

    /**
     *
     * @return
     */
    public ChoiceBox<String> getChoice() {
        return choice;
    }

    /**
     *
     * @param choice
     */
    public void setChoice(ChoiceBox<String> choice) {
        this.choice = choice;
    }

    /**
     *
     */
    public HBox box;

    /**
     *
     */
    public Label outputLabel;

    /**
     *
     */
    public Button button;

    /**
     *
     */
    public TextField inputText;

    /**
     *
     */
    public ChoiceBox<String> choice;

    /**
     *
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
     *
     */
    public MyHBox() {
        this.outputLabel = new Label();
        this.button = new Button();
        this.inputText = new TextField();
        this.box = new HBox(this.inputText, this.button, this.outputLabel);
        this.choice = new ChoiceBox<String>();
    }

    /**
     *
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
     *
     * @param name
     */
    public void setButtonName(String name) {
        this.button.setText(name);
    }

    /**
     *
     * @param fieldValue
     */
    public void setLabelText(String fieldValue) {
        this.outputLabel.setText(fieldValue);
    }

    /**
     *
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
     *
     * @return
     */
    public HBox getBox() {
        return this.box;
    }
}
