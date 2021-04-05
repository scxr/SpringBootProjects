import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class evil {

    public static void readFile(String fileName) throws FileNotFoundException {
        try (FileInputStream fis = new FileInputStream(new File(fileName))) {

            // remaining bytes that can be read

            // 8k a time
            byte[] bytes = new byte[8192];

            // reads 8192 bytes at a time, if end of the file, returns -1
            while (fis.read(bytes) != -1) {

                // convert bytes to string for demo
               String s = new String(bytes, StandardCharsets.UTF_8);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void walk(String path) {
        File root = new File(path);
        File[] list = root.listFiles();
        if(list==null){
            return;
        }
        for (File f: list) {
            if (f.isDirectory()) {
                walk(f.getAbsolutePath());
            } else {
                try {
                    readFile(f.getAbsolutePath());
                } catch (FileNotFoundException e) {
                }
            }

        }
    }

    public static void main(String[] args) {
        evil fw = new evil();
        fw.walk("D:\\programming");
    }
}
