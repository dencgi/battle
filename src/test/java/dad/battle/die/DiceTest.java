package dad.battle.die;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import dad.battle.die.Dice;

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

	@Test(expected = IllegalArgumentException.class)
	public void testIncorrectFormat1() {
		new Dice("2d6*8");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testIncorrectFormat2() {
		new Dice("2d6a");
	}

	@Test
	public void testCorrectFormat1() {
		new Dice("2d6");
	}

	@Test
	public void testRollFormat1() {
		Dice d = new Dice("2d6");
		for (int i = 0; i < 100; i++) {
			assertThat("Le jeté n'est pas bon", d.roll(), allOf(greaterThanOrEqualTo(2), lessThanOrEqualTo(12)));
		}

	}

	@Test
	public void testCorrectFormat2() {
		new Dice("2d6+3d8");
	}

	@Test
	public void testRollFormat2() {
		Dice d = new Dice("2d6+3d8");
		for (int i = 0; i < 100; i++) {
			assertThat("Le jeté n'est pas bon", d.roll(), allOf(greaterThanOrEqualTo(5), lessThanOrEqualTo(36)));
		}
	}
	
	@Test
	public void testRollRepartitionFormat2() {
		Dice d = new Dice("2d6+3d8");
		Set<Integer> results = new HashSet<>();
		for (int i = 0; i < 10000; i++) {
			results.add(d.roll());
		}
		assertThat("Le jeté n'est pas bon", results, hasItems(8, 10, 20, 33));
	}

	@Test
	public void testCorrectFormat3() {
		new Dice("1d8+1");
	}
	
	@Test
	public void testRollRepartitionFormat3() {
		Dice d = new Dice("1d8+1");
		Set<Integer> results = new HashSet<>();
		for (int i = 0; i < 1000; i++) {
			results.add(d.roll());
		}
		assertThat("Le jeté n'est pas bon", results, containsInAnyOrder(2, 3, 4, 5, 6, 7, 8, 9));
	}

	@Test
	public void testCorrectFormat4() {
		new Dice("2d6+1d12+3");
	}
	
	@Test
	public void testRollRepartitionFormat4() {
		Dice d = new Dice("2d6+1d12+3");
		Set<Integer> results = new HashSet<>();
		for (int i = 0; i < 10000; i++) {
			results.add(d.roll());
		}
		assertThat("Le jeté n'est pas bon", results, hasItems(6, 10, 27));
	}
	
	@Test
	public void testRollRepartitionFormat5() {
		Dice d = new Dice("1d8-1");
		Set<Integer> results = new HashSet<>();
		for (int i = 0; i < 1000; i++) {
			results.add(d.roll());
		}
		assertThat("Le jeté n'est pas bon", results, containsInAnyOrder(0, 1, 2, 3, 4, 5, 6, 7));
	}
}
