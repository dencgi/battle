package dad.battle.character;

import dad.battle.die.Die;

/**
 * Énumération modélisant la classe d'un personnage.
 * 
 * @author dencgi
 *
 */
public enum Classs {

	BARBARIAN(Die.D12),
	BARD(Die.D6),
	CLERIC(Die.D8),
	DRUID(Die.D8),
	FIGHTER(Die.D10),
	MONK(Die.D8),
	PALADIN(Die.D10),
	RANGER(Die.D8),
	ROGUE(Die.D6),
	SORCERER(Die.D4),
	WIZARD(Die.D4);

	// Dé de vie de chaque niveau.
	private Die hitPointsDie;

	private Classs(Die hitPointsDie) {
		this.hitPointsDie = hitPointsDie;
	}

	public Die getHitPointsDie() {
		return hitPointsDie;
	}
}
