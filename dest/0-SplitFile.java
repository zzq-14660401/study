package IO_study;

import java.io.File;
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
        for 