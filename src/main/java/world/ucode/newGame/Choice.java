package world.ucode.newGame;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import world.ucode.main.Main;
import world.ucode.pets.Cat;
import world.ucode.pets.Dog;
import world.ucode.view.View;

public class Choice {
    @FXML
    public Button buttonEasy;
    @FXML
    public Button buttonMiddle;
    @FXML
    public Button buttonHard;
    @FXML
    public Label labelEasy;
    @FXML
    public Label labelMiddle;
    @FXML
    public Label labelHard;
    @FXML
    public TextField fieldName;

    @FXML
    public Button backGroundCat;
    @FXML
    public Button backGroundDog;
    @FXML
    public Label choiceCat;
    @FXML
    public Label choiceDog;
    @FXML
    public Label startGame;
    @FXML
    public Label backMenu;

    @FXML
    public Button backGroundType;
    @FXML
    public Button backGroundParam;
    @FXML
    public Label paramPet;
    @FXML
    public Label typePet;
    @FXML
    AnchorPane typeMenu;
    @FXML
    AnchorPane paramMenu;

    @FXML
    public void initialize() {
        labelEasy.setOnMouseClicked(e -> {
            buttonEasy.setOpacity(0.6);
            buttonMiddle.setOpacity(0);
            buttonHard.setOpacity(0);
        });
        labelMiddle.setOnMouseClicked(e -> {
            buttonEasy.setOpacity(0);
            buttonMiddle.setOpacity(0.6);
            buttonHard.setOpacity(0);
        });
        labelHard.setOnMouseClicked(e -> {
            buttonEasy.setOpacity(0);
            buttonMiddle.setOpacity(0);
            buttonHard.setOpacity(0.6);
        });
        startGame.setOnMouseClicked(MouseEvent -> {
//            Main.stage.setTitle("Game");
//            Main.stage.setScene(Main.scenes.get(Main.SceneType.GAME));
//            Main.stage.centerOnScreen();
            View.view(View.SceneType.GAME, "Game");
        });
        paramPet.setOnMouseClicked(MouseEvent -> {
            backGroundType.setOpacity(0);
            backGroundParam.setOpacity(0.25);
            typeMenu.setVisible(false);
            paramMenu.setVisible(true);

        });
        typePet.setOnMouseClicked(MouseEvent -> {
            backGroundType.setOpacity(0.25);
            backGroundParam.setOpacity(0);
            typeMenu.setVisible(true);
            paramMenu.setVisible(false);
        });
        choiceCat.setOnMouseClicked(MouseEvent -> {
            System.out.println("Cat");
            backGroundCat.setOpacity(0.1);
            backGroundDog.setOpacity(0);
            Main.pet = new Cat();
        });
        choiceDog.setOnMouseClicked(MouseEvent -> {
            backGroundDog.setOpacity(0.1);
            backGroundCat.setOpacity(0);
            System.out.println("Dog");
            Main.pet = new Dog();
        });
        backMenu.setOnMouseClicked(e -> {
            backGroundType.setOpacity(0.25);
            backGroundParam.setOpacity(0);
            backGroundCat.setOpacity(0);
            backGroundDog.setOpacity(0);
            fieldName.clear();
            buttonEasy.setOpacity(0);
            buttonMiddle.setOpacity(0);
            buttonHard.setOpacity(0);
            typeMenu.setVisible(true);
            paramMenu.setVisible(false);
            View.view(View.SceneType.MENU, "Cute cat of space");
        });
    }
}
