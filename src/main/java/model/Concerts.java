package model;

import java.util.Date;

/**
 * This enum is for simulation of available concerts DB.
 *
 * @author dulichka
 */

public enum Concerts implements Bookable{
    CONCERT_ONE("AC/DC", new Location("Olympic NSC"),
            new Date(2019, 6, 12, 19, 0), 2500, Genre.ROCK),
    CONCERT_TWO("Slava Komisarenko", new Location("Atlas"), new Date(2019, 3, 17, 21, 0), 250, Genre.STAND_UP),
    CONCERT_THREE("Black Opera", new Location("National Opera Theatre"), new Date(2019, 9, 1, 20, 0), 500, Genre.OPERA);

    private String artistName;
    private Location location;
    private double ticketPrice;
    private Date concertDate;
    private String genre;

    @Override
    public void bookTicket() {
        this.location.reserveSeat();
    }

    public enum Genre {OPERA, ROCK, STAND_UP};

    Concerts(){

    }

    Concerts(String artistName, Location location, Date concertDate, double ticketPrice, Genre genre){
        this.artistName = artistName;
        this.location = location;
        this.concertDate = concertDate;
        this.ticketPrice = ticketPrice;
        this.genre = String.valueOf(genre);
    }

    public String getGenre() {
        return genre;
    }

    public Date getConcertDate() {
        return concertDate;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public Location getLocation() {
        return location;
    }

    public String getArtistName() {
        return artistName;
    }

    @Override
    public String toString() {
        return "Artist name: " + artistName +
                "\nLocation: " + location.getLocationName() +
                "\nTicket price: " + ticketPrice +
                "\nDate: " + concertDate +
                "\nGenre: " + genre +
                "\n__________________________";
    }
}
