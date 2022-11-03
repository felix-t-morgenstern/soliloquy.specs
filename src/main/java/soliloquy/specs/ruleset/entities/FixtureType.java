package soliloquy.specs.ruleset.entities;

import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.common.shared.HasName;

/**
 * <b>FixtureType</b>
 * <p>
 * This is a type of static object on a Tile which is not a Character and which cannot be picked
 * up, e.g. shrubberies, chairs, piles of skulls, commodes
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface FixtureType extends HasDefaultTileOffsets, TileObjectType, HasName, HasId {
    /**
     * @return True, if and only if this FixtureType is a container (e.g. chests, bookshelves,
     *         corpses, secret cracks in the floor)
     */
    boolean isContainer();
}
