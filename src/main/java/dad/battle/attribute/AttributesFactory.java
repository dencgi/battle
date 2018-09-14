package dad.battle.attribute;

import dad.battle.die.Dice;

public class AttributesFactory {

	private static final Dice ABILITY_DICE = new Dice("3d6");

	private Attributes attributes;

	private AttributesFactory() {
		attributes = new Attributes();
	}

	public static AttributesFactory create() {
		return new AttributesFactory();
	}

	public Attributes build() {
		return attributes;
	}

	/**
	 * Initialise aléatoirement les attributs.
	 * 
	 * @return La fabrique.
	 */
	public AttributesFactory withRandom() {
		attributes.setStrength(ABILITY_DICE.roll());
		attributes.setDexterity(ABILITY_DICE.roll());
		attributes.setConstitution(ABILITY_DICE.roll());
		attributes.setIntelligence(ABILITY_DICE.roll());
		attributes.setWisdom(ABILITY_DICE.roll());
		attributes.setCharisma(ABILITY_DICE.roll());
		return this;
	}

	/**
	 * Initialise avec les statistiques passées en paramètre.
	 * 
	 * @param strength     Force.
	 * @param dexterity    Dextérité.
	 * @param constitution Constitution.
	 * @param intelligence Intelligence.
	 * @param wisdom       Sagesse.
	 * @param charisma     Charisme
	 * @return La fabrique.
	 */
	public AttributesFactory withStats(int strength, int dexterity, int constitution, int intelligence, int wisdom,
			int charisma) {
		return withStrength(strength).withDexterity(dexterity).withConstitution(constitution)
				.withIntelligence(intelligence).withWisdom(wisdom).withCharisma(charisma);
	}

	/**
	 * Initialise avec la force passée en paramètre.
	 * 
	 * @param strength Force.
	 * @return La fabrique.
	 */
	public AttributesFactory withStrength(int strength) {
		attributes.setStrength(strength);
		return this;
	}

	/**
	 * Initialise avec la dextérité passée en paramètre.
	 * 
	 * @param dexterity Dextérité.
	 * @return La fabrique.
	 */
	public AttributesFactory withDexterity(int dexterity) {
		attributes.setDexterity(dexterity);
		return this;
	}

	/**
	 * Initialise avec la constitution passée en paramètre.
	 * 
	 * @param constitution Constitution.
	 * @return La fabrique.
	 */
	public AttributesFactory withConstitution(int constitution) {
		attributes.setConstitution(constitution);
		return this;
	}

	/**
	 * Initialise avec l'intelligence passée en paramètre.
	 * 
	 * @param intelligence Intelligence.
	 * @return La fabrique.
	 */
	public AttributesFactory withIntelligence(int intelligence) {
		attributes.setIntelligence(intelligence);
		return this;
	}

	/**
	 * Initialise avec la sagesse passée en paramètre.
	 * 
	 * @param wisdom Sagesse.
	 * @return La fabrique.
	 */
	public AttributesFactory withWisdom(int wisdom) {
		attributes.setWisdom(wisdom);
		return this;
	}

	/**
	 * Initialise avec le charisme passé en paramètre.
	 * 
	 * @param charisma Charisme.
	 * @return La fabrique.
	 */
	public AttributesFactory withCharisma(int charisma) {
		attributes.setCharisma(charisma);
		return this;
	}

}
