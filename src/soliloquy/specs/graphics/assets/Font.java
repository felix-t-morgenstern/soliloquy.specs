package soliloquy.specs.graphics.assets;

import soliloquy.specs.graphics.rendering.FloatBox;

import java.util.Map;

public interface Font extends Asset, HasTextureId {
    // TODO: Fill this in later! Implementation details are highly likely to determine what is exposed here

    /**
     * ("UV coordinates" here refers to the coordinates within a texture uploaded to the GPU; this
     * method allows glyphs to be rendered analogously to {@link AssetSnippet}s.)
     * @param glyph The glyph for which to retrieve the UV coordinates
     * @return The UV coordinates of the provided glyph
     * @throws IllegalArgumentException If and only if glyph corresponds to an invalid character
     * (e.g. ASCII control characters, such as DEL or CR)
     */
    FloatBox getUvCoordinatesForGlyph(char glyph) throws IllegalArgumentException;

    /**
     * (C.f. {@link #getUvCoordinatesForGlyph} for more details)
     * @param glyph The glyph for which to retrieve the UV coordinates
     * @return The UV coordinates of the provided glyph
     * @throws IllegalArgumentException If and only if glyph corresponds to an invalid character
     * (e.g. ASCII control characters, such as DEL or CR)
     */
    FloatBox getUvCoordinatesForGlyphItalic(char glyph) throws IllegalArgumentException;

    /**
     * (C.f. {@link #getUvCoordinatesForGlyph} for more details)
     * @param glyph The glyph for which to retrieve the UV coordinates
     * @return The UV coordinates of the provided glyph
     * @throws IllegalArgumentException If and only if glyph corresponds to an invalid character
     * (e.g. ASCII control characters, such as DEL or CR)
     */
    FloatBox getUvCoordinatesForGlyphBold(char glyph) throws IllegalArgumentException;

    /**
     * (C.f. {@link #getUvCoordinatesForGlyph} for more details)
     * @param glyph The glyph for which to retrieve the UV coordinates
     * @return The UV coordinates of the provided glyph
     * @throws IllegalArgumentException If and only if glyph corresponds to an invalid character
     * (e.g. ASCII control characters, such as DEL or CR)
     */
    FloatBox getUvCoordinatesForGlyphBoldItalic(char glyph) throws IllegalArgumentException;

    /**
     * @return This method is used by
     * {@link soliloquy.specs.graphics.rendering.renderers.TextLineRenderer#render} to ensure that
     * glyphs with additional padding, like a 'Q' with a long tail, don't push subsequent glyphs
     * off to the right by that same amount. This method can return null.
     */
    Map<Character, Float> glyphwiseAdditionalHorizontalPadding();

    /**
     * @return The texture for this font when italicized
     */
    int textureIdItalic();

    /**
     * @return The texture for this font when bold
     */
    int textureIdBold();

    /**
     * @return The texture for this font when bold italic
     */
    int textureIdBoldItalic();
}
