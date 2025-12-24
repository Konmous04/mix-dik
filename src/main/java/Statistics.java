/*αυτή η κλάση περιέχει λίστες όπου αποθηκεύονται τα στατιστικά*/

import java.util.ArrayList;
import java.util.List;

public class Statistics {

    private List<Double> alist;
    private List<Double> tlist;
    private List<Double> llist;

    public Statistics(){
        alist = new ArrayList<>();
        tlist = new ArrayList<>();
        llist = new ArrayList<>();
    }

    public void setAlist(double x){
        alist.add(x);
    }

    public List<Double> getAlist(){
        return alist;
    }

    public void setTlist(double x){
        tlist.add(x);
    }

    public List<Double> getTlist(){
        return tlist;
    }

    public void setLlist(double x){
        llist.add(x);
    }

    public List<Double> getLlist(){
        return llist;
    }
}
