import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
 
public class WriteDemo {
    public static void main(String[] args) {
        String filename = "output.txt";
 
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("Line one");
            writer.newLine();
            writer.write("Line two");
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Could not write file: " + e.getMessage());
        }
    }
}