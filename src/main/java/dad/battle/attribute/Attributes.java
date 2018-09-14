package dad.battle.attribute;

/**
 * Classe modélisant les attributs d'un personnage.
 * 
 * @author dencgi
 *
 */
public class Attributes {

	private Attribute strength = new Attribute();
	private Attribute dexterity = new Attribute();
	private Attribute constitution = new Attribute();
	private Attribute intelligence = new Attribute();
	private Attribute wisdom = new Attribute();
	private Attribute charisma = new Attribute();

	/**
	 * Construit des attributs sans valeur de départ.
	 */
	public Attributes() {
		super();
		strength = new Attribute();
		dexterity = new Attribute();
		constitution = new Attribute();
		intelligence = new Attribute();
		wisdom = new Attribute();
		charisma = new Attribute();
	}

	public int getStrength() {
		return strength.getValue();
	}

	public void setStrength(int strength) {
		this.strength.setValue(strength);
	}

	public int getStrengthModifier() {
		return strength.getAttributeModifier();
	}

	public int getDexterity() {
		return dexterity.getValue();
	}

	public void setDexterity(int dexterity) {
		this.dexterity.setValue(dexterity);
	}

	public int getDexterityModifier() {
		return dexterity.getAttributeModifier();
	}

	public int getConstitution() {
		return constitution.getValue();
	}

	public void setConstitution(int constitution) {
		this.constitution.setValue(constitution);
	}

	public int getConstitutionModifier() {
		return constitution.getAttributeModifier();
	}

	public int getIntelligence() {
		return intelligence.getValue();
	}

	public void setIntelligence(int intelligence) {
		this.intelligence.setValue(intelligence);
	}

	public int getIntelligenceModifier() {
		return intelligence.getAttributeModifier();
	}

	public int getWisdom() {
		return wisdom.getValue();
	}

	public void setWisdom(int wisdom) {
		this.wisdom.setValue(wisdom);
	}

	public int getWisdomModifier() {
		return wisdom.getAttributeModifier();
	}

	public int getCharisma() {
		return charisma.getValue();
	}

	public void setCharisma(int charisma) {
		this.charisma.setValue(charisma);
	}

	public int getCharismaModifier() {
		return charisma.getAttributeModifier();
	}

}
