package soliloquy.game.primary.specs;

import soliloquy.common.specs.IAction;
import soliloquy.common.specs.IFunction;
import soliloquy.common.specs.IMap;
import soliloquy.gamestate.specs.IGameState;
import soliloquy.logger.specs.ILogger;
import soliloquy.ruleset.primary.specs.IRuleset;

//TODO: Document this interface when it is finally filled out
public interface IGame {
	IGameState gameState();
	
	IRuleset ruleset();
	
	ILogger logger();

	IMap<String, IAction> actionsLibrary();

	IMap<String, IFunction> functionsLibrary();
}
