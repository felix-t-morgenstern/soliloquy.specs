package soliloquy.specs.ruleset.gameconcepts;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.gamestate.entities.Character;
import soliloquy.specs.gamestate.entities.Timer;

import java.util.List;
import java.util.Map;

/**
 * <b>RoundEndHandler</b>
 * <p>
 * This class processes the effects taken on
 * {@link soliloquy.specs.gamestate.entities.CharacterDepletableStatistic}s and
 * {@link soliloquy.specs.gamestate.entities.CharacterStatusEffects} (c.f.
 * {@link soliloquy.specs.ruleset.entities.ActOnCharacterOnTurnAndRound}), and the firing of
 * {@link soliloquy.specs.gamestate.entities.Timer}, after the end of the current round, or the
 * elapsing of an arbitrary number of rounds at once.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface RoundEndHandling extends SoliloquyClass {
    /**
     * This method is called by
     * {@link soliloquy.specs.gamestate.entities.RoundManager#advanceRounds} when one or more
     * rounds are elapsed. The parameters outline the number of turn start, turn end, and round end
     * events to fire, all at once, for a number of turns or rounds for each Character equivalent
     * to the value in each of the Maps corresponding to the respective event types.
     * <p>
     * To understand this method better, imagine that walking outside of combat elapses more rounds
     * per step than a single round of combat. In that case, Characters will regenerate health,
     * mana, etc. after one step outside of combat (i.e. the number of turn/round events would be
     * higher) than they would after only a single round of combat.
     * <p>
     * This method also determines the order in which Timers, turn start/end events, and round
     * events are fired, with respect to one another. (Or, put differently, the GameState does not
     * concern itself with whether Timers are fired before or after changing the active Character,
     * or whether round end events are necessarily fired before or after turn start events; that is
     * the responsibility of the Ruleset, specifically, this class.)
     * <p>
     * (This method is intended to invoke {@link TurnHandling#onTurnStart} and
     * {@link TurnHandling#onTurnEnd}.)
     * @param turnStartEventsToFire - The number of turn start events to fire for each Character
     * @param turnEndEventsToFire - The number of turn end events to fire for each Character
     * @param roundEndEventsToFire - The number of round end events to fire for each Character
     * @param timersToFire - The timers to fire (may contain duplicate entries, e.g.
     *                     {@link soliloquy.specs.gamestate.entities.RecurringTimer}s)
     * @param activeCharacterAtRoundEnd - The active Character at the end of the previous round
     * @param activeCharacterAtStartOfNewRound - The active Character at the start of the new round
     * @throws IllegalArgumentException If and only if any of the parameters are null, or if any of
     * the keys for any of the parameters are null, or if any of the values are less than 1
     */
    void runEndOfRoundEvents(Map<Character, Integer> turnStartEventsToFire,
                             Map<Character, Integer> turnEndEventsToFire,
                             Map<Character, Integer> roundEndEventsToFire,
                             List<Timer> timersToFire,
                             Character activeCharacterAtRoundEnd,
                             Character activeCharacterAtStartOfNewRound)
            throws IllegalArgumentException;
}
