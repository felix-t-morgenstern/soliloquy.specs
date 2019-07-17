package soliloquy.specs.ui.windowelements;

import soliloquy.specs.common.infrastructure.Map;
import soliloquy.specs.graphics.Renderable;

//TODO: Document this interface
public interface Screen extends Renderable {
	// NB: The index is the z-index of the elements.
	//     The elements are intended to generally be boxes
	//     and sprites.
	Map<Integer, ScreenElement> elementsByZ();
	
	GameWorldView getGameWorldView();
	void setGameWorldView(GameWorldView gameWorldView);
}
