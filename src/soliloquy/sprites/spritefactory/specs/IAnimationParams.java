package soliloquy.sprites.spritefactory.specs;

import soliloquy.common.specs.ICollection;
import soliloquy.common.specs.IMap;
import soliloquy.common.specs.IPair;
import soliloquy.common.specs.ISoliloquyClass;

public interface IAnimationParams extends ISoliloquyClass {
	/**
	 * @return The collection of AnimationFrameParams which define the individual frames of the Animation
	 */
	ICollection<IAnimationFrameParams> frameParams();

	/**
	 * @return True, if and only if the Animation loops after it has completed. (This is useful, for instance, with TileObjects, such as Grounds or Fixtures.)
	 */
	boolean repeats();
	
	/**
	 * @return The milliseconds which must elapse before this Animation begins playing
	 */
	int millisecondsBeforePlay();
	
	/**
	 * @return A numbered Map, where the indexes are the milliseconds at which the sounds play (after the Animation starts playing), and the values are Collections of SoundType Ids which are played at the corresponding milliseconds, and Integers which specify the volume to play the sounds at. (Intended use is as a percentage, so 100 would imply "full" volume.)
	 */
	IMap<Integer,ICollection<IPair<String,Integer>>> soundsToPlay();
}
