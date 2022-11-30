package common;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class InputReader {
    public static ArrayList<String> get_from_url(int day_number) {
        String url = "common/inputs/day"+day_number;
        ArrayList<String> inputs = new ArrayList<>();
        try {
            BufferedReader read = new BufferedReader(
            new FileReader(url));
            String line;
            while( (line = read.readLine()) != null){
                inputs.add(line);
            }
            read.close();
        } catch (IOException e) {
            System.out.println("no input was provided for day " + day_number);
            e.printStackTrace();
        }
        return inputs;
    }
}