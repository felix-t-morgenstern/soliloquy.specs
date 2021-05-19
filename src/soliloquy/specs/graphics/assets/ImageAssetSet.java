package soliloquy.specs.graphics.assets;

/**
 * <b>ImageAssetSet</b>
 * <p>
 * This class defines an object which can be used to generate a
 * {@link soliloquy.specs.graphics.renderables.ImageAssetSetRenderable} at some location in the
 * window. It is defined one or more Images, and various snippets of those Images, corresponding to
 * the type and direction requested of this ImageAssetSet. (See description of
 * {@link #getImageAssetForTypeAndDirection} for more information about type and
 * direction.)
 * <p>
 * This class can be thought of as a sprite set, except it supports both static {@link Sprite}s and
 * {@link Animation}s (c.f. {@link ImageAsset}).
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface ImageAssetSet extends Asset {
	/**
	 * NB: Null and empty values are treated as identical. Both may be null and/or empty.
	 * @param type The type to retrieve for this ImageAssetSet (e.g. "CombatReady", "Attacking", etc.).
	 *             May be null, e.g. for a statue, which can face a given direction, but which has
	 *             no real variants otherwise.
	 * @param direction The direction to retrieve for this ImageAssetSet (e.g. "NW", "E", etc.). May be
	 *                  null, e.g. for an {@link soliloquy.specs.gamestate.entities.Item}, where it
	 *                  can either be on the ground or in inventory, but it never faces a specific
	 *                  direction
	 * @return The Sprite or Animation for the provided type and direction
	 * @throws IllegalArgumentException If and only if type or direction correspond to a
	 * combination that does not exist in this ImageAssetSet.
	 */
	ImageAsset getImageAssetForTypeAndDirection(String type, String direction)
			throws IllegalArgumentException;

	/**
	 * <i>NB: This method is used to ensure that
	 * {@link soliloquy.specs.graphics.renderables.ImageAssetSetRenderable}s intended to support
	 * mouse event capturing only accept ImageAssetSets which support mouse event capturing.</i>
	 * @return True, if and only if this ImageAssetSet supports mouse event capturing
	 */
	boolean capturesMouseEvents();
}
