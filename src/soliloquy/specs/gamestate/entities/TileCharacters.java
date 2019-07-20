package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.infrastructure.ReadableMap;

/**
 * <b>TileCharacters</b>
 * <p>
 * This class handles Characters on a Tile. It exists to handle invariants which must be enforced,
 * since a Tile should know the Characters on it, and those Characters should know which Tile they
 * are on.
 * <p>
 * This class also supports providing a <i>representation</i> of the Characters on this Tile; i.e.,
 * a Map containing all of those Characters. <u>Editing the Map provided by
 * getCharactersRepresentation will not change the Characters on this Tile.</u> To do that, use the
 * add and remove methods, also provided.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface TileCharacters extends Deletable {
    /**
     * <i>NB: This is only supposed to be a REPRESENTATION of the Characters present on this Tile.
     * To add or remove Characters, use the other methods specified.</i>
     * @return A numbered Map of Characters, where the keys of this Map are Characters present on
     * this Tile, and the numerical values of the Map corresponds to the Z order of Characters on
     * this Tile
     */
    ReadableMap<Character,Integer> charactersRepresentation();

    /**
     * (NB: This method simply calls {@link #addCharacter(Character, int)} with a zIndex of 0)
     * @param character The Character to add onto this Tile
     * @throws IllegalArgumentException If and only if character is null
     */
    void addCharacter(Character character) throws IllegalArgumentException;

    /**
     * (NB: If multiple Characters have the same z-index, this will not cause an error; the z-index
     * only controls display order on the UI. However, if multiple Characters have the same
     * z-index, then display order will be indeterminate.)
     * @param character The Character to add onto this Tile
     * @param zIndex The z-index for this Character. (NB: This only determines display order. If
     *               multiple Characters are on the same Tile, that is not considered an error.)
     * @throws IllegalArgumentException If and only if character is null
     */
    void addCharacter(Character character, int zIndex) throws IllegalArgumentException;

    /**
     * @param character - The Character to remove
     * @return True, if and only if the Character was present, and therefore removed
     * @throws IllegalArgumentException If and only if character is null
     */
    boolean removeCharacter(Character character) throws IllegalArgumentException;

    /**
     * @param character - The Character whose z-index to return
     * @return The z-index for the provided character; null, if character is not present
     * @throws IllegalArgumentException If and only if character is null
     */
    Integer getZIndex(Character character) throws IllegalArgumentException;

    /**
     * @param character - The Character whose z-index to set
     * @param zIndex - The z-index to set for character
     * @throws IllegalArgumentException If and only if character is null, or character is not
     * present
     */
    void setZIndex(Character character, int zIndex) throws IllegalArgumentException;

    /**
     * @param character - The Character whose presence to verify
     * @return True, if and only if item is present on this Tile
     * @throws IllegalArgumentException If and only if character is null
     */
    boolean containsCharacter(Character character) throws IllegalArgumentException;
}
