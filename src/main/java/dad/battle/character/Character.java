package dad.battle.character;

public class Character {

	private static final int STARTING_LEVEL = 1;
	private String name;
	private Attributes attributes;
	private int hitPoints;
	private int level;
	private Classs classs;

	public Character(String name) {
		super();
		this.name = name;
		this.attributes = new Attributes();
		level = STARTING_LEVEL;
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

	public void setStrength(int strength) {
		attributes.setStrength(strength);
	}

	public int getDexterity() {
		return attributes.getDexterity();
	}

	public void setDexterity(int dexterity) {
		attributes.setDexterity(dexterity);
	}

	public int getConstitution() {
		return attributes.getConstitution();
	}

	public void setConstitution(int constitution) {
		attributes.setConstitution(constitution);
	}

	public int getIntelligence() {
		return attributes.getIntelligence();
	}

	public void setIntelligence(int intelligence) {
		attributes.setIntelligence(intelligence);
	}

	public int getWisdom() {
		return attributes.getWisdom();
	}

	public void setWisdom(int wisdom) {
		attributes.setWisdom(wisdom);
	}

	public int getCharisma() {
		return attributes.getCharisma();
	}

	public void setCharisma(int charisma) {
		attributes.setCharisma(charisma);
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
