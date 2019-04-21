package soliloquy.common.specs;

/**
 * <b>SettingsRepo</b>
 * <p>
 * This is a repository for Settings. It is agnostic to the type of its Settings, because it needs
 * to provide all of them as an EntityGroup for UI purposes.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
@SuppressWarnings("rawtypes")
public interface ISettingsRepo extends IEntityGroup<ISetting>, IHasId, IReads, IWrites {
	/**
	 * This is used to retrieve the value of a Setting of a specified type.
	 * <p>
	 * <i>It is expected that any code accessing a Setting will know what type of value that
	 * Setting will provide. (The underlying assumption is that Settings will only be added and
	 * altered by code from the component that placed it in the SettingsRepo in the first
	 * place.)</i>
	 * @param settingId - The Id (i.e. name) of the Setting to retrieve
	 * @param <V> The type of Setting to retrieve 
	 * @return The desired setting
	 * @throws IllegalArgumentException If and only if settingId is null or empty
	 */
	<V> ISetting<V> getSetting(String settingId) throws IllegalArgumentException;
	
	/**
	 * This is used to retrieve a subgrouping, a SettingsRepo within this SettingsRepo
	 * @param groupId - The Id of the subgrouping to retrieve
	 * @return The subgrouping, a SettingsRepo
	 * @throws IllegalArgumentException If and only if settingRepoId is null or empty
	 */
	ISettingsRepo getSubgrouping(String groupId) throws IllegalArgumentException;
	
	/**
	 * @param settingId - The Id (i.e. name) of the Setting whose value to set
	 * @param value - The value to which to set this Setting
	 * @param <V> The type of Setting to set
	 * @throws IllegalArgumentException If and only if settingId is null or empty, there is no
	 * setting with the specified Id and with the same type as the provided Value, or if the value
	 * being assigned to this Setting is illegal
	 */
	<V> void setSetting(String settingId, V value) throws IllegalArgumentException;

	@Override
	/**
	 * @param setting The Setting to add to this SettingsRepo
	 * @param order The order in this SettingsRepo in which the Setting appears. (Order numbers do
	 * not need to be positive, consecutive, etc; they must be unique.)
	 * @throws IllegalArgumentException If order is already used within this SettingsRepo; or if
	 * setting is null; or if setting's Id is already present in this SettingsRepo or any of its
	 * children; or if groupId is non-empty, non-null, and does not exist within this group
	 */
	void addEntity(ISetting setting, int order, String groupId) throws IllegalArgumentException;

	@Override
	/**
	 * <i>This method requires that all values read from the data already exist in this
	 * SettingsRepo</i>
	 * <p>
	 * <i>overridePreviousData is ignored for classes implementing these specifications</i>
	 * @param data - The data to be read by this class
	 * @param overridePreviousData - Ignored
	 * @throws IllegalArgumentException If the data are illegal, e.g. if they are null, if they are
	 * not properly formatted, etc., or if any of the values in the data do not exist in the
	 * SettingsRepo
	 */
	void read(String data, boolean overridePreviousData) throws IllegalArgumentException;
}
