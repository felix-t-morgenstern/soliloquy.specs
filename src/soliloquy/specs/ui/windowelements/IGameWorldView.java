package soliloquy.specs.ui.windowelements;

import soliloquy.specs.common.valueobjects.ICoordinate;
import soliloquy.specs.common.valueobjects.IMap;
import soliloquy.specs.common.shared.ISoliloquyClass;
import soliloquy.specs.gamestate.entities.ICamera;
import soliloquy.specs.gamestate.entities.ITile;
import soliloquy.specs.sprites.entities.ISprite;

//TODO: Document this interface
public interface IGameWorldView extends ISoliloquyClass {
	ICamera getCamera();
	void setCamera(ICamera camera);
	
	void refreshView();
	
	IMap<ICoordinate, ITile> tiles();
	
	// NB: The index implies the z index
	IMap<Integer, ISprite> gameWorldBoxSprites();
}
