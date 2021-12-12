package aoc2021.day12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PathSoFar {
    private List<Cave> listOfCaves = new ArrayList<>();

    public String toString() {
        String newRoute = "";
        for (Cave cave: this.listOfCaves) {
            if (newRoute.length() > 0) {
                newRoute += ",";
            }
            newRoute += cave.getName();
        }
        return newRoute;
    }

    public boolean contains(Cave nextCave) {
        if (nextCave.getName().equals("start")) {
            return true;
        }

        boolean smallCaveDoneTwice = false;
        Map<SmallCave, Integer> smallCaveCounts = new HashMap<>();
        for (Cave c : this.listOfCaves) {
            if (c instanceof SmallCave) {
                Integer count = smallCaveCounts.get(c);
                if (count == null) {
                    smallCaveCounts.put((SmallCave)c, 1);
                } else {
                    smallCaveDoneTwice = true;
                    break;
                }
            }
        }

        boolean caveFound = this.listOfCaves.contains(nextCave);

        if (caveFound && !smallCaveDoneTwice) {
            return false;
        }

        return caveFound;
    }

    public PathSoFar duplicate() {
        PathSoFar newList = new PathSoFar();
        newList.addAll(this.listOfCaves);
        return newList;
    }

    private void addAll(List<Cave> pathSoFar) {
        this.listOfCaves.addAll(pathSoFar);
    }

    public void add(Cave nextCave) {
        this.listOfCaves.add(nextCave);
    }

    public void addAll(PathSoFar pathSoFar) {
        this.listOfCaves.addAll(pathSoFar.listOfCaves);
    }
}
