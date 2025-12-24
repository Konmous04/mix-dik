/*Αυτήν η κλάση κατασκευάζει το παράθυρο που φαίνεται στο τέλος, όπου βλέπουμε το πώς κυμαίνονται οι τιμές*/

import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;

import java.util.List;

public class Plot {
    private List<Double> p;
    private List<Double> a;
    private List<Double> t;
    private List<Double> l;

    public Plot(List<Double> p, List<Double> a, List<Double> t, List<Double> l){
        this.p = p;
        this.a = a;
        this.t = t;
        this.l = l;
    }

    public void createPlot(){
        XYChart chart = new XYChartBuilder()
                .width(800)
                .height(600)
                .build();

        chart.addSeries("Average Delay", p, a);
        chart.addSeries("Throughput", p, t);
        chart.addSeries("Loss Rate", p, l);
        new SwingWrapper<>(chart).displayChart();
    }
}
