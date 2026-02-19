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
    public String toString(){
        return "id Number: " + idNo + " Arrived: " + arrived;
    }
}