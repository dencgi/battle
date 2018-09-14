package dad.battle.attribute;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class AttributesFactoryTest {

	@Test
	public void testRandom() {
		Attributes att = AttributesFactory.create().withRandom().build();

		assertThat("La force n'est pas correcte", att.getStrength(), allOf(greaterThanOrEqualTo(3), lessThanOrEqualTo(18)));
		assertThat("La dextérité n'est pas correcte", att.getDexterity(), allOf(greaterThanOrEqualTo(3), lessThanOrEqualTo(18)));
		assertThat("La constitution n'est pas correcte", att.getConstitution(), allOf(greaterThanOrEqualTo(3), lessThanOrEqualTo(18)));
		assertThat("L'intelligence n'est pas correcte", att.getIntelligence(), allOf(greaterThanOrEqualTo(3), lessThanOrEqualTo(18)));
		assertThat("La sagesse n'est pas correcte", att.getWisdom(), allOf(greaterThanOrEqualTo(3), lessThanOrEqualTo(18)));
		assertThat("Le charisme n'est pas correct", att.getCharisma(), allOf(greaterThanOrEqualTo(3), lessThanOrEqualTo(18)));
	}

	@Test
	public void testWithFixedValue() {
		Attributes att = AttributesFactory.create().withStats(5, 6, 10, 13, 9, 18).build();

		assertEquals("La force n'est pas correcte", 5, att.getStrength());
		assertEquals("La dextérité n'est pas correcte", 6, att.getDexterity());
		assertEquals("La constitution n'est pas correcte", 10, att.getConstitution());
		assertEquals("L'intelligence n'est pas correcte", 13, att.getIntelligence());
		assertEquals("La sagesse n'est pas correcte", 9, att.getWisdom());
		assertEquals("Le charisme n'est pas correct", 18, att.getCharisma());
	}

}
