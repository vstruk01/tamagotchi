package world.ucode.pets;

public class Cat extends Pet {

    @Override
    public void play(int happiness) {
        System.out.println("play cat");
    }

    @Override
    public void feed(int hunger) {
        System.out.println("feed cat");
    }

    @Override
    public void giveWater(int thirst) {
        System.out.println("water cat ");
    }

    @Override
    public void giveMedicine(int health) {
        System.out.println("giveMedicine cat");
    }

    @Override
    public void cleanUp(int cleanliness) {
        System.out.println("cleanUp cat");
    }

    @Override
    public void sound(String url) {
        System.out.println("sound cat ");
    }
}
