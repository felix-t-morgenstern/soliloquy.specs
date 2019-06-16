package soliloquy.specs.graphics;

import soliloquy.specs.common.entities.ISettingsRepo;
import soliloquy.specs.common.shared.ISoliloquyClass;

// TODO: Document this interface
public interface IGraphics extends ISoliloquyClass {
	IAnimationTicker animationTicker();
	
	IWindowRenderer windowRenderer();
	
	ISettingsRepo graphicsSettings();
}
