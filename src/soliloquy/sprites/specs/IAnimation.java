package soliloquy.sprites.specs;

import soliloquy.audio.specs.ISound;
import soliloquy.common.specs.IAction;
import soliloquy.common.specs.ICollection;
import soliloquy.common.specs.ISoliloquyClass;

public interface IAnimation extends ISoliloquyClass {

	/**
	 * @return True, if and only if the Animation loops after it has completed. (This is useful, for instance, with TileObjects, such as Grounds or Fixtures.)
	 */
	boolean repeats();
	
	void setIsRepeating(boolean isRepeating);
	
	// NB: These methods are called when the Animation is 
	//     finished. An example use-case would be dealing
	//     damage to an enemy; when the explosion ends,
	//     the attack is over.
	void setOnCompletion(IAction<Void> action);
	IAction<Void> onCompletion();
	
	int millisecondsPerFrame();
	
	int millisecondsBeforePlay();
	
	/**
	 * When the Animation is advanced by a number of milliseconds (by AnimationTicker), it will change its Frame, and start playing a Sound, if necessary
	 * @param milliseconds The number of milliseconds by which to advance this animation
	 */
	void advanceAnimation(int milliseconds);
	
	/**
	 * When an Animation is paused, it will stay in its current frame, and its associated Sounds will also be paused until the next tick from the AnimationTicker.
	 * @return True, if and only if this Animation is paused
	 */
	boolean isPaused();
	
	/**
	 * @param isPaused Whether the Animation will be paused
	 */
	void setIsPaused(boolean isPaused);
	
	/**
	 * This should either delete the Animation from wherever it was stored, or mark the Animation for deletion by the AnimationTicker
	 */
	void stop();
	
	/**
	 * This sets all of the Sounds in this Animation to have a volume of 0.
	 */
	void mute();
	
	/**
	 * This sets all of the Sounds in this Animation to have the volume they had before they were muted.
	 */
	void unmute();
	
	/**
	 * @return The milliseconds through which this Animation has played
	 */
	int getMilliseconds();
	
	/**
	 * @param milliseconds The milliseconds of progress through the Animation to set for this current Animation
	 */
	void setMilliseconds(int milliseconds);
	
	/**
	 * When a Sound in this collection is stopped (via Sound.stop()), it will be removed from this Collection.
	 * <p>
	 * When an Animation is Paused, all of the Sounds in this Collection will also be Paused.
	 * <p>
	 * This collection cannot be altered otherwise.
	 * @return A collection of the sounds playing
	 */
	ICollection<ISound> soundsPlaying();
}
