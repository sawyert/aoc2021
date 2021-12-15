package aoc2021.day15;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private long minimumTraversalCost = Long.MAX_VALUE;
    private int weight;
    private boolean visited = false;
    List<Node> links = new ArrayList<>();

    public Node(String eachChar) {
        this.weight = Integer.parseInt(eachChar);
    }

    public void link(Node node) {
        this.links.add(node);
        node.links.add(this);
    }

    public void calculateTraversalCosts() {
        for (Node eachNode : this.links) {
//            if (eachNode.visited) {
//                continue;
//            }

            eachNode.setMinTraversalCostFrom(this.minimumTraversalCost);
        }

        this.visited = true;
    }

    private void setMinTraversalCostFrom(long prevNodeMinimumTraversalCost) {
        long newValue = prevNodeMinimumTraversalCost + this.weight;
        if (newValue < this.minimumTraversalCost) {
            this.minimumTraversalCost = newValue;
        }
    }

    public void setAsStartNode() {
        this.minimumTraversalCost = 0;
        this.weight = 0;
    }

    public long getTraversalCost() {
        return this.minimumTraversalCost;
    }

    public Node getMinimumScoreNode() {
        long min = Long.MAX_VALUE;
        Node minNode = null;
        for (Node eachNode : this.links) {
            if (eachNode.visited) {
                continue;
            }

            if (eachNode.weight < min) {
                min = eachNode.weight;
                minNode = eachNode;
            }
        }
        return minNode;
    }

    public boolean isVisited() {
        return this.visited;
    }

    public int getWeight() {
        return this.weight;
    }
}
