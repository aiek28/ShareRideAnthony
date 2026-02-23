public class Person {
    int start;
    int destination;
    int idNo;
    int direction;
    boolean arrived;
    private static int idGen = 0;
    
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

        if (myStart > myDestination){
            direction = -1;
        }
        else{
            direction = 1;
        }
    }

    public int getStart(){
        return start;
    }

    public int getDestination(){
        return destination;
    }

    public int getDirection(){
        return direction;
    }

    public int getID(){
        return idNo;
    }

    public String toString(){
        return "id Number: " + idNo + " Arrived: " + arrived;
    }
}