package soliloquy.specs.graphics.assets;

/**
 * <b>SpriteSet</b>
 * <p>
 * This class defines an object which can be used to generate a
 * {@link soliloquy.specs.graphics.renderables.SpriteSetRenderable} at some location in the window.
 * It is defined one or more Images, and various snippets of those Images, corresponding to the
 * type and direction requested of this SpriteSet. (See description of
 * {@link #getImageAndBoundariesForTypeAndDirection} for more information about type and
 * direction.)
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface SpriteSet extends AssetType {
	/**
	 * @param type The type to retrieve for this SpriteSet (e.g. "CombatReady", "Attacking", etc.).
	 *             May be null, e.g. for a statue, which can face a given direction, but which has
	 *             no real variants otherwise.
	 * @param direction The direction to retrieve for this SpriteSet (e.g. "NW", "E", etc.). May be
	 *                  null, e.g. for an {@link soliloquy.specs.gamestate.entities.Item}, where it
	 *                  can either be on the ground or in inventory, but it never faces a specific
	 *                  direction
	 * @return The asset snippet for the provided type and direction
	 * @throws IllegalArgumentException If and only if type or direction correspond to an invalid
	 * value.
	 */
	AssetSnippet getImageAndBoundariesForTypeAndDirection(String type, String direction)
			throws IllegalArgumentException;
}
