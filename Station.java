import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Station {
    private String name;
    private int id;
    private BlockingQueue<Packets> buffer;
    private int mk;


    public Station(String name, int id, int mk){
        this.name = name;
        this.id = id;
        this.buffer = new ArrayBlockingQueue<>(5);
        this.mk = mk;
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    public int getMk(){
        return mk;
    }

    public boolean addPacket(Packets packet){
        return buffer.offer(packet);
    }

    public Packets pollPacket(){
        return buffer.poll();
    }
}
