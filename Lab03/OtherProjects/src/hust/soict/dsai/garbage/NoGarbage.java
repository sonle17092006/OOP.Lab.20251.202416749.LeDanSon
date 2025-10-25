package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) {
        String filename = "test.exe"; // test.exe is the name or path to an executable file
        byte[] inputBytes = {};
        long startTime, endTime;

        try {
            startTime = System.currentTimeMillis();
            inputBytes = Files.readAllBytes(Paths.get(filename));
            StringBuilder outputStringBuilder = new StringBuilder();
            for (byte b : inputBytes) {
                outputStringBuilder.append((char) b);
            }
            String outputString = outputStringBuilder.toString();
            endTime = System.currentTimeMillis();
            System.out.println("endTime - startTime");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
