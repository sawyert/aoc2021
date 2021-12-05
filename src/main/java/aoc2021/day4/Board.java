package aoc2021.day4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {

    private boolean alreadyWon = false;
    private List<Cell> allCells = new ArrayList<>();
    private List<CellSet> lines = new ArrayList<>();
    private Map<Integer, CellSet> columns = new HashMap<>();

    public void addLine(String bingoLine) {
        String[] lineStrings = bingoLine.split("\s+");
        CellSet lineCellSet = new CellSet();
        int position = 0;
        for (String s: lineStrings) {
            if (s.trim().length() == 0) {
                continue;
            }
            Cell cell = new Cell(s);
            this.allCells.add(cell);

            lineCellSet.add(cell);
            position++;

            CellSet columnSet = this.columns.get(position);
            if (columnSet == null) {
                columnSet = new CellSet();
                columns.put(position, columnSet);
            }
            columnSet.add(cell);
        }
        lines.add(lineCellSet);
    }

    public void markNumber(String numberCalled) {
        for (Cell c: this.allCells) {
            c.markNumber(numberCalled);
        }
    }

    public boolean win() {
        if (alreadyWon) {
            return false;
        }
        for (CellSet cellSet: this.lines) {
            if (cellSet.win()) {
                this.alreadyWon = true;
                return true;
            }
        }

        for (CellSet cellSet: this.columns.values()) {
            if (cellSet.win()) {
                this.alreadyWon = true;
                return true;
            }
        }
        return false;
    }

    public long score(String lastNumberCalled) {
        long total = 0;
        for (Cell cell: allCells) {
            if (cell.isCalled() == false) {
                total += cell.getNumber();
            }
        }

        return total * Integer.parseInt(lastNumberCalled);
    }
}
