package soliloquy.graphics.specs;

import soliloquy.common.specs.ISettingsRepo;
import soliloquy.common.specs.ISoliloquyClass;

// TODO: Document this interface
public interface IGraphics extends ISoliloquyClass {
	IAnimationTicker animationTicker();
	
	IWindowRenderer windowRenderer();
	
	ISettingsRepo graphicsSettings();
}
