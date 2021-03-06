package soliloquy.specs.ruleset;

import soliloquy.specs.common.entities.Action;
import soliloquy.specs.common.entities.Function;
import soliloquy.specs.common.shared.EntityGroup;
import soliloquy.specs.common.infrastructure.SettingsRepo;
import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.gamestate.entities.gameevents.GameAbilityEvent;
import soliloquy.specs.gamestate.entities.gameevents.GameMovementEvent;
import soliloquy.specs.ruleset.entities.*;
import soliloquy.specs.ruleset.entities.abilities.ActiveAbilityType;
import soliloquy.specs.ruleset.entities.abilities.PassiveAbilityType;
import soliloquy.specs.ruleset.entities.abilities.ReactiveAbilityType;
import soliloquy.specs.common.infrastructure.Registry;
import soliloquy.specs.ruleset.valueobjects.CharacterClassification;

// TODO: Document this interface
public interface Ruleset extends SoliloquyClass {
	EntityGroup<ActiveAbilityType> activeAbilityTypes();
	
	EntityGroup<ReactiveAbilityType> reactiveAbilityTypes();
	
	EntityGroup<PassiveAbilityType> passiveAbilityTypes();

	EntityGroup<CharacterVariableStatisticType> variableStatisticTypesGrouped();

	EntityGroup<CharacterStaticStatisticType> characterStaticStatisticTypes();
	
	Registry<CharacterClassification> characterClassifications();

	Registry<CharacterType> characterTypes();

	Registry<CharacterAIType> characterAITypes();

	Registry<Element> elements();

	Registry<EquipmentType> equipmentTypes();

	Registry<FixtureType> fixtureTypes();

	Registry<GameMovementEvent> gameMovementEvents();

	Registry<GameAbilityEvent> gameAbilityEvents();

	Registry<GroundType> groundTypes();

	Registry<ItemType> itemTypes();

	Registry<StatusEffectType> statusEffectTypes();

	Registry<CharacterVariableStatisticType> variableStatisticTypes();

	Registry<WallSegmentType> wallSegmentTypes();

	Registry<Action> actions();

	Registry<Function> functions();
	
	SettingsRepo rulesetSettings();
}
