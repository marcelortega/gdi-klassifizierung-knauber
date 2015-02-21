package de.thomas_klumpp;

import static gdi.MakeItSimple.*;

/**
 * Handles the hole {@literal MovieManagementDatabase}. The business logic is
 * located here.
 * 
 * @author Thomas Klumpp
 */
public class MovieManagementDatabase {
    
    /**
     * Container for all movies in the database
     */
    private Movie[]    movie    = new Movie[5 * 1000000]; //5 million movies maximum
                                                           
    /**
     * Container for all customers in the database
     */
    private Customer[] customer = new Customer[10 * 1000]; //10 thousand customers maximum
                                                           
    /**
     * Ctor to avoid creating an instance from outside this class.
     */
    private MovieManagementDatabase() {
        //no instances from outside
    }
    
    /**
     * Ctor for testing purposes only
     * 
     * @param movie
     *        array with movies for tests
     * @param customer
     *        array with customers for tests
     */
    public MovieManagementDatabase(Movie[] movie, Customer[] customer) {
        this.movie = movie;
        this.customer = customer;
    }
    
    /**
     * Program entry point.
     * A new instance of {@literal MovieManagementDatabase} will be created and
     * the main menu'll be called.
     * 
     * @param args
     *        not necessary
     */
    public static void main(String[] args) {
        MovieManagementDatabase movieDB = new MovieManagementDatabase();
        movieDB.callMainMenu();
    }
    
    /**
     * Main menu of the current {@link MovieManagementDatabase} instance
     */
    public void callMainMenu() {
        int menuSelection;
        int movieCounter = 0;
        int customerCounter = 0;
        
        do {
            println("\n--- Hauptmenü ---");
            println("1. Neuen Film anlegen");
            println("2. Neuen Kunden anlegen");
            println("3. Film ausleihen");
            println("4. Film zurückgeben");
            println("5. Auflistung aller Filme");
            println("6. Auflistung aller Kunden");
            println("7. Erzeuge Statistik");
            println("8. Programm beenden");
            
            print("\nBitte Aktion wählen (1-7): ");
            menuSelection = readInt();
            readLine();
            
            switch (menuSelection) {
                case 1:
                    if (!(movieCounter == movie.length)) {
                        movie[movieCounter++] = this.createNewMovie();
                    } else {
                        println("Filmspeicher voll!");
                    }
                    break;
                case 2:
                    if (!(customerCounter == customer.length)) {
                        customer[customerCounter++] = this.createNewCustomer();
                    } else {
                        println("Kundenspeicher voll!");
                    }
                    break;
                case 3:
                    this.borrowMovie();
                    break;
                case 4:
                    this.returnMovie();
                    break;
                case 5:
                    this.printAllMovies();
                    break;
                case 6:
                    this.printAllCustomers();
                    break;
                case 7:
                    this.printStatistics(movieCounter, customerCounter);
                    break;
                case 8:
                    println("Programm beendet!");
                    break;
                default:
                    println("\nUngültige Menüauswahl!\n");
            }
        } while (menuSelection != 8);
    }
    
    /**
     * Create a new movie. The required parameters are requested from the user.
     * 
     * @return a new {@link Movie}
     */
    public Movie createNewMovie() {
        println("\n--- Neuen Film anlegen ---\n");
        
        String movieTitle;
        do {
            print("Filmtitel: ");
            movieTitle = readLine();
            if (strLen(movieTitle) <= 0) {
                println("Filmtitel darf nicht leer sein!");
            }
        } while (strLen(movieTitle) <= 0);
        
        String mediaType;
        do {
            print("Medientyp: ");
            mediaType = readLine();
            if (strLen(mediaType) <= 0) {
                println("Medientyp darf nicht leer sein!");
            }
        } while (strLen(mediaType) <= 0);
        
        print("Filmlänge in Minuten: ");
        int length = readInt();
        readLine();
        
        print("Altersfreigabe FSK: ");
        int ageRating = readInt();
        readLine();
        
        print("Produktionsjahr: ");
        int productionYear = readInt();
        readLine();
        
        return new Movie(movieTitle, mediaType, length, ageRating, productionYear);
    }
    
    /**
     * Create a new customer. The required parameters are requested from the
     * user.
     * 
     * @return a new {@link Customer}
     */
    public Customer createNewCustomer() {
        println("\n--- Neuen Kunden anlegen ---\n");
        
        String firstName;
        do {
            print("Vorname: ");
            firstName = readLine();
            if (strLen(firstName) <= 0) {
                println("Vorname darf nicht leer sein!");
            }
        } while (strLen(firstName) <= 0);
        
        String lastName;
        do {
            print("Nachname: ");
            lastName = readLine();
            if (strLen(lastName) <= 0) {
                println("Nachname darf nicht leer sein!");
            }
        } while (strLen(lastName) <= 0);
        
        String address;
        do {
            print("Adresse: ");
            address = readLine();
            if (strLen(address) <= 0) {
                println("Adresse darf nicht leer sein!");
            }
        } while (strLen(address) <= 0);
        
        print("Postleitzahl: ");
        int postalCode = readInt();
        readLine();
        
        String city;
        do {
            print("Stadt: ");
            city = readLine();
            if (strLen(city) <= 0) {
                println("Stadt darf nicht leer sein!");
            }
        } while (strLen(city) <= 0);
        
        char gender;
        do {
            print("Geschlecht (m oder w): ");
            gender = readChar();
            readLine();
            if (gender != 'm' && gender != 'w') {
                println("Geschlechtsangabe ungültig!");
            }
        } while (gender != 'm' && gender != 'w');
        
        String dateOfBirth;
        do {
            print("Geburtsdatum (TT.MM.JJJJ): ");
            dateOfBirth = readLine();
            if (strLen(dateOfBirth) != 10 || strCharAt(dateOfBirth, 2) != '.' || strCharAt(dateOfBirth, 5) != '.') {
                println("Geburtsdatum ungültig!");
            }
        } while (strLen(dateOfBirth) != 10 || strCharAt(dateOfBirth, 2) != '.' || strCharAt(dateOfBirth, 5) != '.');
        
        return new Customer(firstName, lastName, address, postalCode, city, gender, dateOfBirth);
    }
    
    /**
     * Borrows an existing movie. The required parameters (which movie and
     * which customer) are requested from the user.
     */
    public void borrowMovie() {
        if (movie[0] == null || customer[0] == null) {
            println("\nEs muss mindestens ein Film und ein Kunde vorhanden sein!");
        } else {
            println("--- Film ausleihen ---");
            
            println("Welcher Film soll ausgeliehen werden?");
            String movieTitle;
            do {
                print("Filmtitel: ");
                movieTitle = readLine();
                if (strLen(movieTitle) <= 0) {
                    println("Filmtitel darf nicht leer sein!");
                }
            } while (strLen(movieTitle) <= 0);
            
            String mediaType;
            do {
                print("Medientyp: ");
                mediaType = readLine();
                if (strLen(mediaType) <= 0) {
                    println("Medientyp darf nicht leer sein!");
                }
            } while (strLen(mediaType) <= 0);
            
            Movie foundMovie = this.searchMovie(movieTitle, mediaType);
            
            //search only for customer if a matching movie was found
            if (foundMovie != null) {
                println("Wer soll den Film ausleihen?");
                String firstName;
                do {
                    print("Vorname: ");
                    firstName = readLine();
                    if (strLen(firstName) <= 0) {
                        println("Vorname darf nicht leer sein!");
                    }
                } while (strLen(firstName) <= 0);
                
                String lastName;
                do {
                    print("Nachname: ");
                    lastName = readLine();
                    if (strLen(lastName) <= 0) {
                        println("Nachname darf nicht leer sein!");
                    }
                } while (strLen(lastName) <= 0);
                
                Customer foundCustomer = this.searchCustomer(firstName, lastName);
                
                if (foundCustomer != null) {
                    foundMovie.setLendTo(foundCustomer); //borrow the movie
                    println("\nFilm wurde erfolgreich ausgeliehen!");
                } else {
                    println("\nEs wurde kein passender Kunde gefunden!");
                }
                
            } else {
                println("\nEs wurde kein passender Film gefunden!");
            }
        }
    }
    
    /**
     * Returns a borrwed movie. The required parameter (which movie) is
     * requested from the user.
     */
    public void returnMovie() {
        //check if a lend movie is existent
        boolean lendMovie = false;
        int i = 0;
        while (movie[i] != null) {
            if (movie[i].getLendTo() != null) {
                lendMovie = true;
            }
            i++;
        }
        
        if (lendMovie) {
            println("--- Film zurückgeben ---");
            
            println("Welcher Film soll zurückgegeben werden?");
            String movieTitle;
            do {
                print("Filmtitel: ");
                movieTitle = readLine();
                if (strLen(movieTitle) <= 0) {
                    println("Filmtitel darf nicht leer sein!");
                }
            } while (strLen(movieTitle) <= 0);
            
            String mediaType;
            do {
                print("Medientyp: ");
                mediaType = readLine();
                if (strLen(mediaType) <= 0) {
                    println("Medientyp darf nicht leer sein!");
                }
            } while (strLen(mediaType) <= 0);
            
            //search movie in the array
            Movie foundMovie = this.searchMovie(movieTitle, mediaType);
            
            if (foundMovie != null) {
                foundMovie.setLendTo(null); //return the movie
            } else {
                println("Es wurde kein passender Film gefunden!");
            }
        } else {
            println("\nKeine ausgeliehenen Filme vorhanden!");
        }
    }
    
    /**
     * Searches the {@link #movie} array for the given parameters.
     * 
     * @param title
     *        the title of the movie
     * @param mediaType
     *        the medium on which the movie is
     * @return first found {@link Movie} or <b>null</b> if no matching movie
     *         was found
     */
    private Movie searchMovie(String title, String mediaType) {
        int i = 0;
        while (movie[i] != null) {
            if ((movie[i].getTitle().equals(title)) && (movie[i].getMediaType().equals(mediaType))) {
                return movie[i]; //return first matching movie
            }
            i++;
        }
        
        //nothing found
        return null;
    }
    
    /**
     * Searches the {@link #customer} array for the given parameters.
     * 
     * @param firstName
     *        of the customer
     * @param lastName
     *        of the customer
     * @return first found {@link Customer} of <b>null</b> if no matching
     *         customer was found
     */
    private Customer searchCustomer(String firstName, String lastName) {
        int i = 0;
        while (customer[i] != null) {
            if ((customer[i].getFirstName().equals(firstName)) && (customer[i].getLastName().equals(lastName))) {
                return customer[i]; //return first matching customer
            }
            i++;
        }
        
        //nothing found
        return null;
    }
    
    /**
     * Prints all movies in the {@link #movie} array to the stdout by using the
     * {@link Movie#toString()} representation.
     */
    public void printAllMovies() {
        if (movie[0] == null) {
            println("\nKeine Filme vorhanden!");
        } else {
            println("\n--- Auflistung aller Filme ---");
            println("\n-------------------------");
            int i = 0;
            while (movie[i] != null) {
                println(movie[i++]); //calls toString()
                println("-------------------------");
            }
        }
    }
    
    /**
     * Prints all customers in the {@link #customer} array to the stdout by
     * using the {@link Customer#toString()} representation.
     */
    public void printAllCustomers() {
        if (customer[0] == null) {
            println("\nKeine Kunden vorhanden!");
        } else {
            println("\n--- Auflistung aller Kunden ---");
            println("\n-------------------------");
            int i = 0;
            while (customer[i] != null) {
                println(customer[i++]); //calls toString()
                println("-------------------------");
            }
        }
    }
    
    /**
     * Prints statistics of the current database state to the stdout
     * 
     * @param movieCount
     *        current movie count
     * @param customerCount
     *        current customer count
     */
    public void printStatistics(int movieCount, int customerCount) {
        println("\n--- Statistik --");
        
        print("Anzahl der Filme: ");
        println(movieCount);
        
        print("Anzahl der Kunden: ");
        println(customerCount);
        
        print("Anzahl der Filme, die eine Jugendfreigabe haben (<18): ");
        int i = 0;
        int ageRatingFreeCounter = 0;
        while (movie[i] != null) {
            if (movie[i].getAgeRating() < 18) {
                ageRatingFreeCounter++;
            }
            i++;
        }
        println(ageRatingFreeCounter);
        
        print("Anzahl der Filme, die keine Jugendfreigabe haben (>18): ");
        println(movieCount - ageRatingFreeCounter); //no secound iteration over the array necessary
    }
    
}
