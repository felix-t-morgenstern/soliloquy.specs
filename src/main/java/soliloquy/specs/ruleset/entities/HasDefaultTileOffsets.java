package soliloquy.specs.ruleset.entities;

import soliloquy.specs.common.valueobjects.Vertex;

/**
 * <b>HasDefaultTileOffsets</b>
 * <p>
 * This object has a default amount specifying its distance from the center of the
 * {@link soliloquy.specs.gamestate.entities.Tile} on which it's placed.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface HasDefaultTileOffsets {
    /**
     * A {@link soliloquy.specs.gamestate.entities.Tile}'s width is defined here as an x value of
     * 1.0f, and its height is defined here as a y value of 1.0f.
     *
     * @return The default offset, in the percentage of the width and height for the respective x
     * and y values of the Vertex. This offset is the amount by which an object of this type is
     * placed away from the center of the {@link soliloquy.specs.gamestate.entities.Tile}, where
     * positive amounts move that object further to the right and bottom of the window
     * respectively.
     */
    Vertex defaultTileOffset();
}
