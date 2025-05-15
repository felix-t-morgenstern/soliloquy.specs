package soliloquy.specs.gamestate.entities.abilities;

import soliloquy.specs.common.infrastructure.ImmutableMap;
import soliloquy.specs.gamestate.entities.Character;
import soliloquy.specs.gamestate.entities.Item;
import soliloquy.specs.ruleset.entities.abilities.Ability;

public class AbilitySource {
    public final Character Character;
    public final Item Item;
    public final soliloquy.specs.ruleset.entities.abilities.Ability Ability;
    public final ImmutableMap<String, Object> Data;

    private AbilitySource(Character character, Item item, Ability ability,
                          ImmutableMap<String, Object> data) {
        Character = character;
        Item = item;
        Ability = ability;
        Data = data;
    }

    public static AbilitySource of(Character character, Ability ability,
                                   ImmutableMap<String, Object> data) {
        return new AbilitySource(character, null, ability, data);
    }

    public static AbilitySource of(Item item, Ability ability, ImmutableMap<String, Object> data) {
        return new AbilitySource(null, item, ability, data);
    }
}
