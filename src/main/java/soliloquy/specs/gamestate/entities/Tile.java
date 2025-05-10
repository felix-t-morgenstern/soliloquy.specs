package soliloquy.specs.gamestate.entities;

import soliloquy.specs.gamestate.entities.shared.GameZoneTerrain;
import soliloquy.specs.graphics.assets.Sprite;
import soliloquy.specs.ruleset.entities.GroundType;

import java.util.Map;

/**
 * <b>Tile</b>
 * <p>
 * A Tile, which may exist at a location and a height in a GameZone.
 * <p>
 * May have a GroundType, TileFixtures, TileWallSegments, Characters, Items, ActiveAbilities,
 * ReactiveAbilities, and Sprites
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface Tile extends GameEventTargetEntity, GameZoneTerrain {
    /**
     * @return The GroundType of this Tile
     * @throws IllegalStateException If this Tile has been deleted
     */
    GroundType getGroundType() throws IllegalStateException;

    /**
     * @param groundType The GroundType to set for this Tile
     * @throws IllegalStateException If this Tile has been deleted
     */
    void setGroundType(GroundType groundType) throws IllegalStateException;

    /**
     * @return An interface for obtaining and editing the Characters on this Tile
     */
    TileEntities<Character> characters();

    /**
     * @return An interface for obtaining and editing the Items on this Tile
     */
    TileEntities<Item> items();

    /**
     * @return A numbered Map of TileFixtures, where the numerical index of the Map corresponds to
     *         the Z order of TileFixtures on this Tile
     * @throws IllegalStateException If this Tile has been deleted
     */
    TileEntities<TileFixture> fixtures() throws IllegalStateException;

    /**
     * @return A numbered Map of Sprites on this Tile, where the numerical value of the Map
     *         corresponds to the Z order of that Sprite on this Tile
     * @throws IllegalStateException If this Tile has been deleted
     */
    Map<Sprite, Integer> sprites() throws IllegalStateException;
}
