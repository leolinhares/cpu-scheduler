import java.util.ArrayList;

/**
 * Created by leolinhares on 01/12/15.
 */
        public class Main {
            public static void main(String[] args) {
                ArrayList<Process> processList = new ArrayList<Process>();
                Reader reader = new Reader();
                processList = reader.run();
                RR rr = new RR(processList);
                rr.execute(2);
    }
}
