package de.thomas_klumpp;

/**
 * ADT represents a customer.
 * 
 * @author Thomas Klumpp
 */
public class Customer {
    
    /**
     * First name of the customer
     */
    private String firstName;
    
    /**
     * Last name of the customer
     */
    private String lastName;
    
    /**
     * Location where the customer lives
     */
    private String address;
    
    /**
     * Zip code of the customer's home town
     */
    private int    postalCode;
    
    /**
     * Customer's home town
     */
    private String city;
    
    /**
     * Gender of the customer.<br>
     * <b>m</b>ale or <b>w</b>oman
     */
    private char   gender;
    
    /**
     * Customer's birthday in dd.mm.yyyy format
     */
    private String dateOfBirth;
    
    /**
     * Creates a new customer with the given values
     * 
     * @param firstName
     *        customer's first name
     * @param lastName
     *        customer's last name
     * @param address
     *        where the customer lives
     * @param postalCode
     *        of the customer's home town
     * @param city
     *        customer's home town
     * @param gender
     *        <b>m</b>ale or <b>w</b>oman
     * @param dateOfBirth
     *        birthday in dd.mm.yyyy format
     */
    public Customer(String firstName, String lastName, String address, int postalCode, String city, char gender, String dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }
    
    /**
     * Getting customer's first name
     * 
     * @return customer's first name
     */
    public String getFirstName() {
        return firstName;
    }
    
    /**
     * Getting customer's last name
     * 
     * @return customer's last name
     */
    public String getLastName() {
        return lastName;
    }
    
    /**
     * Returns a string representation of a customer
     * 
     * @see Object#toString()
     */
    @Override
    public String toString() {
        String fullName = "Name: " + this.firstName + " " + this.lastName;
        String fullAddress = "Adresse: " + this.address + "\n\t " + this.postalCode + " " + this.city;
        String gender = "Geschlecht: " + ((this.gender == 'm') ? "männlich" : "weiblich");
        String dateOfBirth = "Geburtsdatum (TT.MM.JJJJ): " + this.dateOfBirth;
        
        return fullName + "\n" + fullAddress + "\n" + gender + "\n" + dateOfBirth;
    }
    
}
