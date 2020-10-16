package world.ucode.Model.types;

public class Types {
    public enum GameType {
        HARD(0),
        MIDDLE(1),
        EASY(2),
        DEFAULT(3);

        private final int value;

        private GameType(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }
    }

    public enum PetType {
        DOG(0),
        CAT(1),
        DEFAULT(2);

        public int value;

        private PetType(int value) {
            this.value = value;
        }



        public int getValue() {
            return value;
        }
    }
}