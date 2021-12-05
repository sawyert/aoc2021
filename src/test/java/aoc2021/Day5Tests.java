package aoc2021;

import aoc2021.day5.Day5;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Day5Tests {

    @Test
    void testPart1BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day5Example.txt");

        Day5 day5 = new Day5(testInput);
        assertEquals(5, day5.execute1());
    }

    @Test
    void testPart2BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day5Example.txt");

        Day5 day5 = new Day5(testInput);
        assertEquals(12, day5.execute2());
    }

    @Test
    void calculateRealAnswerPart1() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day5.txt");

        Day5 day5 = new Day5(testInput);
        long result = day5.execute1();

        System.out.println(result);
    }

    @Test
    void calculateRealAnswerPart2() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day5.txt");

        Day5 day5 = new Day5(testInput);
        long result = day5.execute2();

        assertNotEquals(18418, result);

        System.out.println(result);
    }
}
