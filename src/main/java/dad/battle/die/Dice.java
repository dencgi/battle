package dad.battle.die;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dice {

	private List<Die> handOfDice = new ArrayList<>();
	private int modifier = 0;
	private static final Pattern HAND_PATTERN = Pattern.compile("^\\d+d\\d+(\\+\\d+d\\d+)*([+-]\\d+)?$");
	private static final Pattern DICE_PATTERN = Pattern.compile("(?<numberOfDice>\\d+)d(?<numberOfSides>\\d+)");
	private static final Pattern MODIFIER_PATTERN = Pattern.compile("(?<modifier>[+-]\\d+)$");

	public Dice(String hand) {
		// Vérification de la syntaxe globale.
		Matcher handMatcher = HAND_PATTERN.matcher(hand);
		if (!handMatcher.matches()) {
			throw new IllegalArgumentException(hand);
		}

		// Récupération des groupes de dés.
		Matcher diceMatcher = DICE_PATTERN.matcher(hand);
		while (diceMatcher.find()) {
			int numberOfDice = Integer.parseInt(diceMatcher.group("numberOfDice"));
			int numberOfSides = Integer.parseInt(diceMatcher.group("numberOfSides"));

			for (int i = 0; i < numberOfDice; ++i) {
				handOfDice.add(Die.get(numberOfSides));
			}
		}
		
		// Récupération du modificateur.
		Matcher modifierMatcher = MODIFIER_PATTERN.matcher(hand);
		if (modifierMatcher.find()) {
			modifier = Integer.parseInt(modifierMatcher.group("modifier"));
		}
	}

	public int roll() {
		int result = 0;
		for (Die d : handOfDice) {
			result += d.roll();
		}
		return result + modifier;
	}
}
