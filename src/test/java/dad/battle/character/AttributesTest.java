package dad.battle.character;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

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
	public void testInit() {
		Attributes att = new Attributes();
		att.init(5, 6, 10, 13, 9, 18);

		assertEquals("La force n'est pas correcte", 5, att.getStrength());
		assertEquals("La dextérité n'est pas correcte", 6, att.getDexterity());
		assertEquals("La constitution n'est pas correcte", 10, att.getConstitution());
		assertEquals("L'intelligence n'est pas correcte", 13, att.getIntelligence());
		assertEquals("La sagesse n'est pas correcte", 9, att.getWisdom());
		assertEquals("Le charisme n'est pas correct", 18, att.getCharisma());
	}

	@Test
	public void testRandomInit() {
		Attributes att = new Attributes();
		att.init();

		Set<Integer> attributes = new HashSet<>();
		attributes.add(att.getStrength());
		attributes.add(att.getDexterity());
		attributes.add(att.getConstitution());
		attributes.add(att.getIntelligence());
		attributes.add(att.getWisdom());
		attributes.add(att.getCharisma());
		assertThat("Les attributs sont tous identiques", attributes, not(hasSize(1)));
		assertThat("Les attributs ne sont pas compris entre 3 et 18", attributes, everyItem(allOf(greaterThanOrEqualTo(3), lessThanOrEqualTo(18))));
	}

	@Test
	public void testModifier() {
		Attributes att = new Attributes();
		att.init(4, 11, 18, 17, 9, 7);

		assertEquals("Le modificateur de force est incorrect", -3, att.getStrengthModifier());
		assertEquals("Le modificateur de dextérité est incorrect", 0, att.getDexterityModifier());
		assertEquals("Le modificateur de constitution est incorrect", 4, att.getConstitutionModifier());
		assertEquals("Le modificateur d'intelligence est incorrect", 3, att.getIntelligenceModifier());
		assertEquals("Le modificateur de sagesse est incorrect", -1, att.getWisdomModifier());
		assertEquals("Le modificateur de charisme est incorrect", -2, att.getCharismaModifier());
	}

}
