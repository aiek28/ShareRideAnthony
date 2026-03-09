public class Tester {
    public static void main (String[] args){
        double totalPercent = 0.0;
        int trials = 5000;

        for (int i = 1; i <= trials; i++){
            Person.resetIDGen();
            Car.resetIDGen();
            Station.resetIDGen();

            Road road = new Road();

            road.populateStations(32);
            road.populateCars(20);
            road.populatePeople(50);

            // System.out.println("BEFORE RUNNING: ");
            // System.out.println(road);

            road.runRoad();
            // System.out.println("AFTER RUNNING: ");
            // System.out.println(road);
            
            double percent = road.getPercentArrived();
            totalPercent += percent;

            System.out.println("Trial " + i + ": " + percent + "%");
        }
        System.out.println();
        System.out.println("Average Percent Arrived: " + (totalPercent/trials));
    }
}
