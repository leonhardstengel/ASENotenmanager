package IO;

import java.util.logging.Logger;

public class OutputLogger {

    private static final Logger LOGGER = Logger.getLogger(OutputLogger.class.getName());
    public static void main(String[] args) {}

    public static void log(String message){
        System.out.println(message);
    }

}
