package world.ucode.Controller.settings;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import world.ucode.View.View;
import world.ucode.main.Main;


public class settings {
    @FXML
    public CheckBox sound;
    @FXML
    public CheckBox autoSave;
    @FXML
    public CheckBox save;
    @FXML
    public CheckBox exitAnswer;
    @FXML
    public Label back;


    @FXML
    public void initialize() {
        sound.setOnAction(e -> {
            if (sound.isSelected()) {
                Main.gameModel.onSound();
            } else {
                Main.gameModel.offSound();
            }
        });
        autoSave.setOnAction(e -> {
            if (autoSave.isSelected()) {
                Main.gameModel.onAutoSave();
            } else {
                Main.gameModel.offAutoSave();
            }
        });
        save.setOnAction(e -> {
            if (save.isSelected()) {
                Main.gameModel.onSave();
            } else {
                Main.gameModel.offSave();
            }
        });
        exitAnswer.setOnAction(e -> {
            if (exitAnswer.isSelected()) {
                Main.gameModel.onExitAnswer();
            } else {
                Main.gameModel.offExitAnswer();
            }
        });
        back.setOnMouseClicked(e -> {
            View.view(View.lastScene, View.lastTitle);
        });
    }
}