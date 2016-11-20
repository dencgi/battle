package dad.battle.die;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe modélisant une poignée de dés.
 * 
 * @author dencgi
 *
 */
public class Dice {

	private List<Die> handOfDice = new ArrayList<>();
	private int modifier = 0;
	// Pattern global, ie. 3d8+2d6+1
	private static final Pattern HAND_PATTERN = Pattern.compile("^\\d+d\\d+(\\+\\d+d\\d+)*([+-]\\d+)?$");
	// Pattern représentant un groupe de dés, ie. 3d8
	private static final Pattern DICE_PATTERN = Pattern.compile("(?<numberOfDice>\\d+)d(?<numberOfSides>\\d+)");
	// Pattern représentant le modificateur, ie. +1
	private static final Pattern MODIFIER_PATTERN = Pattern.compile("(?<modifier>[+-]\\d+)$");

	/**
	 * Construit une poignée de dés.
	 * 
	 * @param hand
	 *            La poignée de dés sous forme de chaîne de caractères. Le format attendu est \d+d\d+(\+\d+d\d+)*([+-]\d+)?
	 * @throws IllegalArgumentException
	 *             Si le format de la main n'est pas correct.
	 */
	public Dice(String hand) {
		// Vérification de la syntaxe globale.
		Matcher handMatcher = HAND_PATTERN.matcher(hand);
		if (!handMatcher.matches()) {
			throw new IllegalArgumentException(hand);
		}

		// Récupération des groupes de dés.
		Matcher diceMatcher = DICE_PATTERN.matcher(hand);
		// Pour chaque groupe...
		while (diceMatcher.find()) {
			int numberOfDice = Integer.parseInt(diceMatcher.group("numberOfDice"));
			int numberOfSides = Integer.parseInt(diceMatcher.group("numberOfSides"));

			// ... les dés sont ajoutés à la liste.
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

	/**
	 * Effectue un lancé de la main de dés.
	 * 
	 * @return Le résultat du lancé.
	 */
	public int roll() {
		int result = 0;
		for (Die d : handOfDice) {
			result += d.roll();
		}
		return result + modifier;
	}
}
