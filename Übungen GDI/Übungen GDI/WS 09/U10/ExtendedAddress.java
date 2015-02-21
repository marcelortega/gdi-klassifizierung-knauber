
public interface ExtendedAddress extends Address {

	/**
	 * Liefert das im Adressobjekt eingetragene Bundesland
	 */
	public String getState();

	/**
	 * Liefert das im Adressobjekt eingetragene Land
	 */
	public String getCountry();

}
