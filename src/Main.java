import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by leolinhares on 01/12/15.
 */
public class Main {
            public static void main(String[] args) {
                ArrayList<Process> processList = new ArrayList<Process>();
                Reader reader = new Reader();
                processList = reader.run();

//                FCFS fcfs = new FCFS(processList);
//                fcfs.execute();
//                SJF sjf = new SJF(processList);
//                sjf.execute(true, null);
                Priority p = new Priority(processList);
                p.execute(true);

            }
}
