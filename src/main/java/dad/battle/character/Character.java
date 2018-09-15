package dad.battle.character;

import dad.battle.attribute.Attributes;
import dad.battle.die.Die;

/**
 * Classe modélisant un personnage.
 * 
 * @author dencgi
 *
 */
public class Character {

	private static final int DEATH_HIT_POINTS = -10;
	private static final int DISABLED_HIT_POINTS = 0;

	private String name;
	private Attributes attributes;
	private int hitPoints;
	private int level;
	private Classs classs;

	/**
	 * Construit un personnage vide.
	 */
	/* pp */ Character() {
		super();
		this.attributes = new Attributes();
		hitPoints = DEATH_HIT_POINTS;
	}

	/**
	 * Indique si le personnage est mort.
	 * 
	 * @return Vrai si le personnage est mort.
	 */
	public boolean isDead() {
		return hitPoints <= DEATH_HIT_POINTS;
	}

	/**
	 * Indique si le personnage est mourrant.
	 * 
	 * @return Vrai si le personnage est mourrant.
	 */
	public boolean isDying() {
		return hitPoints > DEATH_HIT_POINTS && hitPoints < DISABLED_HIT_POINTS;
	}

	/**
	 * Indique si le personnage est hors de combat.
	 * 
	 * @return Vrai si le personnage est hors de combat.
	 */
	public boolean isDisabled() {
		return hitPoints == DISABLED_HIT_POINTS;
	}

	/**
	 * Indique si le personnage est en pleine possession de ses moyens.
	 * 
	 * @return Vrai si le personnage est en pleine possession de ses moyens.
	 */
	public boolean isAble() {
		return hitPoints > DISABLED_HIT_POINTS;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Attributes getAttributes() {
		return attributes;
	}

	/* pp */ void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}

	public int getStrength() {
		return attributes.getStrength();
	}

	public int getDexterity() {
		return attributes.getDexterity();
	}

	public int getConstitution() {
		return attributes.getConstitution();
	}

	public int getIntelligence() {
		return attributes.getIntelligence();
	}

	public int getWisdom() {
		return attributes.getWisdom();
	}

	public int getCharisma() {
		return attributes.getCharisma();
	}

	public int getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}

	public int getLevel() {
		return level;
	}

	/* pp */ void setLevel(int level) {
		this.level = level;
	}

	public Classs getClasss() {
		return classs;
	}

	/* pp */ void setClasss(Classs classs) {
		this.classs = classs;
	}

	public void attack(Character opponent) {
		int damage = Die.D4.roll() + attributes.getStrengthModifier();
		damage = damage < 0 ? 0 : damage;
		opponent.setHitPoints(opponent.getHitPoints() - damage);
	}

}
