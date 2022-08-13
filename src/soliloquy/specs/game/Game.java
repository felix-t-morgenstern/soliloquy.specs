package soliloquy.specs.game;

import soliloquy.specs.common.infrastructure.Registry;
import soliloquy.specs.gamestate.GameState;
import soliloquy.specs.gamestate.entities.gameevents.GameMovementEvent;
import soliloquy.specs.logger.Logger;
import soliloquy.specs.ruleset.Ruleset;

//TODO: Document this interface when it is finally filled out
public interface Game {
    GameState gameState();

    Ruleset ruleset();

    Logger logger();

    Registry<GameMovementEvent> gameEvents();
}
