package world.ucode.Model.pets;

import world.ucode.Model.types.Types;

public class Dog extends Pet {
    public Dog(int gameType, String petName) {
        super(gameType, Types.PetType.DOG.getValue(), petName);
    }
}
