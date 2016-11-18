package dad.battle;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class DieTest {

	private static final int VALEUR_MIN = 1;
	private static final int D4 = 4;
	private static final int D6 = 6;
	private static final int D8 = 8;
	private static final int D10 = 10;
	private static final int D12 = 12;
	private static final int D20 = 20;

	@Test
	public void testRoll() {
		for (int i = 0; i < 100; ++i) {
			Die d = Die.D6;
			int result = d.roll();
			assertThat("Mon chiffre n'est pas compris entre 1 et " + d.getNumberOfFaces(), result, allOf(greaterThanOrEqualTo(VALEUR_MIN), lessThanOrEqualTo(d.getNumberOfFaces())));
		}

		for (int i = 0; i < 100; ++i) {
			Die d = Die.D20;
			int result = d.roll();
			assertThat("Mon chiffre n'est pas compris entre 1 et " + d.getNumberOfFaces(), result, allOf(greaterThanOrEqualTo(VALEUR_MIN), lessThanOrEqualTo(d.getNumberOfFaces())));
		}
	}

	@Test
	public void testRandomRoll() {
		Die d = Die.D6;
		Set<Integer> rolls = new HashSet<>();
		for (int i = 0; i < D6; ++i) {
			rolls.add(d.roll());
		}

		assertThat("Il n'y a qu'une seule valeur", rolls, not(hasSize(1)));
	}

	@Test
	public void testNumberOfFaces() {
		Die d = Die.D6;
		assertEquals("Le nombre de face n'est pas correct", D6, d.getNumberOfFaces());
		d = Die.D20;
		assertEquals("Le nombre de face n'est pas correct", D20, d.getNumberOfFaces());
	}
	
	@Test
	public void testAllDice() {
		assertEquals("Le nombre de face n'est pas correct", D4, Die.D4.getNumberOfFaces());
		assertEquals("Le nombre de face n'est pas correct", D6, Die.D6.getNumberOfFaces());
		assertEquals("Le nombre de face n'est pas correct", D8, Die.D8.getNumberOfFaces());
		assertEquals("Le nombre de face n'est pas correct", D10, Die.D10.getNumberOfFaces());
		assertEquals("Le nombre de face n'est pas correct", D12, Die.D12.getNumberOfFaces());
		assertEquals("Le nombre de face n'est pas correct", D20, Die.D20.getNumberOfFaces());
	}
	
	@Test
	public void testFabrique() {
		assertEquals("Le nombre de face n'est pas de 6", 6, Die.get(6).getNumberOfFaces());
		assertEquals("Le nombre de face n'est pas de 12", 12, Die.get(12).getNumberOfFaces());
		assertEquals("Le nombre de face n'est pas de 20", 20, Die.get(20).getNumberOfFaces());
	}

}
