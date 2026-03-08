public class Person {
    private int start;
    private int destination;
    private int idNo;
    private int direction;
    private boolean arrived;
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

    public void setArrived(){
        arrived = true;
    }

    public boolean hasArrived(){
        return arrived;
    }

    public String toString(){
        return "id Number: " + idNo + " Arrived: " + arrived;
    }
}