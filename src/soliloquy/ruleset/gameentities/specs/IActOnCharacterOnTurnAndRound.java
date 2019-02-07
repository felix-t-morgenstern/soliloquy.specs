package soliloquy.ruleset.gameentities.specs;

import soliloquy.common.specs.IAction;
import soliloquy.common.specs.ISoliloquyClass;
import soliloquy.gamestate.specs.ICharacter;

/**
 * <b>IActOnCharacterOnTurnAndRound</b>
 * <p>
 * It has Actions, which can be performed on each Character, at the start and end of their turn, and the start and end of the round.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IActOnCharacterOnTurnAndRound extends ISoliloquyClass {
	/**
	 * This action is added to a list of actions to perform on all Characters at the start of the round. If it returns null, then no action is performed.
	 * @return The action to perform on each Character at the start of the round, corresponding to the entity in question
	 */
	IAction<ICharacter> onTurnStart();

	/**
	 * This action is added to a list of actions to perform on all Characters at the end of the round. If it returns null, then no action is performed.
	 * @return The action to perform on each Character at the end of the round, corresponding to the entity in question
	 */
	IAction<ICharacter> onTurnEnd();

	/**
	 * This action is added to a list of actions to perform on all Characters at the start of their turn. If it returns null, then no action is performed.
	 * @param numberOfRounds - The number of rounds whose elapsing should be considered at the start of the round.
	 * <p>
	 * For example, if the party is traveling outdoors, one movement might correspond to multiple Rounds, for purposes of determining the effect of losing bonuses or taking damage.)
	 * @return The action to perform on each Character at the start of their turn, corresponding to the entity in question
	 */
	IAction<ICharacter> onRoundStart(Integer numberOfRounds);

	/**
	 * This action is added to a list of actions to perform on all Characters at the end of their turn. If it returns null, then no action is performed.
	 * @param numberOfRounds - The number of rounds whose elapsing should be considered at the start of the round.
	 * <p>
	 * For example, if the party is traveling outdoors, one movement might correspond to multiple Rounds, for purposes of determining the effect of losing bonuses or taking damage.)
	 * @return The action to perform on each Character at the end of their turn, corresponding to the entity in question
	 */
	IAction<ICharacter> onRoundEnd(Integer numberOfRounds);
}
