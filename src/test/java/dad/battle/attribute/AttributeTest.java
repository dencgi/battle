package dad.battle.attribute;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

public class AttributeTest {

	@Test
	public void testConstructor() {
		Attribute att = new Attribute(5);

		assertEquals("La valeur n'est pas correcte", 5, att.getValue());
	}

	@Test
	public void testGetterSetter() {
		Attribute att = new Attribute();
		att.setValue(5);

		assertEquals("La valeur n'est pas correcte", 5, att.getValue());
	}

	@Test
	public void testModifier() {
		Map<Integer, Integer> valueToModifier = new HashMap<>();
		valueToModifier.put(4, -3);
		valueToModifier.put(11, 0);
		valueToModifier.put(18, 4);
		valueToModifier.put(17, 3);
		valueToModifier.put(9, -1);
		valueToModifier.put(7, -2);
		Attribute att = new Attribute();

		for (Entry<Integer, Integer> e : valueToModifier.entrySet()) {
			att.setValue(e.getKey());
			assertEquals("Le modificateur est incorrect", e.getValue().intValue(), att.getAttributeModifier());
		}
	}

}
