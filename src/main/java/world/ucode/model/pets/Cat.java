package world.ucode.Model.pets;

import world.ucode.Model.types.Types;

public class Cat extends Pet {
    public Cat(Types.GameType gameType, String petName) {
        super(gameType, Types.PetType.CAT, petName);
    }
}
