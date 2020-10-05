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

import javax.swing.*;

public class Choice {
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
        labelEasy.setOnMouseClicked(e -> {
            labelEasy.setStyle("-fx-background-color: rgba(0, 0, 0, 0.6)");
            labelMiddle.setStyle("-fx-background-color: rgba(0, 0, 0, 0)");
            labelHard.setStyle("-fx-background-color: rgba(0, 0, 0, 0)");
        });
        labelMiddle.setOnMouseClicked(e -> {
            labelEasy.setStyle("-fx-background-color: rgba(0, 0, 0, 0)");
            labelMiddle.setStyle("-fx-background-color: rgba(0, 0, 0, 0.6)");
            labelHard.setStyle("-fx-background-color: rgba(0, 0, 0, 0)");
        });
        labelHard.setOnMouseClicked(e -> {
            labelEasy.setStyle("-fx-background-color: rgba(0, 0, 0, 0)");
            labelMiddle.setStyle("-fx-background-color: rgba(0, 0, 0, 0)");
            labelHard.setStyle("-fx-background-color: rgba(0, 0, 0, 0.6)");
        });
        startGame.setOnMouseClicked(MouseEvent -> {
            if (fieldName.getText().equals("vlad")) {
                errorName.setVisible(true);
                return;
            }
            System.out.println(fieldName.getText());
            defaultSettings();
            View.view(View.SceneType.GAME, "Game");
        });
        paramPet.setOnMouseClicked(MouseEvent -> {
            typePet.setStyle("-fx-background-color: rgba(255, 255, 255, 0)");
            paramPet.setStyle("-fx-background-color: rgba(255, 255, 255, 0.25)");
            typeMenu.setVisible(false);
            paramMenu.setVisible(true);

        });
        typePet.setOnMouseClicked(MouseEvent -> {
            typePet.setStyle("-fx-background-color: rgba(255, 255, 255, 0.25)");
            paramPet.setStyle("-fx-background-color: rgba(255, 255, 255, 0)");
            typeMenu.setVisible(true);
            paramMenu.setVisible(false);
        });
        choiceCat.setOnMouseClicked(MouseEvent -> {
            System.out.println("Cat");
            choiceCat.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4)");
            choiceDog.setStyle("-fx-background-color: rgba(0, 0, 0, 0)");
            Main.pet = new Cat();
        });
        choiceDog.setOnMouseClicked(MouseEvent -> {
            choiceCat.setStyle("-fx-background-color: rgba(0, 0, 0, 0)");
            choiceDog.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4)");
            System.out.println("Dog");
            Main.pet = new Dog();
        });
        backMenu.setOnMouseClicked(e -> {
            defaultSettings();
            View.view(View.SceneType.MENU, "Cute cat of space");
        });
    }

    private void defaultSettings() {
        typePet.setStyle("-fx-background-color: rgba(255, 255, 255, 0.25)");
        paramPet.setStyle("-fx-background-color: rgba(255, 255, 255, 0)");
        choiceCat.setStyle("-fx-background-color: rgba(255, 255, 255, 0)");
        choiceDog.setStyle("-fx-background-color: rgba(255, 255, 255, 0)");
        labelEasy.setStyle("-fx-background-color: rgba(0, 0, 0, 0)");
        labelMiddle.setStyle("-fx-background-color: rgba(0, 0, 0, 0)");
        labelHard.setStyle("-fx-background-color: rgba(0, 0, 0, 0)");
        fieldName.clear();
        typeMenu.setVisible(true);
        paramMenu.setVisible(false);
        errorName.setVisible(false);
    }
}
