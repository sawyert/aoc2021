package aoc2021.day15;

public class Day15 {
    private String[] input;

    public Day15(String[] testInput) {
        this.input = testInput;
    }

    public long execute1() {
        Grid grid = new Grid(this.input);

        grid.calculateTraversalCosts();

        grid.printGrid();
        grid.printTraversalGrid();

        return grid.getEndNodeTraversalCost();
    }

    public long execute2() {
        return 0L;
    }
}
