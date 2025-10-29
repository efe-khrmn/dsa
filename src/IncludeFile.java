import java.util.*;
import java.io.*;

public class IncludeFile {
    public static void expandFile(String filename, Set<String> visited)throws IOException {
        if (visited.contains(filename)) {
            throw new IllegalArgumentException("Cyclic include detected: " + filename);
        }
        visited.add(filename);

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("#include")) {
                   String includedFile = line.substring(8).trim();
                   expandFile(includedFile, visited);
                } else {
                    System.out.println(line);
                }
            }
            visited.remove(filename);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
        } catch (IOException e) {
            System.err.println("Error reading file: " + filename);
        }
    }
    public static void main(String[] args) {
        if (args.length != 1){
            System.err.println("Usage: java IncludeFile <filename>");
            return;
        }
        try{
            expandFile(args[0], new HashSet<>());
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
