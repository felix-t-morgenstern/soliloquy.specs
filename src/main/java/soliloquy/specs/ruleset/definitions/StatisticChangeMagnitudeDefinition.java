package soliloquy.specs.ruleset.definitions;

public class StatisticChangeMagnitudeDefinition {
    public int effectType;
    public int amountType;
    public Integer[] perLevelValueRange;
    public Float[] perLevelPercentRange;
    public Integer[] absoluteValueRange;
    public Float[] absolutePercentRange;

    public StatisticChangeMagnitudeDefinition(int effectType, int amountType,
                                              Integer[] perLevelValueRange,
                                              Float[] perLevelPercentRange,
                                              Integer[] absoluteValueRange,
                                              Float[] absolutePercentRange) {
        this.effectType = effectType;
        this.amountType = amountType;
        this.perLevelValueRange = perLevelValueRange;
        this.perLevelPercentRange = perLevelPercentRange;
        this.absoluteValueRange = absoluteValueRange;
        this.absolutePercentRange = absolutePercentRange;
    }
}
