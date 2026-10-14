import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class GradeAnalyzerTest {

    @Test
    void calculateAverageWithMultipleScores() {
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(80);
        scores.add(90);
        scores.add(100);

        assertEquals(90.0, GradeAnalyzer.calculateAverage(scores), 0.001);
    }

    @Test
    void calculateAverageWithOneScore() {
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(75);

        assertEquals(75.0, GradeAnalyzer.calculateAverage(scores), 0.001);
    }

    @Test
    void calculateAverageWithEmptyList() {
        ArrayList<Integer> scores = new ArrayList<>();

        assertEquals(0.0, GradeAnalyzer.calculateAverage(scores), 0.001);
    }

    @Test
    void calculateAverageWithZeroScores() {
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(0);
        scores.add(0);
        scores.add(0);

        assertEquals(0.0, GradeAnalyzer.calculateAverage(scores), 0.001);
    }

    @Test
    void calculateAverageWithDecimalResult() {
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(80);
        scores.add(81);

        assertEquals(80.5, GradeAnalyzer.calculateAverage(scores), 0.001);
    }

    @Test
    void calculateAverageWithTenScores() {
        ArrayList<Integer> scores = new ArrayList<>();
        for (int score = 10; score <= 100; score += 10) {
            scores.add(score);
        }

        assertEquals(55.0, GradeAnalyzer.calculateAverage(scores), 0.001);
    }
}