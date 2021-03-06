package dad.battle.character;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class CharacterFactoryTest {

	@Test
	public void testFighter() {
		String nom = "toto";
		Classs classs = Classs.FIGHTER;
		Character c = CharacterFactory.create().withName(nom).withClass(classs).build();
		assertNotNull("Le personnage est créé", c);
		assertEquals("Le nom du personnage n'est pas correct", nom, c.getName());
		assertEquals("La classe du personnage n'est pas correct", classs, c.getClasss());
	}

	@Test
	public void testMonk() {
		String nom = "toto";
		Classs classs = Classs.MONK;
		Character c = CharacterFactory.create().withName(nom).withClass(classs).build();
		assertNotNull("Le personnage est créé", c);
		assertEquals("Le nom du personnage n'est pas correct", nom, c.getName());
		assertEquals("La classe du personnage n'est pas correct", classs, c.getClasss());
	}

	@Test
	public void testRandomInit() {
		String nom = "toto";
		Classs classs = Classs.MONK;
		Character c = CharacterFactory.create().withName(nom).withClass(classs).build();
		Set<Integer> attributes = new HashSet<>();
		attributes.add(c.getAttributes().getStrength());
		attributes.add(c.getAttributes().getDexterity());
		attributes.add(c.getAttributes().getConstitution());
		attributes.add(c.getAttributes().getIntelligence());
		attributes.add(c.getAttributes().getWisdom());
		attributes.add(c.getAttributes().getCharisma());
		assertThat("Les attributs sont tous identiques", attributes, not(hasSize(1)));
		assertThat("Les attributs ne sont pas compris entre 3 et 18", attributes, everyItem(allOf(greaterThanOrEqualTo(3), lessThanOrEqualTo(18))));
	}

	@Test
	public void testChosenInit() {
		String nom = "toto";
		Classs classs = Classs.MONK;
		Character c = CharacterFactory.create().withName(nom).withClass(classs).withAttributes(6, 7, 8, 9, 10, 11).build();
		Set<Integer> attributes = new HashSet<>();
		attributes.add(c.getAttributes().getStrength());
		attributes.add(c.getAttributes().getDexterity());
		attributes.add(c.getAttributes().getConstitution());
		attributes.add(c.getAttributes().getIntelligence());
		attributes.add(c.getAttributes().getWisdom());
		attributes.add(c.getAttributes().getCharisma());
		assertThat("Les attributs ne sont pas ceux fournis", attributes, contains(6, 7, 8, 9, 10, 11));
	}

	@Test
	public void testHitPoints() {
		String nom = "tata";
		Classs classs = Classs.WIZARD;

		Character c = CharacterFactory.create().withName(nom).withClass(classs).withAttributes(10, 10, 10, 10, 10, 10).build();

		assertThat("Il a entre 1 et 4 points de vie", c.getHitPoints(), allOf(greaterThanOrEqualTo(1), lessThanOrEqualTo(4)));
	}

	@Test
	public void testHitPointsWithModifier() {
		String nom = "tata";
		Classs classs = Classs.WIZARD;

		Character c = CharacterFactory.create().withName(nom).withClass(classs).withAttributes(10, 10, 18, 10, 10, 10).build();

		assertThat("Il a entre 5 et 8 points de vie", c.getHitPoints(), allOf(greaterThanOrEqualTo(5), lessThanOrEqualTo(8)));
	}

	@Test
	public void testHitPointsWithRandomModifier() {
		String nom = "tata";
		Classs classs = Classs.WIZARD;

		Character c = CharacterFactory.create().withName(nom).withClass(classs).build();

		assertThat("Il a entre -3 et 8 points de vie", c.getHitPoints(), allOf(greaterThanOrEqualTo(-3), lessThanOrEqualTo(8)));
	}

}
