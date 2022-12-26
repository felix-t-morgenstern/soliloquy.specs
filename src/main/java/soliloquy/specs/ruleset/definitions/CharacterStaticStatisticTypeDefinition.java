package soliloquy.specs.ruleset.definitions;

import soliloquy.specs.graphics.assets.ImageAsset;

public class CharacterStaticStatisticTypeDefinition {
    public String id;
    public String name;
    public String description;
    public String imageAssetSetId;
    public String[] defaultColorShifts;

    public CharacterStaticStatisticTypeDefinition(String id,
                                                  String name,
                                                  String description,
                                                  String imageAssetSetId,
                                                  String[] defaultColorShifts) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageAssetSetId = imageAssetSetId;
        this.defaultColorShifts = defaultColorShifts;
    }
}
