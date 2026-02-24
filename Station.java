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
                        carArrived.add(car);
                        peopleWaiting.add(car.dropPerson(pWait));
                    }
                }
            }
        }

    }

    public void takePassengers() {
        for (Car car: carWaiting){
            Iterator<Person> it = peopleWaiting.iterator();
            while (it.hasNext()){ // allows us to loop through peopleWaiting while also deleting them once they board a car
                Person p = it.next();
                if (car.hasSpace() && (p.getDirection() == car.getDirection())){ // if has space and going in the same direction
                    it.remove();
                    car.addPerson(p);
                }
            }
        }
    }

    public void addCarsWaiting(Car car){ // adds cars when you build the station
        carWaiting.add(car);
    }

    public void addPassengerWaiting(Person person){
        peopleWaiting.add(person);
    }
}
