import IO.CSVHandler;

import java.util.ArrayList;
import java.util.LinkedList;

public class CSVHelper {
    public static ArrayList<String> readRows(String file) {
        ArrayList<String> rowsOut = new ArrayList<String>();
        try {
            LinkedList<String> rows = CSVHandler.getInstance().read(file, "\r\n");
            rows.remove(0);
            for (String row : rows) {
                rowsOut.add(row);
            }
            return rowsOut;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
