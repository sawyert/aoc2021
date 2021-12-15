package aoc2021.day15;

import aoc2021.day14.PolymerChain;

import java.util.ArrayList;
import java.util.List;

public class Day15 {
    private String[] input;
    private Node[][] nodes;
    private Node startNode;
    private Node endNode;
    private int maxX = 0;
    private int maxY = 0;

    public Day15(String[] testInput) {
        this.input = testInput;
        this.nodes = new Node[this.input.length][this.input[0].length()];

        int y = 0;
        for (String s : this.input) {
            for (int x=0;x<s.length();x++) {
                int value = Integer.parseInt(s.substring(x,x+1));
                this.nodes[y][x] = new Node(value, x, y);
                if (y > this.maxY) {
                    this.maxY = y;
                }
                if (x > this.maxX) {
                    this.maxX = x;
                }
            }
            y++;
        }
        this.startNode = this.nodes[0][0];
        this.startNode.clearMinDistance();
        this.endNode = this.nodes[this.maxX][this.maxY];
    }

    public long execute1() {
        Node node = startNode;
        node.walk(this.nodes, this.maxX, this.maxY);

        return endNode.getMinPath();
    }

    public long execute2() {
        return 0L;
    }


}
