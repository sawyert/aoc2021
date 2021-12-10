package aoc2021.day10;

public class Node {

    private char bracket;
    private Node child;
    private Node parent;

    public Node(char character) {
        this.bracket = character;
    }

    public void addChild(Node node) {
        this.child = node;
        this.child.setParent(this);
    }

    public void setParent(Node node) {
        this.parent = node;
    }

    public Node unwind(char charAt) throws WrongTrousersException {
        if (this.bracket == '(' && charAt != ')') {
            throw new WrongTrousersException(charAt);
        }
        if (this.bracket == '[' && charAt != ']') {
            throw new WrongTrousersException(charAt);
        }
        if (this.bracket == '{' && charAt != '}') {
            throw new WrongTrousersException(charAt);
        }
        if (this.bracket == '<' && charAt != '>') {
            throw new WrongTrousersException(charAt);
        }
        return parent;
    }

    public String completeString() {
        if (this.parent == null) {
            return "" + this.closeChar();
        }
        return this.closeChar() + this.parent.completeString();
    }

    private char closeChar() {
        switch (this.bracket)
        {
            case '(':
                return ')';
            case '[':
                return ']';
            case '{':
                return '}';
            case '<':
                return '>';
        }
        throw new UnsupportedOperationException();
    }
}
