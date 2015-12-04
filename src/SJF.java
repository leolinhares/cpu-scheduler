import java.util.*;

import static java.util.Comparator.comparing;

/**
 * Created by leolinhares on 30/11/15.
 */
public class SJF extends FCFS{

    public SJF(List<Process> processes) {
        super(processes);
    }

    @Override
    public void execute() {
        Collections.sort(processList, Comparator.comparing(Process::getArrivalTime).thenComparing(Process::getBurstTime));
        super.execute();
    }

    public void execute(boolean preemptive){

        Comparator<Process> comparator = new Comparator<Process>() {
            @Override
            public int compare(Process o1, Process o2) {
                Integer time1 = o1.getBurstTime();
                Integer time2 = o2.getBurstTime();
                return time1.compareTo(time2);
            }
        };

        // ordered by smallest burst time
        PriorityQueue<Process> waitingQueue = new PriorityQueue<>(comparator);

        int i = 0;
        do{

            // Find processes that have arrived at the second 'i'
            for (int j = 0; j < processList.size(); j++) {
                if (processList.get(j).getArrivalTime() == i) {
                    Process p = processList.get(j);
                    waitingQueue.add(p);
                    processList.remove(j);
                }else if (processList.get(j).getArrivalTime() > i){
                    break;
                }
            }


            //'execute' first process of the waiting queue ()

            //remove the process with smallest burst time
            Process p = waitingQueue.poll();
            System.out.println(p.getID());

            p.setWaitingTime(p.getWaitingTime()+ i);
            p.setBurstTime(p.getBurstTime()-1);

//            p.setTurnaround();
//            p.setResponseTime();

            if (p.getBurstTime() != 0){
                waitingQueue.add(p);
            }

            i++;
        }while (waitingQueue.size() > 0 && processList.size() > 0);


    }
}
