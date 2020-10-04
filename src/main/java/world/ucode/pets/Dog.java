package world.ucode.pets;

public class Dog extends Pet {
    @Override
    public void play(int happiness) {
        System.out.println("play dog");
    }

    @Override
    public void feed(int hunger) {
        System.out.println("feed dog");
    }

    @Override
    public void giveWater(int thirst) {
        System.out.println("water dog");
    }

    @Override
    public void giveMedicine(int health) {
        System.out.println("giveMedicine dog ");
    }

    @Override
    public void cleanUp(int cleanliness) {
        System.out.println("cleanUp dog");
    }

    @Override
    public void sound(String url) {
        System.out.println("sound dog");
    }
}
