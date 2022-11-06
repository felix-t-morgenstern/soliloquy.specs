package soliloquy.specs.ruleset.definitions;

public class StatusEffectTypeDefinition {
    public String id;
    public String name;
    public boolean stopsAtZero;
    public String nameAtValueFunctionId;
    public IconForCharacterFunction[] iconForCharacterFunctions;

    public StatusEffectTypeDefinition(String id, String name, boolean stopsAtZero,
                                      String nameAtValueFunctionId,
                                      IconForCharacterFunction[] iconForCharacterFunctions) {
        this.id = id;
        this.name = name;
        this.stopsAtZero = stopsAtZero;
        this.nameAtValueFunctionId = nameAtValueFunctionId;
        this.iconForCharacterFunctions = iconForCharacterFunctions;
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
