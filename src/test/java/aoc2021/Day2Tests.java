package aoc2021;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day2Tests {

    @Test
    void testPart1BasicInputWorks() {
        String[] testInput = new String[] {"199", "200", "208", "210", "200", "207", "240", "269", "260", "263"};

        Day2 day2 = new Day2(testInput);
        assertEquals(7, day2.execute1());
    }

    @Test
    void testPart2BasicInputWorks() {
        String[] testInput = new String[] {"199", "200", "208", "210", "200", "207", "240", "269", "260", "263"};

        Day2 day2 = new Day2(testInput);
        assertEquals(5, day2.execute2());
    }

    @Test
    void calculateRealAnswerPart1() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("day2.txt");

        Day2 day2 = new Day2(testInput);
        System.out.println(day2.execute1());
    }

    @Test
    void calculateRealAnswerPart2() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("day2.txt");

        Day2 day2 = new Day2(testInput);
        System.out.println(day2.execute2());
    }
}
