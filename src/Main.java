import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by leolinhares on 01/12/15.
 */
public class Main {
            public static void main(String[] args) {
                ArrayList<Process> processList = new ArrayList<Process>();
                ArrayList<Process> processList1 = new ArrayList<Process>();
                ArrayList<Process> processList2 = new ArrayList<Process>();
                ArrayList<Process> processList3 = new ArrayList<Process>();
                ArrayList<Process> processList4 = new ArrayList<Process>();

                Reader reader = new Reader();
                Writer writer = new Writer();
                processList = reader.run();
                processList1 = reader.run();
                processList2 = reader.run();
                processList3 = reader.run();
                processList4 = reader.run();

                FCFS fcfs = new FCFS(processList);
                fcfs.execute();
                SJF sjf = new SJF(processList1);
                sjf.execute();
                Priority p = new Priority(processList2);
                p.execute();

                //Preemptive
                SJF sjfp = new SJF(processList3);
                sjfp.execute(true, null);
                Priority pp = new Priority(processList4);
                pp.execute(true);

                writer.write(fcfs);
                writer.write(sjf);
                writer.write(p);
                writer.write(sjfp);
                writer.write(pp);

            }
}
