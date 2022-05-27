package SupplementServices.centerPane;

import SupplementServices.BackEnd;
import SupplementServices.FrontEndGUI;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class CenterPanelEdit extends CenterPanel {

    private Button saveButton, saveAsButton;
    private int buttonWidth;

    public CenterPanelEdit(BackEnd backEnd, FrontEndGUI frontEnd) {
        super(backEnd, frontEnd);
        this.saveButton = new Button();
        this.saveAsButton = new Button();
        this.buttonWidth = 150;
        setBottomPane();
    }

    public void setBottomPane() {
        this.saveButton.setText("Save");
        this.saveButton.setOnAction(e -> {
            try {
                onSaveChangesButtonClick();
            } catch (IOException ex) {
                Logger.getLogger(CenterPanelEdit.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        this.saveButton.setMinWidth(this.buttonWidth);
        
        this.saveAsButton.setMinWidth(this.buttonWidth);
        this.saveAsButton.setText("Save As");
        this.saveAsButton.setOnAction(e -> {
            try {
                onSaveAsChangesButtonClick();
            } catch (IOException ex) {
                Logger.getLogger(CenterPanelEdit.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        this.saveAsButton.setMinWidth(this.buttonWidth);

        HBox bottomButtons = new HBox(this.saveButton, saveAsButton);
        bottomButtons.setAlignment(Pos.CENTER);
        bottomButtons.setPadding(new Insets(15, 0, 0, 10));
        bottomButtons.setSpacing(10);
        this.centerBottomPane.setCenter(bottomButtons);
        this.centerBottomPane.setMargin(this.saveButton, new Insets(0, 0, 30, 0));
        this.centerSectionPane.setBottom(this.centerBottomPane);
    }

    public String getDirectory() {
        String fileName = "";
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("."));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Binary Files", "bin");
        fileChooser.setFileFilter(filter);
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            System.out.println(file);
            fileName = file.toString();
            if (!fileName.endsWith("bin")) {
                fileName += ".bin";
            }
            System.out.println(fileName);
        }
        return fileName;
    }

    public void onSaveAsChangesButtonClick() throws IOException {
//        this.backEnd.setFileName(getDirectory());
        this.backEnd.save(getDirectory());
    }

    public void onSaveChangesButtonClick() throws IOException {
        this.backEnd.save();
    }

    @Override
    public void setPane() {
        this.centerSectionPane.setPadding(new Insets(0, 0, 0, 15));
        this.backEnd.getEditPane().setCenter(this.centerSectionPane);
    }
}
