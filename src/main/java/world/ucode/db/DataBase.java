package world.ucode.db;

import world.ucode.pets.Pet;

public abstract class DataBase {
//    public abstract String[]  getCurrName();
    public abstract boolean isExistsPet(String namePet);
    public abstract Pet[] getAllPet();
    public abstract void addPet(Pet pet);
    public abstract void savePet();
}