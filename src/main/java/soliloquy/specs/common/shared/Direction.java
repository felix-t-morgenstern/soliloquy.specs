package soliloquy.specs.common.shared;

public enum Direction {
    NORTH(8),
    NORTHEAST(9),
    EAST(6),
    SOUTHEAST(3),
    SOUTH(2),
    SOUTHWEST(1),
    WEST(4),
    NORTHWEST(7);

    private final int value;

    Direction(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Direction fromValue(Integer value) {
        // quoth: "null in switch cases is a preview feature and is disabled by default." Oh well.
        if (value == null) {
            return null;
        }
        return switch (value) {
            case 8 -> NORTH;
            case 9 -> NORTHEAST;
            case 6 -> EAST;
            case 3 -> SOUTHEAST;
            case 2 -> SOUTH;
            case 1 -> SOUTHWEST;
            case 4 -> WEST;
            case 7 -> NORTHWEST;
            default ->
                    throw new IllegalArgumentException("Direction: value (" + value + ") does not" +
                            " correspond to valid enum type");
        };
    }
}
