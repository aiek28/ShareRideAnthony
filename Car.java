import java.util.*;

public class Car {
    // fields
    private int destination;
    private int currStation;
    private int maxSeats;
    private int direction;
    private ArrayList<Person> passengers;
    private int idNo;
    private static int idGen = 0;

    // constructor
    public Car(int startPos, int endDestination){
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
        idNo = idGen;
        idGen ++;
    }

    public boolean hasArrived(){
        return currStation == destination;
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

    public boolean hasSpace(){
        return maxSeats > passengers.size();
    }

    public int getID(){
        return idNo;
    }

    public void addPerson(Person person){ //planning to loop through people at station and see if they are in the spot
        if (hasSpace()){
            passengers.add(person);
        }
    }


    public Person dropPerson(int index){ 
        return passengers.remove(index);
    }

    public String toString(){
        return "Car ID: " + idNo +
        ", Current Station: " + currStation +
        ", destination " + destination +
        ", direction " + direction +
        ", passengers: " + passengers.size();
    }
}



