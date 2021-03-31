package soliloquy.specs.graphics.assets;

import soliloquy.specs.graphics.rendering.FloatBox;

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
     * @return The texture for this font when italicized
     */
    int textureIdItalic();

    /**
     * @return The texture for this font when bold
     */
    int textureIdBold();
}
