package IO_study;

import java.io.*;
import java.net.URL;

/**
 * 转换流
 * 1.以字符流的形式操作字节流(纯文本的)
 * 2.指定字符集
 */
public class ConvertTest02 {
    public static void main(String[] args) {
        //操作System.in和System.out
        try (BufferedReader reader =
                     new BufferedReader(
                             new InputStreamReader(
                                     new URL("http//www.baidu.com").openStream(), "UTF-8"))) {
            String msg;
            while ((msg = reader.readLine()) != null) {
                System.out.println(msg);
            }
        } catch (IOException e) {
            System.out.println("操作异常");
        }
    }
}
