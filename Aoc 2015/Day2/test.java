package Day2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class test {

    public static int calculateWrappingPaperLength(int l, int w, int h) {
        // Calculate surface area
        int surfaceArea = 2 * (l * w + w * h + h * l);

        // Find the area of the smallest side
        int smallestSide = Math.min(l * w, Math.min(w * h, h * l));

        // Add the surface area and the area of the smallest side
        return surfaceArea + smallestSide;
    }

    public static void main(String[] args) {
        List<int[]> dimensionsList = new ArrayList<>();

        File myObj = new File("Day2/input.txt");

        // Read dimensions from the file
        try (BufferedReader br = new BufferedReader(myObj)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] dimensionsStr = line.trim().split("x");
                int[] dimensions = new int[3];
                for (int i = 0; i < 3; i++) {
                    dimensions[i] = Integer.parseInt(dimensionsStr[i]);
                }
                dimensionsList.add(dimensions);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Calculate total square feet of wrapping paper needed
        int totalSquareFeet = dimensionsList.stream()
                .mapToInt(dimensions -> calculateWrappingPaperLength(dimensions[0], dimensions[1], dimensions[2]))
                .sum();

        System.out.println("Total square feet of wrapping paper to order: " + totalSquareFeet);
    }
}
