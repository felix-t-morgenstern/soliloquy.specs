package soliloquy.graphics.specs;

import soliloquy.common.specs.ISettingsRepo;

public interface IGraphics {
	IAnimationTicker animationTicker();
	
	IWindowRenderer windowRenderer();
	
	ISettingsRepo graphicsSettings();
}
