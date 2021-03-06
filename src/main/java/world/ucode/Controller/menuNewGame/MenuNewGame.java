package world.ucode.Controller.menuNewGame;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.sql.SQLException;

import world.ucode.main.Main;
import world.ucode.Model.types.Types;
import world.ucode.View.View;

public class MenuNewGame {
    public Types.GameType gameType = Types.GameType.DEFAULT;
    public Types.PetType petType = Types.PetType.DEFAULT;

    @FXML
    public Label labelEasy;
    @FXML
    public Label labelMiddle;
    @FXML
    public Label labelHard;
    @FXML
    public TextField fieldName;

    @FXML
    public Label choiceCat;
    @FXML
    public Label choiceDog;
    @FXML
    public Label startGame;
    @FXML
    public Label backMenu;

    @FXML
    public Label paramPet;
    @FXML
    public Label typePet;
    @FXML
    AnchorPane typeMenu;
    @FXML
    AnchorPane paramMenu;

    @FXML
    Label errorName;

    @FXML
    public void initialize() {
        fieldName.setFocusTraversable(false);

        labelEasy.setOnMouseClicked(e -> {
            Main.gameModel.clickSound();
            labelEasy.setStyle("-fx-background-color: rgba(0, 0, 0, 0.6)");
            labelMiddle.setStyle("-fx-background-color: rgba(0, 0, 0, 0.3)");
            labelHard.setStyle("-fx-background-color: rgba(0, 0, 0, 0.3)");
            gameType = Types.GameType.EASY;
        });
        labelMiddle.setOnMouseClicked(e -> {
            Main.gameModel.clickSound();
            labelEasy.setStyle("-fx-background-color: rgba(0, 0, 0, 0.3)");
            labelMiddle.setStyle("-fx-background-color: rgba(0, 0, 0, 0.6)");
            labelHard.setStyle("-fx-background-color: rgba(0, 0, 0, 0.3)");
            gameType = Types.GameType.MIDDLE;
        });
        labelHard.setOnMouseClicked(e -> {
            Main.gameModel.clickSound();
            labelEasy.setStyle("-fx-background-color: rgba(0, 0, 0, 0.3)");
            labelMiddle.setStyle("-fx-background-color: rgba(0, 0, 0, 0.3)");
            labelHard.setStyle("-fx-background-color: rgba(0, 0, 0, 0.6)");
            gameType = Types.GameType.HARD;
        });

        startGame.setOnMouseClicked(MouseEvent -> {
            Main.gameModel.clickSound();
            if (petType == Types.PetType.DEFAULT) {
                toType();
            } else if (gameType == Types.GameType.DEFAULT || fieldName.getText().equals("")) {
                toParam();
            } else {
                if (Main.gameModel.CreateNewPet(gameType.getValue(), petType.getValue(), fieldName.getText())) {
                    defaultSettings();
                    Main.gameModel.startGame();
                } else {
                    errorName.setVisible(true);
                    toParam();
                }
            }
        });

        paramPet.setOnMouseClicked(MouseEvent -> {
            Main.gameModel.clickSound();
            toParam();
        });
        typePet.setOnMouseClicked(MouseEvent -> {
            Main.gameModel.clickSound();
            toType();
        });
        choiceCat.setOnMouseClicked(MouseEvent -> {
            Main.gameModel.clickSound();
            choiceCat.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4)");
            choiceDog.setStyle("-fx-background-color: rgba(0, 0, 0, 0)");
            petType = Types.PetType.CAT;
        });
        choiceDog.setOnMouseClicked(MouseEvent -> {
            Main.gameModel.clickSound();
            choiceCat.setStyle("-fx-background-color: rgba(0, 0, 0, 0)");
            choiceDog.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4)");
            petType = Types.PetType.DOG;
        });
        backMenu.setOnMouseClicked(e -> {
            Main.gameModel.clickSound();
            defaultSettings();
            View.view(View.SceneType.MENU, "Cute cat of space");
        });
    }

    private void defaultSettings() {
        typePet.setStyle("-fx-background-color: rgba(255, 255, 255, 0.25)");
        paramPet.setStyle("-fx-background-color: rgba(255, 255, 255, 0)");
        choiceCat.setStyle("-fx-background-color: rgba(255, 255, 255, 0)");
        choiceDog.setStyle("-fx-background-color: rgba(255, 255, 255, 0)");
        labelEasy.setStyle("-fx-background-color: rgba(0, 0, 0, 0.3)");
        labelMiddle.setStyle("-fx-background-color: rgba(0, 0, 0, 0.3)");
        labelHard.setStyle("-fx-background-color: rgba(0, 0, 0, 0.3)");
        fieldName.clear();
        typeMenu.setVisible(true);
        paramMenu.setVisible(false);
        errorName.setVisible(false);
    }

    private void toParam() {
        typePet.setStyle("-fx-background-color: rgba(255, 255, 255, 0)");
        paramPet.setStyle("-fx-background-color: rgba(255, 255, 255, 0.25)");
        typeMenu.setVisible(false);
        paramMenu.setVisible(true);
    }

    private void toType() {
        typePet.setStyle("-fx-background-color: rgba(255, 255, 255, 0.25)");
        paramPet.setStyle("-fx-background-color: rgba(255, 255, 255, 0)");
        typeMenu.setVisible(true);
        paramMenu.setVisible(false);
        errorName.setVisible(false);
    }
}
