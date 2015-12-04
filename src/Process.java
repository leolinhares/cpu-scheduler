/**
 * Created by leolinhares on 26/11/15.
 */
public class Process{
    private int ID;
    private int burstTime;
    private int priority;
    private int arrivalTime;
    private int turnaround; //How long it takes to execute the process
    private int waitingTime = 0; //How much time the process spends waiting on the ready queue
    private int responseTime; //Time from the submission of a request until the first response is produced

    public Process(int ID, int burstTime, int arrivalTime, int priority ) {
        this.ID = ID;
        this.burstTime = burstTime;
        this.priority = priority;
        this.arrivalTime = arrivalTime;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getTurnaround() {
        return turnaround;
    }

    public void setTurnaround(int turnaround) {
        this.turnaround = turnaround;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public int getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(int responseTime) {
        this.responseTime = responseTime;
    }
}
