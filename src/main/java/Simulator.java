import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

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
    private int pid = 1;

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
        for (Station st : stations){
            if(rand.nextDouble()<arrivingProb){
                Packets p = new Packets("P"+pid, pid, currentTime, st.getId());
                pid++;
                totalPacketsCreated++;
                if(!st.addPacket(p)){
                    totalPacketsLost++;
                }
            }
        }
    }

    private void handleTransmissions(int currentTime){
        boolean[] wantsToTransmit = new boolean[stations.size()];
        for(int i=0; i< stations.size(); i++){
            Station st = stations.get(i);
            if (st.peekPacket()==null){
                wantsToTransmit[i] = false;
                continue;
            }
            wantsToTransmit[i] = (rand.nextDouble()<transmitProb);
        }

        for(int i=0; i<stations.size();i+=2){
            int a = i;
            int b = i+1;
            boolean A = wantsToTransmit[a];
            boolean B = wantsToTransmit[b];

            if(!A && !B)
                continue;
            if(A && !B){
                successfulTransmition(stations.get(a), currentTime);
                continue;
            }
            if(!A && B){
                successfulTransmition(stations.get(b), currentTime);
                continue;
            }
            if(A && B){

            }
        }
    }

    public BlockingQueue<Double> printStatistics(){
        System.out.println("Total Packets Created: " + totalPacketsCreated);
        System.out.println("Total Packets Sent: " + totalPacketsSent);
        System.out.println("Total Packets Lost: " + totalPacketsLost);

        BlockingQueue<Double> l = new ArrayBlockingQueue<>(3);

        double averageDelay = (totalPacketsSent == 0) ? 0 : (double) totalDelay / totalPacketsSent;
        l.add(averageDelay);
        System.out.println("Average delay: " + averageDelay);

        double throughput = (double) totalPacketsSent / timeSlots;
        l.add(throughput);
        System.out.println("Throughput: " + throughput);

        double lossRate = (double) totalPacketsLost / totalPacketsCreated;
        l.add(lossRate);
        System.out.println("Packet loss rate: " + lossRate);

        return l;
    }

    public void successfulTransmition(Station st, int currentTime){
        Packets packet = st.pollPacket();
        if (packet != null){
            int delay = currentTime-packet.getArrivalTime();
            totalDelay += delay;
            totalPacketsSent++;
        }
    }

}
