package model;

public interface Bookable {
    void bookTicket() throws NoAvailableSeatsException;
}
