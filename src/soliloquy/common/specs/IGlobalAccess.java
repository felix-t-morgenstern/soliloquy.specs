package soliloquy.common.specs;

import soliloquy.game.primary.specs.IGame;

/**
 * <b>GlobalAccess</b>
 * <p>
 * This class indicates that this class should have global access to the Game, so it can reach out to any aspect of the Game it needs, giving it maximum flexibility.
 * <p>
 * This is intended for any class where code for anything story-related may take place (e.g. a creature's AI, a dialog box, a game zone, an action, etc.).
 * <p>
 * <i>This design feature runs the risk of being misused by developers; but the philosophy behind Soliloquy, broadly speaking, is to allow developers the flexibility to do whatever they want in their games.</i>
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IGlobalAccess extends ISoliloquyClass {
	IGame game();
}
