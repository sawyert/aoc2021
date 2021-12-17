package aoc2021;

import aoc2021.day15.Day15;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Day15Tests {

    @Test
    void testPart1Simple1InputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day15Simple1.txt");

        Day15 day15 = new Day15(testInput);
        assertEquals(10, day15.execute1());
    }

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
        assertEquals(0, day15.execute2());
    }

    @Test
    void calculateRealAnswerPart1() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day15.txt");

        Day15 day15 = new Day15(testInput);
        long result = day15.execute1();

        assertNotEquals(result, 394); // too high
        assertNotEquals(result, 393); // too high
        assertNotEquals(result, 392); // too high

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
