package soliloquy.specs.gamestate.entities;

import soliloquy.specs.ruleset.entities.ICharacterEventType;

/**
 * <b>CharacterEvent</b>
 * <p>
 * A CharacterEvent is a behavior that occurs when a designated event (in CharacterAI.events)
 * happens to a Character.
 * <p>
 * A CharacterEvent has a priority. If the CharacterAI has multiple CharacterEvents for the same 
 * event type, the events are triggered in order of their priority.
 * <p>
 * If there are multiple CharacterEvents for a single event type, a CharacterEvent can prevent
 * CharacterEvents with lower priorities from firing.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface ICharacterEvent extends IDeletable {
	/**
	 * @return The type of this Character Event. CharacterEventTypes must be instantiated as a part
	 * of the Ruleset, so they can be saved to file and loaded back up again.
	 */
	ICharacterEventType characterEventType();
	
	/**
	 * @return The priority of this event.
	 * <p>
	 * If there are multiple CharacterEvents for the same event type, the ones with higher
	 * priority fire first.
	 */
	int getPriority();
	
	/**
	 * @param priority - The priority to set for this CharacterEvent
	 * <p>
	 * If there are multiple CharacterEvents for the same event type, the ones with higher
	 * priority fire first.
	 */
	void setPriority(int priority);
	
	/**
	 * @return True, if and only if this CharacterEvent blocks CharacterEvents with lower
	 * priorities from firing
	 */
	boolean getBlocksSubsequentEvents();
	
	/**
	 * @param blocksSubsequentEvents - Whether this CharacterEvent will block CharacterEvents
	 * with lower priorities from firing
	 */
	void setBlocksSubsequentEvents(boolean blocksSubsequentEvents);
}
