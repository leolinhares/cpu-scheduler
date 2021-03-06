import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by leolinhares on 30/11/15.
 */
public abstract class Scheduler {
    protected List<Process> processList;

    protected int totalProcessingTime;
    protected double CPUutilization;
    protected double throughput; // total number of process completed per time
    protected int contextSwitch;
    protected int numberOfCompletedProcesses;

    protected double averageWaiting;
    protected double averageResponse;
    protected double averageTurnaround;


    public Scheduler(List<Process> processes) {
        this.processList = processes;
    }

    public abstract void execute();
}
