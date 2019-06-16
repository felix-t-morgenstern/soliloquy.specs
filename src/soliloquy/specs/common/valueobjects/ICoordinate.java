package soliloquy.specs.common.valueobjects;

import soliloquy.specs.common.shared.ICloneable;

/**
 * <b>Coordinate2d</b>
 * <p>
 * This object has both an x and a y coordinate.
 * <p>
 * A Coordinate can be compared with another coordinate. When it is thusly compared, Coordinates
 * are counted, with (0,0) as the first Coordinate, (0,1) as the second, (1,0) as the third, (0,2)
 * as the fourth, and so-on; and the difference between these two counts is used. (In this sense,
 * Coordinates with negative x or y coordinates will not be compared properly.)
 * <p>
 * <b>Coordinates are mutable, so if you pass one into a method, be sure to <u>make a copy</u> in
 * the class receiving that Coordinate as an input!</b>
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface ICoordinate extends Comparable<ICoordinate>, ICloneable<ICoordinate> {
	/**
	 * @return The x value of this coordinate
	 */
	int getX();
	
	/**
	 * @param x - The x value to set for this coordinate
	 */
	void setX(int x);
	
	/**
	 * @return The y value of this coordinate
	 */
	int getY();
	
	/**
	 * @param y - The y value to set for this coordinate
	 */
	void setY(int y);
}
