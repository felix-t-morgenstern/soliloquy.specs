package soliloquy.ruleset.primary.specs;

import soliloquy.common.specs.ICollection;
import soliloquy.common.specs.IEntityGroup;
import soliloquy.common.specs.IMap;
import soliloquy.common.specs.ISettingsRepo;
import soliloquy.common.specs.ISoliloquyClass;
import soliloquy.ruleset.gameentities.specs.ITimerAction;
import soliloquy.ruleset.gameentities.specs.ITypesRegistry;
import soliloquy.ruleset.gameentities.abilities.specs.IActiveAbilityType;
import soliloquy.ruleset.gameentities.abilities.specs.IPassiveAbilityType;
import soliloquy.ruleset.gameentities.abilities.specs.IReactiveAbilityType;
import soliloquy.ruleset.gameentities.specs.IAttribute;
import soliloquy.ruleset.gameentities.specs.ICharacterAIType;
import soliloquy.ruleset.gameentities.specs.ICharacterClassification;
import soliloquy.ruleset.gameentities.specs.ICharacterEventType;
import soliloquy.ruleset.gameentities.specs.ICharacterType;
import soliloquy.ruleset.gameentities.specs.IElement;
import soliloquy.ruleset.gameentities.specs.IEquipmentType;
import soliloquy.ruleset.gameentities.specs.IFixtureType;
import soliloquy.ruleset.gameentities.specs.IGroundType;
import soliloquy.ruleset.gameentities.specs.IItemType;
import soliloquy.ruleset.gameentities.specs.IStatusEffectType;
import soliloquy.ruleset.gameentities.specs.IVitalAttributeType;
import soliloquy.ruleset.gameentities.specs.IWallSegmentType;
import soliloquy.sprites.specs.ISpriteFactory;
import soliloquy.sprites.specs.ISpriteSetFactory;

// TODO: Document this interface
public interface IRuleset extends ISoliloquyClass {
	IEntityGroup<IActiveAbilityType> activeAbilitiyTypes();
	
	IEntityGroup<IReactiveAbilityType> reactiveAbilitiyTypes();
	
	IEntityGroup<IPassiveAbilityType> passiveAbilitiyTypes();
	
	/**
	 * (CharacterAptitudes are either calculated algorithmically in a single instance, or are
	 * stored statically. See {@link soliloquy.gamestate.specs.ICharacterAptitude} for more
	 * information.
	 * @return A Collection of Aptitude Ids.
	 */
	ICollection<String> aptitudes();
	
	/**
	 * (CharacterAttributes are either calculated algorithmically in a single instance, or are
	 * stored statically. See {@link soliloquy.gamestate.specs.ICharacterAttribute} for more
	 * information.
	 * @return A Collection of Attribute Ids.
	 */
	IEntityGroup<IAttribute> attributes();
	
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

	ITypesRegistry<ITimerAction> timerActions();

	ITypesRegistry<IVitalAttributeType> vitalAttributes();

	ITypesRegistry<IWallSegmentType> wallSegmentTypes();
	
	ISettingsRepo rulesetSettings();
	
	ISpriteFactory spriteFactory();
	
	ISpriteSetFactory spriteSetFactory();
}
