package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.shared.HasName;
import soliloquy.specs.common.shared.HasUuid;
import soliloquy.specs.gamestate.entities.exceptions.EntityDeletedException;
import soliloquy.specs.ruleset.entities.FixtureType;

/**
 * <b>TileFixture</b>
 * <p>
 * A TileFixture is an object (that is not a Character or an Item) on a Tile.
 * <p>
 * Has a FixtureType.
 * <p>
 * May have contained Items, if it its FixtureType is a container.
 * <p>
 * May have a pixel offset.
 * <p>
 * May have Active and Reactive Abilities.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface TileFixture extends GameEventTargetEntity, TileEntity, HasTileOffsets, HasName,
		HasUuid {
	/**
	 * @return The FixtureType of this TileFixture
	 * @throws IllegalStateException If it has no FixtureType
	 * @throws EntityDeletedException If this TileFixture has been deleted
	 */
	FixtureType type() throws IllegalStateException, EntityDeletedException;

	/**
	 * @return A class by which items contained in this fixture may be accessed and altered
	 * @throws IllegalStateException If it has no FixtureType
	 * @throws EntityDeletedException If this TileFixture has been deleted
	 */
	TileFixtureItems items() throws IllegalStateException, EntityDeletedException;
}
