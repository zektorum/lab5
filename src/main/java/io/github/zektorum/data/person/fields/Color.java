package io.github.zektorum.data.person.fields;

public class Color {
    public enum HairColor {
        GREEN(0), BLUE(1), WHITE(2);

        private int value;

        HairColor(int value){
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum EyeColor {
        RED(0), BLACK(1), BLUE(2),
        ORANGE(3), BROWN(4);

        private int value;

        EyeColor(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }
}
