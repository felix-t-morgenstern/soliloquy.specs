package soliloquy.specs.ruleset.entities;

import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.common.shared.HasName;

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
}
