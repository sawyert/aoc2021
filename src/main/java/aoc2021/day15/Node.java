package aoc2021.day15;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private long minDistance = Long.MAX_VALUE;
    private final int value;
    private boolean visited = false;
    private int x;
    private int y;

    public Node(int value, int x, int y) {
        this.value = value;
        this.x = x;
        this.y = y;
    }

    public void clearMinDistance() {
        this.minDistance = 0;
    }

    public long getMinPath() {
        return this.minDistance;
    }

    public void walk(Node[][] nodes, int maxX, int maxY) {
        List<Node> neighbours = this.calculateUnvisitedNeighbours(nodes, maxX, maxY);

        for (Node neighbour : neighbours) {
            neighbour.tryMinDistance(this.minDistance + this.value);
        }

        this.visited = true;
        System.out.println(this.y + "," + this.x + " visited");

        this.printGrid(nodes, maxX, maxY);

        long lowestDistance = Long.MAX_VALUE;
        Node lowestDistanceNode = null;
        for (Node neighbour : neighbours) {
            if (neighbour.getMinPath() + neighbour.value < lowestDistance) {
                lowestDistance = neighbour.getMinPath() + neighbour.value;
                lowestDistanceNode = neighbour;
            }
        }

        if (lowestDistanceNode != null) {
            lowestDistanceNode.walk(nodes, maxX, maxY);
        }

        return;
    }

    private void printGrid(Node[][] nodes, int maxX, int maxY) {
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

    private List<Node> calculateUnvisitedNeighbours(Node[][] nodes, int maxX, int maxY) {
        Node left = null;
        Node top = null;
        Node right = null;
        Node bottom = null;

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

        List<Node> neighbours = new ArrayList<>();
        if (bottom != null && !bottom.visited) neighbours.add(bottom);
        if (right != null && !right.visited) neighbours.add(right);
        if (left != null && !left.visited) neighbours.add(left);
        if (top != null && !top.visited) neighbours.add(top);

        return neighbours;

    }

    private void tryMinDistance(long minDistanceFrom) {
        if (minDistanceFrom < this.minDistance) {
            this.minDistance = minDistanceFrom;
        }
    }
}
