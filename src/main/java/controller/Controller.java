package controller;

import model.Concert;
import model.Concerts;
import model.NoAvailableSeatsException;
import view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * This class is for handling user actions.
 * @see Concert
 * @see Concerts
 *
 * Controller calls View for displaying messages and results.
 * @see View
 *
 * @author dulichka
 */

public class Controller {

    Concert concert;
    View view;
    Scanner sc = new Scanner(System.in);

    public Controller(Concert concert, View view){
        this.concert = concert;
        this.view = view;
    }

    /**
     * Console menu function.
     */
    public void controlUser(){
        boolean exit;
        do{
            view.printMessage(View.bundle.getString(View.INPUT_STRING_DATA));
            exit = userChoice(controlUserChoice());
        } while (exit);

    }

    /**
     * Checks if user entered correct value.
     * @return valid integer choice for console menu.
     */

    private int controlUserChoice(){
        while (!sc.hasNextInt()) {
            sc.next();
            view.printMessage(View.bundle.getString(View.WRONG_INPUT_TYPE));
        }
        return sc.nextInt();
    }

    /**
     *This method is defined for sorting available concerts by sortParemeter
     * @param sortParameter is for defining sorting criteria
     * @param reverse is for descending order.
     */

    public void sort(String sortParameter, boolean reverse){
        List<Concerts> allConcerts = new ArrayList<>(Arrays.asList(Concerts.CONCERT_ONE, Concerts.CONCERT_TWO, Concerts.CONCERT_THREE));

        if(!reverse){
            allConcerts.stream()
                    .sorted((p1, p2) -> {
                        switch (sortParameter.toLowerCase()){
                            case "genre": return p1.getGenre().compareTo(p2.getGenre());
                            case "date": return p1.getConcertDate().compareTo(p2.getConcertDate());
                            case "price": return (int) (p1.getTicketPrice() - p2.getTicketPrice());
                            case "artist": return p1.getArtistName().compareTo(p2.getArtistName());
                            case "location": return p1.getLocation().getLocationName().compareTo(p2.getLocation().getLocationName());
                            default: return 0;
                        }
                    })
                    .forEach(c -> System.out.println(c.toString()));
        }
        else {
            allConcerts.stream()
                    .sorted((p1, p2) -> {
                        switch (sortParameter.toLowerCase()){
                            case "genre": return p2.getGenre().compareTo(p1.getGenre());
                            case "date": return p2.getConcertDate().compareTo(p1.getConcertDate());
                            case "price": return (int) (p2.getTicketPrice() - p1.getTicketPrice());
                            case "artist": return p2.getArtistName().compareTo(p1.getArtistName());
                            case "location": return p2.getLocation().getLocationName().compareTo(p1.getLocation().getLocationName());
                            default: return 0;
                        }
                    })
                    .forEach(c -> System.out.println(c.toString()));
        }
    }

    /**
     * This method is defined for sorting available concerts by sortParemeter.
     * @param pickParameter is for defining criteria of showing info.
     */

    public void pick(String pickParameter) {
        List<Concerts> allConcerts = new ArrayList<>(Arrays.asList(Concerts.CONCERT_ONE, Concerts.CONCERT_TWO, Concerts.CONCERT_THREE));
        allConcerts.stream()
                .filter(c -> {
                    switch (pickParameter.toLowerCase()){
                        case "genre": return c.getGenre().equals(pickParameter.toUpperCase());
                        case "date": return c.getConcertDate().equals(pickParameter);
                        //case "price": return c.getTicketPrice();
                        case "artist": return c.getArtistName().toLowerCase().equals(pickParameter);
                        case "location": return c.getArtistName().toLowerCase().equals(pickParameter);
                        default: return false;
                    }
                })
                .forEach(c -> System.out.println(c.toString()));
    }

    /**
     * This method is for user menu positions shifts.
     * @param choice defines the action to do.
     * @return
     */

    public boolean userChoice(int choice){
        switch (choice){
            case 1:
                view.printStringInput(View.SORT_PARAMETER);
                sortParameterChoice(controlUserChoice());
                return true;
            case 2:
                view.printStringInput(View.PICK_PARAMETER);
                pickParameterChoice(controlUserChoice());
                return true;
            case 3:
                view.printStringInput(View.CONCERTS_INFO);
                try {
                    chooseConcertToBook();
                } catch (NoAvailableSeatsException noSeats){
                    System.err.println(noSeats.getMessage());
                }
                return true;

            case 0:
                return false;
            default:
                return false;
        }
    }

    public void sortParameterChoice(int userParameter){
        boolean isReversed = false;
        //ADD ISREVERSED INPUT
        switch (userParameter){
            case 1: sort("genre", isReversed); break;
            case 2: sort("date", isReversed); break;
            case 3: sort("price", isReversed); break;
            case 4: sort("artist", isReversed); break;
            case 5: sort("location", isReversed); break;
        }
    }

    public void pickParameterChoice(int userParameter){
        switch (userParameter){
            case 1: pick("genre"); break;
            case 2: pick("date"); break;
            case 3: pick("price"); break;
            case 4: pick("artist"); break;
            case 5: pick("location"); break;
        }
    }

    /**
     * This method is for choosing a concert for booking a ticket.
     */
    public void chooseConcertToBook() throws NoAvailableSeatsException {
        List<Concerts> allConcerts = new ArrayList<>(Arrays.asList
                (Concerts.CONCERT_ONE, Concerts.CONCERT_TWO, Concerts.CONCERT_THREE));
        allConcerts.stream().forEach(c -> System.out.println(c.toString()));
        view.printMessage(View.bundle.getString(View.LOCATION_INPUT));
        Scanner scc = new Scanner(System.in);
        String chosenLocation = scc.nextLine();
        if(allConcerts.stream()
                .anyMatch(n -> n.getLocation().getLocationName().toLowerCase()
                        .equals(chosenLocation.toLowerCase()))){

            allConcerts.stream()
                    .filter(n -> n.getLocation().getLocationName().toLowerCase()
                            .equals(chosenLocation.toLowerCase()))
                    .forEach(Concerts::bookTicket);

        }
    }

}
