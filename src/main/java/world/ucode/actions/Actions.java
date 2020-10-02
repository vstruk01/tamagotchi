package world.ucode.actions;

public interface Actions {
    void play(int happiness);
    void feed(int hunger);
    void giveWater(int thirst);
    void giveMedicine(int health);
    void cleanUp(int cleanliness);
    void sound(String url);
}
