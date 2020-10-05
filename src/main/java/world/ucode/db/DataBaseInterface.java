package world.ucode.db;

import world.ucode.pets.Pet;

interface DataBase {
    String[] getCurrName();
    Pet getPet();
    Pet[] getAllPet();
}