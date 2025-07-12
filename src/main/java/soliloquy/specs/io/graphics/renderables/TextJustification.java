package soliloquy.specs.io.graphics.renderables;

public enum TextJustification {
    UNKNOWN(0),
    LEFT(1),
    CENTER(2),
    RIGHT(3);

    private final int VALUE;

    TextJustification(int value) {
        VALUE = value;
    }

    public int getValue() {
        return VALUE;
    }

    public static TextJustification fromValue(Integer value) {
        if (value == null) {
            return null;
        }
        return switch (value) {
            case 0 -> UNKNOWN;
            case 1 -> LEFT;
            case 2 -> CENTER;
            case 3 -> RIGHT;
            default -> throw new IllegalArgumentException("TextJustification: value (" + value +
                    ") does not correspond to valid enum type");
        };
    }
}
