import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Simulator {
    private int timeSlots;
    private double arrivingProb;
    private final double transmitProb;
    private List<Station> stations;
    private Random rand;
    private int totalPacketsCreated;
    private int totalPacketsSent;
    private int totalPacketsLost;
    private long totalDelay;

    public Simulator(int timeSlots, double arrivingProb){
        this.timeSlots = timeSlots;
        this.arrivingProb = arrivingProb;
        this.transmitProb = 0.5;
        stations = new ArrayList<>();
        rand = new Random();

        initStations();
    }

    private void initStations(){
        stations.add(new Station("Pc1", 1, 1));
        stations.add(new Station("Pc2", 2, 1));
        stations.add(new Station("Pc3", 3, 2));
        stations.add(new Station("Pc4", 4, 2));
        stations.add(new Station("Pc5", 5, 3));
        stations.add(new Station("Pc6", 6, 3));
        stations.add(new Station("Pc7", 7, 4));
        stations.add(new Station("Pc8", 8, 4));
    }

    public void run(){

        for (int t=0; t<timeSlots; t++){
            handleArrivals(t);

            handleTransmissions(t);
        }

    }

    private void handleArrivals(int currentTime){

    }

    private void handleTransmissions(int currentTime){

    }

    public void printStatistics(){
        System.out.println("Total Packets Created: " + totalPacketsCreated);
        System.out.println("Total Packets Sent: " + totalPacketsSent);
        System.out.println("Total Packets Lost: " + totalPacketsLost);

        double averageDelay = (totalPacketsSent == 0) ? 0 : (double) totalDelay / totalPacketsSent;
        System.out.println("Average delay: " + averageDelay);

        double throughput = (double) totalPacketsSent / timeSlots;
        System.out.println("Throughput: " + throughput);

        double lossRate = (double) totalPacketsLost / totalPacketsCreated;
        System.out.println("Packet loss rate: " + lossRate);
    }



}
