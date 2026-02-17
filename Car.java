import java.util.*;

public class Car {
    // fields
    private int seatsOccupied;
    private int destination;
    private int currStation;
    private int maxSeats;
    private int direction;
    private ArrayList<Person> people;
    
    // constructor
    public car(int startPos, int endDestination){
        seatsOccupied = 0;
        maxSeats = 3;
        currStation = startPos;
        destination = endDestination;
    }

}
