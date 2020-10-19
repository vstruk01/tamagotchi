package world.ucode.Model.pets;

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

    public double giveScale;

    public Pet(int typeGame, int petType, String petName) {
        this.type = petType;
        this.typeGame = typeGame;
        switch (typeGame) {
            case 0:
                this.setPoint(120);
                break;
            case 1:
                this.setPoint(180);
                break;
            case 2:
                this.setPoint(240);
                break;
            default:
                this.setPoint(200);
                break;
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

    //setters
    public void setCleanliness(double cleanliness) {
        this.cleanliness = cleanliness;
    }


    public void setHappiness(double happiness) {
        this.happiness = happiness;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public void setHunger(double hunger) {
        this.hunger = hunger;
    }

    public void setThirst(double thirst) {
        this.thirst = thirst;
    }

    public void setGiveScale(double giveScale) {
        this.giveScale = giveScale;
    }

    // getters
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
        this.giveScale = maxUnit * 0.1;
    }
}
