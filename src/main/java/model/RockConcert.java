package model;

import model.Concert;
import model.Concerts;

import java.util.Date;

public class RockConcert extends Concert {

    RockConcert(String artistName, Location location, Date concertDate, double ticketPrice){
        super(artistName, location, concertDate, ticketPrice, "Rock");
    }

    RockConcert(Concerts concert){
        super(concert);
    }
}
