package soliloquy.graphics.specs;

import soliloquy.common.specs.ICollection;
import soliloquy.common.specs.ISoliloquyClass;
import soliloquy.sprites.specs.IAnimation;

//TODO: Ensure that implementations pass ILogger into any and all generated Runnables

public interface IAnimationTicker extends ISoliloquyClass {
	/**
	 * Ticks forward all un-paused Animations by the number of millisecondsPerTick.
	 * <p>
	 * All Animations will be found in:
	 * <p><ul>
	 * <li>The Tiles of the GameWorldView (including their Grounds, Fixtures, WallSegments, and Sprites)
	 * <li>The gameWorldBoxSprites of the GameWorldView
	 * <li>The elementsByZ of the Screen
	 * </ul>
	 * <p>
	 * <i>You may wish to register all Animations on Tiles via registeredAnimations, rather than scan every Tile (and its Sprites) many times per second.</i>
	 * @param msAdvanced - The number of milliseconds by which the Game has advanced, determining by how many milliseconds each Animation must therefore be advanced
	 */
	void refreshAnimations(int msAdvanced);
	
	/**
	 * Causes all Animations to play
	 */
	void play();
	
	/**
	 * Causes all Animations to be paused
	 */
	void pause();
	
	/**
	 * @return True, if and only if all Animations are paused
	 */
	boolean isPaused();
	
	/**
	 * (You do not have to use this method, if you would rather scan every Tile for its Animations.)
	 * @return A Collection of all Animations registered to this class, which are to be animated every tick
	 */
	ICollection<IAnimation> registeredAnimations();
}
