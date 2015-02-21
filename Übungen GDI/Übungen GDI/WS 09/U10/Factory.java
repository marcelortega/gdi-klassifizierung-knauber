
public class Factory {

	public static ExtendedAddress createExtendedAddress( String street,
			int number, int zip, String city, String state, String country ) {
		return null;
	}

	public static Date createDate() {
		return null;
	}

	public static Date createDate( int day, int month, int year ) {
		return null;
	}

	public static ContactWithTexts createExtendedContact() {
		return null;
	}

	public static ContactWithTexts createContactWithTexts( String firstName,
			String lastName, String title, String companyName,
			String phoneAtHome, String phoneAtWork, String mobilePhone,
			String email, String url, Address homeAddress, Address workAddress,
			Date birthday, boolean birthdayReminder, String freeText,
			String notes ) {
		return null;
	}

	public static SearchableContactManager createSearchableContactManager() {
		return null;
	}

}
