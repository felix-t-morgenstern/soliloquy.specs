package soliloquy.common.specs;

import soliloquy.game.primary.specs.IGame;

/**
 * <b>AdditionalSetupSteps</b>
 * <p>
 * This class contains a singular method, which acts on the Game. The intended use of this class is
 * to be a possible extension of the AbstractModule class for each module; if the AbstractModule
 * class implements this interface, then the Game will know to execute runAdditionalSteps during
 * initial setup.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IAdditionalSetupSteps {
	/**
	 * @param game The Game (for which additional setup steps will be taken)
	 */
	void runAdditionalSteps(IGame game);
}
