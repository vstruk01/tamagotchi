package world.ucode.pets;

import world.ucode.types.Types;

public class Dog extends Pet {
    public Dog(Types.GameType gameType, String petName) {
        super(gameType, Types.PetType.DOG, petName);
    }
}
