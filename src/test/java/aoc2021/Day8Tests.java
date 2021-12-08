package aoc2021;

import aoc2021.day8.Day8;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day8Tests {

    @Test
    void testPart1BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day8Example.txt");

        Day8 day8 = new Day8(testInput);
        assertEquals(26, day8.execute1());
    }

    @Test
    void testPart2BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day8Example.txt");

        Day8 day8 = new Day8(testInput);
        assertEquals(61229, day8.execute2());
    }

    @Test
    void calculateRealAnswerPart1() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day8.txt");

        Day8 day8 = new Day8(testInput);
        long result = day8.execute1();

        System.out.println(result);
    }

    @Test
    void calculateRealAnswerPart2() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day8.txt");

        Day8 day8 = new Day8(testInput);
        long result = day8.execute2();

        System.out.println(result);
    }
}
