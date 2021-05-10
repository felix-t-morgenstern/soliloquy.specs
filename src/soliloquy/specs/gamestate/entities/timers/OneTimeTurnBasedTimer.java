package soliloquy.specs.gamestate.entities.timers;

/**
 * <b>OneTimeTurnBasedTimer</b>
 * <p>
 * This is a TurnBasedTimer which goes off once, and is then disposed of.
 * 
 * @author felix.t.morgenstern
 *
 */
public interface OneTimeTurnBasedTimer extends TurnBasedTimer {
	/**
	 * This TurnBasedTimer will go off when the round is elapsed, via Round.advanceRounds()
	 * @return The round on which this TurnBasedTimer will fire
	 */
	long roundWhenGoesOff();
}
