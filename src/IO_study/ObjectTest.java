package IO_study;

import java.io.*;
import java.util.Date;

public class ObjectTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream dos = new ObjectOutputStream(new BufferedOutputStream(baos));
        dos.writeUTF("张志强");
        dos.writeInt(18);
        dos.writeBoolean(false);
        dos.writeChar('c');
        dos.writeObject(new Date());
        dos.flush();
        byte[] datas = baos.toByteArray();
        System.out.println(datas.length);
        ObjectInputStream dis = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
        //顺序和写出一致
        String msg = dis.readUTF();
        int age = dis.readInt();
        boolean flag = dis.readBoolean();
        char ch = dis.readChar();
        Object date=dis.readObject();
        if (date instanceof Date){
            Date dateObj=(Date)date;
            System.out.println(dateObj);
        }
    }
}
