package IO_study;

import java.io.*;

public class DataTest {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(baos));
        dos.writeUTF("张志强");
        dos.writeInt(18);
        dos.writeBoolean(false);
        dos.writeChar('c');
        dos.flush();
        byte[] datas = baos.toByteArray();
        System.out.println(datas.length);
        DataInputStream dis = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
        //顺序和写出一致
        String msg = dis.readUTF();
        int age = dis.readInt();
        boolean flag = dis.readBoolean();
        char ch = dis.readChar();
        System.out.println(flag);
    }
}
