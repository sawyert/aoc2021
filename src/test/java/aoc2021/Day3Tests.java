package aoc2021;

import aoc2021.day3.Day3;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Day3Tests {

    @Test
    void testPart1BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day3Example.txt");

        Day3 day3 = new Day3(testInput);
        assertEquals(198, day3.execute1());
    }

    @Test
    void testPart2BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day3Example.txt");

        Day3 day3 = new Day3(testInput);
        assertEquals(230, day3.execute2());
    }

    @Test
    void calculateRealAnswerPart1() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day3.txt");

        Day3 day3 = new Day3(testInput);
        long result = day3.execute1();

        assertNotEquals(230126, result);
        assertEquals(3687446, result);

        System.out.println(result);
    }

    @Test
    void calculateRealAnswerPart2() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day3.txt");

        Day3 day3 = new Day3(testInput);
        System.out.println(day3.execute2());
    }
}
