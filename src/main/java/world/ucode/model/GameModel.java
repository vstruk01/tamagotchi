package world.ucode.model;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;
import world.ucode.db.sqlite;
import world.ucode.pets.Cat;
import world.ucode.pets.Dog;
import world.ucode.pets.Pet;
import world.ucode.types.Types;
import java.sql.SQLException;

public class GameModel {
    public static Pet pet;
    public sqlite sql;

    public boolean startGame(Types.GameType gameType, Types.PetType petType, String petName) throws SQLException, ClassNotFoundException {
        if (petName.equals("vlad")) {
            return false;
        }
        if (petType == Types.PetType.CAT) {
            pet = new Cat(gameType, petName);
        } else if (petType == Types.PetType.DOG) {
            pet = new Dog(gameType, petName);
        }
//        Timeline myLine = new Timeline();
//        myLine.setCycleCount(Timeline.INDEFINITE);
//        myLine.setAutoReverse(true);
//        myLine.play();
        sql = new sqlite();
        sql.addPet(pet);
        return true;
    }

//    public Label[] loadSave() {
//        return
//    }
}