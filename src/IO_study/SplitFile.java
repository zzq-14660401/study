package IO_study;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class SplitFile {
    //源头
    private File src;
    //目的地(文件夹)
    private String destDir;
    //手游分割后的文件存储路径
    private List<String> destPath;
    //每块大小
    private int blockSize;
    //块数:多少块
    private int size;

    public SplitFile(String srcPath, String destDir) {
        this(srcPath, destDir, 1024);
    }

    public SplitFile(String srcPath, String destDir, int blockSize) {
        this.src = new File(srcPath);
        this.destDir = destDir;
        this.blockSize = blockSize;
        this.destPath = new ArrayList<String>();
        init();
    }

    private void init() {
        //总长度
        long len = this.src.length();
        //块数:多少块
        this.size = (int) Math.ceil(len * 1.0 / blockSize);
        //路径
        for (int i = 0; i < size; i++) {
            this.destPath.add(this.destDir + "/" + i + "-" + this.src.getName());
        }
    }

    public void split() throws IOException {
        long len = src.length();
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
            splitDetail(i, beginPos, actualSize);
        }
    }

    private void splitDetail(int i, int beginPos, int actualSize) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(this.src, "r");
        RandomAccessFile raf2 = new RandomAccessFile(this.destPath.get(i), "rw");
        raf.seek(beginPos);
        byte[] flush = new byte[1024];
        int len = -1;
        while ((len = raf.read(flush)) != -1) {
            if (actualSize > len) {
                raf2.write(flush, 0, len);
                actualSize -= len;
            } else {
                raf2.write(flush, 0, actualSize);
                break;
            }
        }
        raf2.close();
        raf.close();
    }

    public static void main(String[] args) throws IOException {
        SplitFile sf = new SplitFile("src/IO_study/SplitFile.java", "dest");
        sf.split();
    }
}
