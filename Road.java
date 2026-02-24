import java.util.*;

public class Road {
    private Station[] stations;
    private int numStations;
    
    public void populateStations(int num){ // populate station with s
        numStations = num;
        for (int i=0; i < numStations; i++){
            Station s = new Station();
            stations[i] = s;
        }
    }
    public void populateCars(int numCars){
        for (int i = 0; i < numCars; i++){ // creating the each car
            // creating start and end position of car
            int startPos = (int)(Math.random() * numStations);
            int endPos = (int)(Math.random() * numStations);
            while (startPos == endPos){ // prevent start == end 
                endPos = (int)(Math.random() * numStations);
            }

            Car car = new Car(startPos, endPos);

            int randNum = (int)(Math.random() * numStations); // creating random number to assign into the train
            Station stationToAddCar = stations[randNum];

            stationToAddCar.addCarsWaiting(car);
        }
    }

    public void populatePeople(int numPeople){
        for (int i = 0; i < numPeople; i++){ // creating the each car
            // creating start and end position of person
            int startPos = (int)(Math.random() * numStations);
            int endPos = (int)(Math.random() * numStations);
            while (startPos == endPos){ // prevent start == end 
                endPos = (int)(Math.random() * numStations);
            }

            Person person = new Person(startPos, endPos);

            int randNum = (int)(Math.random() * numStations); // creating random number to assign into the train
            Station stationToAddCar = stations[randNum];

            stationToAddCar.addPassengerWaiting(person); // 
        }
    }
}
