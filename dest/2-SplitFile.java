-1) {
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
