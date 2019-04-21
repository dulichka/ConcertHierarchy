package model;

import java.util.Date;

public class OperaConcert extends Concert {

    OperaConcert(String artistName, Location location, Date concertDate, double ticketPrice){
        super(artistName, location, concertDate, ticketPrice, "Opera");
    }

    OperaConcert(Concerts concert){
        super(concert);
    }

}
