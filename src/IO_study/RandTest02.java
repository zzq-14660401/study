package IO_study;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 随机读取和写入流
 */
public class RandTest02 {
    public static void main(String[] args) throws IOException {
        //分多少块
        File src = new File("src/IO_study/DecorateTest01.java");
        //总长度
        long len = src.length();
        //每块大小
        int blockSize = 1024;
        //块数
        int size = (int) Math.ceil(len * 1.0 / blockSize);
        System.out.println(size);
        //起始位置和实际大小 
        int beginPos = 0;
        int actualSize = (int) (blockSize > len ? len : blockSize);
        for (int i = 0; i < size; i++) {
            beginPos = i * blockSize;
            if (i == size - 1) {
                actualSize = (int) len;
            } else {
                actualSize = blockSize;
                len -= actualSize;
            }
            System.out.println(i + "-->" + beginPos + "-->" + actualSize);
        }
    }

    //分开思想:起始,实际大小
    public static void split(int i, int beginPos, int actualSize) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(new File("src/IO_study/DecorateTest01.java"), "r");
        RandomAccessFile raf2 = new RandomAccessFile(new File("dest/"+i+"DecorateTest01.java"), "rw");
        raf.seek(beginPos);
        byte[] flush = new byte[1024];
        int len = -1;
        while ((len = raf.read(flush)) != -1) {
            if (actualSize > len) {
                raf2.write(flush,0,len);
                actualSize -= len;
            } else {
                raf2.write(flush,0,actualSize);
                break;
            }
        }
        raf2.close();
        raf.close();
    }

    //指定起始位置读取剩下内容
    public static void test02(String[] args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(new File("src/IO_study/CopyTxt.java"), "r");
        raf.seek(2);
        byte[] flush = new byte[1024];
        int len = -1;
        while ((len = raf.read(flush)) != -1) {
            System.out.println(new String(flush, 0, len));
        }
        raf.close();
    }
}
