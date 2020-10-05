package world.ucode.model;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import world.ucode.pets.Cat;
import world.ucode.pets.Dog;
import world.ucode.pets.Pet;
import world.ucode.types.Types;

public class GameModel {
    public static Pet pet;
    public boolean startGame(Types.GameType gameType, Types.PetType petType, String petName) {
        if (petName.equals("vlad")) {
            return false;
        }
        if (petType == Types.PetType.CAT) {
            pet = new Cat(gameType, petName);
        } else if (petType == Types.PetType.DOG) {
            pet = new Dog(gameType, petName);
        }
        Ешьук
        AnimationTimer myLine = new Myline();
//        myLine.setCycleCount(Timeline.INDEFINITE);
//        myLine.setAutoReverse(true);
        myLine.start();
        return true;
    }

    public class Myline extends AnimationTimer {
        public void handle(long now) {
            pet.happiness -= 5;
            pet.cleanliness -= 5;
            pet.health -= 5;
            pet.hunger -= 5;
            pet.thirst -= 5;
        }
    }
}