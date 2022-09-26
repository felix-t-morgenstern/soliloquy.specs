package soliloquy.specs.common.factories;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.common.valueobjects.Coordinate;

/**
 * <b>CoordinateFactory</b>
 * <p>
 * Factory class, used to create Coordinates
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface CoordinateFactory extends SoliloquyClass {
    /**
     * Creates a new Coordinate
     *
     * @param x The x value of the new Coordinate
     * @param y The x value of the new Coordinate
     * @return The new Coordinate, with the provided values
     */
    Coordinate make(int x, int y);
}
