package aoc2021;

import aoc2021.day6.Day6;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Day6Tests {

    @Test
    void testPart1BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day6Example.txt");

        Day6 day6 = new Day6(testInput);
        assertEquals(5934, day6.execute1());
    }

    @Test
    void testPart2BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day6Example.txt");

        Day6 day6 = new Day6(testInput);
        assertEquals(26984457539l, day6.execute2());
    }

    @Test
    void calculateRealAnswerPart1() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day6.txt");

        Day6 day6 = new Day6(testInput);
        long result = day6.execute1();

        System.out.println(result);
    }

    @Test
    void calculateRealAnswerPart2() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day6.txt");

        Day6 day6 = new Day6(testInput);
        long result = day6.execute2();

        System.out.println(result);
    }
}
