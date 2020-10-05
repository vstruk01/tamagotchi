package world.ucode.pets;

import world.ucode.types.Types;

public abstract class Pet {
    public double unitToDegree;
    public double maxUnit;
    public double toGetUnit;
    public double health;
    public double happiness;
    public double hunger;
    public double thirst;
    public double cleanliness;
    public String name;
    public Types.PetType type;

    public Pet(Types.GameType gameType, Types.PetType petType, String petName) {
        this.type = petType;
        if (gameType == Types.GameType.HARD) {
            this.setPoint(120);
        } else if (gameType == Types.GameType.MIDDLE) {
            this.setPoint(180);
        } else {
            this.setPoint(240);
        }
        this.cleanliness = maxUnit;
        this.health = maxUnit;
        this.happiness = maxUnit;
        this.hunger = maxUnit;
        this.thirst = maxUnit;
        this.name = petName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void play() {
        if (this.happiness + this.toGetUnit >  this.maxUnit) {
            this.happiness = maxUnit;
        } else {
            this.happiness += this.toGetUnit;
        }
    };
    public void feeds() {
        if (this.hunger + this.toGetUnit >  this.maxUnit) {
            this.hunger = maxUnit;
        } else {
            this.hunger += this.toGetUnit;
        }
    };
    public void giveWater() {
        if (this.thirst + this.toGetUnit >  this.maxUnit) {
            this.thirst = maxUnit;
        } else {
            this.thirst += this.toGetUnit;
        }
    };
    public void giveMedicine() {
        if (this.health + this.toGetUnit >  this.maxUnit) {
            this.health = maxUnit;
        } else {
            this.health += this.toGetUnit;
        }
    };
    public void cleanUp() {
        if (this.cleanliness + this.toGetUnit >  this.maxUnit) {
            this.cleanliness = maxUnit;
        } else {
            this.cleanliness += this.toGetUnit;
        }
    };

    public double getHealth() {
        return health;
    }

    public double getHappiness() {
        return happiness;
    }

    public double getHunger() {
        return hunger;
    }

    public double getThirst() {
        return thirst;
    }

    public double getCleanliness() {
        return cleanliness;
    }

    public double getMaxUnit() {
        return maxUnit;
    }

    public double getUnitToDegree() {
        return unitToDegree;
    }

    public String getName() {
        return name;
    }

    public void setPoint(double unit) {
        this.maxUnit = unit;
        this.unitToDegree = 360 / maxUnit; // how much degrees per one unit

    }
}
