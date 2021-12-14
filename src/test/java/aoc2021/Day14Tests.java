package aoc2021;

import aoc2021.day14.Day14;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day14Tests {

    @Test
    void testPart1BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day14Example.txt");

        Day14 day14 = new Day14(testInput);
        assertEquals(1588, day14.execute1());
    }

    @Test
    void testPart2BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day14Example.txt");

        Day14 day14 = new Day14(testInput);
        assertEquals(2188189693529L, day14.execute2());
    }

    @Test
    void calculateRealAnswerPart1() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day14.txt");

        Day14 day14 = new Day14(testInput);
        long result = day14.execute1();

        System.out.println(result);
    }

    @Test
    void calculateRealAnswerPart2() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day14.txt");

        Day14 day14 = new Day14(testInput);
        long result = day14.execute2();

        System.out.println(result);
    }
}
