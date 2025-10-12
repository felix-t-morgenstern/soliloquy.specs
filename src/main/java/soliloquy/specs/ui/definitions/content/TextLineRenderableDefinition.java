package soliloquy.specs.ui.definitions.content;

import soliloquy.specs.common.valueobjects.Vertex;
import soliloquy.specs.io.graphics.renderables.TextJustification;
import soliloquy.specs.io.graphics.renderables.providers.ProviderAtTime;
import soliloquy.specs.ui.definitions.providers.AbstractProviderDefinition;

import java.awt.*;
import java.util.Map;

public class TextLineRenderableDefinition extends AbstractContentDefinition {
    public final String FONT_ID;
    public final AbstractProviderDefinition<String> TEXT_PROVIDER;
    public final ProviderAtTime<Vertex> LOCATION_PROVIDER;
    public final AbstractProviderDefinition<Vertex> LOCATION_PROVIDER_DEF;
    public final AbstractProviderDefinition<Float> HEIGHT_PROVIDER;
    public final TextJustification JUSTIFICATION;
    public final float GLYPH_PADDING;

    public Map<Integer, AbstractProviderDefinition<Color>> colorProviderIndicesDefs;
    public Map<Integer, ProviderAtTime<Color>> colorProviderIndices;

    public int[] italicIndices;
    public int[] boldIndices;

    public AbstractProviderDefinition<Float> borderThicknessProvider;
    public AbstractProviderDefinition<Color> borderColorProvider;

    public AbstractProviderDefinition<Float> dropShadowSizeProvider;
    public AbstractProviderDefinition<Vertex> dropShadowOffsetProvider;
    public AbstractProviderDefinition<Color> dropShadowColorProvider;

    private TextLineRenderableDefinition(String fontId,
                                         AbstractProviderDefinition<String> textProvider,
                                         ProviderAtTime<Vertex> locationProvider,
                                         AbstractProviderDefinition<Float> heightProvider,
                                         TextJustification justification,
                                         float glyphPadding,
                                         int z) {
        super(z);
        FONT_ID = fontId;
        TEXT_PROVIDER = textProvider;
        LOCATION_PROVIDER = locationProvider;
        LOCATION_PROVIDER_DEF = null;
        HEIGHT_PROVIDER = heightProvider;
        JUSTIFICATION = justification;
        GLYPH_PADDING = glyphPadding;
    }

    private TextLineRenderableDefinition(String fontId,
                                         AbstractProviderDefinition<String> textProvider,
                                         AbstractProviderDefinition<Vertex> locationProviderDef,
                                         AbstractProviderDefinition<Float> heightProvider,
                                         TextJustification justification,
                                         float glyphPadding,
                                         int z) {
        super(z);
        FONT_ID = fontId;
        TEXT_PROVIDER = textProvider;
        LOCATION_PROVIDER = null;
        LOCATION_PROVIDER_DEF = locationProviderDef;
        HEIGHT_PROVIDER = heightProvider;
        JUSTIFICATION = justification;
        GLYPH_PADDING = glyphPadding;
    }

    public static TextLineRenderableDefinition textLine(String fontId,
                                                        AbstractProviderDefinition<String> textProvider,
                                                        AbstractProviderDefinition<Vertex> locationProviderDef,
                                                        AbstractProviderDefinition<Float> heightProvider,
                                                        TextJustification justification,
                                                        float glyphPadding,
                                                        int z) {
        return new TextLineRenderableDefinition(fontId, textProvider, locationProviderDef,
                heightProvider, justification, glyphPadding, z);
    }

    public static TextLineRenderableDefinition textLine(String fontId,
                                                        AbstractProviderDefinition<String> textProvider,
                                                        ProviderAtTime<Vertex> locationProvider,
                                                        AbstractProviderDefinition<Float> heightProvider,
                                                        TextJustification justification,
                                                        float glyphPadding,
                                                        int z) {
        return new TextLineRenderableDefinition(fontId, textProvider, locationProvider,
                heightProvider, justification, glyphPadding, z);
    }

    public TextLineRenderableDefinition withColorDefs(
            Map<Integer, AbstractProviderDefinition<Color>> colorProviderIndicesDefs) {
        this.colorProviderIndicesDefs = colorProviderIndicesDefs;

        return this;
    }

    public TextLineRenderableDefinition withColorProviders(
            Map<Integer, ProviderAtTime<Color>> colorProviderIndices) {
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
