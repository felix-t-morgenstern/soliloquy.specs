package soliloquy.specs.game;

import soliloquy.specs.common.entities.IAction;
import soliloquy.specs.common.entities.IFunction;
import soliloquy.specs.common.valueobjects.IMap;
import soliloquy.specs.gamestate.valueobjects.IGameState;
import soliloquy.specs.logger.ILogger;
import soliloquy.specs.ruleset.IRuleset;

//TODO: Document this interface when it is finally filled out
public interface IGame {
	IGameState gameState();
	
	IRuleset ruleset();
	
	ILogger logger();

	IMap<String, IAction> actionsLibrary();

	IMap<String, IFunction> functionsLibrary();
}
