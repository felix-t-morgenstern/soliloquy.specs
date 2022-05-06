package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.infrastructure.Pair;
import soliloquy.specs.common.infrastructure.VariableCache;
import soliloquy.specs.common.shared.SoliloquyClass;

import java.util.List;
import java.util.function.Supplier;

/**
 * <b>RoundManager</b>
 * <p>
 * This class manages rounds.
 * <p>
 * It keeps track of the current round number, the end of Characters' turns, the Character
 * currently active, the order in which Characters will act, and Characters' action points.
 * <p>
 * It handles round advancement and Timers.
 * 
 * @author felix.t.morgenstern
 *
 */
public interface RoundManager extends SoliloquyClass {
	/**
	 * @param character The Character whose presence in the queue to verify
	 * @return True, if and only if character is present in characterQueue
	 * @throws IllegalArgumentException If and only if character is null
	 */
	boolean characterIsInQueue(Character character) throws IllegalArgumentException;

	/**
	 * The queue starts at position 0, and increasing numbers designate positions further back in
	 * the queue.
	 * @param character The Character whose position in the queue to retrieve
	 * @return If character is present in the queue, then returns their order in the queue; else,
	 * null
	 * @throws IllegalArgumentException If and only if character is null
	 */
	Integer getCharacterPositionInQueue(Character character) throws IllegalArgumentException;

	/**
	 * @return The size of the queue
	 */
	int queueSize();

	/**
	 * The round-specific data for a Character is information about that Character which is only in
	 * effect for a single round, c.f. {@link #characterQueueRepresentation}.
	 * @param character The Character whose round-specific data to retrieve
	 * @return If character is present in the queue, returns their round-specific data; else, null
	 * @throws IllegalArgumentException If and only if character is null
	 */
	VariableCache characterRoundData(Character character) throws IllegalArgumentException;

	/**
	 * If character is not present in the queue, adds them at the designated location, and shifts
	 * all other Characters back to make room. If character is present in the queue, pushes them to
	 * the new position, adjusting all other positions accordingly.
	 * <p>
	 * If position is greater than the maximum position in the queue, then the Character is simply
	 * placed at the back of the queue.
	 * <p>
	 * If the Character is a new entrant into the queue, then a {@link VariableCache} with their
	 * round-specific data (c.f. {@link #characterQueueRepresentation}) will be generated by this
	 * class.
	 * <p>
	 * For Characters which are changing position, rather than being newly-added, position implies
	 * the position in the <i>current</i> queue positioning, not what the queue positioning
	 * <i>would</i> look like if that Character were removed. (So, for instance, if a Character is
	 * to be moved to the position they currently occupy, they will not move.)
	 * @param character The Character whose position in the queue to set
	 * @param position The position to assign to character
	 * @throws IllegalArgumentException If and only if character is null, or if position is less
	 * than zero
	 */
	void setCharacterPositionInQueue(Character character, int position)
			throws IllegalArgumentException;

	/**
	 * If character is not present in the queue, this method will have no effect.
	 * @param character The Character whose round-specific data to set
	 * @param roundData The round-specific data to set for character
	 * @throws IllegalArgumentException If and only if character or roundData are null
	 */
	void setCharacterRoundData(Character character, VariableCache roundData)
			throws IllegalArgumentException;

	/**
	 * @param character The Character to remove from characterQueue
	 * @return True, if and only if character was present in characterQueue (prior to being
	 * removed)
	 * @throws IllegalArgumentException If and only if character is null
	 */
	boolean removeCharacterFromQueue(Character character) throws IllegalArgumentException;

	/**
	 * Removes all {@link Character}s (and their round-specific data) from the queue
	 */
	void clearQueue();

	/**
	 * @return A read-only representation of the Character queue, where the number index to the
	 * List is the order of Characters in the queue, and the VariableCache paired with that
	 * Character describes all information about that Character that is specific to that round
	 * only, e.g. the Character's action points, whether they are spending the round in defensive
	 * mode, etc.
	 */
	List<Pair<Character, VariableCache>> characterQueueRepresentation();
	
	/**
	 * If there is an active Character, ends their turn; if there are no remaining Characters in
	 * characterOrder, starts a new round; and if there are remaining Characters in characterOrder,
	 * then sets the top Character in the queue as the active Character.
	 * <p>
	 * This method <b>does not remove</b> the active Character from the ordering. This is to
	 * support different means of a Character no longer being active; for instance, a Character may
	 * end their turn entirely, removing them from the order; but they may also delay the rest of
	 * their turn, pushing them toward the back of the queue, but not removing them from the queue.
	 * <p>
	 * Intended use case will have this method call the ActOnCharacterOnTurnAndRound methods of
	 * StatusEffectTypes and VitalAttributes.
	 */
	void endActiveCharacterTurn();
	
	/**
	 * @return The active Character; null, if no Character is active
	 */
	Character activeCharacter();
	
	/**
	 * @return The number of the Round in the game
	 */
	int getRoundNumber();
	
	/**
	 * @param roundNumber The round number to which to set the Game
	 */
	void setRoundNumber(int roundNumber);

	// NB: This _should_ be provided in the constructor, but since active character provision is a
	//     responsibility of the Ruleset module, and since the Ruleset module currently depends on
	//     the Gamestate module, this method must be exposed.
	/**
	 * @param provider The function which provides a list of active Characters, paired with the
	 *                 round-specific data associated with that Character at the start of a new
	 *                 round
	 * @throws IllegalArgumentException If and only if provider is null
	 */
	void setActiveCharactersProvider(Supplier<List<Pair<Character, VariableCache>>> provider)
			throws IllegalArgumentException;
	
	/**
	 * This method doesn't just change the arbitrary number corresponding to the rounds; it
	 * triggers any timers, status effects, etc. associated with the advancement of rounds.
	 * <p>
	 * Since the purpose of this method is to trigger movementEvents related to the progression of
	 * Rounds in the Game, it is not permitted to allow the Game to "advance" by 0 or negative
	 * rounds; use {@link #setRoundNumber} instead.
	 * <p>
	 * Intended use case will have this method call the ActOnCharacterOnTurnAndRound methods of
	 * StatusEffectTypes and VitalAttributes, and it will also check to see if Timers should be
	 * triggered by calling
	 * {@link soliloquy.specs.gamestate.entities.timers.RoundBasedTimerManager#fireTimersForRoundsElapsed}.
	 * @param numberOfRounds The number of rounds to advance
	 * @throws IllegalArgumentException If and only if numberOfRounds is 0 or negative
	 * @throws IllegalStateException If and only if {@link #setActiveCharactersProvider} has not
	 * been called
	 */
	void advanceRounds(int numberOfRounds) throws IllegalArgumentException, IllegalStateException;
}
