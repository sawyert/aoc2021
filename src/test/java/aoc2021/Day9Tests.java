package aoc2021;

import aoc2021.day9.Day9;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day9Tests {

    @Test
    void testPart1BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day9Example.txt");

        Day9 day9 = new Day9(testInput);
        assertEquals(15, day9.execute1());
    }

    @Test
    void testPart2BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day9Example.txt");

        Day9 day9 = new Day9(testInput);
        assertEquals(1134, day9.execute2());
    }

    @Test
    void calculateRealAnswerPart1() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day9.txt");

        Day9 day9 = new Day9(testInput);
        long result = day9.execute1();

        System.out.println(result);
    }

    @Test
    void calculateRealAnswerPart2() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day9.txt");

        Day9 day9 = new Day9(testInput);
        long result = day9.execute2();

        System.out.println(result);
    }
}
