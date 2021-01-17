package soliloquy.specs.common.valueobjects;

import soliloquy.specs.common.shared.Cloneable;

/**
 * <b>ReadableCoordinate</b>
 * <p>
 * This class defines a read-only (x,y) coordinate. (If you want the coordinate to be mutable, use
 * {@link Coordinate}.)
 * <p>
 * There exists a factory to produce this class, but it is also open to instantiation as an
 * anonymous class.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
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
