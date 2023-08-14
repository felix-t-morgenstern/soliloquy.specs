package soliloquy.specs.gamestate.entities;

public enum WallSegmentDirection {
    NORTH(1),
    NORTHWEST(2),
    WEST(3);

    private final int value;

    WallSegmentDirection(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static WallSegmentDirection fromValue(int value) {
        return switch (value) {
            case 1 -> NORTH;
            case 2 -> NORTHWEST;
            case 3 -> WEST;
            default ->
                    throw new IllegalArgumentException("TileWallSegmentDirection: value (" + value +
                            ") does not correspond to valid enum type");
        };
    }
}
