package IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class CSVHandler {

    private static CSVHandler singletonCSVHandler = null;

    public static CSVHandler getInstance() {
        if(CSVHandler.singletonCSVHandler == null) {
            CSVHandler.singletonCSVHandler = new CSVHandler();
        }
        return CSVHandler.singletonCSVHandler;
    }

    public LinkedList<String> read(String path, String delimiter) throws FileNotFoundException {
        LinkedList<String> csvData = new LinkedList<String>();
        Scanner sc = new Scanner(new File(path));
        sc.useDelimiter(delimiter);
        while (sc.hasNext()) {
            csvData.add(sc.next());
        }
        sc.close();
        return csvData;
    }

    public void writeLine(String file, String line){
        try(FileWriter pw = new FileWriter(file,true);){
            pw.write(line+"\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
