package dad.battle.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AttributesTest {

	@Test
	public void testGetterSetter() {
		Attributes att = new Attributes();
		att.setStrength(5);
		att.setDexterity(6);
		att.setConstitution(10);
		att.setIntelligence(13);
		att.setWisdom(9);
		att.setCharisma(18);

		assertEquals("La force n'est pas correcte", 5, att.getStrength());
		assertEquals("La dextérité n'est pas correcte", 6, att.getDexterity());
		assertEquals("La constitution n'est pas correcte", 10, att.getConstitution());
		assertEquals("L'intelligence n'est pas correcte", 13, att.getIntelligence());
		assertEquals("La sagesse n'est pas correcte", 9, att.getWisdom());
		assertEquals("Le charisme n'est pas correct", 18, att.getCharisma());
	}

	@Test
	public void testModifier() {
		Attributes att = new Attributes();
		att.setStrength(4);
		att.setDexterity(11);
		att.setConstitution(18);
		att.setIntelligence(17);
		att.setWisdom(9);
		att.setCharisma(7);

		assertEquals("Le modificateur de force est incorrect", -3, att.getStrengthModifier());
		assertEquals("Le modificateur de dextérité est incorrect", 0, att.getDexterityModifier());
		assertEquals("Le modificateur de constitution est incorrect", 4, att.getConstitutionModifier());
		assertEquals("Le modificateur d'intelligence est incorrect", 3, att.getIntelligenceModifier());
		assertEquals("Le modificateur de sagesse est incorrect", -1, att.getWisdomModifier());
		assertEquals("Le modificateur de charisme est incorrect", -2, att.getCharismaModifier());
	}

}
