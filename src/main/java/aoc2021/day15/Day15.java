package aoc2021.day15;

import java.util.*;

public class Day15 {
    private String[] input;
    private int[][] risks;
    private int[][] costFromOrigin;
    private boolean[][] visited;
    private int maxY = 0;
    private int maxX = 0;

    public Day15(String[] testInput, boolean supersize) {
        this.input = testInput;
        this.maxX = this.input[0].length();
        this.maxY = this.input.length;

        if (supersize) {
            this.maxX = this.maxX * 5;
            this.maxY = this.maxY * 5;
        }

        this.risks = new int[this.maxY][this.maxX];
        int ry = 0;
        for (String s: this.input) {
            for (int rx=0; rx<s.length(); rx++) {
                this.risks[ry][rx] = Integer.parseInt(s.substring(rx, rx+1));
            }
            ry++;
        }

        this.costFromOrigin = new int[this.maxY][this.maxX];
        for (int oy=0;oy<this.maxY;oy++) {
            for (int ox=0; ox<this.maxX; ox++) {
                this.costFromOrigin[oy][ox] = Integer.MAX_VALUE;
            }
        }

        this.visited = new boolean[this.maxY][this.maxX];

        this.risks[0][0]=0;
        this.costFromOrigin[0][0]=0;
    }

    public long execute() {

        int doItAgain = 10000;
        int counter = 0;
        while(true) {
            this.visited = new boolean[this.maxY][this.maxX];

            counter++;
            this.scoreNeighbours(new Coordinates(0, 0));

            if (this.costFromOrigin[this.maxY-1][this.maxX-1] < Integer.MAX_VALUE) {
                doItAgain--;
            }

            if (doItAgain < 1 || counter > 50000) {
                break;
            }
        }

        return this.costFromOrigin[this.maxY-1][this.maxX-1];
    }

    private void scoreNeighbours(Coordinates nextNode) {
        this.visited[nextNode.y][nextNode.x] = true;
        List<Coordinates> neighbours = this.getNeighboursOf(nextNode);
        for (Coordinates eachNeighbour : neighbours) {
            this.setLowerCostFromOrigin(nextNode, eachNeighbour);
            if (this.visited[eachNeighbour.y][eachNeighbour.x] == false) {
                this.scoreNeighbours(eachNeighbour);
            }
        }
    }



    private List<Coordinates> getNeighboursOf(Coordinates nextNode) {
        Coordinates left = null;
        Coordinates top = null;
        Coordinates right = null;
        Coordinates bottom = null;

        if (nextNode.x > 0) {
            left = new Coordinates(nextNode.x-1, nextNode.y);
        }

        if (nextNode.x < this.maxX-1) {
            right = new Coordinates(nextNode.x + 1, nextNode.y);
        }

        if (nextNode.y > 0) {
            top = new Coordinates(nextNode.x, nextNode.y-1);
        }

        if (nextNode.y < this.maxY-1) {
            bottom = new Coordinates(nextNode.x, nextNode.y+1);
        }

        List<Coordinates> neighbours = new ArrayList<>();
        if (bottom != null) neighbours.add(bottom);
        if (right != null) neighbours.add(right);
        if (left != null) neighbours.add(left);
        if (top != null) neighbours.add(top);

        Collections.shuffle(neighbours);

        return neighbours;
    }

    private int setLowerCostFromOrigin(Coordinates sourceNode, Coordinates newNode) {
        int existingValue = this.costFromOrigin[newNode.y][newNode.x];
        int newValue = this.costFromOrigin[sourceNode.y][sourceNode.x] + this.risks[newNode.y][newNode.x];

        if (newValue < existingValue) {
            this.costFromOrigin[newNode.y][newNode.x] = newValue;
            return 1;
        }
        return 0;
    }
}
