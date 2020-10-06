package world.ucode.model;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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


    public boolean startGame(Types.GameType gameType, Types.PetType petType, String petName) throws SQLException, ClassNotFoundException {
        sql = new sqlite();

//        if (sql.isExistsPet(petName)) {
//            return false;
//        }
        if (petType == Types.PetType.CAT) {
            pet = new Cat(gameType, petName);
        } else if (petType == Types.PetType.DOG) {
            pet = new Dog(gameType, petName);
        }
        sql.addPet(pet);
        timeLineReduce = getTimeLineReduce();
        timeLineReduce.play();
        return true;
    }

    public Timeline getTimeLineReduce() {

        Timeline timeLine = new Timeline(
                new KeyFrame(
                    Duration.millis(100),
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

    public void reduce() {
        Game game = View.loaders.get(View.SceneType.GAME).getController();
        pet.cleanliness -= 1;
        pet.health -= 1;
        pet.happiness -= 1;
        pet.hunger -= 1;
        pet.thirst -= 1;
        game.cleanliness.getGraphicsContext2D().clearRect(0, 0, 80, 80);
        game.hunger.getGraphicsContext2D().clearRect(0, 0, 80, 80);
        game.happiness.getGraphicsContext2D().clearRect(0, 0, 80, 80);
        game.thirst.getGraphicsContext2D().clearRect(0, 0, 80, 80);
        game.health.getGraphicsContext2D().clearRect(0, 0, 80, 80);

        game.cleanliness.getGraphicsContext2D().fillArc(0, 0, 80, 80, 180 - ((pet.getCleanliness()*pet.getUnitToDegree() - 180) / 2), pet.getCleanliness()*pet.getUnitToDegree(), ArcType.OPEN);
        game.hunger.getGraphicsContext2D().fillArc(0, 0, 80, 80, 180 - ((pet.getHunger()*pet.getUnitToDegree() - 180) / 2), pet.getHunger()*pet.getUnitToDegree(), ArcType.OPEN);
        game.health.getGraphicsContext2D().fillArc(0, 0, 80, 80, 180 - ((pet.getHappiness()*pet.getUnitToDegree() - 180) / 2), pet.getHealth()*pet.getUnitToDegree(), ArcType.OPEN);
        game.thirst.getGraphicsContext2D().fillArc(0, 0, 80, 80, 180 - ((pet.getThirst()*pet.getUnitToDegree() - 180) / 2), pet.getThirst()*pet.getUnitToDegree(), ArcType.OPEN);
        game.happiness.getGraphicsContext2D().fillArc(0, 0, 80, 80, 180 - ((pet.getHappiness()*pet.getUnitToDegree() - 180) / 2), pet.getHappiness()*pet.getUnitToDegree(), ArcType.OPEN);
        System.out.print("clean = ");
        System.out.println(((pet.getCleanliness()*pet.getUnitToDegree() - 180) / 2));
        System.out.println(pet.getHappiness());
        System.out.println(pet.getHunger());
        System.out.println(pet.getHealth());
        System.out.println(pet.getCleanliness());
        System.out.println(pet.getThirst());
//        View.view(View.SceneType.GAME, "Game");
    }
}