package aoc2021.day12;

import java.util.ArrayList;
import java.util.List;

public abstract class Cave {
    private final String name;
    List<Cave> linkedCaves = new ArrayList<>();
    protected boolean blocked = false;

    protected Cave(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addLink(Cave linkTo) {
        if (this.linkedCaves.contains(linkTo)) {
            return;
        }
        this.linkedCaves.add(linkTo);
    }

    public void setVisited() {
        return;
    }

    public boolean available() {
        return !this.blocked;
    }

    public List<Cave> getLinkedCaves(){
        return this.linkedCaves;
    }

    public void resetBlocked() {
        this.blocked = false;
    }
}
