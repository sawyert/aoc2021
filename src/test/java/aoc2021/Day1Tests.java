package aoc2021;

import aoc2021.day1.Day1;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day1Tests {

    @Test
    void testPart1BasicInputWorks() {
        String[] testInput = new String[] {"199", "200", "208", "210", "200", "207", "240", "269", "260", "263"};

        Day1 day1 = new Day1(testInput);
        assertEquals(7, day1.execute1());
    }

    @Test
    void testPart2BasicInputWorks() {
        String[] testInput = new String[] {"199", "200", "208", "210", "200", "207", "240", "269", "260", "263"};

        Day1 day1 = new Day1(testInput);
        assertEquals(5, day1.execute2());
    }

    @Test
    void calculateRealAnswerPart1() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day1.txt");

        Day1 day1 = new Day1(testInput);
        System.out.println(day1.execute1());
    }

    @Test
    void calculateRealAnswerPart2() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day1.txt");

        Day1 day1 = new Day1(testInput);
        System.out.println(day1.execute2());
    }
}
