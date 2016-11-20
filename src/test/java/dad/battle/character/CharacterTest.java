package dad.battle.character;

import static org.hamcrest.Matchers.isA;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CharacterTest {

	@Test
	public void testCreation() {
		Character c = new Character("toto");
		assertEquals("Le nom est différent", "toto", c.getName());
	}
	
	@Test
	public void testAttributes() {
		Character c = new Character("toto");
		assertEquals("Les attributs ne sont pas initialisé", 0, c.getStrength());
		assertEquals("Les attributs ne sont pas initialisé", 0, c.getDexterity());
		assertEquals("Les attributs ne sont pas initialisé", 0, c.getConstitution());
		assertEquals("Les attributs ne sont pas initialisé", 0, c.getIntelligence());
		assertEquals("Les attributs ne sont pas initialisé", 0, c.getWisdom());
		assertEquals("Les attributs ne sont pas initialisé", 0, c.getCharisma());
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
		assertNull("Le personne a une classe", c.getClasss());
		c.setClasss(Classs.PALADIN);
		assertNotNull("Le personne n'a pas de classe", c.getClasss());
		assertThat("La classe du personnage n'a pas le bon type", c.getClasss(), isA(Classs.class));
	}

}
