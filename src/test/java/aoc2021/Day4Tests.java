package aoc2021;

import aoc2021.day3.Day3;
import aoc2021.day4.Day4;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Day4Tests {

    @Test
    void testPart1BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day4Example.txt");

        Day4 day4 = new Day4(testInput);
        assertEquals(4512, day4.execute1());
    }

    @Test
    void testPart2BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day4Example.txt");

        Day4 day4 = new Day4(testInput);
        assertEquals(1924, day4.execute2());
    }

    @Test
    void calculateRealAnswerPart1() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day4.txt");

        Day4 day4 = new Day4(testInput);
        long result = day4.execute1();

        System.out.println(result);
    }

    @Test
    void calculateRealAnswerPart2() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day4.txt");

        Day4 day4 = new Day4(testInput);
        long result = day4.execute2();

        System.out.println(result);
    }
}
