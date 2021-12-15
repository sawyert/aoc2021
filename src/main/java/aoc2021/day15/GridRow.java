package aoc2021.day15;

import java.util.ArrayList;
import java.util.List;

public class GridRow {
    List<Node> nodes = new ArrayList<>();

    public GridRow(String s) {
        Node previous = null;
        for (int i=0; i<s.length();i++) {
            String eachChar = s.substring(i, i+1);
            Node eachNode = new Node(eachChar);
            this.nodes.add(eachNode);
            if (previous != null) {
                eachNode.link(previous);
            }
            previous = eachNode;
        }
    }

    public void link(GridRow previous) {
        for (int i=0; i<this.nodes.size(); i++) {
            Node thisNode = this.nodes.get(i);
            Node previousNode = previous.get(i);

            thisNode.link(previousNode);
        }
    }

    public Node get(int i) {
        return this.nodes.get(i);
    }

    public Node getLast() {
        return this.nodes.get(this.nodes.size() - 1);
    }

    public List<Node> getNodes() {
        return this.nodes;
    }

    public void printRow() {
        for (Node node: this.nodes) {
            if (node.isVisited()) {
                System.out.print(".");
            } else {
                System.out.print(node.getWeight());
            }
        }
        System.out.println();
    }
}
