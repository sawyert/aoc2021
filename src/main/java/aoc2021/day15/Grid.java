package aoc2021.day15;

import java.util.ArrayList;
import java.util.List;

public class Grid {

    private List<Node> allNodes = new ArrayList<>();
    private List<GridRow> rows = new ArrayList<>();
    private Node startNode;
    private Node endNode;


    public Grid(String[] input) {
        for (String s: input) {
            GridRow gridRow = new GridRow(s);
            this.rows.add(gridRow);

        }

        GridRow previous = null;
        for (GridRow row: rows) {
            if (previous != null) {
                row.link(previous);
            }

            previous = row;
        }

        for (GridRow eachRow : this.rows) {
            for (Node eachNode : eachRow.getNodes()) {
                this.allNodes.add(eachNode);
            }
        }

        this.startNode = this.rows.get(0).get(0);
        this.startNode.setAsStartNode();
        this.endNode = this.rows.get(this.rows.size()-1).getLast();
    }

    public void printGrid() {
        for (GridRow gridRow : this.rows) {
            gridRow.printRow();
        }
    }

    public long getEndNodeTraversalCost() {
        return this.endNode.getTraversalCost();
    }

    public void calculateTraversalCosts() {
        int counter = 0;
        Node nextNode = this.startNode;
        while (true) {
            nextNode.calculateTraversalCosts();
            nextNode = nextNode.getMinimumScoreNode();

            if (nextNode == null) {
                nextNode = this.findNextUnvisitedNode();
            }

            if (nextNode == this.endNode) {
                break;
            }

            System.out.println(counter);
            counter++;
            this.printGrid();
        }

        return;
    }

    private Node findNextUnvisitedNode() {
        for (Node node: this.allNodes) {
            if (node.isVisited()) {
                continue;
            }
            return node;
        }
        throw new UnsupportedOperationException();
    }
}
