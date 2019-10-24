package soliloquy.specs.ruleset;

import soliloquy.specs.common.infrastructure.Collection;
import soliloquy.specs.common.shared.EntityGroup;
import soliloquy.specs.common.infrastructure.SettingsRepo;
import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.gamestate.entities.gameevents.GameAbilityEvent;
import soliloquy.specs.gamestate.entities.gameevents.GameMovementEvent;
import soliloquy.specs.ruleset.entities.abilities.ActiveAbilityType;
import soliloquy.specs.ruleset.entities.abilities.PassiveAbilityType;
import soliloquy.specs.ruleset.entities.abilities.ReactiveAbilityType;
import soliloquy.specs.common.infrastructure.Registry;
import soliloquy.specs.ruleset.entities.AttributeType;
import soliloquy.specs.ruleset.entities.CharacterAIType;
import soliloquy.specs.ruleset.valueobjects.CharacterClassification;
import soliloquy.specs.ruleset.entities.CharacterType;
import soliloquy.specs.ruleset.entities.Element;
import soliloquy.specs.ruleset.entities.EquipmentType;
import soliloquy.specs.ruleset.entities.FixtureType;
import soliloquy.specs.ruleset.entities.GroundType;
import soliloquy.specs.ruleset.entities.ItemType;
import soliloquy.specs.ruleset.entities.StatusEffectType;
import soliloquy.specs.ruleset.entities.VitalAttributeType;
import soliloquy.specs.ruleset.entities.WallSegmentType;
import soliloquy.specs.gamestate.entities.CharacterAptitude;
import soliloquy.specs.gamestate.entities.CharacterAttribute;

// TODO: Document this interface
public interface Ruleset extends SoliloquyClass {
	EntityGroup<ActiveAbilityType> activeAbilitiyTypes();
	
	EntityGroup<ReactiveAbilityType> reactiveAbilitiyTypes();
	
	EntityGroup<PassiveAbilityType> passiveAbilitiyTypes();
	
	/**
	 * (CharacterAptitudes are either calculated algorithmically in a single instance, or are
	 * stored statically. See {@link CharacterAptitude} for more
	 * information.
	 * @return A Collection of Aptitude Ids.
	 */
	Collection<String> aptitudes();
	
	/**
	 * (CharacterAttributes are either calculated algorithmically in a single instance, or are
	 * stored statically. See {@link CharacterAttribute} for more
	 * information.
	 * @return A Collection of Attribute Ids.
	 */
	EntityGroup<AttributeType> attributes();
	
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

	Registry<VitalAttributeType> vitalAttributes();

	Registry<WallSegmentType> wallSegmentTypes();
	
	SettingsRepo rulesetSettings();
}
