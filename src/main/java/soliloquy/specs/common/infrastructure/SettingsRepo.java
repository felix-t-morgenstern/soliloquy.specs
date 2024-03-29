package soliloquy.specs.common.infrastructure;

import soliloquy.specs.common.shared.EntityGroup;
import soliloquy.specs.common.shared.HasId;

/**
 * <b>SettingsRepo</b>
 * <p>
 * This is a repository for Settings. It is agnostic to the type of its Settings, because it needs
 * to provide all of them as an EntityGroupOfType for UI purposes.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
@SuppressWarnings("rawtypes")
public interface SettingsRepo extends EntityGroup<Setting>, HasId {
    /**
     * This is used to retrieve the value of a Setting of a specified type.
     * <p>
     * <i>It is expected that any code accessing a Setting will know what type of value that
     * Setting will provide. (The underlying assumption is that Settings will only be added and
     * altered by code from the component that placed it in the SettingsRepo in the first
     * place.)</i>
     *
     * @param settingId The Id (i.e. name) of the Setting to retrieve
     * @param <V>       The type of Setting to retrieve
     * @return The desired setting; if no such setting found, returns null
     * @throws IllegalArgumentException If and only if settingId is null or empty
     */
    <V> Setting<V> getSetting(String settingId) throws IllegalArgumentException;

    /**
     * This is used to retrieve a subgrouping, a SettingsRepo within this SettingsRepo
     *
     * @param groupId The Id of the subgrouping to retrieve
     * @return The subgrouping, a SettingsRepo
     * @throws IllegalArgumentException If and only if settingRepoId is null or empty
     */
    SettingsRepo getSubgrouping(String groupId) throws IllegalArgumentException;

    /**
     * @param settingId The Id (i.e. name) of the Setting whose value to set
     * @param value     The value to which to set this Setting
     * @param <V>       The type of Setting to set
     * @throws IllegalArgumentException If and only if settingId is null or empty, there is no
     *                                  setting with the specified Id and with the same type as the
     *                                  provided Value, or if the value
     *                                  being assigned to this Setting is illegal
     */
    <V> void setSetting(String settingId, V value) throws IllegalArgumentException;

    /**
     * @param setting The Setting to add to this SettingsRepo
     * @param order   The order in this SettingsRepo in which the Setting appears. (Order numbers do
     *                not need to be positive, consecutive, etc; they must be unique.)
     * @throws IllegalArgumentException If order is already used within this SettingsRepo; or if
     *                                  setting is null; or if setting's Id is already present in
     *                                  this SettingsRepo or any of its
     *                                  children; or if groupId is non-empty, non-null, and does not
     *                                  exist within this group
     */
    @Override
    void addEntity(Setting setting, int order, String groupId) throws IllegalArgumentException;
}
