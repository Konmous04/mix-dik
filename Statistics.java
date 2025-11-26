public class Statistics {
    private double averageDelay;
    private double throughput;
    private double lossRate;

    public Statistics(double averageDelay, double throughput, double lossRate){
        this.averageDelay = averageDelay;
        this.throughput = throughput;
        this.lossRate = lossRate;
    }
}
