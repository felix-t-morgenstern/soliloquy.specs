package soliloquy.specs.io.graphics.renderables.colorshifting;

public enum ColorComponent {
    UNKNOWN(0),
    RED(1),
    GREEN(2),
    BLUE(3),
    ALPHA(4);

    private final int value;

    ColorComponent(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ColorComponent fromValue(int value) {
        return switch (value) {
            case 0 -> UNKNOWN;
            case 1 -> RED;
            case 2 -> GREEN;
            case 3 -> BLUE;
            case 4 -> ALPHA;
            default -> throw new IllegalArgumentException(
                    "ColorComponent: value (" + value + ") does not correspond to valid enum type");
        };
    }
}
