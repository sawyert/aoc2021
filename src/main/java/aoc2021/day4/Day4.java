package aoc2021.day4;

import java.util.ArrayList;
import java.util.List;

public class Day4 {
    private String[] input;
    private String numbers;
    private List<Board> boards = new ArrayList<>();

    public Day4(String[] testInput) {
        this.input = testInput;
        this.numbers = this.input[0];

        Board board = null;
        for (int i=1; i<this.input.length; i++) {
            String line = this.input[i];
            if (line.trim().length() == 0) {
                board = new Board();
                this.boards.add(board);
                continue;
            }
            board.addLine(this.input[i]);
        }
    }

    public long execute1() {
        String[] numbersCalled = this.numbers.split(",");
        for (String s: numbersCalled) {
            for (Board board: boards) {
                board.markNumber(s);
                if (board.win()) {
                    return board.score(s);
                }
            }
        }
        return 0;
    }

    public long execute2() {
        List<Board> wonBoards = new ArrayList<>();
        String[] numbersCalled = this.numbers.split(",");
        for (String s: numbersCalled) {
            for (Board board: boards) {
                board.markNumber(s);
                if (board.win()) {
                    wonBoards.add(board);

                    if (wonBoards.size() == this.boards.size()) {
                        // last board just won
                        return board.score(s);
                    }
                }
            }
        }
        return 0;
    }
}
