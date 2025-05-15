package soliloquy.specs.ui.windowelements;

import soliloquy.specs.common.valueobjects.Coordinate2d;
import soliloquy.specs.gamestate.entities.Camera;
import soliloquy.specs.gamestate.entities.Tile;
import soliloquy.specs.graphics.assets.Sprite;

import java.util.Map;

// NB: This is a trash interface
//TODO: Document this interface
public interface GameWorldView {
    Camera getCamera();

    void setCamera(Camera camera);

    void refreshView();

    Map<Coordinate2d, Tile> tiles();

    // NB: The index implies the z index
    Map<Integer, Sprite> gameWorldBoxSprites();
}
