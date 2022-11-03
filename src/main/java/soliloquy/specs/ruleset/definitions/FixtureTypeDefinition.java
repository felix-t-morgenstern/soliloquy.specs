package soliloquy.specs.ruleset.definitions;

import soliloquy.specs.graphics.assets.ImageAsset;

public class FixtureTypeDefinition {
    public String id;
    public String name;
    public String imageAssetSetId;
    public ImageAsset.ImageAssetType imageAssetType;
    public boolean isContainer;
    public String onStepFunctionId;
    public String canStepFunctionId;
    public String[] defaultColorShifts;
    public float defaultXTileWidthOffset;
    public float defaultYTileHeightOffset;

    public FixtureTypeDefinition(String id, String name, String imageAssetSetId,
                                 ImageAsset.ImageAssetType imageAssetType, boolean isContainer,
                                 String onStepFunctionId, String canStepFunctionId,
                                 String[] defaultColorShifts, float defaultXTileWidthOffset,
                                 float defaultYTileHeightOffset) {
        this.id = id;
        this.name = name;
        this.imageAssetSetId = imageAssetSetId;
        this.imageAssetType = imageAssetType;
        this.isContainer = isContainer;
        this.onStepFunctionId = onStepFunctionId;
        this.canStepFunctionId = canStepFunctionId;
        this.defaultColorShifts = defaultColorShifts;
        this.defaultXTileWidthOffset = defaultXTileWidthOffset;
        this.defaultYTileHeightOffset = defaultYTileHeightOffset;
    }
}
