package soliloquy.specs.ruleset.definitions;

public class StatusEffectTypeDefinition {
    public String id;
    public String name;
    public boolean stopsAtZero;
    public String nameAtValueFunctionId;
    public IconForCharacterFunction[] iconForCharacterFunctions;
    public EffectsOnCharacterDefinition effectsOnRoundEnd;
    public EffectsOnCharacterDefinition effectsOnTurnStart;
    public EffectsOnCharacterDefinition effectsOnTurnEnd;

    public StatusEffectTypeDefinition(String id, String name, boolean stopsAtZero,
                                      String nameAtValueFunctionId,
                                      IconForCharacterFunction[] iconForCharacterFunctions,
                                      EffectsOnCharacterDefinition effectsOnRoundEnd,
                                      EffectsOnCharacterDefinition effectsOnTurnStart,
                                      EffectsOnCharacterDefinition effectsOnTurnEnd) {
        this.id = id;
        this.name = name;
        this.stopsAtZero = stopsAtZero;
        this.nameAtValueFunctionId = nameAtValueFunctionId;
        this.iconForCharacterFunctions = iconForCharacterFunctions;
        this.effectsOnRoundEnd = effectsOnRoundEnd;
        this.effectsOnTurnStart = effectsOnTurnStart;
        this.effectsOnTurnEnd = effectsOnTurnEnd;
    }

    public static class IconForCharacterFunction {
        public String iconType;
        public String functionId;

        public IconForCharacterFunction(String iconType, String functionId) {
            this.iconType = iconType;
            this.functionId = functionId;
        }
    }
}
