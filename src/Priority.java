import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by leolinhares on 01/12/15.
 */
public class Priority extends SJF{

    public Priority(List<Process> processes) {
        super(processes);
    }

    @Override
    public void execute() {
        Collections.sort(processList, Comparator.comparing(Process::getArrivalTime).thenComparing(Process::getPriority));
        super.execute();
    }

    public void execute(boolean preemptive){
        Comparator<Process> comparator;
        comparator = new Comparator<Process>() {
            @Override
            public int compare(Process o1, Process o2) {
                Integer time1 = o1.getPriority();
                Integer time2 = o2.getPriority();
                return time1.compareTo(time2);
            }
        };
        super.execute(preemptive, comparator);
    }
}
