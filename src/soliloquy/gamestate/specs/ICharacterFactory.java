package soliloquy.gamestate.specs;

import soliloquy.common.specs.ICollection;
import soliloquy.common.specs.IGenericParamsSet;
import soliloquy.common.specs.IMap;
import soliloquy.common.specs.ISoliloquyClass;

public interface ICharacterFactory extends ISoliloquyClass {
	ICharacter make(String characterTpeId, ICollection<String> characterClassificationIds,
                    IMap<String,String> pronouns, IGenericParamsSet traits, String stance,
                    String direction, String spriteSetTypeId, String aiTypeId,
                    IGenericParamsSet characterAIParams)
            throws IllegalArgumentException;
}
