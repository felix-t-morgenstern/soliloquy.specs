package soliloquy.gamestate.specs;

import soliloquy.common.specs.IGenericParamsSet;
import soliloquy.common.specs.IHasId;

/**
 * <b>CharacterAIEvent</b>
 * <p>
 * A CharacterAIEvent is a behavior that occurs when a designated event (in CharacterAI.events)
 * happens to a Character.
 * <p>
 * A CharacterAIEvent has a priority. If the CharacterAI has multiple CharacterAIEvents for the
 * same event type, the events are triggered in order of their priority.
 * <p>
 * If there are multiple CharacterAIEvents for a single event type, a CharacterAIEvent can prevent
 * CharacterAIEvents with lower priorities from firing.
 * <p>
 * This interface exists because CharacterAIEvents must be identified by name, and they must have
 * the exact same behavior, so they can be successfully saved to files and read from files without
 * losing any information about them.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface ICharacterAIEvent extends IHasId {
	/**
	 * @return The priority of this event.
	 * <p>
	 * If there are multiple CharacterAIEvents for the same event type, the ones with higher
	 * priority fire first.
	 */
	int getPriority();
	
	/**
	 * @param priority - The priority to set for this CharacterAIEvent
	 * <p>
	 * If there are multiple CharacterAIEvents for the same event type, the ones with higher
	 * priority fire first.
	 */
	void setPriority(int priority);
	
	/**
	 * @return True, if and only if this CharacterAIEvent blocks CharacterAIEvents with lower
	 * priorities from firing
	 */
	boolean getBlocksSubsequentEvents();
	
	/**
	 * @param blocksSubsequentEvents - Whether this CharacterAIEvent will block CharacterAIEvents
	 * with lower priorities from firing
	 */
	void setBlocksSubsequentEvents(boolean blocksSubsequentEvents);
	
	/**
	 * The function which is executed when this CharacterAIEvent is fired
	 * @param params - Parameters specifying how this CharacterAIEvent will behave, e.g. which
	 * Character killed this Character, which Tile's trap went off to kill this Character, the Tile
	 * this Character will turn to face
	 */
	void onFire(IGenericParamsSet params);
}
