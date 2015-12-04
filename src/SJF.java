import java.util.*;

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
        // adiciona no final remove no inicio
        LinkedList<Process> waitingQueue = new LinkedList<>();

        int i = 0;
        int cpuTick = 0;
        do{
            // Find processes that have arrived at the second 'i'
            for (Process p : this.processList) {
                if (p.getArrivalTime() == i) {
                    waitingQueue.add(p);
                    this.processList.remove(p);
                }else if (p.getArrivalTime() > i){
                    break;
                }
            }

            //'execute' first process of the waiting queue
            Process p = waitingQueue.remove();



            i++;
        }while (waitingQueue.size() > 0 && this.processList.size() > 0);


    }
}
