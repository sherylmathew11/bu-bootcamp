import java.io.*; 
import java.util.ArrayList;
 
public class GradeAnalyzer {
 
    public static void main(String[] args) {
        ArrayList<Integer> scores = readScores("scores.txt");

        double average = calculateAverage(scores);

        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;

        for (int score : scores) {
            if (score > highest) {
                highest = score;
            }
            if (score < lowest) {
                lowest = score;
            }
        }

        if (scores.isEmpty()) {
            highest = 0;
            lowest = 0;
            System.out.println("No valid scores found in the file.");
        }

        int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;

        for (int score : scores) {
            if (score >= 90) {
                countA += 1;
            } else if (score >= 80) {
                countB += 1;
            } else if (score >= 70) {
                countC += 1;
            } else if (score >= 60) {
                countD += 1;
            } else {
                countF += 1;
            }
        }

        writeReport(scores, average, highest, lowest, countA, countB, countC, countD, countF, "report.txt");
    } 
 
    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        ArrayList<Integer> scores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }
                try {
                    int score = Integer.parseInt(line);
                    if (score < 0 || score > 100) {
                        System.err.println("Invalid score found in file: " + line + " (must be between 0 and 100)");
                        continue;
                    }
                    scores.add(score);
                } catch (NumberFormatException e) {
                    System.err.println("Invalid score found in file: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return scores;
    }
 
    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        if (scores.isEmpty()) {
            return 0.0;
        }
        double total = 0.0;
        for (int score : scores) {
            total += score;
        }
        return total / scores.size();
    } 
 
    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores,
                                   double avg, int high, int low, int countA, int countB, int countC, int countD, int countF,
                                   String outputFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write("=== Grade Analysis Report ===\n");
            writer.write(String.format("Total Scores processed:  %d%n", scores.size()) );
            writer.write(String.format("Average score:           %.2f%n", avg));
            writer.write(String.format("Highest score:           %d%n", high));
            writer.write(String.format("Lowest score:            %d%n", low));

            writer.write("Grade Distribution:\n");
            writer.write(String.format("A (90-100):              %d%n", countA));
            writer.write(String.format("B (80-89):               %d%n", countB));
            writer.write(String.format("C (70-79):               %d%n", countC));
            writer.write(String.format("D (60-69):               %d%n", countD));
            writer.write(String.format("F (below 60):            %d%n", countF));
        } catch (IOException e) {
            System.err.println("Error writing report: " + e.getMessage());
        }

        System.out.println("=== Grade Analysis Report ===");
        System.out.println(String.format("Total Scores processed:  %d", scores.size()));
        System.out.println(String.format("Average score:           %.2f", avg));
        System.out.println(String.format("Highest score:           %d", high));
        System.out.println(String.format("Lowest score:            %d", low));

        System.out.println("\nGrade Distribution:");
        System.out.println(String.format("A (90-100):              %d", countA));
        System.out.println(String.format("B (80-89):               %d", countB));
        System.out.println(String.format("C (70-79):               %d", countC));
        System.out.println(String.format("D (60-69):               %d", countD));
        System.out.println(String.format("F (below 60):            %d", countF));
    }
} 