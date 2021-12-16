package aoc2021;

import aoc2021.day16.Day16;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Day16Tests {

    @Test
    void testPart1Simple1InputWorks() throws IOException, URISyntaxException {
        Day16 day16 = new Day16("D2FE28");
        assertEquals(6, day16.execute1());
    }

    @Test
    void testPart1Simple2InputWorks() throws IOException, URISyntaxException {
        Day16 day16 = new Day16("38006F45291200");
        assertEquals(9, day16.execute1());
    }

    @Test
    void testPart1Simple3InputWorks() throws IOException, URISyntaxException {
        Day16 day16 = new Day16("8A004A801A8002F478");
        assertEquals(16, day16.execute1());
    }

    @Test
    void testPart1Simple4InputWorks() throws IOException, URISyntaxException {
        Day16 day16 = new Day16("620080001611562C8802118E34");
        assertEquals(12, day16.execute1());
    }


    @Test
    void testPart1Simple5InputWorks() throws IOException, URISyntaxException {
        Day16 day16 = new Day16("C0015000016115A2E0802F182340");
        assertEquals(23, day16.execute1());
    }

    @Test
    void testPart1Simple6InputWorks() throws IOException, URISyntaxException {
        Day16 day16 = new Day16("A0016C880162017C3686B18A3D4780");
        assertEquals(31, day16.execute1());
    }

    @Test
    void testPart2Simple1InputWorks() throws IOException, URISyntaxException {
        Day16 day16 = new Day16("C200B40A82");
        assertEquals(3, day16.execute2());
    }

    @Test
    void testPart2Simple2InputWorks() throws IOException, URISyntaxException {
        Day16 day16 = new Day16("880086C3E88112");
        assertEquals(7, day16.execute2());
    }

    @Test
    void testPart2Simple4InputWorks() throws IOException, URISyntaxException {
        Day16 day16 = new Day16("CE00C43D881120");
        assertEquals(9, day16.execute2());
    }

    @Test
    void testPart2Simple5InputWorks() throws IOException, URISyntaxException {
        Day16 day16 = new Day16("D8005AC2A8F0");
        assertEquals(1, day16.execute2());
    }

    @Test
    void testPart2Simple6InputWorks() throws IOException, URISyntaxException {
        Day16 day16 = new Day16("F600BC2D8F");
        assertEquals(0, day16.execute2());
    }

    @Test
    void testPart2Simple7InputWorks() throws IOException, URISyntaxException {
        Day16 day16 = new Day16("9C005AC2F8F0");
        assertEquals(0, day16.execute2());
    }

    @Test
    void testPart2Simple8InputWorks() throws IOException, URISyntaxException {
        Day16 day16 = new Day16("9C0141080250320F1802104A08");
        assertEquals(1, day16.execute2());
    }

    @Test
    void calculateRealAnswerPart1() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day16.txt");

        Day16 day16 = new Day16(testInput[0]);
        long result = day16.execute1();

        System.out.println(result);
    }

    @Test
    void calculateRealAnswerPart2() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day16.txt");

        Day16 day16 = new Day16(testInput[0]);
        long result = day16.execute2();

        assertNotEquals(result, 3988270351285L);
        assertNotEquals(result, 3988270354959L);

        System.out.println(result);
    }
}
