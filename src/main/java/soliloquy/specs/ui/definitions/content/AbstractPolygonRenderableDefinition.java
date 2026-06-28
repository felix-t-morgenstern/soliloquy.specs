package soliloquy.specs.ui.definitions.content;

import soliloquy.specs.io.graphics.renderables.providers.ProviderAtTime;
import soliloquy.specs.ui.definitions.providers.AbstractProviderDefinition;

import java.util.UUID;

import static soliloquy.specs.ui.definitions.providers.StaticProviderDefinition.staticVal;

public abstract class AbstractPolygonRenderableDefinition extends AbstractRenderableWithMouseEventsDefinition {
    public AbstractProviderDefinition<Integer> textureIdProviderDef;
    public ProviderAtTime<Integer> textureIdProvider;

    public AbstractProviderDefinition<Float> textureTilesPerWidthProviderDef;
    public ProviderAtTime<Float> textureTilesPerWidthProvider;

    public AbstractProviderDefinition<Float> textureXOffsetProviderDef;
    public ProviderAtTime<Float> textureXOffsetProvider;

    public AbstractProviderDefinition<Float> textureTilesPerHeightProviderDef;
    public ProviderAtTime<Float> textureTilesPerHeightProvider;

    public AbstractProviderDefinition<Float> textureYOffsetProviderDef;
    public ProviderAtTime<Float> textureYOffsetProvider;

    protected AbstractPolygonRenderableDefinition(int z, UUID uuid) {
        super(z, uuid);
    }

    public AbstractPolygonRenderableDefinition withTexture(int textureId) {
        textureIdProviderDef = staticVal(textureId);
        textureTilesPerWidthProviderDef = textureTilesPerHeightProviderDef = staticVal(1f);

        return this;
    }

    public abstract AbstractPolygonRenderableDefinition withTexture(
            AbstractProviderDefinition<Integer> textureIdProviderDef,
            AbstractProviderDefinition<Float> textureWidthProviderDef,
            AbstractProviderDefinition<Float> textureXOffsetProviderDef,
            AbstractProviderDefinition<Float> textureHeightProviderDef,
            AbstractProviderDefinition<Float> textureYOffsetProviderDef);

    public abstract AbstractPolygonRenderableDefinition withTexture(
            AbstractProviderDefinition<Integer> textureIdProviderDef,
            AbstractProviderDefinition<Float> textureWidthProviderDef,
            AbstractProviderDefinition<Float> textureHeightProviderDef);

    public abstract AbstractPolygonRenderableDefinition withTexture(
            AbstractProviderDefinition<Integer> textureIdProvider,
            float tilesPerWidth,
            float tilesPerHeight);

    public abstract AbstractPolygonRenderableDefinition withTexture(
            AbstractProviderDefinition<Integer> textureIdProvider,
            float tilesPerWidth,
            float xOffset,
            float tilesPerHeight,
            float yOffset);

    public abstract AbstractPolygonRenderableDefinition withTexture(
            ProviderAtTime<Integer> textureIdProvider,
            float tileWidth,
            float tileHeight);

    public abstract AbstractPolygonRenderableDefinition withTexture(
            ProviderAtTime<Integer> textureIdProvider,
            float tilesPerWidth,
            float xOffset,
            float tilesPerHeight,
            float yOffset);

    public abstract AbstractPolygonRenderableDefinition withTexture(
            ProviderAtTime<Integer> textureIdProvider,
            ProviderAtTime<Float> tilesPerWidthProvider,
            ProviderAtTime<Float> textureXOffsetProvider,
            ProviderAtTime<Float> tilesPerHeightProvider,
            ProviderAtTime<Float> textureYOffsetProvider
    );

    public abstract AbstractPolygonRenderableDefinition withTexture(
            ProviderAtTime<Integer> textureIdProvider,
            ProviderAtTime<Float> tileWidthProvider,
            ProviderAtTime<Float> tileHeightProvider
    );
}
