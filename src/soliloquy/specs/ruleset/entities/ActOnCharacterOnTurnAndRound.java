package soliloquy.specs.ruleset.entities;

import soliloquy.specs.common.infrastructure.ReadablePair;
import soliloquy.specs.common.shared.HasGlobalAccess;
import soliloquy.specs.gamestate.entities.Character;

import java.util.function.BiConsumer;

/**
 * <b>ActOnCharacterOnTurnAndRound</b>
 * <p>
 * It has Actions, which can be performed on each Character, at the start and end of their turn,
 * and the start and end of the round.
 * <p>
 * The intent of these actions is to impact a Character at the start/end of their turn, or end of
 * the round, if they have a status effect. Examples include regaining spell points or health, or
 * taking damage if they are on fire, etc.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface ActOnCharacterOnTurnAndRound extends HasGlobalAccess {
	/**
	 * This method returns a pair; where the first item is the action performed on a Character at
	 * the start of their turn, for the number of turns started at one time (cf
	 * {@link soliloquy.specs.gamestate.entities.RoundManager#advanceRounds}); and the second item
	 * is the firing priority of that action.
	 * <p>
	 * (Higher firing priority implies that the event will fire first. This does not matter whether
	 * the event corresponds to a depletable statistic, or to a status effect; if you wish for all
	 * depletable statistic events to fire first, then assign a higher priority to all of those.)
	 */
	ReadablePair<BiConsumer<Character, Integer>, Integer> onTurnStart();

	/**
	 * This method returns a pair; where the first item is the action performed on a Character at
	 * the end of their turn, for the number of turns ended at one time (cf
	 * {@link soliloquy.specs.gamestate.entities.RoundManager#advanceRounds}); and the second item
	 * is the firing priority of that action.
	 * <p>
	 * (Higher firing priority implies that the event will fire first. This does not matter whether
	 * the event corresponds to a depletable statistic, or to a status effect; if you wish for all
	 * depletable statistic events to fire first, then assign a higher priority to all of those.)
	 */
	ReadablePair<BiConsumer<Character, Integer>, Integer> onTurnEnd();

	/**
	 * This method returns a pair; where the first item is the action performed on a Character at
	 * the end of a round, for the number of rounds elapsed at one time (cf
	 * {@link soliloquy.specs.gamestate.entities.RoundManager#advanceRounds}); and the second item
	 * is the firing priority of that action.
	 * <p>
	 * (Higher firing priority implies that the event will fire first. This does not matter whether
	 * the event corresponds to a depletable statistic, or to a status effect; if you wish for all
	 * depletable statistic events to fire first, then assign a higher priority to all of those.)
	 */
	ReadablePair<BiConsumer<Character, Integer>, Integer> onRoundEnd();
}
