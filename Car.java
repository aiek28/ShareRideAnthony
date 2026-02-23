import java.util.*;

public class Car {
    // fields
    private int seatsOccupied;
    private int destination;
    private int currStation;
    private int maxSeats;
    private int direction;
    private ArrayList<Person> passengers;

    // constructor
    public Car(int startPos, int endDestination){
        seatsOccupied = 0;
        maxSeats = 3;
        currStation = startPos;
        destination = endDestination;
        if (startPos > endDestination){
            direction = -1;
        }
        else{
            direction = 1;
        }
        passengers = new ArrayList<Person>();
    }

    public void move() {
        currStation = currStation + direction;
    }

    public ArrayList<Person> getPassengers(){
        return passengers;
    }

    public int getCurrStation(){
        return currStation;
    }

    public int getDirection(){
        return direction;
    }

    public int getDestination(){
        return destination;
    }

    public void addPerson(Person person){ //planning to loop through people at station and see if they are in the spot
        passengers.add(person);
    }


    public Person dropPerson(Person person){ 
        for (Person p: passengers){ // looping through the people in passengers and dropping them
            if (p.getID() == person.getID()){ 
                passengers.remove(p);
                return p;
            }
        }
        return null; 
    }
}



