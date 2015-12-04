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
        ArrayList<Process> newListOfProcesses = new ArrayList<>();
        int i = 0;
        do{

            Iterator<Process> iterator = processList.iterator();
            while (iterator.hasNext()){
                Process current = iterator.next();
                if (current.getArrivalTime() == i) {
                    waitingQueue.add(current);
                    iterator.remove();
                }else if (current.getArrivalTime()>i){
                    break;
                }
            }

            //If there's something to execute
            if (waitingQueue.size() > 0){

                //remove the process with smallest burst time
                Process p = waitingQueue.poll();
                p.setBurstTime(p.getBurstTime()-1);


                if (p.getBurstTime() != 0){
                    waitingQueue.add(p);
                }else{
                    p.setTurnaround(i+1);
                }

                if (p.getResponseTime() == 0){
                    p.setResponseTime(i+1);
                }
                //saving everything to a new list
                newListOfProcesses.add(p);


            }
            i++;
        }while (processList.size() > 0 || waitingQueue.size() > 0);

        for (Process p : newListOfProcesses) {
            p.setWaitingTime(p.getTurnaround()-p.getOriginalBurstTime()-p.getArrivalTime());
        }

        newListOfProcesses = new ArrayList(new HashSet(newListOfProcesses));
        Collections.sort(newListOfProcesses, Comparator.comparing(Process::getID));
        for (Process p: newListOfProcesses){
            System.out.println(p.getID() + " "+ p.getTurnaround() + " " +p.getResponseTime()+ " " + p.getWaitingTime() );
        }
    }
}
