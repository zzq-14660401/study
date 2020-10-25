package IO_study;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedTest04 {
    public static void main(String[] args) {
        File src = new File("abc.txt");
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(src));
            writer.append("hello");
            writer.newLine();
            writer.append("wrold");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
