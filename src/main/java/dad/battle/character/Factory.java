package dad.battle.character;

/**
 * Fabrique de personnage.
 * 
 * @author dencgi
 *
 */
public class Factory {

	private static final int NUMBER_OF_ATTRIBUTES = 6;

	private Factory() {
	}

	/**
	 * Construit un personnage ayant des attributs aléatoires.
	 * 
	 * @param name
	 *            Nom du personnage.
	 * @param classs
	 *            Classe du personnage.
	 * @return Le personnage construit et initialisé.
	 */
	public static Character getCharacter(String name, Classs classs) {
		Character c = new Character(name);
		c.setClasss(classs);
		c.getAttributes().init();
		c.setHitPoints(calculateHitPoints(c));
		return c;
	}

	/**
	 * Construit un personnage dont les attributs sont passés en paramètre.
	 * 
	 * @param name
	 *            Nom du personnage.
	 * @param classs
	 *            Classe du personnage.
	 * @param attributes
	 *            Liste d'attributs dans l'ordre suivant : force, dextérité, constitution, intelligence, sagesse et charisme.
	 * @return Le personnage construit et initialisé.
	 */
	public static Character getCharacter(String name, Classs classs, int... attributes) {
		Character c = new Character(name);
		c.setClasss(classs);
		if (attributes == null || attributes.length != NUMBER_OF_ATTRIBUTES) {
			throw new IllegalArgumentException(NUMBER_OF_ATTRIBUTES + " attributes exactly");
		}
		c.getAttributes().setStrength(attributes[0]);
		c.getAttributes().setDexterity(attributes[1]);
		c.getAttributes().setConstitution(attributes[2]);
		c.getAttributes().setIntelligence(attributes[3]);
		c.getAttributes().setWisdom(attributes[4]);
		c.getAttributes().setCharisma(attributes[5]);
		c.setHitPoints(calculateHitPoints(c));
		return c;
	}

	/**
	 * Calcule le nombre de point de vie d'un personnage à sa création.
	 * 
	 * @param character
	 *            Le personnage dont on veut calculer les points de vie.
	 * @return Le nombre de points de vie obtenu.
	 */
	private static int calculateHitPoints(Character character) {
		return character.getClasss().getHitPointsDie().roll() + character.getAttributes().getConstitutionModifier();
	}
}
