package soliloquy.specs.gamestate.entities;

public enum TileWallSegmentDirection {
    NOT_FOUND(-1),
    UNKNOWN(0),
    NORTH(1),
    NORTHWEST(2),
    WEST(3);

    private int _value;

    private TileWallSegmentDirection(int value) {
        _value = value;
    }
};