package soliloquy.ruleset.gameentities.specs;

import soliloquy.common.specs.ISoliloquyClass;

public interface ICharacterPronouns extends ISoliloquyClass {
	/**
	 * @return The nominative pronoun for this set of pronouns, e.g. "they", "ze", "she", "he"
	 * @throws IllegalStateException If no nominative pronoun is defined
	 */
	String getNominative() throws IllegalStateException;
	
	/**
	 * @param nom - The nominative pronoun to set for this set of pronouns, e.g. "they", "ze", "she", "he"
	 * @throws IllegalArgumentException If nom is null or blank
	 */
	void setNominative(String nom) throws IllegalArgumentException;

	/**
	 * @return The oblique pronoun for this set of pronouns, e.g. "them", "hir", "her", "him"
	 * @throws IllegalStateException If no oblique pronoun is defined
	 */
	String getOblique() throws IllegalStateException;

	/**
	 * @param nom - The oblique pronoun to set for this set of pronouns, e.g. "them", "hir", "her", "him"
	 * @throws IllegalArgumentException If obl is null or blank
	 */
	void setOblique(String obl) throws IllegalArgumentException;
	
	/**
	 * @return The genitive adjective for this set of pronouns, e.g. "their", "hir", "her", "his"
	 * @throws IllegalStateException If no genitive adjective is defined
	 */
	String getGenitiveAdjective() throws IllegalStateException;
	
	/**
	 * @param genAdj - The genitive adjective to set for this set of pronouns, e.g. "their", "hir", "her", "his"
	 * @throws IllegalArgumentException If genAdj is null or blank
	 */
	void setGenitiveAdjective(String genAdj) throws IllegalArgumentException;
	
	/**
	 * @return The genitive pronoun for this set of pronouns, e.g. "theirs", "hirs", "hers", "his"
	 * @throws IllegalStateException If no genitive pronoun is defined
	 */
	String getGenitivePronoun() throws IllegalStateException;
	
	/**
	 * @param genAdj - The genitive pronoun to set for this set of pronouns, e.g. "theirs", "hirs", "hers", "his"
	 * @throws IllegalArgumentException If genPro is null or blank
	 */
	void setGenitivePronoun(String genPro) throws IllegalArgumentException;
	
	/**
	 * @return The reflexive pronoun for this set of pronouns, e.g. "themself", "hirself", "herself", "himself"
	 * @throws IllegalStateException If no reflexive pronoun is defined
	 */
	String getReflexive() throws IllegalStateException;
	
	/**
	 * @param ref - The reflexive pronoun to set for this set of pronouns, e.g. "themself", "hirself", "herself", "himself"
	 * @throws IllegalArgumentException If ref is null or blank
	 */
	void setReflexive(String ref) throws IllegalArgumentException;
}
