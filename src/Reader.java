import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by leolinhares on 30/11/15.
 */
public class Reader {



    public static void main(String args[]) {
        Reader obj = new Reader();
        obj.run();
    }

    public ArrayList run() {
        ArrayList <Process> processList = new ArrayList<>();
        String arquivo = "csv/processQueue.csv";
        BufferedReader br = null;
        String linha = "";
        String separar = ";";


        try {
            br = new BufferedReader(new FileReader(arquivo));
            while ((linha = br.readLine()) != null) {

                String[] posicao = linha.split(separar);

                Process p = new Process(Integer.parseInt(posicao[0]),Integer.parseInt(posicao[1]),
                        Integer.parseInt(posicao[2]),Integer.parseInt(posicao[3]));

                //System.out.println("ID = " + posicao[0] + " " + "Burst = " + posicao[1] + " " + "Priority = " + posicao[2] +
                //        " " + "Arrival Time = " + posicao[3]);

                processList.add(p);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        for (Process p: processList) {
            System.out.println(p.getID());
        }

        System.out.println("Arquivo totalmente lido");

        return processList;
    }
}

