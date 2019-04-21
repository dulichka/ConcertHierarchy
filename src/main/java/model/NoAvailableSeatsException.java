package model;

public class NoAvailableSeatsException extends Exception {
    public NoAvailableSeatsException(String message){
        super(message);
    }
}
