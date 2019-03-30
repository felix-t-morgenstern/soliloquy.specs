package soliloquy.ruleset.gameentities.specs;

/**
 * <b>StatusEffectType</b>
 * <p>
 * It has a name and id.
 * <p>
 * It has Actions, which can be performed on each Character, at the start and end of their turn,
 * and the start and end of the round.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IStatusEffectType extends IActOnCharacterOnTurnAndRound, IIconForCharacter, IGameEntity {
	/**
	 * Intended use is to return true if and only if it makes no sense for this StatusEffectType to
	 * ever go below zero. For instance, it makes no sense to have a negative amount of poisoning
	 * or disease.
	 * @return True, if and only if this StatusEffectType cannot be negative.
	 */
	boolean stopsAtZero();
	
	/**
	 * Intended use is to return the correct name for a Status Effect, depending on its value. For 
	 * instance, a StatusEffectType of "Focus" might allow negative values to represent a Character
	 * being distracted. In that case, nameAtValue(-5) might return "Distracted", whereas
	 * nameAtValue(5) might return "Alert", nameAtValue(10) might return "Highly Alert", etc.
	 * @param nonNegativeValence
	 * @return The proper name for the StatusEffectType, depending on whether its value is 
	 * non-negative.
	 * @throws UnsupportedOperationException If and only if this StatusEffectType cannot be 
	 * negative (i.e. if and only if stopsAtZero returns true)
	 */
	String nameAtValue(int value) throws UnsupportedOperationException;
}
