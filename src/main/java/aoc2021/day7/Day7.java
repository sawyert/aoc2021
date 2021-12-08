package aoc2021.day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.abs;

public class Day7 {
    private String[] input;

    public Day7(String[] testInput) {
        this.input = testInput;
    }

    public long execute1() {
        String[] positions = this.input[0].split(",");
        long sum = 0;
        int[] crabs = new int[positions.length];
        for (int i=0;i<positions.length;i++) {
            crabs[i] = Integer.parseInt((positions[i]));
            sum += crabs[i];
        }

        int[] sortedArray = crabs;
        Arrays.sort(sortedArray);

        long ave = 0;
        if (sortedArray.length % 2 == 0)
            ave = ((long)sortedArray[sortedArray.length/2] + (long)sortedArray[sortedArray.length/2 - 1])/2;
        else
            ave = sortedArray[sortedArray.length/2];

        long fuel = 0;
        for (int i : crabs) {
            long fuelToUse = i - ave;
            if (fuelToUse < 0) {
                fuelToUse *= -1;
            }
            fuel += fuelToUse;
        }

        return fuel;
    }

    private int triangular(int i) {
        return i * (i + 1) / 2;
    }

    public long execute2() {
        String[] positions = this.input[0].split(",");
        long max = 0;
        List<Integer> crabs = new ArrayList<>();
        for (int i=0;i<positions.length;i++) {
            int value = Integer.parseInt((positions[i]));
            crabs.add(value);
            if (value > max) {
                max = value;
            }
        }

        long minCostPosition = 9999999999999999L;
        for (int position=0; position<max; position++) {
            long cost = this.calculateCost(position, crabs);
            if (cost < minCostPosition) {
                minCostPosition = cost;
            }
        }

        return minCostPosition;
    }

    private long calculateCost(int position, List<Integer> crabs) {
        long cost = 0;
        for (Integer crab: crabs) {
            cost += triangular(abs(position - crab));
        }
        return cost;
    }

}
