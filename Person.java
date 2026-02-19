public class Person {
    int start;
    int destination;
    int idNo;
    boolean arrived;
    private static int idGen = 1;
    
    /**
     * Create Person. Random values can be fed through the simulator.
     * 
     * @param myStart
     * @param myDestination
     */
    public Person(int myStart, int myDestination){
        start = myStart;
        destination = myDestination;
        idNo = idGen;
        arrived = false;
        idGen++;
    }

    public int getStart(){
        return start;
    }

    public int getDestination(){
        return destination;
    }

    public String toString(){
        return "id Number: " + idNo + " Arrived: " + arrived;
    }
}