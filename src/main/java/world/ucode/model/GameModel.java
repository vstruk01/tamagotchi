package world.ucode.model;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.shape.ArcType;
import javafx.util.Duration;
import world.ucode.db.sqlite;
import world.ucode.game.Game;
import world.ucode.pets.Cat;
import world.ucode.pets.Dog;
import world.ucode.pets.Pet;
import world.ucode.types.Types;
import world.ucode.view.View;

import java.sql.SQLException;

public class GameModel {
    public static Pet pet;
    public sqlite sql;
    private Timeline timeLineReduce;
    Game game;

    public boolean startGame(Types.GameType gameType, Types.PetType petType, String petName) throws SQLException, ClassNotFoundException {
        sql = new sqlite();

        if (sql.isExistsPet(petName)) {
            return false;
        }
        if (petType == Types.PetType.CAT) {
            this.pet = new Cat(gameType, petName);
        } else if (petType == Types.PetType.DOG) {
            this.pet = new Dog(gameType, petName);
        }
        game = View.loaders.get(View.SceneType.GAME).getController();
        game.nameScreen.setText(GameModel.pet.getName());
        sql.addPet(pet);
        timeLineReduce = getTimeLineReduce();
        timeLineReduce.play();
        return true;
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
        Game game = View.loaders.get(View.SceneType.GAME).getController();
        pet.cleanliness -= 1;
        pet.health -= 1;
        pet.happiness -= 1;
        pet.hunger -= 1;
        pet.thirst -= 1;
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
        return !(pet.cleanliness < 0) && !(pet.health < 0) && !(pet.hunger < 0) && !(pet.thirst < 0) && !(pet.happiness < 0);
    }
}