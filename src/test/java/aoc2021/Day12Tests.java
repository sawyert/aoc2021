package aoc2021;

import aoc2021.day12.Day12;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day12Tests {

    @Test
    void testPart1SmallInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day12Small.txt");

        Day12 day12 = new Day12(testInput);
        assertEquals(10, day12.execute1());
    }

    @Test
    void testPart1BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day12Example.txt");

        Day12 day12 = new Day12(testInput);
        assertEquals(226, day12.execute1());
    }

    @Test
    void testPart2BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day12Example.txt");

        Day12 day12 = new Day12(testInput);
        assertEquals(195, day12.execute2());
    }

    @Test
    void calculateRealAnswerPart1() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day12.txt");

        Day12 day12 = new Day12(testInput);
        long result = day12.execute1();

        System.out.println(result);
    }

    @Test
    void calculateRealAnswerPart2() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day12.txt");

        Day12 day12 = new Day12(testInput);
        long result = day12.execute2();

        System.out.println(result);
    }
}
