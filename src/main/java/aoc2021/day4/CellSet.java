package aoc2021.day4;

import java.util.ArrayList;
import java.util.List;

public class CellSet {
    private List<Cell> cells = new ArrayList<>();

    public void add(Cell cell) {
        this.cells.add(cell);
    }

    public boolean win() {
        for (Cell cell : this.cells) {
            if (cell.isCalled() == false) {
                return false;
            }
        }
        return true;
    }
}
