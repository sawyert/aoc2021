package aoc2021;

import aoc2021.day7.Day7;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day7Tests {

    @Test
    void testPart1BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day7Example.txt");

        Day7 day7 = new Day7(testInput);
        assertEquals(5934, day7.execute1());
    }

    @Test
    void testPart2BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day7Example.txt");

        Day7 day7 = new Day7(testInput);
        assertEquals(26984457539l, day7.execute2());
    }

    @Test
    void calculateRealAnswerPart1() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day7.txt");

        Day7 day7 = new Day7(testInput);
        long result = day7.execute1();

        System.out.println(result);
    }

    @Test
    void calculateRealAnswerPart2() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day7.txt");

        Day7 day7 = new Day7(testInput);
        long result = day7.execute2();

        System.out.println(result);
    }
}
