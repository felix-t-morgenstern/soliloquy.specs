package soliloquy.ruleset.gameentities.specs;

import java.lang.reflect.Type;

import soliloquy.common.specs.ICollection;
import soliloquy.common.specs.ISoliloquyClass;
import soliloquy.common.specs.IWrites;

public interface IPartyAttributes extends IWrites, ISoliloquyClass {
	<V> IPartyAttributeTypeRepo<V> getTypeRepo(Type type);
	<V> void addTypeRepo(Type type);
	<V> void deleteTypeRepo(Type type);
	ICollection<Type> allRepoTypes();
}
