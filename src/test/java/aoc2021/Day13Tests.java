package aoc2021;

import aoc2021.day13.Day13;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day13Tests {

    @Test
    void testPart1BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day13Example.txt");

        Day13 day13 = new Day13(testInput);
        assertEquals(17, day13.execute1());
    }

    @Test
    void testPart2BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day13Example.txt");

        Day13 day13 = new Day13(testInput);
        assertEquals(3509, day13.execute2());
    }

    @Test
    void calculateRealAnswerPart1() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day13.txt");

        Day13 day13 = new Day13(testInput);
        long result = day13.execute1();

        System.out.println(result);
    }

    @Test
    void calculateRealAnswerPart2() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day13.txt");

        Day13 day13 = new Day13(testInput);
        long result = day13.execute2();

        System.out.println(result);
    }
}
