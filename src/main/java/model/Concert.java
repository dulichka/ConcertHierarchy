package model;

import java.util.Date;

public class Concert implements Bookable {
    protected String artistName;
    protected Location location;
    protected double ticketPrice;
    protected Date concertDate;
    private String genre;

    public Concert(){
    }

    public Concert(Concerts concert){
        artistName = concert.getArtistName();
        location = concert.getLocation();
        ticketPrice = concert.getTicketPrice();
        concertDate = getConcertDate();
    }

    public Concert(String artistName, Location location, Date concertDate, double ticketPrice, String genre){
        this.artistName = artistName;
        this.location = location;
        this.concertDate = concertDate;
        this.ticketPrice = ticketPrice;
        this.genre = String.valueOf(genre);
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Date getConcertDate() {
        return concertDate;
    }

    public void setConcertDate(Date concertDate) {
        this.concertDate = concertDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


    @Override
    public void bookTicket() throws NoAvailableSeatsException {
        this.location.reserveSeat();
    }
}
