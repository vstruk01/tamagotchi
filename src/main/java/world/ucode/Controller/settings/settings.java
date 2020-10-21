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
            Main.gameModel.clickSound();
            if (sound.isSelected()) {
                Main.gameModel.onSound();
            } else {
                Main.gameModel.offSound();
            }
        });
        autoSave.setOnAction(e -> {
            Main.gameModel.clickSound();
            if (autoSave.isSelected()) {
                Main.gameModel.onAutoSave();
            } else {
                Main.gameModel.offAutoSave();
            }
        });
        save.setOnAction(e -> {
            Main.gameModel.clickSound();
            if (save.isSelected()) {
                Main.gameModel.onSave();
            } else {
                Main.gameModel.offSave();
            }
        });
        exitAnswer.setOnAction(e -> {
            Main.gameModel.clickSound();
            if (exitAnswer.isSelected()) {
                Main.gameModel.onExitAnswer();
            } else {
                Main.gameModel.offExitAnswer();
            }
        });
        back.setOnMouseClicked(e -> {
            Main.gameModel.clickSound();
            View.view(View.lastScene, View.lastTitle);
        });
    }
}