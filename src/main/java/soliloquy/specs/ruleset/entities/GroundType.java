package soliloquy.specs.ruleset.entities;

import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.common.shared.HasName;
import soliloquy.specs.common.valueobjects.Coordinate2d;
import soliloquy.specs.common.valueobjects.Coordinate3d;
import soliloquy.specs.ruleset.entities.shared.TileObjectType;

/**
 * <b>GroundType</b>
 * <p>
 * A GroundType is a type of Ground, i.e. the base of a Tile. Each Tile may have one (or no)
 * GroundType.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface GroundType extends TileObjectType, HasName, HasId {
    /**
     * @return True, if and only if a {@link soliloquy.specs.gamestate.entities.Tile} with this
     *         GroundType blocks sight through it, in which case it will form a 'ceiling' and
     *         'floor' which block lines of sight, c.f.
     *         {@link soliloquy.specs.ruleset.gameconcepts.TileVisibilityRayCalculation}
     */
    boolean blocksSight();
}
