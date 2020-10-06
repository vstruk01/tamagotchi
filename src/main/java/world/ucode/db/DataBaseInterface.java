package world.ucode.db;

import world.ucode.pets.Pet;

import java.sql.SQLException;

interface DataBase {
    String[] getCurrName();
    Pet getPet(String namePet);
    Pet[] getAllPet();
    void addPet(Pet pet) throws SQLException;
    void savePet();
}