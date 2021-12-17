package aoc2021;

import aoc2021.day15.Day15;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

public class Day15Tests {

    @Test
    void testPart1Simple1InputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day15Simple1.txt");

        Day15 day15 = new Day15(testInput, false);
        assertEquals(10, day15.execute());
    }

    @Test
    void testPart1BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day15Example.txt");

        Day15 day15 = new Day15(testInput, false);
        assertEquals(40, day15.execute());
    }

    @Test
    void testPart2BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day15Example.txt");

        Day15 day15 = new Day15(testInput, true);
        assertEquals(315, day15.execute());
    }

    @Test
    void calculateRealAnswerPart1() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day15.txt");

        Day15 day15 = new Day15(testInput, false);
        long result = day15.execute();

        assertNotEquals(result, 394); // too high
        assertNotEquals(result, 393); // too high
        assertNotEquals(result, 392); // too high
        assertNotEquals(result, 1042); // too high
        assertTrue(result < 392);


        System.out.println(result);
    }

    @Test
    void calculateRealAnswerPart2() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day15.txt");

        Day15 day15 = new Day15(testInput, true);
        long result = day15.execute();

        System.out.println(result);
    }
}
