package soliloquy.specs.ruleset.entities;

import soliloquy.specs.common.infrastructure.Collection;
import soliloquy.specs.common.shared.HasGlobalAccess;
import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.common.infrastructure.Map;
import soliloquy.specs.gamestate.entities.gameevents.GameEvent;

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
public interface CharacterAIType extends HasId, HasGlobalAccess {
	/**
	 * Causes this Character to act when they are active
	 */
	void act();
	
	/**
	 * The name indices of this Map are names of the events which trigger these CharacterEvents
	 * @return A Collection of GameEvents which occur when certain events occur, e.g. when
	 * the Character is killed, when the Character is close to death, when the demonic ritual is
	 * complete
	 */
	Map<String, Collection<GameEvent>> events();
}
