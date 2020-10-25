package IO_study;

import java.io.*;

public class BufferedTest {
    public static void main(String[] args) {
        File src = new File("abc.txt");
        OutputStream os = null;
        try {
            os = new BufferedOutputStream(new FileOutputStream(src));
            String msg = "hello wrold";
            byte[] bytes = msg.getBytes();
            os.write(bytes);
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                while (null != os) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
