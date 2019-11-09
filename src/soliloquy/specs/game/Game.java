package soliloquy.specs.game;

import soliloquy.specs.common.entities.Action;
import soliloquy.specs.common.entities.Function;
import soliloquy.specs.common.infrastructure.Registry;
import soliloquy.specs.gamestate.entities.gameevents.GameMovementEvent;
import soliloquy.specs.gamestate.entities.GameState;
import soliloquy.specs.logger.Logger;
import soliloquy.specs.ruleset.Ruleset;

//TODO: Document this interface when it is finally filled out
public interface Game {
	GameState gameState();
	
	Ruleset ruleset();
	
	Logger logger();

	Registry<Action> actions();

	Registry<Function> functions();

	Registry<GameMovementEvent> gameEvents();
}
