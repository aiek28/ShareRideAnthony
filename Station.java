import java.util.*;

public class Station {
    // fields
    private ArrayList<Person> peopleWaiting;
    private ArrayList<Person> peopleArrived;
    private int idNo;
    private static int idGen = 0;

    public Station() {
        peopleWaiting = new ArrayList<Person>();
        peopleArrived = new ArrayList<Person>();
        idNo = idGen;
        idGen++;
    }

    public int getID(){ 
        return idNo;
    }

    public ArrayList<Person> getPeopleWaiting(){
        return peopleWaiting;
    }

    public ArrayList<Person> getPeopleArrived(){
        return peopleArrived;
    }

    public void addPassengerWaiting(Person person){
        peopleWaiting.add(person);
    }

    public void addPassengerArrived(Person person){
        peopleArrived.add(person);
    }

    public String toString(){
        String s = "Station ID: " + idNo + "\n";

        s += "Current People Waiting: ";
        for (Person waiting: peopleWaiting){
            s += "(" + waiting.toString() + ")"; // calling toString on person
        }
        s += "\n";

        s += "Current People Arrived: ";
        for (Person arrived: peopleArrived){
            s += "(" + arrived.toString() + ")";
        }
        s += "\n";
        
        return s;
    }

}
