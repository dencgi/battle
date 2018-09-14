package dad.battle.character;

import static org.hamcrest.Matchers.isA;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CharacterTest {

	@Test
	public void testCreation() {
		Character c = new Character();
		c.setName("toto");
		assertEquals("Le nom est différent", "toto", c.getName());
		c.setName("titi");
		assertEquals("Le nom est différent", "titi", c.getName());
	}

	@Test
	public void testAttributes() {
		Character c = new Character();
		c.setName("toto");
		assertEquals("Les attributs ne sont pas initialisé", 0, c.getStrength());
		assertEquals("Les attributs ne sont pas initialisé", 0, c.getDexterity());
		assertEquals("Les attributs ne sont pas initialisé", 0, c.getConstitution());
		assertEquals("Les attributs ne sont pas initialisé", 0, c.getIntelligence());
		assertEquals("Les attributs ne sont pas initialisé", 0, c.getWisdom());
		assertEquals("Les attributs ne sont pas initialisé", 0, c.getCharisma());
	}

	@Test
	public void testHitPoints() {
		Character c = new Character();
		c.setName("tata");
		assertNotNull("Le personne n'a pas de points de vie", c.getHitPoints());
		assertEquals("Le personne n'est pas au seuil de la mort", -10, c.getHitPoints());
	}

	@Test
	public void testLevel() {
		Character c = new Character();
		c.setName("titi");
		c.setLevel(5);
		assertNotNull("Le personne n'a pas de level", c.getLevel());
		assertEquals("Le personne n'a pas le niveau 5", 5, c.getLevel());
	}

	@Test
	public void testCharClass() {
		Character c = new Character();
		c.setName("tutu");
		assertNull("Le personne a une classe", c.getClasss());
		c.setClasss(Classs.PALADIN);
		assertNotNull("Le personne n'a pas de classe", c.getClasss());
		assertThat("La classe du personnage n'a pas le bon type", c.getClasss(), isA(Classs.class));
	}

	@Test
	public void testDeath() {
		Character c = new Character();
		c.setName("tati");
		c.setHitPoints(-15);
		assertTrue("Le personnage n'est pas mort", c.isDead());
		c.setHitPoints(-10);
		assertTrue("Le personnage n'est pas mort", c.isDead());
		c.setHitPoints(-8);
		assertFalse("Le personnage est mort", c.isDead());
		c.setHitPoints(3);
		assertFalse("Le personnage est mort", c.isDead());
	}

	@Test
	public void testDying() {
		Character c = new Character();
		c.setName("tati");
		c.setHitPoints(-15);
		assertFalse("Le personnage est mourrant", c.isDying());
		c.setHitPoints(-10);
		assertFalse("Le personnage est mourrant", c.isDying());
		c.setHitPoints(-8);
		assertTrue("Le personnage n'est pas mourrant", c.isDying());
		c.setHitPoints(0);
		assertFalse("Le personnage est mourrant", c.isDying());
		c.setHitPoints(3);
		assertFalse("Le personnage est mourrant", c.isDying());
	}

	@Test
	public void testDisabled() {
		Character c = new Character();
		c.setName("tati");
		c.setHitPoints(-15);
		assertFalse("Le personnage est hors combat", c.isDisabled());
		c.setHitPoints(-10);
		assertFalse("Le personnage est hors combat", c.isDisabled());
		c.setHitPoints(-8);
		assertFalse("Le personnage est hors combat", c.isDisabled());
		c.setHitPoints(0);
		assertTrue("Le personnage n'est pas hors combat", c.isDisabled());
		c.setHitPoints(3);
		assertFalse("Le personnage est hors combat", c.isDisabled());
	}

	@Test
	public void testAble() {
		Character c = new Character();
		c.setName("tati");
		c.setHitPoints(-15);
		assertFalse("Le personnage est en pleine forme", c.isAble());
		c.setHitPoints(-10);
		assertFalse("Le personnage est en pleine forme", c.isAble());
		c.setHitPoints(-8);
		assertFalse("Le personnage est en pleine forme", c.isAble());
		c.setHitPoints(0);
		assertFalse("Le personnage est en pleine forme", c.isAble());
		c.setHitPoints(3);
		assertTrue("Le personnage n'est pas en pleine forme", c.isAble());
	}

}
