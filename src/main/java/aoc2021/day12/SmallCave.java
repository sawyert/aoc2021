package aoc2021.day12;

public class SmallCave extends Cave {
    public SmallCave(String name) {
        super(name);
    }

    public void setVisited() {
        this.blocked = true;
    }
}
