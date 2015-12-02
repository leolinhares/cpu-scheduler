import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

/**
 * Created by leolinhares on 30/11/15.
 */
public class SJF extends FCFS {

    public SJF(List<Process> processes) {
        super(processes);
    }

    @Override
    public void execute() {
        Collections.sort(processList, Comparator.comparing(Process::getArrivalTime).thenComparing(Process::getBurstTime));
        super.execute();
    }

    public void execute(boolean preemptive){

    }
}
