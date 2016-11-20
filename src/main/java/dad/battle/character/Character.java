package dad.battle.character;

/**
 * Classe modélisant un personnage.
 * 
 * @author dencgi
 *
 */
public class Character {

	private static final int STARTING_LEVEL = 1;
	private static final int DEATH_HIT_POINTS = -10;
	private static final int DISABLED_HIT_POINTS = 0;

	private String name;
	private Attributes attributes;
	private int hitPoints;
	private int level;
	private Classs classs;

	/**
	 * Construit un personnage dont le nom a été passé en paramètre.
	 * 
	 * @param name
	 *            Nom du personnage.
	 */
	public Character(String name) {
		super();
		this.name = name;
		this.attributes = new Attributes();
		level = STARTING_LEVEL;
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

	public void setAttributes(Attributes attributes) {
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

	public void setLevel(int level) {
		this.level = level;
	}

	public Classs getClasss() {
		return classs;
	}

	public void setClasss(Classs classs) {
		this.classs = classs;
	}

}
