package dad.battle.character;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isA;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import dad.battle.character.Character;
import dad.battle.character.Classs;

public class CharacterTest {

	@Test
	public void testCreation() {
		Character c = new Character("toto");
		assertEquals("Le nom est différent", "toto", c.getName());
	}
	
	@Test
	public void testAttributes() {
		Character c = new Character("toto");
		assertNotEquals("Les attributs sont nuls", 0, c.getStrength());
		assertNotEquals("Les attributs sont nuls", 0, c.getDexterity());
		assertNotEquals("Les attributs sont nuls", 0, c.getConstitution());
		assertNotEquals("Les attributs sont nuls", 0, c.getIntelligence());
		assertNotEquals("Les attributs sont nuls", 0, c.getWisdom());
		assertNotEquals("Les attributs sont nuls", 0, c.getCharisma());
	}
	
	@Test
	public void testRandomAttributes() {
		Character c = new Character("toto");
		Set<Integer> attributes = new HashSet<>();
		attributes.add(c.getStrength());
		attributes.add(c.getDexterity());
		attributes.add(c.getConstitution());
		attributes.add(c.getIntelligence());
		attributes.add(c.getWisdom());
		attributes.add(c.getCharisma());
		assertThat("Les attributs sont tous identiques", attributes, not(hasSize(1)));
		assertThat("Les attributs ne sont pas compris entre 3 et 18", attributes, everyItem(allOf(greaterThanOrEqualTo(3), lessThanOrEqualTo(18))));
	}
	
	@Test
	public void testHitPoints() {
		Character c = new Character("tata");
		assertNotNull("Le personne n'a pas de points de vie", c.getHitPoints());
	}
	
	@Test
	public void testLevel() {
		Character c = new Character("titi");
		assertNotNull("Le personne n'a pas de level", c.getLevel());
		assertNotEquals("Le personne a le niveau 0", 0, c.getLevel());
	}
	
	@Test
	public void testCharClass() {
		Character c = new Character("tutu");
		assertNotNull("Le personne n'a pas de classe", c.getClasss());
		assertThat("La classe du personnage n'a pas le bon type", c.getClasss(), isA(Classs.class));
	}

}
