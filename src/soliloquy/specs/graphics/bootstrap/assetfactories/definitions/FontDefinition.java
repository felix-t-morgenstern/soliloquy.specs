package soliloquy.specs.graphics.bootstrap.assetfactories.definitions;

import soliloquy.specs.graphics.assets.Font;

/**
 * <b>FontDefinition</b>
 * <p>
 * This class defines a {@link Font}.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface FontDefinition extends AssetDefinition<Font> {
    /**
     * @return This is the relative location of the font file within the font folder
     */
    String relativeLocation();

    /**
     * @return The maximum size of the font which can be displayed without getting blurry from
     * being drawn too large (cannot be less than 0)
     */
    float maxLosslessFontSize();

    /**
     * @return The amount of padding between rendered glyphs of this Font (cannot be less than 0)
     */
    float additionalGlyphPadding();
}
