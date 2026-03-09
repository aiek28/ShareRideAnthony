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
        while (carsTraveling.size() > 0) { // if there are still cars traveling
            for (int i = carsTraveling.size() - 1; i >=0; i--){ // looping backwards to prevent potential removal errors
                Car car = carsTraveling.get(i);

                Station currentStation = stations[car.getCurrStation()];

                dropPotentialPassengers(car, currentStation);

                if (car.hasArrived()){
                    unloadRemainingPassenger(car, currentStation);
                    carsArrived.add(car);
                    carsTraveling.remove(i);
                }
                else {
                    pickUpPassengers(car, currentStation);
                    car.move();
                }
            }
            iterator ++;
    }
    }

    public void dropPotentialPassengers(Car car, Station station) { // looping backwards to prevent skipping a person when removing
        ArrayList<Person> passengers = car.getPassengers(); //creating a refrence of passengers list 

        for (int i = passengers.size() - 1; i >=0; i--) {
            Person p = passengers.get(i);
            
            if (p.getDestination() == station.getID()) { // if person has arrived
                p.setArrived();
                Person removed = car.dropPerson(i);
                station.addPassengerArrived(removed);
                peopleArrived.add(removed);
                peopleTraveling.remove(removed);
            }
        }
    }

    public void unloadRemainingPassenger(Car car, Station station){
        ArrayList<Person> passengers = car.getPassengers(); // refrence of passengers list

        for (int i = passengers.size() - 1; i >=0; i--){
            Person removed = car.dropPerson(i);

            if (removed.getDestination() == station.getID()){ // if car unloading destination is also person's final destination
                removed.setArrived(); // set person has arrived
                station.addPassengerArrived(removed);
                peopleArrived.add(removed);
                peopleTraveling.remove(removed);
            }
            else { // if they didn't arrive when the car arrived to its finald estination
                station.addPassengerWaiting(removed);
            }
        }
    }

    public void pickUpPassengers(Car car, Station station) {
        ArrayList<Person> waiting = station.getPeopleWaiting(); // refrence (see above comments)
        
        for (int i = waiting.size()-1; i >= 0; i--){
            Person p = waiting.get(i);
            
            if (car.hasSpace() && (p.getDirection() == car.getDirection())){
                car.addPerson(p);
                waiting.remove(i);
            }
        }
    }

    public String toString() {
        String s = "Current Iterator: ";
        s = s + iterator + "\n";

        for (Station station : stations) { // looping through each station
            s = s + station.toString(); // printing out their toString()
            s = s + "\n";
        }
        return s;
    }
}