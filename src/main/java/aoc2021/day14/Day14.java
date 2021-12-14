package aoc2021.day14;

import java.util.ArrayList;
import java.util.List;

public class Day14 {
    private String[] input;
    private String startPoint;
    private List<String> rules = new ArrayList<>();

    public Day14(String[] testInput) {
        this.input = testInput;
        this.startPoint = this.input[0];

        for (int i=2;i<this.input.length; i++) {
            this.rules.add(this.input[i]);
        }
    }

    public long execute1() {
        PolymerChain pc = new PolymerChain(startPoint);
        for (int i=1; i<11; i++) {

            pc.pairInsert(this.rules);
            System.out.println(i + " -> " + pc.length());
            pc.countElements(startPoint.substring(0, 1));
        }

       return pc.getMostCommonElementCount() - pc.getLeastCommonElementCount();
    }

    public long execute2() {
        PolymerChain pc = new PolymerChain(startPoint);
        for (int i=1; i<41; i++) {

            pc.pairInsert(this.rules);
            System.out.println(i + " -> " + pc.length());
            pc.countElements(startPoint.substring(0, 1));
        }

        return pc.getMostCommonElementCount() - pc.getLeastCommonElementCount();
    }


}
