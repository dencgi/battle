package dad.battle.die;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

/**
 * Énumération modélisant des dés.
 * 
 * @author dencgi
 *
 */
public enum Die {

	D4(4), D6(6), D8(8), D10(10), D12(12), D20(20);

	private int numberOfSides;
	private Random randomizer;

	private Die(int numberOfSides) {
		this.numberOfSides = numberOfSides;
		randomizer = new Random();
	}

	/**
	 * Effectue un lancé du dé.
	 * 
	 * @return Le résultat du lancé.
	 */
	public int roll() {
		return randomizer.nextInt(numberOfSides) + 1;
	}

	/**
	 * Fournit le dé dont le nombre de faces est passé en paramètre.
	 * 
	 * @param numberOfSides Nombre de faces du dé.
	 * @return Le dé correspondant au nombre de faces, ou null si aucun dé n'est
	 *         trouvé.
	 */
	public static Die get(int numberOfSides) {
		Optional<Die> found = Arrays.stream(Die.values()).filter(d -> d.numberOfSides == numberOfSides).findFirst();
		return found.isPresent() ? found.get() : null;
	}

	/* pp */ int getNumberOfSides() {
		return numberOfSides;
	}

}
