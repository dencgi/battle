package dad.battle.character;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import dad.battle.die.Die;

public class ClasssTest {

	@Test
	public void testAllClassesExists() {
		@SuppressWarnings("unused")
		Classs cc;
		cc = Classs.BARBARIAN;
		cc = Classs.BARD;
		cc = Classs.CLERIC;
		cc = Classs.DRUID;
		cc = Classs.FIGHTER;
		cc = Classs.MONK;
		cc = Classs.PALADIN;
		cc = Classs.RANGER;
		cc = Classs.ROGUE;
		cc = Classs.SORCERER;
		cc = Classs.WIZARD;
	}
	
	@Test
	public void testHitPointsDie() {
		assertEquals("Le dé de vie n'est pas correct", Die.D12, Classs.BARBARIAN.getHitPointsDie());
		assertEquals("Le dé de vie n'est pas correct", Die.D6, Classs.BARD.getHitPointsDie());
		assertEquals("Le dé de vie n'est pas correct", Die.D8, Classs.CLERIC.getHitPointsDie());
		assertEquals("Le dé de vie n'est pas correct", Die.D8, Classs.DRUID.getHitPointsDie());
		assertEquals("Le dé de vie n'est pas correct", Die.D10, Classs.FIGHTER.getHitPointsDie());
		assertEquals("Le dé de vie n'est pas correct", Die.D8, Classs.MONK.getHitPointsDie());
		assertEquals("Le dé de vie n'est pas correct", Die.D10, Classs.PALADIN.getHitPointsDie());
		assertEquals("Le dé de vie n'est pas correct", Die.D8, Classs.RANGER.getHitPointsDie());
		assertEquals("Le dé de vie n'est pas correct", Die.D6, Classs.ROGUE.getHitPointsDie());
		assertEquals("Le dé de vie n'est pas correct", Die.D4, Classs.SORCERER.getHitPointsDie());
		assertEquals("Le dé de vie n'est pas correct", Die.D4, Classs.WIZARD.getHitPointsDie());
	}

}
