package soliloquy.specs.gamestate.entities;

public enum WallSegmentDirection {
    HORIZONTAL(1),
    CORNER(2),
    VERTICAL(3);

    private final int value;

    WallSegmentDirection(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static WallSegmentDirection fromValue(int value) {
        return switch (value) {
            case 1 -> HORIZONTAL;
            case 2 -> CORNER;
            case 3 -> VERTICAL;
            default ->
                    throw new IllegalArgumentException("TileWallSegmentDirection: value (" + value +
                            ") does not correspond to valid enum type");
        };
    }
}
