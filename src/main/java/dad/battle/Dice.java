package dad.battle;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dice {

	private List<Die> handOfDice = new ArrayList<>();
	private static final Pattern HAND_PATTERN = Pattern.compile("^(?<numberOfDice>\\d+)d(?<numberOfFaces>\\d+)$");
	
	public Dice(String hand) {
		Matcher handMatcher = HAND_PATTERN.matcher(hand);
		if (!handMatcher.matches()) {
			throw new IllegalArgumentException(hand);
		}
		int numberOfDice = Integer.parseInt(handMatcher.group("numberOfDice"));
		int numberOfFaces = Integer.parseInt(handMatcher.group("numberOfFaces"));
		
		for (int i = 0; i < numberOfDice; ++i) {
			handOfDice.add(Die.get(numberOfFaces));
		}
	}
	
	public int roll() {
		int result = 0;
		for (Die d : handOfDice) {
			result += d.roll();
		}
		return result;
	}
}
