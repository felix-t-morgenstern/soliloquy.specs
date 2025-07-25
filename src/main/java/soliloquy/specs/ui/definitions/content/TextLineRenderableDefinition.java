package soliloquy.specs.ui.definitions.content;

import soliloquy.specs.common.valueobjects.Pair;
import soliloquy.specs.common.valueobjects.Vertex;
import soliloquy.specs.io.graphics.renderables.TextJustification;
import soliloquy.specs.ui.definitions.providers.AbstractProviderDefinition;

import java.awt.*;

public class TextLineRenderableDefinition extends AbstractContentDefinition {
    public final String FONT_ID;
    public final AbstractProviderDefinition<String> TEXT_PROVIDER;
    public final AbstractProviderDefinition<Vertex> LOCATION_PROVIDER;
    public final AbstractProviderDefinition<Float> HEIGHT_PROVIDER;
    public final TextJustification JUSTIFICATION;
    public final float GLYPH_PADDING;

    public Pair<Integer, AbstractProviderDefinition<Color>>[] colorProviderIndices;

    public int[] italicIndices;
    public int[] boldIndices;

    public AbstractProviderDefinition<Float> borderThicknessProvider;
    public AbstractProviderDefinition<Color> borderColorProvider;

    public AbstractProviderDefinition<Float> dropShadowSizeProvider;
    public AbstractProviderDefinition<Vertex> dropShadowOffsetProvider;
    public AbstractProviderDefinition<Color> dropShadowColorProvider;

    private TextLineRenderableDefinition(String fontId,
                                         AbstractProviderDefinition<String> textProvider,
                                         AbstractProviderDefinition<Vertex> locationProvider,
                                         AbstractProviderDefinition<Float> heightProvider,
                                         TextJustification justification,
                                         float glyphPadding,
                                         int z) {
        super(z);
        FONT_ID = fontId;
        TEXT_PROVIDER = textProvider;
        LOCATION_PROVIDER = locationProvider;
        HEIGHT_PROVIDER = heightProvider;
        JUSTIFICATION = justification;
        GLYPH_PADDING = glyphPadding;
    }

    public static TextLineRenderableDefinition textLine(String fontId,
                                                        AbstractProviderDefinition<String> textProvider,
                                                        AbstractProviderDefinition<Vertex> locationProvider,
                                                        AbstractProviderDefinition<Float> heightProvider,
                                                        TextJustification justification,
                                                        float glyphPadding,
                                                        int z) {
        return new TextLineRenderableDefinition(fontId, textProvider, locationProvider,
                heightProvider, justification, glyphPadding, z);
    }

    @SuppressWarnings("unchecked")
    public TextLineRenderableDefinition withColors(
            Pair<Integer, AbstractProviderDefinition<Color>>... colorProviderIndices) {
        this.colorProviderIndices = colorProviderIndices;

        return this;
    }

    public TextLineRenderableDefinition withItalics(int... italicIndices) {
        this.italicIndices = italicIndices;

        return this;
    }

    public TextLineRenderableDefinition withBold(int... boldIndices) {
        this.boldIndices = boldIndices;

        return this;
    }

    public TextLineRenderableDefinition withBorder(
            AbstractProviderDefinition<Float> thicknessProvider,
            AbstractProviderDefinition<Color> colorProvider) {
        borderThicknessProvider = thicknessProvider;
        borderColorProvider = colorProvider;

        return this;
    }

    public TextLineRenderableDefinition withDropShadow(
            AbstractProviderDefinition<Float> sizeProvider,
            AbstractProviderDefinition<Vertex> offsetProvider,
            AbstractProviderDefinition<Color> colorProvider) {
        dropShadowSizeProvider = sizeProvider;
        dropShadowOffsetProvider = offsetProvider;
        dropShadowColorProvider = colorProvider;

        return this;
    }
}
