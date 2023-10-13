package soliloquy.specs.ruleset.gameconcepts;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.common.valueobjects.Coordinate2d;
import soliloquy.specs.common.valueobjects.Coordinate3d;
import soliloquy.specs.gamestate.entities.Tile;
import soliloquy.specs.gamestate.entities.WallSegmentDirection;

import java.util.Map;
import java.util.Set;

/**
 * <b>TileVisibility</b>
 * <p>
 * This class contains the rules determining whether all Tiles and Segments between two Tiles are
 * visible from one Tile to the other
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface TileVisibilityCalculation extends SoliloquyClass {
    /**
     * This method goes out from the origin tile, and checks for the visibility of all
     * {@link Tile}s and {@link soliloquy.specs.gamestate.entities.WallSegment}s between the origin
     * and the target, stopping only when visibility is blocked.
     * <p>
     * <i>NB: The first Tile above a cliff is visible, even if visibility would be blocked by that
     * cliff, as long as no visibility-blocking WallSegments go above the first Tile on the top of
     * the cliff. This is for the purpose of allowing
     * {@link soliloquy.specs.gamestate.entities.Character}s at the bottom of a cliff to at least
     * see Characters at the very edge of a cliff above them. Similarly, if the origin is at the
     * top
     * of a cliff, all Tiles and Segments which would otherwise be blocked by that cliff do not
     * block visibility. This is to ensure that a Character at the top of a cliff is capable of
     * seeing all of the Tiles and Segments beneath them at the bottom of that cliff.
     * <p>
     * Additionally, origin has a z component, since segments may block visibility differently
     * given
     * a different origin height. One quirk of origin height is that Tiles of the same height as the
     * origin Tile are always visible, unless a WallSegment blocks visibility <b>precisely</b> at
     * the height of the origin. This is to ensure that low walls (e.g. at most people's waist
     * height) do not block visibility of Tiles past that wall.</i>
     *
     * @param origin The Tile from which the check for visibility starts, i.e. where the Ray begins
     * @param target The Tile at the maximum end of the Ray
     * @return The Ray of visibility for the locations of all Tiles and WallSegments visible between
     *         the origin and the target (including the origin itself)
     * @throws IllegalArgumentException If and only if origin and target are null
     */
    Result castRay(Coordinate3d origin, Coordinate2d target) throws IllegalArgumentException;

    interface Result {
        /**
         * @return The locations of Tiles visible in this Ray
         */
        Set<Coordinate2d> tiles();

        /**
         * @return A mapping of WallSegmentDirections to the locations (c.f.
         *         {@link soliloquy.specs.gamestate.entities.GameZone#getSegments}) of visible
         *         {@link soliloquy.specs.gamestate.entities.WallSegment}s of that type
         */
        Map<WallSegmentDirection, Set<Coordinate3d>> segments();
    }
}
