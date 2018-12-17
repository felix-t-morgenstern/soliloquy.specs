package soliloquy.common.specs;

@SuppressWarnings("rawtypes")
/**
 * <b>SettingsRepo</b>
 * <p>
 * This is a repository for Settings. It is agnostic to the type of its Settings, because it needs to provide all of them as an EntityGroup for UI purposes.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface ISettingsRepo extends IEntityGroup<ISetting>, IReads, IWrites {
	/**
	 * This is used to retrieve the value of a Setting of a specified type.
	 * @param settingId - The Id (i.e. name) of the Setting whose value to retrieve
	 * @param <V> The type of Setting to retrieve 
	 * @return The value of the setting of that Type with that given Id
	 * @throws IllegalArgumentException If and only if a setting with the specified Id and Type does not exist
	 */
	<V> ISetting<V> getSetting(String settingId) throws IllegalArgumentException;
	
	/**
	 * @param settingId - The Id (i.e. name) of the Setting whose value to set
	 * @param value - The value to which to set this Setting
	 * @param <V> The type of Setting to set
	 * @throws IllegalArgumentException If and only if there is no setting with the specified Id and with the same type as the provided Value, or if the value being assigned to this Setting is illegal
	 */
	<V> void setSetting(String settingId, V value) throws IllegalArgumentException;
}
