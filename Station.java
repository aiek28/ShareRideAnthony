import java.util.*;

public class Station {
    // fields
    private ArrayList<Person> peopleWaiting;
    private ArrayList<Person> peopleArrived;
    private ArrayList<Car> carWaiting;
    private ArrayList<Car> carArrived;
    private int idNo;
    private static int idGen = 0;

    public Station() {
        peopleWaiting = new ArrayList<Person>();
        peopleArrived = new ArrayList<Person>();
        carWaiting = new ArrayList<Car>();
        carArrived = new ArrayList<Car>();
        int idNo = idGen;
        idGen++;
    }

    public void dropPassengers() {
        for (Car car : carWaiting) {
            ArrayList<Person> passengers = car.getPassengers(); // getting all the passengers in one car
            for (Person p : passengers) { // getting all passengers in the car
                if (p.getDestination() == idNo) { // seeing if their destination is equal to the station
                    peopleArrived.add(car.dropPerson(p)); //dropping person from car and adding it to station
                } else if (car.getCurrStation() == car.getDestination()) { // if car has reached destination
                    for (Person pWait: passengers){
                        peopleWaiting.add(car.dropPerson(pWait));
                    }
                }
            }
        }

    }

    public void takePassengers() {

    }
}
