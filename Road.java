import java.util.*;

public class Road {
    private Station[] stations;
    private ArrayList<Car> carsTraveling;
    private ArrayList<Car> carsArrived;
    private ArrayList<Person> peopleTraveling;
    private ArrayList<Person> peopleArrived;
    private int numStations;
    private static int iterator;

    public Road(){
        carsTraveling = new ArrayList<Car>();
        carsArrived = new ArrayList<Car>();
        peopleTraveling = new ArrayList<Person>();
        peopleArrived = new ArrayList<Person>();
        iterator = 0;
    }   

    public void populateStations(int num) { // populate station with s
        numStations = num;
        stations = new Station[numStations]; // creating new Station that is 32 long
        
        for (int i = 0; i < numStations; i++) {
            stations[i] = new Station(); // adding the stations
        }
    }

    public void populateCars(int numCars) {
        for (int i = 0; i < numCars; i++) { // creating the each car
            // creating start and end position of car
            int startPos = (int)(Math.random() * numStations);
            int endPos = (int)(Math.random() * numStations);

            while (startPos == endPos) { // prevent start == end
                endPos = (int)(Math.random() * numStations);
            }

            Car car = new Car(startPos, endPos);
            carsTraveling.add(car); // adding car to Traveling ArrayList
        }
    }

    public void populatePeople(int numPeople) {
        for (int i = 0; i < numPeople; i++) { // creating the each car
            // creating start and end position of person
            int startPos = (int)(Math.random() * numStations);
            int endPos = (int)(Math.random() * numStations);

            while (startPos == endPos) { // prevent start == end
                endPos = (int)(Math.random() * numStations);
            }

            Person person = new Person(startPos, endPos);
            stations[startPos].addPassengerWaiting(person); // adding them to the station
            peopleTraveling.add(person);  // adding them to Traveling arraylist

        }
    }

    public void runRoad() {
        while (carTraveling.size() != 0) { // if there are still cars traveling
            for (Station s: stations){ // looping through stations 
                s.takePassengers(); // taking the passengers
                s.dropPassengers(); // dropping the passengers
                s.stationMove(); // moving
            }
            iterator ++;
    }

    public String toString() {
        String s = "Current Iterator: ";
        s = s + iterator;

        for (Station station : stations) { // looping through each station
            s = s + station.toString(); // printing out their toString()
            s = s + "\n";
        }
        return s;
    }
    }
}