package soliloquy.specs.ruleset;

import soliloquy.specs.common.entities.Action;
import soliloquy.specs.common.entities.Function;
import soliloquy.specs.common.infrastructure.EntityGroup;
import soliloquy.specs.gamestate.entities.Setting;
import soliloquy.specs.gamestate.entities.gameevents.GameAbilityEvent;
import soliloquy.specs.gamestate.entities.gameevents.GameMovementEvent;
import soliloquy.specs.ruleset.entities.*;
import soliloquy.specs.ruleset.entities.abilities.ActiveAbility;
import soliloquy.specs.ruleset.entities.abilities.PassiveAbility;
import soliloquy.specs.ruleset.entities.abilities.ReactiveAbility;
import soliloquy.specs.ruleset.entities.character.*;
import soliloquy.specs.ruleset.valueobjects.CharacterClassification;

import java.util.Map;

// TODO: Document this interface
public interface Ruleset {
    EntityGroup<ActiveAbility> activeAbilities();

    EntityGroup<ReactiveAbility> reactiveAbilities();

    EntityGroup<PassiveAbility> passiveAbilities();

    EntityGroup<VariableStatisticType> variableStatisticTypesGrouped();

    EntityGroup<StaticStatisticType> characterStaticStatisticTypes();

    Map<String, CharacterClassification> characterClassifications();

    Map<String, CharacterType> characterTypes();

    Map<String, CharacterAIType> characterAITypes();

    Map<String, Element> elements();

    Map<String, EquipmentType> equipmentTypes();

    Map<String, FixtureType> fixtureTypes();

    Map<String, GameMovementEvent> gameMovementEvents();

    Map<String, GameAbilityEvent> gameAbilityEvents();

    Map<String, GroundType> groundTypes();

    Map<String, ItemType> itemTypes();

    Map<String, StatusEffectType> statusEffectTypes();

    Map<String, VariableStatisticType> variableStatisticTypes();

    Map<String, WallSegmentType> wallSegmentTypes();

    Map<String, Action> actions();

    Map<String, Function> functions();

    EntityGroup<Setting> rulesetSettings();
}
