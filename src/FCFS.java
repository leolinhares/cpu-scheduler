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
        for(Process p: processList) {
            // colado ou escada
            if (cpuTick - p.getArrivalTime() >= 0){
                p.setWaitingTime(cpuTick - p.getArrivalTime());
                cpuTick = cpuTick + p.getBurstTime();
            }else{
                System.out.println("buraco");
                //buraco
                p.setWaitingTime(0);
                cpuTick = p.getBurstTime() + p.getArrivalTime();
            }
            p.setTurnaround(p.getWaitingTime()+p.getBurstTime());
            p.setResponseTime(p.getTurnaround());
        }

        int processingTotal = 0;
        int turnTotal = 0;
        int waitingTotal = 0;
        int responseTotal = 0;

        for (Process p: processList){

            processingTotal = processingTotal + p.getBurstTime(); //total processing time
            turnTotal = turnTotal + p.getTurnaround(); // total turnaround
            waitingTotal = waitingTotal + p.getWaitingTime(); // total waiting time
            responseTotal = responseTotal + p.getResponseTime();

        }

        this.throughput = processList.size()/cpuTick; //process:time
        this.totalProcessingTime = processingTotal;
        this.CPUutilization = processingTotal/cpuTick;
        double m = turnTotal/processList.size(); //turnaround media
        this.contextSwitch = processList.size();
    }
}
