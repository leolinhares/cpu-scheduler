import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by leolinhares on 30/11/15.
 */
public class Reader {



    public static void main(String args[]){
        Queue<Process> a = new LinkedList<>();
        Process p = new Process(1, 20, 10,12);
        Process p1= new Process(2, 12, 7, 8);
        a.add(p);
        a.add(p1);
        for (Process process:a) {
            System.out.println(process.getArrivalTime());
            System.out.println(process.getBurstTime());
        }
    }

}
