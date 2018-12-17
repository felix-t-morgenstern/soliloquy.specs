package soliloquy.gamestate.specs;

import soliloquy.common.specs.ICollection;
import soliloquy.common.specs.IGenericParamsSet;
import soliloquy.common.specs.IMap;
import soliloquy.common.specs.IReads;
import soliloquy.common.specs.IWrites;

/**
 * <b>CharacterAI</b>
 * <p>
 * CharacterAI determines what a Character does when it is their turn to act.
 * <p>
 * CharacterAI contains parameters describing how the Character will behave, e.g. their level of fear, their aggression, their current target(s)
 * <p>
 * CharacterAI describes a series of CharacterAIEvents which occur when certain events occur, e.g. when the Character is killed, when the Character is close to death, when the demonic ritual is complete
 * <p>
 * CharacterAIs may be written to and read from save files.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface ICharacterAI extends IReads, IWrites {
	/**
	 * Causes this Character to act when they are active
	 */
	void act();
	
	/**
	 * @return Parameters describing how the Character will behave, e.g. their level of fear, their aggression, their current target(s)
	 */
	IGenericParamsSet aiParams();
	
	/**
	 * The name indices of this Map are names of the events which trigger these CharacterAIEvents
	 * @return A Collection of CharacterAIEvents which occur when certain events occur, e.g. when the Character is killed, when the Character is close to death, when the demonic ritual is complete
	 */
	IMap<String,ICollection<ICharacterAIEvent>> events();
}
