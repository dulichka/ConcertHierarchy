package model;

import model.Concert;
import model.Concerts;

import java.util.Date;

public class StandUpConcert extends Concert {

    StandUpConcert(String artistName, Location location, Date concertDate, double ticketPrice){
        super(artistName, location, concertDate, ticketPrice, "Stand up");
    }

    StandUpConcert(Concerts concert){
        super(concert);
    }
}
