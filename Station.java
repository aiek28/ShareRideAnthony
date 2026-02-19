import java.util.*;

public class Station {
    // fields
    private ArrayList<Person> peopleWaiting;
    private ArrayList<Person> peopleArrived;
    private ArrayList<Car> carWaiting;
    private ArrayList<Car> carArrived;
    private int idNo;
    private static int idGen=0;

    public Station(){
        peopleWaiting = new ArrayList<Person>();
        peopleArrived = new ArrayList<Person>();
        carWaiting = new ArrayList<Car>();
        carArrived = new ArrayList<Car>();
        int idNo = idGen;
    }
}
