package soliloquy.ui.windowelements.specs;

import soliloquy.common.specs.IMap;
import soliloquy.graphics.specs.IRenderable;

public interface IScreen extends IRenderable {
	// NB: The index is the z-index of the elements.
	//     The elements are intended to generally be boxes
	//     and sprites.
	IMap<Integer,IScreenElement> elementsByZ();
	
	IGameWorldView getGameWorldView();
	void setGameWorldView(IGameWorldView gameWorldView);
}