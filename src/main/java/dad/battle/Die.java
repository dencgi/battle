package dad.battle;

import java.util.Random;

public enum Die {

	D4(4), D6(6), D8(8), D10(10), D12(12), D20(20);
	
	private int numberOfFaces;
	private Random randomizer;

	private Die(int numberOfFaces) {
		this.numberOfFaces = numberOfFaces;
		randomizer = new Random();
	}

	public int roll() {
		return randomizer.nextInt(numberOfFaces) + 1;
	}

	public int getNumberOfFaces() {
		return numberOfFaces;
	}

}
