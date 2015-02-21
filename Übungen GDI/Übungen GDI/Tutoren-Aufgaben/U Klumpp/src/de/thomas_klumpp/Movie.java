package de.thomas_klumpp;

/**
 * ADT represents a movie.
 * 
 * @author Thomas Klumpp
 */
public class Movie {
    
    /**
     * Name of the Movie
     */
    private String   title;
    
    /**
     * Medium on which the movie is. e.g. DVD, Blue-ray, VHS,...
     */
    private String   mediaType;
    
    /**
     * Movie length in minutes
     */
    private int      length;
    
    /**
     * Age rating of the movie (FSK).<br>
     * > 18 not for adolescent person
     */
    private int      ageRating;
    
    /**
     * Production year of the movie
     */
    private int      productionYear;
    
    /**
     * Customer who has the movie at the moment
     */
    private Customer lendTo;
    
    /**
     * Creates a new movie with the given values
     * 
     * @param title
     *        movie title
     * @param mediaType
     *        medium, e.g. DVD or Blue-ray
     * @param length
     *        in minutes
     * @param ageRating
     *        of the movie (FSK)
     * @param productionYear
     *        when the movie was producted
     */
    public Movie(String title, String mediaType, int length, int ageRating, int productionYear) {
        this.title = title;
        this.mediaType = mediaType;
        this.length = length;
        this.ageRating = ageRating;
        this.productionYear = productionYear;
    }
    
    /**
     * Getting the movie title
     * 
     * @return title of the movie
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * Getting the medium
     * 
     * @return medium on which the movie is
     */
    public String getMediaType() {
        return mediaType;
    }
    
    /**
     * Getting current borrower
     * 
     * @return Customer who has the movie atm
     */
    public Customer getLendTo() {
        return lendTo;
    }
    
    /**
     * Setting current borrower
     * 
     * @param lendTo
     *        current borrower or <b>null</b>, if there is nobody atm
     */
    public void setLendTo(Customer lendTo) {
        this.lendTo = lendTo;
    }
    
    /**
     * Getting age rating
     * 
     * @return number allowed age
     */
    public int getAgeRating() {
        return ageRating;
    }
    
    /**
     * Returns a string representation of a movie.<br>
     * {@link #lendTo} is only available if the field is not null.
     * 
     * @see Object#toString()
     */
    @Override
    public String toString() {
        String title = "Filmtitel: " + this.title;
        String mediaType = "Medientyp: " + this.mediaType;
        String length = "Filmlänge in Minuten: " + this.length;
        String ageRating = "Altersfreigabe FSK: " + this.ageRating;
        String productionYear = "Produktionsjahr: " + this.productionYear;
        
        //return lendTo only if a movie is lend
        String lendTo = "";
        if (getLendTo() != null) {
            lendTo = "\nZur Zeit ausgeliehen an: " + this.getLendTo().getFirstName() + " " + this.getLendTo().getLastName();
        }
        
        return title + "\n" + mediaType + "\n" + length + "\n" + ageRating + "\n" + productionYear + lendTo;
    }
    
}
