package soliloquy.specs.ruleset.gameconcepts;

import soliloquy.specs.gamestate.entities.Tile;

public interface TileVisibility {
    /**
     * (Ray targets are calculated radially. The center of the origin point can be considered
     * (0.0,0.0); the tile below it would be (0.0,1.0), and so on. If the center of a Tile is within
     * a circle centered on the origin with the provided radius, then it is included among the
     * targets to be used by {@link TileVisibilityCalculation#castRay}.)
     *
     * @param point            The point at which visibility is calculated
     * @param visibilityRadius The number of Tiles away from the provided point to use as targets
     *                         when casting visibility rays. A radius of 0 implies that only the
     *                         point itself and its neighboring
     *                         {@link soliloquy.specs.gamestate.entities.WallSegment}s are visible,
     *                         and not any Tiles or WallSegments past that.
     * @return The visibility of all {@link Tile}s and
     *         {@link soliloquy.specs.gamestate.entities.WallSegment}s visible from the provided
     *         point
     * @throws IllegalArgumentException If and only if point is null, or visibilityRadius is
     *                                  negative.
     */
    TileVisibilityCalculation.Result atPoint(Tile point, int visibilityRadius)
            throws IllegalArgumentException;
}
