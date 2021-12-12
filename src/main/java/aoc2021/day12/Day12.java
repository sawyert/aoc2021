package aoc2021.day12;

import java.util.ArrayList;
import java.util.List;

public class Day12 {
    private String[] input;
    List<Cave> allCaves = new ArrayList<>();

    public Day12(String[] testInput) {
        this.input = testInput;
        for (String s: this.input) {
            String[] startEnd = s.split("-");
            this.addCave(startEnd[0]);
            this.addCave(startEnd[1]);
            this.linkCaves(startEnd[0], startEnd[1]);
        }
    }

    private void addCave(String caveName) {
        Cave cave = this.findCave(caveName);

        if (cave == null) {

            if (caveName.toLowerCase().equals(caveName)) {
                cave = new SmallCave(caveName);
            } else {
                cave = new LargeCave(caveName);
            }

            this.allCaves.add(cave);
        }
    }

    private Cave findCave(String caveName) {
        for (Cave cave: this.allCaves) {
            if (cave.getName().equals(caveName)) {
                return cave;
            }
        }
        return null;
    }

    private void linkCaves(String startName, String endName) {
        Cave start = this.findCave(startName);
        Cave end = this.findCave(endName);

        start.addLink(end);
        end.addLink(start);
    }


    public long execute1() {
        Cave start = this.findCave("start");

        List<String> foundRoutes = new ArrayList<>();

        for (Cave cave : start.getLinkedCaves()) {
            List<Cave> progress = new ArrayList<>();
            progress.add(start);
            progress.add(cave);
            this.recurse1(progress, cave, foundRoutes);
        }

        return foundRoutes.size();
    }

    public void recurse1(List<Cave> pathSoFar, Cave start, List<String> foundRoutes) {
        System.out.println(this.pathSoFarAsString(pathSoFar));
        for (Cave nextCave: start.getLinkedCaves()) {

            if (nextCave instanceof SmallCave && pathSoFar.contains(nextCave)) {
                continue;
            }

            if (nextCave == this.findCave("end")) {
                // this is a valid route
                List<Cave> path = new ArrayList<>();
                path.addAll(pathSoFar);
                path.add(nextCave);
                this.recordRoute(path, foundRoutes);
                continue;
            }

            List<Cave> newPathSoFar = new ArrayList<>();
            newPathSoFar.addAll(pathSoFar);
            newPathSoFar.add(nextCave);
            this.recurse1(newPathSoFar, nextCave, foundRoutes);
        }
    }

    private void recordRoute(List<Cave> pathSoFar, List<String> foundRoutes) {
        String newRoute = this.pathSoFarAsString(pathSoFar);
        System.out.println(newRoute);
        foundRoutes.add(newRoute);
    }

    private String pathSoFarAsString(List<Cave> pathSoFar) {
        String newRoute = "";
        for (Cave cave: pathSoFar) {
            if (newRoute.length() > 0) {
                newRoute += ",";
            }
            newRoute += cave.getName();
        }
        return newRoute;
    }


    public long execute2() {
        Cave start = this.findCave("start");

        List<String> foundRoutes = new ArrayList<>();

        for (Cave cave : start.getLinkedCaves()) {
            PathSoFar progress = new PathSoFar();
            progress.add(start);
            progress.add(cave);
            this.recurse2(progress, cave, foundRoutes);
        }

        return foundRoutes.size();
    }

    public void recurse2(PathSoFar pathSoFar, Cave start, List<String> foundRoutes) {
        System.out.println(pathSoFar.toString());
        for (Cave nextCave: start.getLinkedCaves()) {

            if (nextCave instanceof SmallCave && pathSoFar.contains(nextCave)) {
                continue;
            }

            if (nextCave == this.findCave("end")) {
                // this is a valid route
                PathSoFar path = pathSoFar.duplicate();
                path.add(nextCave);
                String newRoute = pathSoFar.toString();
                System.out.println(newRoute);
                foundRoutes.add(newRoute);
                continue;
            }

            PathSoFar newPathSoFar = new PathSoFar();
            newPathSoFar.addAll(pathSoFar);
            newPathSoFar.add(nextCave);
            this.recurse2(newPathSoFar, nextCave, foundRoutes);
        }
    }

}
