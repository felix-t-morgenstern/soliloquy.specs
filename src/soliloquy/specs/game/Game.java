package soliloquy.specs.game;

import soliloquy.specs.common.entities.Action;
import soliloquy.specs.common.entities.Function;
import soliloquy.specs.common.infrastructure.Map;
import soliloquy.specs.gamestate.valueobjects.GameState;
import soliloquy.specs.logger.Logger;
import soliloquy.specs.ruleset.Ruleset;

//TODO: Document this interface when it is finally filled out
public interface Game {
	GameState gameState();
	
	Ruleset ruleset();
	
	Logger logger();

	Map<String, Action> actionsLibrary();

	Map<String, Function> functionsLibrary();
}
