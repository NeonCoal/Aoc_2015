package Day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class Main {
    public static void main(String args[]) {
        String content = "";
        int floor = 0;
        int count = 0;
        
        try {
            Path path = Paths.get("Day1/input.txt");
            content = Files.readString(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        for(char input : content.toCharArray()) {
            if (floor >= 0) {
                if (input == '(') {
                    floor++;
                }
                else if (input == ')') {
                    floor--;
                }
                count++;
            }
            else {
                break;
            }
        }
        System.out.println(count);
    }
}