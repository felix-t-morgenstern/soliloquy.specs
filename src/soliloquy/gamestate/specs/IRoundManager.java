package soliloquy.gamestate.specs;

import soliloquy.common.specs.ICollection;
import soliloquy.common.specs.IMap;
import soliloquy.common.specs.IPair;
import soliloquy.common.specs.IReads;
import soliloquy.common.specs.IWrites;

/**
 * <b>RoundManager</b>
 * <p>
 * This class manages rounds.
 * <p>
 * It keeps track of the current round number, the end of Characters' turns, the Character currently active, the order in which Characters will act, and Characters' action points.
 * <p>
 * It handles round advancement and Timers.
 * 
 * @author felix.t.morgenstern
 *
 */
public interface IRoundManager extends IReads, IWrites {
	/**
	 * @return A numbered Map of Pairs of Characters and Integers, where the number index to the Set is the order of Characters in this round (i.e. a queue), and the Integer paired with the Character is the number of action points that Character has
	 * <p>
	 * Intended use case is if a Character delays their turn, they will be pushed to the bottom of the queue, with however many action points they still have.
	 */
	IMap<Integer,IPair<ICharacter,Integer>> characterOrder();
	
	/**
	 * Ends the active Character's turn; and if this Character is the last Character to act in this round, advances the round
	 * <p>
	 * Intended use case will have this method call the ActOnCharacterOnTurnAndRound methods of StatusEffectTypes and VitalAttributes.
	 * @return The next Character to act, and their action points
	 */
	IPair<ICharacter,Integer> endActiveCharacterTurn();
	
	/**
	 * @return The Id of the active Character
	 */
	String activeCharacterId();
	
	/**
	 * @return The number of the Round in the game
	 */
	int getRoundNumber();
	
	/**
	 * @param roundNumber The round number to which to set the Game
	 * @throws IllegalArgumentException If the roundNumber is illegal, e.g. if it is negative, and the current implementation does not support negative values
	 */
	void setRoundNumber(int roundNumber) throws IllegalArgumentException;
	
	/**
	 * This method doesn't just change the arbitrary number corresponding to the rounds; it triggers any timers, status effects, etc. associated with the advancement of rounds.
	 * <p>
	 * Since the purpose of this method is to trigger events related to the progression of Rounds in the Game, it is encouraged to not allow the Game to "advance" by negative rounds, and to use getRound and setRound instead.
	 * <p>
	 * Intended use case will have this method call the ActOnCharacterOnTurnAndRound methods of StatusEffectTypes and VitalAttributes, and it will also check to see if Timers should be triggered.
	 * @param numberOfRounds The number of rounds by which to advance the Game.
	 * @throws IllegalArgumentException If the numberOfRounds is illegal, e.g. if it is negative, or if it would push the round number past the maximum value for an int
	 */
	void advanceRounds(int numberOfRounds) throws IllegalArgumentException;
	
	/**
	 * (If this property is undefined when this method is called, this method should ensure that this property is initialized.)
	 * @return A Collection of the One-Time Timers currently in effect
	 */
	ICollection<IOneTimeTimer> oneTimeTimers();
	
	/**
	 * (If this property is undefined when this method is called, this method should ensure that this property is initialized.)
	 * @return A Collection of the Recurring Timers currently in effect
	 */
	ICollection<IRecurringTimer> recurringTimers();
	
}
