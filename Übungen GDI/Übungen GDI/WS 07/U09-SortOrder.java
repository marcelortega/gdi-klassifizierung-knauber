package contactManagement;

public enum SortOrder {
	
	LAST_NAME_THEN_FIRST_NAME("Name, dann Vorname"),
	FIRST_NAME_THEN_LAST_NAME("Vorname, dann Name"),
	COMPANY_THEN_LAST_NAME("Firmenname, dann Name");
	
	private String text;
	
	SortOrder( String text ) {
		this.text = text;
	}

	public String toString() {
		return text;
	}
	
}
