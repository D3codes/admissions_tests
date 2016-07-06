import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by davidfreeman on 5/10/16.
 */
public class ReadIn {

    public ArrayList<String> readFile(String fileName){

        ArrayList<String> names = new ArrayList<String>();
        try {
            FileReader fstream = new FileReader(fileName);
            BufferedReader in = new BufferedReader(fstream);

            String line;
            while((line = in.readLine()) != null)
                names.add(line);

        } catch(Exception e) { System.err.println(e); }

        return names;
    }
  }
