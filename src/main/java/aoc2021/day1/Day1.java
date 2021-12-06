package aoc2021.day1;

public class Day1 {
    String[] input;

    public Day1(String[] testInput) {
        this.input = testInput;
    }

    public long execute1() {
        int previous = -1;
        int count = 0;
        for (String s: this.input) {

            int nextVal = Integer.parseInt(s);
            if (previous > 0 && previous < nextVal) {
                count++;
            }

            previous = nextVal;
        }
        return count;
    }

    public long execute2() {
        int previous1 = -1;
        int previous2 = -1;
        int count = 0;
        int previousTotal = -1;

        for (String s: this.input) {
            int nextVal = Integer.parseInt(s);
            if (previous1 > 0 && previous2 > 0) {
                int nextTotal = previous1 + previous2 + nextVal;
                if (previousTotal > 0 && previousTotal < nextTotal) {
                    count++;
                }
                previousTotal = nextTotal;
            }

            previous1 = previous2;
            previous2 = nextVal;

        }
        return count;
    }
}
