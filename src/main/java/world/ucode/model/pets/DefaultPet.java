package world.ucode.Model.pets;

import world.ucode.Model.types.Types;

public class DefaultPet extends Pet {
    public DefaultPet(int gameType, String petName) {
        super(gameType, Types.PetType.DEFAULT.getValue(), petName);
    }
}