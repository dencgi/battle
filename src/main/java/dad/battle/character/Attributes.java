package dad.battle.character;

import dad.battle.die.Dice;

public class Attributes {

	private static final Dice ABILITY_DICE = new Dice("3d6");

	private int strength;
	private int dexterity;
	private int constitution;
	private int intelligence;
	private int wisdom;
	private int charisma;

	public Attributes() {
		super();
	}

	public void init() {
		strength = ABILITY_DICE.roll();
		dexterity = ABILITY_DICE.roll();
		constitution = ABILITY_DICE.roll();
		intelligence = ABILITY_DICE.roll();
		wisdom = ABILITY_DICE.roll();
		charisma = ABILITY_DICE.roll();
	}

	public void init(int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
		this.strength = strength;
		this.dexterity = dexterity;
		this.constitution = constitution;
		this.intelligence = intelligence;
		this.wisdom = wisdom;
		this.charisma = charisma;
	}

	private int calculateModifier(int ability) {
		return ability % 2 == 0 ? (ability - 10) / 2 : (ability - 11) / 2;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getStrengthModifier() {
		return calculateModifier(strength);
	}

	public int getDexterity() {
		return dexterity;
	}

	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}

	public int getDexterityModifier() {
		return calculateModifier(dexterity);
	}

	public int getConstitution() {
		return constitution;
	}

	public void setConstitution(int constitution) {
		this.constitution = constitution;
	}

	public int getConstitutionModifier() {
		return calculateModifier(constitution);
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getIntelligenceModifier() {
		return calculateModifier(intelligence);
	}

	public int getWisdom() {
		return wisdom;
	}

	public void setWisdom(int wisdom) {
		this.wisdom = wisdom;
	}

	public int getWisdomModifier() {
		return calculateModifier(wisdom);
	}

	public int getCharisma() {
		return charisma;
	}

	public void setCharisma(int charisma) {
		this.charisma = charisma;
	}

	public int getCharismaModifier() {
		return calculateModifier(charisma);
	}

}
