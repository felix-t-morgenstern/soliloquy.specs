package soliloquy.specs.gamestate.entities;

public enum WallSegmentOrientation {
    HORIZONTAL(1),
    CORNER(2),
    VERTICAL(3);

    private final int value;

    WallSegmentOrientation(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static WallSegmentOrientation fromValue(int value) {
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
