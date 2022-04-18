package soliloquy.specs.graphics.bootstrap.taskfactories;

import soliloquy.specs.graphics.assets.Animation;
import soliloquy.specs.graphics.assets.Image;
import soliloquy.specs.graphics.bootstrap.assetfactories.AssetFactory;
import soliloquy.specs.graphics.bootstrap.assetfactories.definitions.AnimationDefinition;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * <b>AnimationPreloaderTaskFactory</b>
 * <p>
 * This class creates a Runnable which will load an Animation when preloading all graphics (c.f.
 * {@link soliloquy.specs.graphics.bootstrap.GraphicsPreloader})
 *
 * @param <TDefinitionDto> The DTO defining the Animation to be created
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface AnimationPreloaderTaskFactory<TDefinitionDto> {
    /**
     * @param getImage A Function which gets an Image from its corresponding Id
     * @param animationDefinitionDTOs Definitions of the Animations to be created
     * @param factory Creates the Animation
     * @param processResult A function which processes each result as it is created
     * @return A Task, which, when run, will load some Animations
     * @throws IllegalArgumentException If and only if getImage, factory, animationDefinitionDTOs,
     * or processResult are null
     */
    Runnable make(Function<String, Image> getImage,
                  Collection<TDefinitionDto> animationDefinitionDTOs,
                  AssetFactory<AnimationDefinition, Animation> factory,
                  Consumer<Animation> processResult)
            throws IllegalArgumentException;
}
