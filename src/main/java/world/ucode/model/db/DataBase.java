package world.ucode.Model.db;

import world.ucode.Model.pets.Pet
;
import java.util.ArrayList;

public abstract class DataBase {
    public abstract boolean isExistsPet(String namePet);
    public abstract ArrayList<Pet> getAllPet();
    public abstract void addPet(Pet pet);
    public abstract void savePet(Pet pet);
    public abstract void deletePet(Pet pet);
}