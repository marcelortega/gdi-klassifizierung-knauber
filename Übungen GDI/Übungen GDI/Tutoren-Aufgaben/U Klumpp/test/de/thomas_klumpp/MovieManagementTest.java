package de.thomas_klumpp;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static gdi.MakeItSimplePrivate.*;

/**
 * Test class for the {@link MovieManagementDatabase}.
 * You have to add a <b>public</b> constructor like this to the
 * {@link MovieManagementDatabase}:
 * <p>
 * <code>
 * 
 * public MovieManagementDatabase(Movie[] movie, Customer[] customer) {<br>
 *    this.movie = movie;<br>
 *    this.customer = customer;<br>
 * }
 * </code>
 * 
 * @author Thomas Klumpp
 */
public class MovieManagementTest {
    
    /**
     * Instance of a {@link MovieManagementDatabase}
     */
    private MovieManagementDatabase movieDB;
    
    /**
     * Array with test {@link Movie}s
     */
    private Movie[]                 movie;
    
    /**
     * Array with test {@link Customer}s
     */
    private Customer[]              customer;
    
    /**
     * Setup the test class
     */
    @Before
    public void setUp() {
        this.movie = new Movie[5 * 1000000]; //5 million movies maximum
        this.customer = new Customer[10 * 1000]; //10 thousand customers maximum
        
        Movie movie0 = new Movie("Herr der Ringe 1", "DVD", 178, 12, 2001);
        Movie movie1 = new Movie("Herr der Ringe 2", "DVD", 179, 12, 2002);
        Movie movie2 = new Movie("Herr der Ringe 3", "Blue-ray", 200, 12, 2003);
        
        this.movie[0] = movie0;
        this.movie[1] = movie1;
        this.movie[2] = movie2;
        
        Customer customer0 = new Customer("Angelina", "Jolie", "Top Secret", 90210, "Beverly Hills", 'w', "04.06.1975");
        Customer customer1 = new Customer("Max", "Mustermann", "Musterstr. 1", 1234, "Musterstadt", 'm', "01.01.2012");
        Customer customer2 = new Customer("James", "Bond", "Unknown", 1234, "London", 'm', "31.12.1950");
        
        this.customer[0] = customer0;
        this.customer[1] = customer1;
        this.customer[2] = customer2;
        
        this.movieDB = new MovieManagementDatabase(this.movie, this.customer);
    }
    
    @Test
    public void createNewMovie() {
        supplyReadLineValues("Pulp Fiction", "Blue-ray");
        supplyReadIntValues(148);
        supplyReadLineValues("");
        supplyReadIntValues(16);
        supplyReadLineValues("");
        supplyReadIntValues(1994);
        supplyReadLineValues("");
        
        Movie pulpFiction = movieDB.createNewMovie();
        
        String expected = "Filmtitel: Pulp Fiction\n" +
                          "Medientyp: Blue-ray\n" +
                          "Filmlänge in Minuten: 148\n" +
                          "Altersfreigabe FSK: 16\n" +
                          "Produktionsjahr: 1994";
        
        assertTrue(pulpFiction.toString().equals(expected));
    }
    
    @Test
    public void createNewCustomer() {
        supplyReadLineValues("Max", "Mustermann", "Musterstr. 1");
        supplyReadIntValues(1234);
        supplyReadLineValues("");
        supplyReadLineValues("Musterstadt");
        supplyReadCharValues('m');
        supplyReadLineValues("");
        supplyReadLineValues("01.01.2012");
        
        Customer maxMustermann = movieDB.createNewCustomer();
        
        String expected = "Name: Max Mustermann\n" +
                          "Adresse: Musterstr. 1\n\t " +
                          "1234 Musterstadt\n" +
                          "Geschlecht: männlich\n" +
                          "Geburtsdatum (TT.MM.JJJJ): 01.01.2012";
        
        assertTrue(maxMustermann.toString().equals(expected));
    }
    
    @Test
    public void createNewCustomerWrongDateOfBirth() {
        supplyReadLineValues("Max", "Mustermann", "Mustertr. 1");
        supplyReadIntValues(1234);
        supplyReadLineValues("");
        supplyReadLineValues("Musterstadt");
        supplyReadCharValues('m');
        supplyReadLineValues("");
        supplyReadLineValues("0101.2012"); //wrong format
        supplyReadLineValues("01.01.2012"); //do it again
        
        Customer customer = movieDB.createNewCustomer();
        
        assertNotNull(customer);
    }
    
    @Test
    public void borrowMovie() {
        supplyReadLineValues("Herr der Ringe 2", "DVD");
        supplyReadLineValues("Max", "Mustermann");
        movieDB.borrowMovie();
        
        assertEquals(customer[1], movie[1].getLendTo());
    }
    
    @Test
    public void returnMovie() {
        supplyReadLineValues("Herr der Ringe 2", "DVD");
        supplyReadLineValues("Max", "Mustermann");
        movieDB.borrowMovie();
        assertEquals(customer[1], movie[1].getLendTo());
        
        supplyReadLineValues("Herr der Ringe 2", "DVD");
        supplyReadLineValues("Max", "Mustermann");
        movieDB.returnMovie();
        assertNull(movie[1].getLendTo());
    }
    
}
