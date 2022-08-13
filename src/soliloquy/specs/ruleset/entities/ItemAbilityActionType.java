package soliloquy.specs.ruleset.entities;

public enum ItemAbilityActionType {
    UNKNOWN(0),
    PASSIVE(1),
    REACTIVE(2),
    ACTIVE(3);

    private int _value;

    private ItemAbilityActionType(int value) {
        _value = value;
    }
}
