import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        Statistics st = new Statistics();
        List<Double> plist = new ArrayList<>();
        List<Double> avglist = new ArrayList<>();
        List<Double> thrlist = new ArrayList<>();
        List<Double> loslist = new ArrayList<>();
        for(int p=1 ;p<11; p++) {
            Simulator sim = new Simulator(500000, p/10.0);
            plist.add(p/10.0);
            sim.run();
            System.out.println(p/10.0);
            sim.printStatistics();
        }
        avglist = st.getAlist();
        thrlist = st.getTlist();
        loslist = st.getLlist();
    }
}
