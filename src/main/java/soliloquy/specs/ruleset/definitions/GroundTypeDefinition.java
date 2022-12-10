package soliloquy.specs.ruleset.definitions;

public class GroundTypeDefinition {
    public String id;
    public String name;
    public int imageAssetType;
    public String imageAssetId;
    public String onStepFunctionId;
    public String canStepFunctionId;
    public String[] defaultColorShifts;

    public GroundTypeDefinition(String id, String name, int imageAssetType, String imageAssetId,
                                String onStepFunctionId, String canStepFunctionId,
                                String[] defaultColorShifts) {
        this.id = id;
        this.name = name;
        this.imageAssetType = imageAssetType;
        this.imageAssetId = imageAssetId;
        this.onStepFunctionId = onStepFunctionId;
        this.canStepFunctionId = canStepFunctionId;
        this.defaultColorShifts = defaultColorShifts;
    }
}
