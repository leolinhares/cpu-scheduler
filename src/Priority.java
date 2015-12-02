import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by leolinhares on 01/12/15.
 */
public class Priority extends FCFS{

    public Priority(List<Process> processes) {
        super(processes);
    }

    @Override
    public void execute() {
        Collections.sort(processList, Comparator.comparing(Process::getArrivalTime).thenComparing(Process::getPriority));
        super.execute();
    }
}
