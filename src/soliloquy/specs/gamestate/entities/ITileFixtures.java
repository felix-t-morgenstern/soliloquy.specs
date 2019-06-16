package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.valueobjects.IMap;

/**
 * <b>TileFixtures</b>
 * <p>
 * This class handles TileFixtures present on a Tile. It exists to handle invariants which must be
 * enforced, since a Tile should know its Fixtures, and Fixtures should know their Tile. To be more
 * specific, every Fixture on a Tile should know that it belongs to that Tile, and vice-versa.
 * <p>
 * This class also supports providing a <i>representation</i> of the TileFixtures on this Tile;
 * i.e., a Map containing all of those TileFixtures. <u>Editing the Map provided by
 * getTileFixturesRepresentation will not change the TileFixtures on the Tile.</u> To do that, use
 * the add and remove methods, also provided.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface ITileFixtures extends IDeletable {
    /**
     * <i>NB: This is only supposed to be a REPRESENTATION of the TileFixtures present on this
     * Tile. To add or remove TileFixtures, use the other methods specified.</i>
     * @return A numbered Map of TileFixtures, where the keys of this Map are TileFixtures present
     * on this Tile, and the numerical values of the Map corresponds to the Z order of TileFixtures
     * on this Tile
     */
    IMap<ITileFixture,Integer> getRepresentation() throws IllegalStateException;

    /**
     * (NB: This method simply calls {@link #add(ITileFixture, int)} with a zIndex of 0)
     * @param tileFixture The TileFixture to add onto this Tile
     * @throws IllegalArgumentException If and only if tileFixture is null
     */
    void add(ITileFixture tileFixture) throws IllegalArgumentException;

    /**
     * (NB: If multiple TileFixtures have the same z-index, this will not cause an error; the
     * z-index only controls display order on the UI. However, if multiple TileFixtures have the
     * same z-index, then display order will be indeterminate.)
     * @param tileFixture The TileFixture to add onto this Tile
     * @param zIndex The z-index for this TileFixture. (NB: This only determines display order. If
     *               multiple TileFixtures are on the same Tile, that is not considered an error.)
     * @throws IllegalArgumentException If and only if tileFixture is null
     */
    void add(ITileFixture tileFixture, int zIndex) throws IllegalArgumentException;

    /**
     * @param tileFixture - The TileFixture to remove
     * @return True, if and only if the TileFixture was present, and therefore removed
     */
    boolean remove(ITileFixture tileFixture);

    /**
     * @param tileFixture - The TileFixture whose presence to verify
     * @return True, if and only if tileFixture is present in this TileFixtures
     * @throws IllegalArgumentException If and only if tileFixture is null
     */
    boolean contains(ITileFixture tileFixture) throws IllegalArgumentException;
}
