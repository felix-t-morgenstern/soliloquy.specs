package soliloquy.gamestate.specs;

/**
 * <b>OneTimeTimer</b>
 * <p>
 * This is a Timer which goes off once, and is then disposed of.
 * 
 * @author felix.t.morgenstern
 *
 */
public interface IOneTimeTimer extends ITimer {
	/**
	 * This Timer will go off when the round is elapsed, via Round.advanceRounds()
	 * @return The round on which this Timer will fire
	 */
	int getRoundWhenGoesOff();
	
	/**
	 * @param roundWhenGoesOff - The round on which this Timer will fire
	 */
	void setRoundWhenGoesOff(int roundWhenGoesOff);
}
