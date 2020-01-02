package soliloquy.specs.gamestate.entities;

public enum TileWallSegmentDirection {
    NOT_FOUND(-1),
    UNKNOWN(0),
    NORTH(1),
    NORTHWEST(2),
    WEST(3);

    private final int value;

    TileWallSegmentDirection(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static TileWallSegmentDirection fromValue(int value) {
        switch(value) {
            case -1:
                return NOT_FOUND;
            case 0:
                return UNKNOWN;
            case 1:
                return NORTH;
            case 2:
                return NORTHWEST;
            case 3:
                return WEST;
            default:
                throw new IllegalArgumentException("TileWallSegmentDirection: value (" + value +
                        ") does not correspond to valid enum type");
        }
    }
}
