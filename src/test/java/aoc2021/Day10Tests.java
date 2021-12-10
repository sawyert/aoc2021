package aoc2021;

import aoc2021.day10.Day10;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day10Tests {

    @Test
    void testPart1BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day10Example.txt");

        Day10 day10 = new Day10(testInput);
        assertEquals(26397, day10.execute1());
    }

    @Test
    void testPart2BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day10Example.txt");

        Day10 day10 = new Day10(testInput);
        assertEquals(288957, day10.execute2());
    }

    @Test
    void calculateRealAnswerPart1() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day10.txt");

        Day10 day10 = new Day10(testInput);
        long result = day10.execute1();

        System.out.println(result);
    }

    @Test
    void calculateRealAnswerPart2() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day10.txt");

        Day10 day10 = new Day10(testInput);
        long result = day10.execute2();

        System.out.println(result);
    }
}
