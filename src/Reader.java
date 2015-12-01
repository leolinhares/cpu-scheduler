import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by leolinhares on 30/11/15.
 */
public class Reader {

    public ArrayList run() {
        ArrayList <Process> processList = new ArrayList<>();
        String arquivo = "csv/process.csv";
        BufferedReader br = null;
        String linha = "";
        String separar = ";";


        try {
            br = new BufferedReader(new FileReader(arquivo));
            while ((linha = br.readLine()) != null) {

                String[] posicao = linha.split(separar);

                Process p = new Process(Integer.parseInt(posicao[0]),Integer.parseInt(posicao[1]),
                        Integer.parseInt(posicao[2]),Integer.parseInt(posicao[3]));

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

        System.out.println("Arquivo totalmente lido");

        return processList;
    }
}

