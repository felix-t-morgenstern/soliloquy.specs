package soliloquy.specs.ruleset;

import soliloquy.specs.common.valueobjects.ICollection;
import soliloquy.specs.common.shared.IEntityGroup;
import soliloquy.specs.common.entities.ISettingsRepo;
import soliloquy.specs.common.shared.ISoliloquyClass;
import soliloquy.specs.ruleset.entities.abilities.IActiveAbilityType;
import soliloquy.specs.ruleset.entities.abilities.IPassiveAbilityType;
import soliloquy.specs.ruleset.entities.abilities.IReactiveAbilityType;
import soliloquy.specs.ruleset.valueobjects.ITypesRegistry;
import soliloquy.specs.ruleset.entities.IAttributeType;
import soliloquy.specs.ruleset.entities.ICharacterAIType;
import soliloquy.specs.ruleset.valueobjects.ICharacterClassification;
import soliloquy.specs.ruleset.entities.ICharacterEventType;
import soliloquy.specs.ruleset.entities.ICharacterType;
import soliloquy.specs.ruleset.entities.IElement;
import soliloquy.specs.ruleset.entities.IEquipmentType;
import soliloquy.specs.ruleset.entities.IFixtureType;
import soliloquy.specs.ruleset.entities.IGroundType;
import soliloquy.specs.ruleset.entities.IItemType;
import soliloquy.specs.ruleset.entities.IStatusEffectType;
import soliloquy.specs.ruleset.entities.IVitalAttributeType;
import soliloquy.specs.ruleset.entities.IWallSegmentType;
import soliloquy.specs.gamestate.entities.ICharacterAptitude;
import soliloquy.specs.gamestate.entities.ICharacterAttribute;

// TODO: Document this interface
public interface IRuleset extends ISoliloquyClass {
	IEntityGroup<IActiveAbilityType> activeAbilitiyTypes();
	
	IEntityGroup<IReactiveAbilityType> reactiveAbilitiyTypes();
	
	IEntityGroup<IPassiveAbilityType> passiveAbilitiyTypes();
	
	/**
	 * (CharacterAptitudes are either calculated algorithmically in a single instance, or are
	 * stored statically. See {@link ICharacterAptitude} for more
	 * information.
	 * @return A Collection of Aptitude Ids.
	 */
	ICollection<String> aptitudes();
	
	/**
	 * (CharacterAttributes are either calculated algorithmically in a single instance, or are
	 * stored statically. See {@link ICharacterAttribute} for more
	 * information.
	 * @return A Collection of Attribute Ids.
	 */
	IEntityGroup<IAttributeType> attributes();
	
	ITypesRegistry<ICharacterClassification> characterClassifications();

	ITypesRegistry<ICharacterType> characterTypes();

	ITypesRegistry<ICharacterAIType> characterAITypes();

	ITypesRegistry<ICharacterEventType> characterEventTypes();

	ITypesRegistry<IElement> elements();

	ITypesRegistry<IEquipmentType> equipmentTypes();

	ITypesRegistry<IFixtureType> fixtureTypes();

	ITypesRegistry<IGroundType> groundTypes();

	ITypesRegistry<IItemType> itemTypes();

	ITypesRegistry<IStatusEffectType> statusEffectTypes();

	ITypesRegistry<IVitalAttributeType> vitalAttributes();

	ITypesRegistry<IWallSegmentType> wallSegmentTypes();
	
	ISettingsRepo rulesetSettings();
}
