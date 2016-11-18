package dad.battle;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class DiceTest {

	@Test
	public void testRollD6() {
		for (int i = 0; i < 100; i++) {
			Dice dice = new Dice("2d6");
			assertThat("Le jeté n'est pas bon", dice.roll(), allOf(greaterThanOrEqualTo(2), lessThanOrEqualTo(12)));
		}
	}

	@Test
	public void testRollD12() {
		for (int i = 0; i < 100; i++) {
			Dice dice = new Dice("5d12");
			assertThat("Le jeté n'est pas bon", dice.roll(), allOf(greaterThanOrEqualTo(5), lessThanOrEqualTo(60)));
		}
	}

	@Test
	public void testRandomRoll() {
		Dice d = new Dice("2d6");
		Set<Integer> rolls = new HashSet<>();
		for (int i = 0; i < 12; ++i) {
			rolls.add(d.roll());
		}

		assertThat("Il n'y a qu'une seule valeur", rolls, not(hasSize(1)));

		rolls.clear();
		for (int i = 0; i < 200; ++i) {
			rolls.add(d.roll());
		}
		assertThat("Il n'y a pas 11 valeurs", rolls, hasSize(11));
	}

	@Test
	public void testFormat() {
		Dice d = null;
		try {
			d = null;
			d = new Dice("2d6*8");
		} catch (IllegalArgumentException e) {

		}
		assertNull("Il n'y a pas eu d'exception", d);

		try {
			d = null;
			d = new Dice("2d6");
		} catch (IllegalArgumentException e) {

		}
		assertNotNull("Il y a eu une exception", d);
	}

}
