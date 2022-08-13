package soliloquy.specs.ui.windowelements;

import soliloquy.specs.common.infrastructure.Map;
import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.common.valueobjects.Coordinate;
import soliloquy.specs.gamestate.entities.Camera;
import soliloquy.specs.gamestate.entities.Tile;
import soliloquy.specs.graphics.assets.Sprite;

// NB: This is a trash interface
//TODO: Document this interface
public interface GameWorldView extends SoliloquyClass {
    Camera getCamera();

    void setCamera(Camera camera);

    void refreshView();

    Map<Coordinate, Tile> tiles();

    // NB: The index implies the z index
    Map<Integer, Sprite> gameWorldBoxSprites();
}
