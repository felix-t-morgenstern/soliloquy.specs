package soliloquy.ruleset.gameentities.specs;

import soliloquy.common.specs.IHasOneGenericParam;
import soliloquy.common.specs.IMap;
import soliloquy.common.specs.IWrites;

public interface IPartyAttributeTypeRepo<V> extends IWrites, IMap<String,V>, IHasOneGenericParam<V> {
}
