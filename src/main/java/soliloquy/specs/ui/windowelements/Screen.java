package soliloquy.specs.ui.windowelements;

import soliloquy.specs.io.graphics.renderables.Renderable;

import java.util.Map;

//TODO: Document this interface
public interface Screen extends Renderable {
    // NB: The index is the z-index of the elements.
    //     The elements are intended to generally be boxes
    //     and sprites.
    Map<Integer, ScreenElement> elementsByZ();

    GameWorldView getGameWorldView();

    void setGameWorldView(GameWorldView gameWorldView);
}
