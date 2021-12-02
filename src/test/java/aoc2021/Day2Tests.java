package aoc2021;

import aoc2021.day2.Day2;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day2Tests {

    @Test
    void testPart1BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day2Example.txt");

        Day2 day2 = new Day2(testInput);
        assertEquals(150, day2.execute1());
    }

    @Test
    void testPart2BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day2Example.txt");

        Day2 day2 = new Day2(testInput);
        assertEquals(900, day2.execute2());
    }

    @Test
    void calculateRealAnswerPart1() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day2.txt");

        Day2 day2 = new Day2(testInput);
        System.out.println(day2.execute2());
    }

    @Test
    void calculateRealAnswerPart2() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day2.txt");

        Day2 day2 = new Day2(testInput);
        System.out.println(day2.execute2());
    }
}
