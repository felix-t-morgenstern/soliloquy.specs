package soliloquy.specs.ruleset.entities;

import soliloquy.specs.common.infrastructure.ICollection;
import soliloquy.specs.common.shared.IHasGlobalAccess;
import soliloquy.specs.common.shared.IHasId;
import soliloquy.specs.common.infrastructure.IMap;
import soliloquy.specs.gamestate.entities.ICharacterEvent;

/**
 * <b>CharacterAI</b>
 * <p>
 * CharacterAI determines what a Character does when it is their turn to act.
 * <p>
 * CharacterAI contains parameters describing how the Character will behave, e.g. their level of
 * fear, their aggression, their current target(s)
 * <p>
 * CharacterAI describes a series of CharacterEvents which occur when certain events occur, e.g.
 * when the Character is killed, when the Character is close to death, when the demonic ritual is
 * complete
 * <p>
 * CharacterAIs may be written to and read from save files.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface ICharacterAIType extends IHasId, IHasGlobalAccess {
	/**
	 * Causes this Character to act when they are active
	 */
	void act();
	
	/**
	 * The name indices of this Map are names of the events which trigger these CharacterEvents
	 * @return A Collection of CharacterEvents which occur when certain events occur, e.g. when
	 * the Character is killed, when the Character is close to death, when the demonic ritual is
	 * complete
	 */
	IMap<String,ICollection<ICharacterEvent>> events();
}
