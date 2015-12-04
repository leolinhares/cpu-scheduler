import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by leolinhares on 01/12/15.
 */
public class RR extends Scheduler {

    public RR(List<Process> processes) {
        super(processes);
    }

    @Override
    public void execute() {

    }

    public void execute(int quantum){

        LinkedList<Process> queue = new LinkedList<Process>();
        int time = processList.get(0).getArrivalTime(); //comeca no at do primeiro cara
        int turn = 0; //acumular o turnaround

        while(!(queue.isEmpty() && processList.isEmpty())){

            for(int i=0;i<processList.size();i++){
                if(processList.get(i).getArrivalTime()<=time + quantum){ //coloca na fila os processos q chegaram durante um quantum e tira da PL
                    queue.add(processList.get(i));
                    processList.remove(i);
                    i--;
                }
            }

            time = time + quantum; //Aconteceu um quantum
            Process aux = queue.removeFirst(); //remove o primeiro processo da fila
            //System.out.println(aux.getID());

            if(aux.getBurstTime()<=quantum){ //Se o burst for menor do que o quantum, funfa igual o FCFS
                if (time - aux.getArrivalTime() >= 0){ //colado ou escada
                    aux.setWaitingTime(time - aux.getArrivalTime());
                    time = time + aux.getBurstTime(); //o time vai pro tempo de termino do processo
                }else{//buraco
                    aux.setWaitingTime(0);
                    time = aux.getBurstTime() + aux.getArrivalTime(); //o time vai pro tempo de termino do processo
                }
                aux.setTurnaround(aux.getTurnaround()+aux.getWaitingTime()+aux.getBurstTime());
                aux.setResponseTime(aux.getTurnaround());
                System.out.println("Process: " + aux.getID());
                System.out.println("Waiting Time: " + aux.getWaitingTime());
                System.out.println("Turn: " + aux.getTurnaround() + "\n");
            }
            else{ //Se o burst for maior do que o quantum o processo vai ser quebrado
                aux.setBurstTime(aux.getBurstTime()-quantum); //Decrementa o burst
                aux.setTurnaround(aux.getTurnaround()+quantum);
                queue.add(aux); //Coloca o processo na fila
            }



        }


    }
}
