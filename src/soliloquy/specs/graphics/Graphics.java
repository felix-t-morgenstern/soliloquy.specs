package soliloquy.specs.graphics;

import soliloquy.specs.common.infrastructure.SettingsRepo;
import soliloquy.specs.common.shared.SoliloquyClass;

// TODO: Document this interface
public interface Graphics extends SoliloquyClass {
	AnimationTicker animationTicker();
	
	WindowRenderer windowRenderer();
	
	SettingsRepo graphicsSettings();
}
