package world.ucode.pets;

import world.ucode.types.Types;

public class Cat extends Pet {
    public Cat(Types.GameType gameType, String petName) {
        super(gameType, Types.PetType.CAT, petName);
    }
}
