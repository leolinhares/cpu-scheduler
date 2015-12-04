import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * Created by Bruno on 01/12/2015.
 */
public class Writer {
    public static  void  main(String[] args){
        BufferedWriter escrever = null;
        try{
//            File arquivoDeLog = new File();// passar os valores para criar o arquivo
//            escrever = new BufferedWriter( new FileWriter()); // escrever no arquivo os valores passados
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try{
                escrever.close();
            } catch (Exception e) {
            }
        }
    }
}
