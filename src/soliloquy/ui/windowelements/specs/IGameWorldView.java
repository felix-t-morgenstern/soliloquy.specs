package soliloquy.ui.windowelements.specs;

import soliloquy.common.specs.ICoordinate;
import soliloquy.common.specs.IMap;
import soliloquy.common.specs.ISoliloquyClass;
import soliloquy.gamestate.specs.ICamera;
import soliloquy.gamestate.specs.ITile;
import soliloquy.sprites.specs.ISprite;

public interface IGameWorldView extends ISoliloquyClass {
	ICamera getCamera();
	void setCamera(ICamera camera);
	
	void refreshView();
	
	IMap<ICoordinate,ITile> tiles();
	
	// NB: The index implies the z index
	IMap<Integer,ISprite> gameWorldBoxSprites();
}
