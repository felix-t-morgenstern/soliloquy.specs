package soliloquy.specs.ruleset.definitions;

public class CharacterVariableStatisticTypeDefinition {
    public String id;
    public String name;
    public String pluralName;
    public String description;
    public String imageAssetSetId;
    public String[] defaultColorShifts;
    public String iconForCharacterFunctionId;

    public CharacterVariableStatisticTypeDefinition(String id,
                                                    String name,
                                                    String pluralName,
                                                    String description,
                                                    String imageAssetSetId,
                                                    String[] defaultColorShifts,
                                                    String iconForCharacterFunctionId) {
        this.id = id;
        this.name = name;
        this.pluralName = pluralName;
        this.description = description;
        this.imageAssetSetId = imageAssetSetId;
        this.defaultColorShifts = defaultColorShifts;
        this.iconForCharacterFunctionId = iconForCharacterFunctionId;
    }
}
