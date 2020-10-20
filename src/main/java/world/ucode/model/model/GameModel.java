package world.ucode.Model.model;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.ArcType;
import javafx.util.Duration;
import world.ucode.Controller.load.Load;
import world.ucode.Model.db.sqlite;
import world.ucode.Controller.game.Game;
import world.ucode.Model.pets.Cat;
import world.ucode.Model.pets.Dog;
import world.ucode.Model.pets.Pet;
import world.ucode.Model.types.Types;
import world.ucode.View.View;
import world.ucode.Model.pets.DefaultPet;

import java.sql.SQLException;
import java.util.ArrayList;

public class GameModel {
    public Pet pet;
    public sqlite sql;
    private Timeline timeLineReduce;
    public Game game;
    public ArrayList<Pet> pets;
    Label[] labels;
    private int labelChoice = -1;

    public enum  actionsEvent {
        MEDICINE,
        FEED,
        PLAY,
        CLEAN,
        WATER,
    }

    public GameModel() {
        pet = new DefaultPet(Types.GameType.DEFAULT.getValue(), "def");
        game = View.loaders.get(View.SceneType.GAME_CAT).getController();
        game.playPage.setVisible(true);
        game.deadPage.setVisible(false);
        try {
            sql = new sqlite();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public Pet CreatePet(int petType, int gameType, String petName) {
        return switch (petType) {
            case 0 -> new Dog(gameType, petName);
            case 1 -> new Cat(gameType, petName);
            default -> new DefaultPet(gameType, petName);
        };
    }

    public void loadLoad() {
        pets = sql.getAllPet();
        labels = new Label[pets.size()];

        Load load = View.loaders.get(View.SceneType.LOAD).getController();
        if (pets.size() > 6) {
            load.pane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        }

        for (int i = 0; i < pets.size(); i++) {
            Pet petTmp = pets.get(i);
            labels[i] = new Label(petTmp.getName() + "\ttype: " + petTmp.getType() + "\tHP " + petTmp.getHealth() + "\t");
            labels[i].setMinWidth(600);
            labels[i].setMinHeight(100);
            labels[i].setAlignment(Pos.CENTER_LEFT);
            labels[i].setStyle("-fx-background-color: rgba(0, 0, 0, 0.3)");
            labels[i].setId(Integer.toString(i));
            labels[i].setOnMouseClicked(me -> {
                 Label curr = (Label)me.getSource();
                 this.pet = pets.get(Integer.parseInt(curr.getId()));
                 if (labelChoice != -1) {
                    labels[labelChoice].setStyle("-fx-background-color: rgba(0, 0, 0, 0.3)");
                 }
                 labelChoice = Integer.parseInt(curr.getId());
                 labels[labelChoice].setStyle("-fx-background-color: rgba(0, 0, 0, 0.6)");
            });
            AnchorPane.setTopAnchor(labels[i], (double)(i * 100));
            load.anchor.setMinHeight((i + 1) * 100);
            load.anchor.getChildren().add(labels[i]);
        }
    }

    public void toDifferentScene() {
        StopTimeLine();
    }

    public void actions(actionsEvent ae) {
        switch (ae) {
            case MEDICINE -> pet.giveMedicine();
            case PLAY -> pet.play();
            case CLEAN -> pet.cleanUp();
            case FEED -> pet.feeds();
            case WATER -> pet.giveWater();
        }
    }
    
    public boolean CreateNewPet(int gameType, int petType, String petName) {
        if (sql.isExistsPet(petName))
            return false;
        this.pet = this.CreatePet(petType, gameType, petName);
        sql.addPet(pet);
        return true;
    }

    public void delLoadLabel() {
        Load load = View.loaders.get(View.SceneType.LOAD).getController();
        for (Label label : labels) {
            load.anchor.getChildren().remove(label);
        }
        labelChoice = -1;
    }

    public void startGame() {
        System.out.println(pet.getType());
        if (pet.getType() == Types.PetType.DOG.getValue()) {
            System.out.println("dog");
            View.view(View.SceneType.GAME_DOG, "Game");
            game = View.loaders.get(View.SceneType.GAME_DOG).getController();
        } else if (pet.getType() == Types.PetType.CAT.getValue()) {
            System.out.println("cat");
            View.view(View.SceneType.GAME_CAT, "Game");
            game = View.loaders.get(View.SceneType.GAME_CAT).getController();
        }
        game.playPage.setVisible(true);
        game.deadPage.setVisible(false);
        game.nameScreen.setText(this.pet.getName());
        timeLineReduce = getTimeLineReduce();
        timeLineReduce.play();
    }

    public Timeline getTimeLineReduce() {
        Timeline timeLine = new Timeline(
                new KeyFrame(
                    Duration.millis(200),
                    event -> {
                        reduce();
                    }
                ));
        timeLine.setCycleCount(Timeline.INDEFINITE);
        return timeLine;
    };

    public void StopTimeLine() {
        timeLineReduce.stop();
    }

    public void savePet() {
        sql.savePet(pet);
    }

    public void reduce() {
        pet.setHealth(pet.getHealth() - 1);
        pet.setCleanliness(pet.getCleanliness() - 1);
        pet.setHappiness(pet.getHappiness() - 1);
        pet.setHunger(pet.getHunger() - 1);
        pet.setThirst(pet.getThirst() - 1);
        if (!checkLive()) {
            deadPet();
        }
        drawPoint(pet.getCleanliness(), game.cleanliness);
        drawPoint(pet.getHunger(), game.hunger);
        drawPoint(pet.getHappiness(), game.happiness);
        drawPoint(pet.getThirst(), game.thirst);
        drawPoint(pet.getHealth(), game.health);
    }

    public void drawPoint(double unit, Canvas obj) {
        obj.getGraphicsContext2D().clearRect(0, 0, obj.getWidth(), obj.getHeight());
        obj.getGraphicsContext2D().fillArc(0, 0, obj.getWidth(), obj.getHeight(), 180 - ((unit * pet.getUnitToDegree() - 180) / 2), unit * pet.getUnitToDegree(), ArcType.OPEN);
    }

    public void deadPet() {
        StopTimeLine();
        game.playPage.setVisible(false);
        game.deadPage.setVisible(true);
        sql.deletePet(pet);
    }

    public boolean checkLive() {
        return !(pet.getCleanliness() < 0) && !(pet.getHealth() < 0) && !(pet.getHunger() < 0) && !(pet.getThirst() < 0) && !(pet.getHappiness() < 0);
    }

    public boolean checkChoice() {
        return labelChoice != -1;
    }
}