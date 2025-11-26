public class Main {
    public static void main(String[] args){
        for(int p=1 ;p<11; p++) {
            Simulator sim = new Simulator(500000, p/10.0);
            sim.run();
            System.out.println(p/10.0);
            sim.printStatistics();
        }
    }
}
