package soliloquy.specs.ruleset.definitions;

public class EffectsOnCharacterDefinition {
    public MagnitudeForStatisticDefinition[] magnitudeForStatisticDefinitions;
    public String accompanyEffectFunctionId;
    public String otherEffectsFunctionId;

    public EffectsOnCharacterDefinition(MagnitudeForStatisticDefinition[]
                                                magnitudeForStatisticDefinitions,
                                        String accompanyEffectFunctionId,
                                        String otherEffectsFunctionId) {
        this.magnitudeForStatisticDefinitions = magnitudeForStatisticDefinitions;
        this.accompanyEffectFunctionId = accompanyEffectFunctionId;
        this.otherEffectsFunctionId = otherEffectsFunctionId;
    }

    public static class MagnitudeForStatisticDefinition {
        public String characterVariableStatisticTypeId;
        public StatisticChangeMagnitudeDefinition magnitudeDefinition;

        public MagnitudeForStatisticDefinition(String characterVariableStatisticTypeId,
                                               StatisticChangeMagnitudeDefinition
                                                       magnitudeDefinition) {
            this.characterVariableStatisticTypeId = characterVariableStatisticTypeId;
            this.magnitudeDefinition = magnitudeDefinition;
        }
    }
}
