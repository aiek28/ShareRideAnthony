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
            ArrayList<Person> droppedPeople; // getting the list returned from dropPerson function in car class

            ArrayList<Person> passengers = car.getPassengers(); // getting all the passengers in one car
            for (Person person : passengers) { // getting all passengers in the car
                if (person.getDestination() == idNo) { // seeing if their destination is equal to the station
                    droppedPeople = car.dropPerson(person); // dropping person
                    for (Person p : droppedPeople) {
                        peopleArrived.add(p);
                    }
                } else if (car.getCurrStation() == car.getDestination()) { // if car has reached destination
                    droppedPeople = car.dropPerson(person);
                    for (Person p : droppedPeople) {
                        if (car.getCurrStation() == p.getDestination()) {
                            peopleArrived.add(p);
                        } else {
                            peopleWaiting.add(p);
                        }
                    }
                }
            }
        }

    }

    public void takePassengers() {

    }
}
