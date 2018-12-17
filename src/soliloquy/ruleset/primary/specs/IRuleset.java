package soliloquy.ruleset.primary.specs;

import soliloquy.common.specs.ISettingsRepo;
import soliloquy.common.specs.ISoliloquyClass;
import soliloquy.ruleset.gameentities.abilities.specs.IActiveAbilityTypes;
import soliloquy.ruleset.gameentities.abilities.specs.IPassiveAbilityTypes;
import soliloquy.ruleset.gameentities.abilities.specs.IReactiveAbilityTypes;
import soliloquy.ruleset.gameentities.specs.IAptitudes;
import soliloquy.ruleset.gameentities.specs.IAttributes;
import soliloquy.ruleset.gameentities.specs.ICharacterClassifications;
import soliloquy.ruleset.gameentities.specs.ICharacterTypes;
import soliloquy.ruleset.gameentities.specs.IElements;
import soliloquy.ruleset.gameentities.specs.IEquipmentTypes;
import soliloquy.ruleset.gameentities.specs.IFixtureTypes;
import soliloquy.ruleset.gameentities.specs.IGroundTypes;
import soliloquy.ruleset.gameentities.specs.IItemTypes;
import soliloquy.ruleset.gameentities.specs.IPartyAttributes;
import soliloquy.ruleset.gameentities.specs.IStatusEffectTypes;
import soliloquy.ruleset.gameentities.specs.IVitalAttributes;
import soliloquy.ruleset.gameentities.specs.IWallSegmentTypes;
import soliloquy.sprites.specs.ISpriteFactory;
import soliloquy.sprites.specs.ISpriteSetFactory;

public interface IRuleset extends ISoliloquyClass {
	IActiveAbilityTypes activeAbilitiyTypes();
	
	IReactiveAbilityTypes reactiveAbilitiyTypes();
	
	IPassiveAbilityTypes passiveAbilitiyTypes();
	
	IAptitudes aptitudes();
	
	IAttributes attributes();
	
	ICharacterClassifications characterClassifications();
	
	ICharacterTypes characterTypes();
	
	IElements elements();
	
	IEquipmentTypes equipmentTypes();
	
	IFixtureTypes fixtureTypes();
	
	IGroundTypes groundTypes();
	
	IItemTypes itemTypes();
	
	IPartyAttributes partyAttributes();
	
	IStatusEffectTypes statusEffectTypes();
	
	IVitalAttributes vitalAttributes();
	
	IWallSegmentTypes wallSegmentTypes();
	
	ISettingsRepo rulesetSettings();
	
	ISpriteFactory spriteFactory();
	
	ISpriteSetFactory spriteSetFactory();
}
