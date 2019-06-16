package soliloquy.specs.common.factories;

import soliloquy.specs.common.valueobjects.ICoordinate;
import soliloquy.specs.common.shared.ISoliloquyClass;

/**
 * <b>CoordinateFactory</b>
 * <p>
 * Factory class, used to create Coordinates
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface ICoordinateFactory extends ISoliloquyClass {
	/**
	 * Creates a new Coordinate
	 * @param x - The x value of the new Coordinate
	 * @param y - The x value of the new Coordinate
	 * @return The new Coordinate, with the provided values
	 */
	ICoordinate make(int x, int y);
}
