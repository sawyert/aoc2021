package aoc2021;

import aoc2021.day15.Day15;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day15Tests {

    @Test
    void testPart1BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day15Example.txt");

        Day15 day15 = new Day15(testInput);
        assertEquals(40, day15.execute1());
    }

    @Test
    void testPart2BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day15Example.txt");

        Day15 day15 = new Day15(testInput);
        assertEquals(2188189693529L, day15.execute2());
    }

    @Test
    void calculateRealAnswerPart1() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day15.txt");

        Day15 day15 = new Day15(testInput);
        long result = day15.execute1();

        System.out.println(result);
    }

    @Test
    void calculateRealAnswerPart2() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day15.txt");

        Day15 day15 = new Day15(testInput);
        long result = day15.execute2();

        System.out.println(result);
    }
}
