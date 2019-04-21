package model;

import java.util.Arrays;

public class Location {
    protected boolean[]seats = new boolean[10];
    protected String locationName;

    Location(String locationName){
        this.locationName = locationName;
        Arrays.fill(seats, Boolean.TRUE);
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public void reserveSeat()throws NoAvailableSeatsException{
        for (int i = 0; i < seats.length; i++){
            if (seats[i]){
                System.out.println("Your seat is " + i);
                seats[i] = false;
                break;
            }
            else {
                throw new NoAvailableSeatsException("TNo more available seats for location: "+this.getLocationName());
            }
        }
    }
}
