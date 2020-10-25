package IO_study;

import java.io.*;

public class BufferedTest03 {
    public static void main(String[] args) {
        File src = new File("abc.txt");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(src));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
