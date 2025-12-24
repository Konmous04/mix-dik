/*Αυτή η κλάση κατασκευάζει τα πακέτα που χρησιμοποιούμε για την προσομοίωση*/
public class Packets {
    private final String name;
    private final int id;
    private final int arrivalTime;
    private final int sourceStationId;

    public Packets(String name, int id, int arrivalTime, int sourceStationId){
        this.name = name;
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.sourceStationId = sourceStationId;
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    public int getArrivalTime(){
        return arrivalTime;
    }

    public int getSourceStationId(){
        return sourceStationId;
    }

}
