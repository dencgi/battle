package dad.battle.attribute;

public class Attribute {
	
	private static final int DEFAULT_VALUE = 9;

	private int value;

	public Attribute() {
		value = DEFAULT_VALUE;
	}

	public Attribute(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * Calcule le modificateur pour la valeur d'attribut passé en paramètre.
	 * 
	 * <ul>
	 * <li>Pour un attribut de 10, le modificateur est 0.</li>
	 * <li>Le modificateur augmente (ou diminue) de 1, tous les 2 points
	 * d'attribut.</li>
	 * </ul>
	 * 
	 * @param ability Valeur de l'attribut dont on veut calculer le modificateur.
	 * @return Le modificateur.
	 */
	public int getAttributeModifier() {
		return value % 2 == 0 ? (value - 10) / 2 : (value - 11) / 2;
	}
}
