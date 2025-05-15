package soliloquy.specs.game;

import soliloquy.specs.gamestate.GameState;
import soliloquy.specs.gamestate.entities.gameevents.GameMovementEvent;
import soliloquy.specs.logger.Logger;
import soliloquy.specs.ruleset.Ruleset;

import java.util.Map;

//TODO: Document this interface when it is finally filled out
public interface Game {
    GameState gameState();

    Ruleset ruleset();

    Logger logger();

    Map<String, GameMovementEvent> gameEvents();
}
