package world.ucode.pets;

import world.ucode.actions.*;

public abstract class Pet {
    public int health;
    public int happiness;
    public int hunger;
    public int thirst;
    public int cleanliness;
    public String name;

    public void setHealth(int health) {
        this.health = health;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void play(int happiness);
    public abstract void feed(int hunger);
    public abstract void giveWater(int thirst);
    public abstract void giveMedicine(int health);
    public abstract void cleanUp(int cleanliness);
    public abstract void sound(String url);
}
