package aoc2021.day15;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Grid {

    private List<Node> allNodes = new ArrayList<>();
    private List<GridRow> rows = new ArrayList<>();
    private Node startNode;
    private Node endNode;


    public Grid(String[] input) {
        int counter = 0;
        for (String s: input) {
            GridRow gridRow = new GridRow(s, counter);
            this.rows.add(gridRow);
            counter++;
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

    public void printTraversalGrid() {
        for (GridRow gridRow : this.rows) {
            gridRow.printTraversalGridRow();
        }
    }

    public long getEndNodeTraversalCost() {
        return this.endNode.getTraversalCost();
    }

    public void calculateTraversalCosts() {
        Node nextNode = this.startNode;
        boolean stillStuffToDo = true;
        while (stillStuffToDo) {
            nextNode.calculateTraversalCosts();
            nextNode = this.findNextUnvisitedNode();

            if (nextNode == null) {
                break;
            }
        }
    }

    private Node findNextUnvisitedNode() {
        Node node = this.allNodes.stream().filter(n-> !n.isVisited()).sorted(Comparator.comparing(Node::getXYScore)).findFirst().orElse(null);
        return node;
    }
}
