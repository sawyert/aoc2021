package aoc2021;

import aoc2021.day17.Day17;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Day17Tests {

    @Test
    void testPart1BasicInputWorks() throws IOException, URISyntaxException {

        Day17 day17 = new Day17("target area: x=20..30, y=-10..-5");
        assertEquals(45, day17.execute1());
    }

    @Test
    void testPart2BasicInputWorks() throws IOException, URISyntaxException {
        Day17 day17 = new Day17("target area: x=20..30, y=-10..-5");
        assertEquals(112, day17.execute2());
    }

    @Test
    void calculateRealAnswerPart1() throws IOException, URISyntaxException {
        Day17 day17 = new Day17("target area: x=288..330, y=-96..-50");
        long result = day17.execute1();

        System.out.println(result);

        assertTrue(result > 1225);
    }

    @Test
    void calculateRealAnswerPart2() throws IOException, URISyntaxException {
        Day17 day17 = new Day17("target area: x=288..330, y=-96..-50");
        long result = day17.execute2();

        System.out.println(result);
    }
}
