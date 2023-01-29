package soliloquy.specs.ruleset.entities.abilities;

import soliloquy.specs.common.infrastructure.VariableCache;
import soliloquy.specs.gamestate.entities.Character;
import soliloquy.specs.gamestate.entities.Item;

public class AbilitySource {
    public final Character Character;
    public final Item Item;
    public final Ability Ability;
    public final VariableCache Params;

    private AbilitySource(Character character, Item item, Ability ability, VariableCache params) {
        Character = character;
        Item = item;
        Ability = ability;
        Params = params;
    }

    public static AbilitySource of(Character character, Ability ability, VariableCache params) {
        return new AbilitySource(character, null, ability, params);
    }

    public static AbilitySource of(Item item, Ability ability, VariableCache params) {
        return new AbilitySource(null, item, ability, params);
    }
}
