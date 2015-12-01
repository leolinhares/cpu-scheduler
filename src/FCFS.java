import java.util.List;

/**
 * Created by leolinhares on 30/11/15.
 */
public class FCFS extends Scheduler {

    /*
    protected int totalProcessingTime;
    protected int CPUutilization;
    protected double throughput; // total number of process completed per time
    protected int contextSwitch;
    protected int numberOfCompletedProcesses;

    private int turnaround; //How long it takes to execute the process
    private int waitingTime; //How much time the process spends waiting on the ready queue
    private int responseTime;
    */


    public FCFS(List<Process> processes) {
        super(processes);
    }

    @Override
    public void execute() {
        int cpuTick = 0;
        int count = 0;
        for(Process p: processList) {
            // colado ou escada
            if (cpuTick - p.getArrivalTime() >= 0){
                p.setWaitingTime(cpuTick - p.getArrivalTime());
                cpuTick = cpuTick + p.getBurstTime();
            }else{
                System.out.println("buraco");
                //buraco
                p.setWaitingTime(0);
                cpuTick = p.getArrivalTime();
            }
            p.setTurnaround(p.getWaitingTime()+p.getBurstTime());
            p.setResponseTime(p.getTurnaround());
        }

        for (Process p: processList){
            System.out.println(p.getWaitingTime());
            //System.out.println(p.getTurnaround());
        }
    }
}
