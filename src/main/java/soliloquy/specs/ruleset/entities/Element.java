package soliloquy.specs.ruleset.entities;

import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.common.shared.HasName;

/**
 * <b>Element</b>
 * <p>
 * An Element is type of effect which can occur to a Character, e.g., Aqua, Flora, Ignis
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface Element extends HasName, HasId, HasDescription, HasImageAssetSet {
}
