package soliloquy.specs.common.factories;

import soliloquy.specs.common.infrastructure.Setting;
import soliloquy.specs.common.infrastructure.VariableCache;
import soliloquy.specs.common.shared.SoliloquyClass;

/**
 * <b>SettingFactory</b>
 * <p>
 * This class creates Settings, to be added to the SettingsRepo on Game setup
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface SettingFactory extends SoliloquyClass {
    /**
     * @param id            The id of the Setting
     * @param name          The name of the Setting
     * @param defaultValue  The default value of the Setting
     * @param controlParams The control parameters, e.g. specifications for UI
     * @return The Setting
     */
    <T> Setting<T> make(String id, String name, T defaultValue, VariableCache controlParams);
}
