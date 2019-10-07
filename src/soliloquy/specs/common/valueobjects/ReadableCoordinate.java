package soliloquy.specs.common.valueobjects;

import soliloquy.specs.common.shared.Cloneable;

public interface ReadableCoordinate extends Comparable<ReadableCoordinate>, Cloneable<Coordinate> {
    /**
     * @return The x value of this coordinate
     */
    int getX();

    /**
     * @return The y value of this coordinate
     */
    int getY();
}
