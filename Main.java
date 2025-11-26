public class Main {
    public static void main(String[] args){
        Simulator sim = new Simulator(500000, 0.2);
        sim.run();
        sim.printStatistics();
    }
}
