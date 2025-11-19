package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) {
        String filename = "test.exe"; // test.exe is the name or path to an executable file
        byte[] inputBytes = {};
        long startTime, endTime;

        try {
            startTime = System.currentTimeMillis();
            inputBytes = Files.readAllBytes(Paths.get(filename));
            String outputString = "";
            for (byte b : inputBytes) {
                outputString += (char) b;
            }
            endTime = System.currentTimeMillis();
            System.out.println("endTime - startTime");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
