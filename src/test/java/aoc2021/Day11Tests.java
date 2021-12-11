package aoc2021;

import aoc2021.day11.Day11;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day11Tests {

    @Test
    void testPart1BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day11Example.txt");

        Day11 day11 = new Day11(testInput);
        assertEquals(1656, day11.execute1());
    }

    @Test
    void testPart2BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day11Example.txt");

        Day11 day11 = new Day11(testInput);
        assertEquals(195, day11.execute2());
    }

    @Test
    void calculateRealAnswerPart1() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day11.txt");

        Day11 day11 = new Day11(testInput);
        long result = day11.execute1();

        System.out.println(result);
    }

    @Test
    void calculateRealAnswerPart2() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day11.txt");

        Day11 day11 = new Day11(testInput);
        long result = day11.execute2();

        System.out.println(result);
    }
}
