package soliloquy.specs.ruleset.definitions;

public class CharacterStaticStatisticTypeDefinition {
    public String id;
    public String name;
    public String description;
    public String imageAssetSetId;
    public String[] defaultColorShifts;
    public EffectsOnCharacterDefinition effectsOnRoundEnd;
    public EffectsOnCharacterDefinition effectsOnTurnStart;
    public EffectsOnCharacterDefinition effectsOnTurnEnd;

    public CharacterStaticStatisticTypeDefinition(String id,
                                                  String name,
                                                  String description,
                                                  String imageAssetSetId,
                                                  String[] defaultColorShifts,
                                                  EffectsOnCharacterDefinition effectsOnRoundEnd,
                                                  EffectsOnCharacterDefinition effectsOnTurnStart,
                                                  EffectsOnCharacterDefinition effectsOnTurnEnd) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageAssetSetId = imageAssetSetId;
        this.defaultColorShifts = defaultColorShifts;
        this.effectsOnRoundEnd = effectsOnRoundEnd;
        this.effectsOnTurnStart = effectsOnTurnStart;
        this.effectsOnTurnEnd = effectsOnTurnEnd;
    }
}
