import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Project1 {

    // Directions for 4-way connectivity (north, south, east, west)
    private static final int[] rowDirections = {-1, 1, 0, 0};
    private static final int[] colDirections = {0, 0, -1, 1};

        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read image #
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline 

        // Process each image, read dimensions
        for (int imageIndex = 0; imageIndex < n; imageIndex++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            sc.nextLine(); // Consume newline 

            // Read image data
            char[][] image = new char[r][c];
            for (int i = 0; i < r; i++) {
                String line = sc.nextLine();
                for (int j = 0; j < c; j++) {
                    image[i][j] = line.charAt(j);
                }
            }

            // Process image, label connected components
            char[][] labeledImage = labelConnectedComponents(image, r, c);

            // Output the labeled image
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    System.out.print(labeledImage[i][j]);
                }
                System.out.println();
            }

            // Tabulate sizes of connected components
            Map<Integer, Integer> sizeCounts = tabulateComponentSizes(labeledImage, r, c);

            // Output tabulation
            for (Map.Entry<Integer, Integer> entry : sizeCounts.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }

            System.out.println();
        }

        sc.close();
    }

    // Method to label connected components in the image
    private static char[][] labelConnectedComponents(char[][] image, int r, int c) {
        char[][] labeledImage = new char[r][c];
        for (int i = 0; i < r; i++) {
            System.arraycopy(image[i], 0, labeledImage[i], 0, c);
        }

        char currentLabel = 'a';

        // labeling
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (labeledImage[i][j] == '*') {
                    dfsLabeling(labeledImage, i, j, r, c, currentLabel);
                    currentLabel++; // Move to the next label
                }
            }
        }

        return labeledImage;
    }

    // Recursive DFS method to label connected components
    private static void dfsLabeling(char[][] image, int i, int j, int r, int c, char label) {
        // Base case: out of bounds or not a white pixel
        if (i < 0 || i >= r || j < 0 || j >= c || image[i][j] != '*') {
            return;
        }
        image[i][j] = label;

        // label connected pixels
        for (int d = 0; d < 4; d++) {
            dfsLabeling(image, i + rowDirections[d], j + colDirections[d], r, c, label);
        }
    }

    // Method to tabulate the sizes of connected components
    private static Map<Integer, Integer> tabulateComponentSizes(char[][] labeledImage, int r, int c) {
        Map<Character, Integer> componentSizes = new HashMap<>();
        Map<Integer, Integer> sizeCounts = new HashMap<>();

        // Count the size of each connected component
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (labeledImage[i][j] != '.') {
                    char label = labeledImage[i][j];
                    componentSizes.put(label, componentSizes.getOrDefault(label, 0) + 1);
                }
            }
        }

        // Count out sizes and size quatities
        for (int size : componentSizes.values()) {
            sizeCounts.put(size, sizeCounts.getOrDefault(size, 0) + 1);
        }

        return sizeCounts;
    }
}