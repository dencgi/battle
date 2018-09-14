package dad.battle.character;

import dad.battle.attribute.Attributes;
import dad.battle.attribute.AttributesFactory;

/**
 * Fabrique de personnage.
 * 
 * @author dencgi
 *
 */
public class CharacterFactory {

	private static final int STARTING_LEVEL = 1;

	private String name;
	private Classs classs;
	private Attributes attributes;

	private CharacterFactory() {
	}

	public static CharacterFactory create() {
		return new CharacterFactory();
	}

	public Character build() {
		Character character = new Character();
		character.setName(name);
		character.setLevel(STARTING_LEVEL);
		character.setClasss(classs);
		character.setAttributes(attributes != null ? attributes : AttributesFactory.create().withRandom().build());
		character.setHitPoints(calculateHitPoints(character));
		return character;
	}

	public CharacterFactory withName(String name) {
		this.name = name;
		return this;
	}

	public CharacterFactory withClass(Classs classs) {
		this.classs = classs;
		return this;
	}

	public CharacterFactory withAttributes(int strength, int dexterity, int constitution, int intelligence, int wisdom,
			int charisma) {
		attributes = AttributesFactory.create()
				.withStats(strength, dexterity, constitution, intelligence, wisdom, charisma).build();
		return this;
	}

	/**
	 * Calcule le nombre de point de vie d'un personnage à sa création.
	 * 
	 * @param character Le personnage dont on veut calculer les points de vie.
	 * @return Le nombre de points de vie obtenu.
	 */
	private int calculateHitPoints(Character character) {
		return character.getClasss().getHitPointsDie().roll() + character.getAttributes().getConstitutionModifier();
	}
}
