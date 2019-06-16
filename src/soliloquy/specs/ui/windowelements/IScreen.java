package soliloquy.specs.ui.windowelements;

import soliloquy.specs.common.valueobjects.IMap;
import soliloquy.specs.graphics.IRenderable;

//TODO: Document this interface
public interface IScreen extends IRenderable {
	// NB: The index is the z-index of the elements.
	//     The elements are intended to generally be boxes
	//     and sprites.
	IMap<Integer,IScreenElement> elementsByZ();
	
	IGameWorldView getGameWorldView();
	void setGameWorldView(IGameWorldView gameWorldView);
}
