import java.io.*;
import java.util.ArrayList;

/**
 * Created by Bruno on 01/12/2015.
 */
public class Writer {

    public void write(Scheduler scheduler){
        BufferedWriter output = null;
        String text = "\n\n" + scheduler.getClass().getName();
        text += "\nAverage Response: " + Double.toString(scheduler.averageResponse);
        text += "\nAverage Turnaround: " + Double.toString(scheduler.averageTurnaround);
        text += "\nAverage Waiting: " + Double.toString(scheduler.averageWaiting);
        text += "\nCPU Utilization: " + Double.toString(scheduler.CPUutilization);
        text += "\nNumber of completed processes: " + Double.toString(scheduler.numberOfCompletedProcesses);
        text += "\nThroughput: " + Double.toString(scheduler.throughput);
        text += "\nTotal processing time: " + Double.toString(scheduler.totalProcessingTime);

        try {
            File file = new File("estatisticas.txt");
            output = new BufferedWriter(new FileWriter(file, true));
            output.write(text);
        } catch ( IOException e ) {
            e.printStackTrace();
        } finally {
            if ( output != null ) try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
