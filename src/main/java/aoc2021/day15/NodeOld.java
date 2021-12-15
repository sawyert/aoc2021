package aoc2021.day15;

import java.util.ArrayList;
import java.util.List;

public class NodeOld {
    private long minDistance = Long.MAX_VALUE;
    private int value;
    private boolean visited = false;
    private int x;
    private int y;

    public NodeOld(int value, int x, int y) {
        this.value = value;
        this.x = x;
        this.y = y;
    }

    public void clearMinDistance() {

        this.minDistance = 0;
        this.value = 0;
    }

    public long getMinPath() {
        return this.minDistance;
    }

    public void walk(NodeOld[][] nodes, int maxX, int maxY) {
        if (this.x == maxX && this.y == maxY) {
            return;
        }

        List<NodeOld> neighbours = this.calculateUnvisitedNeighbours(nodes, maxX, maxY);

        for (NodeOld neighbour : neighbours) {
            neighbour.tryMinDistance(this.minDistance);
        }

        this.visited = true;
        System.out.println(this.y + "," + this.x + " visited");

        this.printGrid(nodes, maxX, maxY);

        long lowestDistance = Long.MAX_VALUE;
        NodeOld lowestDistanceNode = null;
        for (NodeOld neighbour : neighbours) {
            if (neighbour.value < lowestDistance) {
                lowestDistance = neighbour.value;
                lowestDistanceNode = neighbour;
            }
        }

        if (lowestDistanceNode != null) {
            lowestDistanceNode.walk(nodes, maxX, maxY);
        }
    }

    private void printGrid(NodeOld[][] nodes, int maxX, int maxY) {
        for (int py=0;py<=maxY; py++) {
            for (int px=0;px<=maxX; px++) {
                if (nodes[py][px].visited) {
                    System.out.print(".");
                } else {
                    System.out.print(nodes[py][px].value);
                }
            }
            System.out.println();
        }
    }

    private List<NodeOld> calculateUnvisitedNeighbours(NodeOld[][] nodes, int maxX, int maxY) {
        NodeOld left = null;
        NodeOld top = null;
        NodeOld right = null;
        NodeOld bottom = null;

        if (this.x > 0) {
            left = nodes[this.y][this.x-1];
        }

        if (this.x < maxX) {
            right = nodes[this.y][this.x+1];
        }

        if (this.y > 0) {
            top = nodes[this.y-1][this.x];
        }

        if (this.y < maxY) {
            bottom = nodes[this.y+1][this.x];
        }

        List<NodeOld> neighbours = new ArrayList<>();
        if (bottom != null && !bottom.visited) neighbours.add(bottom);
        if (right != null && !right.visited) neighbours.add(right);
        if (left != null && !left.visited) neighbours.add(left);
        if (top != null && !top.visited) neighbours.add(top);

        return neighbours;

    }

    private void tryMinDistance(long minDistanceFrom) {
        long newValue = minDistanceFrom + this.value;
        if (newValue < this.minDistance) {
            this.minDistance = newValue;
        }
    }
}
