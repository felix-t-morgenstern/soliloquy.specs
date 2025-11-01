package soliloquy.specs.ui.definitions.content;

import soliloquy.specs.common.valueobjects.Vertex;
import soliloquy.specs.io.graphics.renderables.TextJustification;
import soliloquy.specs.io.graphics.renderables.providers.ProviderAtTime;
import soliloquy.specs.ui.definitions.providers.AbstractProviderDefinition;

import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static java.util.UUID.randomUUID;
import static soliloquy.specs.ui.definitions.providers.StaticProviderDefinition.staticVal;

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

    public List<Integer> italicIndices;
    public List<Integer> boldIndices;

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
                                         int z,
                                         UUID uuid) {
        super(z, uuid);
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
                                         int z,
                                         UUID uuid) {
        super(z, uuid);
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
                                                        int z,
                                                        UUID uuid) {
        return new TextLineRenderableDefinition(fontId, textProvider, locationProviderDef,
                heightProvider, justification, glyphPadding, z, uuid);
    }

    public static TextLineRenderableDefinition textLine(String fontId,
                                                        AbstractProviderDefinition<String> textProvider,
                                                        AbstractProviderDefinition<Vertex> locationProviderDef,
                                                        AbstractProviderDefinition<Float> heightProvider,
                                                        TextJustification justification,
                                                        float glyphPadding,
                                                        int z) {
        return textLine(fontId, textProvider, locationProviderDef, heightProvider, justification,
                glyphPadding, z, randomUUID());
    }

    public static TextLineRenderableDefinition textLine(String fontId,
                                                        AbstractProviderDefinition<String> textProvider,
                                                        ProviderAtTime<Vertex> locationProvider,
                                                        AbstractProviderDefinition<Float> heightProvider,
                                                        TextJustification justification,
                                                        float glyphPadding,
                                                        int z,
                                                        UUID uuid) {
        return new TextLineRenderableDefinition(fontId, textProvider, locationProvider,
                heightProvider, justification, glyphPadding, z, uuid);
    }

    public static TextLineRenderableDefinition textLine(String fontId,
                                                        AbstractProviderDefinition<String> textProvider,
                                                        ProviderAtTime<Vertex> locationProvider,
                                                        AbstractProviderDefinition<Float> heightProvider,
                                                        TextJustification justification,
                                                        float glyphPadding,
                                                        int z) {
        return textLine(fontId, textProvider, locationProvider, heightProvider, justification,
                glyphPadding, z, randomUUID());
    }

    public static TextLineRenderableDefinition textLine(String fontId,
                                                        String text,
                                                        Vertex location,
                                                        float height,
                                                        TextJustification justification,
                                                        float glyphPadding,
                                                        int z) {
        return textLine(
                fontId,
                staticVal(text),
                staticVal(location),
                staticVal(height),
                justification,
                glyphPadding,
                z
        );
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

    public TextLineRenderableDefinition withItalics(List<Integer> italicIndices) {
        this.italicIndices = italicIndices;

        return this;
    }

    public TextLineRenderableDefinition withBold(List<Integer> boldIndices) {
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

    public TextLineRenderableDefinition withBorder(float thickness, Color color) {
        return withBorder(staticVal(thickness), staticVal(color));
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
