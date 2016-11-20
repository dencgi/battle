package dad.battle.character;

public class Factory {

	public static Character getCharacter(String nom, Classs classs) {
		Character c = new Character(nom);
		c.setClasss(classs);
		c.getAttributes().init();
		c.setHitPoints(calculateHitPoints(c));
		return c;
	}

	public static Character getCharacter(String nom, Classs classs, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
		Character c = new Character(nom);
		c.setClasss(classs);
		c.getAttributes().setStrength(strength);
		c.getAttributes().setDexterity(dexterity);
		c.getAttributes().setConstitution(constitution);
		c.getAttributes().setIntelligence(intelligence);
		c.getAttributes().setWisdom(wisdom);
		c.getAttributes().setCharisma(charisma);
		c.setHitPoints(calculateHitPoints(c));
		return c;
	}
	
	private static int calculateHitPoints(Character character) {
		return character.getClasss().getHitPointsDie().roll() + character.getAttributes().getConstitutionModifier();
	}
}
