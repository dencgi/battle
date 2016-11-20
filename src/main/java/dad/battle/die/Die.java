package dad.battle.die;

import java.util.Random;

public enum Die {

	D4(4), D6(6), D8(8), D10(10), D12(12), D20(20);

	private int numberOfSides;
	private Random randomizer;

	private Die(int numberOfSides) {
		this.numberOfSides = numberOfSides;
		randomizer = new Random();
	}

	public int roll() {
		return randomizer.nextInt(numberOfSides) + 1;
	}

	public static Die get(int numberOfSides) {
		for (Die d : Die.values()) {
			if (d.numberOfSides == numberOfSides) {
				return d;
			}
		}
		return null;
	}

	public int getNumberOfSides() {
		return numberOfSides;
	}

}
