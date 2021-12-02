package aoc2021.day2;

public class Day2 {
    String[] input;

    public Day2(String[] testInput) {
        this.input = testInput;
    }

    public long execute1() {
        Sub sub = new Sub();
        for (String s : this.input) {
            sub.move1(s);
        }

        return sub.getDepth() * sub.getHorizontal();
    }

    public long execute2() {
        Sub sub = new Sub();
        for (String s : this.input) {
            sub.move2(s);
        }

        return sub.getDepth() * sub.getHorizontal();
    }
}
