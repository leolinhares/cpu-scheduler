import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by leolinhares on 30/11/15.
 */
public abstract class Scheduler {
    public List<Process> processList;
    public List<Process> processQueue;

    public Scheduler(List<Process> processes) {
        this.processList = processes;
    }

    public abstract void execute();
}
