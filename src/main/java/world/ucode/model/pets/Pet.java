package world.ucode.Model.pets;

import world.ucode.Model.types.Types;

public abstract class Pet {
    public double unitToDegree;
    public double maxUnit;
    public double health;
    public double happiness;
    public double hunger;
    public double thirst;
    public double cleanliness;
    public String name;
    private int type;
    private int typeGame;

    public double giveScale = 30;

    public Pet(int gameType, int petType, String petName) {
        this.type = petType;
        if (gameType == Types.GameType.HARD.getValue()) {
            this.setPoint(120);
        } else if (gameType == Types.GameType.MIDDLE.getValue()) {
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

    public int getType() {
        return type;
    }

    public int getTypeGame() {
        return typeGame;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void play() {
        if (this.happiness + this.giveScale >  this.maxUnit) {
            this.happiness = maxUnit;
        } else {
            this.happiness += this.giveScale;
        }
    };
    public void feeds() {
        if (this.hunger + this.giveScale >  this.maxUnit) {
            this.hunger = maxUnit;
        } else {
            this.hunger += this.giveScale;
        }
    };
    public void giveWater() {
        if (this.thirst + this.giveScale >  this.maxUnit) {
            this.thirst = maxUnit;
        } else {
            this.thirst += this.giveScale;
        }
    };
    public void giveMedicine() {
        if (this.health + this.giveScale >  this.maxUnit) {
            this.health = maxUnit;
        } else {
            this.health += this.giveScale;
        }
    };
    public void cleanUp() {
        if (this.cleanliness + this.giveScale >  this.maxUnit) {
            this.cleanliness = maxUnit;
        } else {
            this.cleanliness += this.giveScale;
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
