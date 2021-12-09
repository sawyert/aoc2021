package aoc2021.day9;

import aoc2021.day8.NumberList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day9 {
    private String[] input;
    private static final int SIZE = 1000;

    public Day9(String[] testInput) {
        this.input = testInput;
    }

    public long execute1() {
        long riskLevel = 0;

        int lineLength = 0;
        int rows = 0;

        int j=0;
        int[][] board = new int[SIZE][SIZE];
        for (String s: this.input) {
            for (int i=0; i<s.length(); i++) {
                board[i][j]=Integer.parseInt(s.substring(i, i+1));
                if (i>lineLength) {
                    lineLength = i;
                }
            }
            j++;

            if (j>rows) {
                rows = j;
            }
        }
        lineLength++;

        for (int x=0;x<lineLength; x++) {
            for (int y=0; y<rows; y++) {
                int lowestAround = this.calculateLowestAround(board, x, y, lineLength, rows);
                if (board[x][y] < lowestAround) {
                    riskLevel += board[x][y] + 1;
                }
            }
        }
        return riskLevel;
    }

    private int calculateLowestAround(int[][] board, int x, int y, int lineLength, int rows) {
        int value = 10;

        // up
        if (y > 0) {
            // we're not top line
            int up = board[x][y-1];
            if (up < value) value = up;
        }

        // down
        if (y < rows - 1) {
            int down = board[x][y+1];
            if (down < value) value = down;
        }

        // left
        if (x > 0) {
            int left = board[x-1][y];
            if (left < value) value = left;
        }

        // right
        if (x < lineLength - 1) {
            int right = board[x+1][y];
            if (right < value) value = right;
        }

        return value;
    }

    public long execute2() {
        List<Integer> basinSizes = new ArrayList<>();

        int lineLength = 0;
        int rows = 0;

        int j=0;
        int[][] board = new int[SIZE][SIZE];
        for (String s: this.input) {
            for (int i=0; i<s.length(); i++) {
                board[i][j]=Integer.parseInt(s.substring(i, i+1));
                if (i>lineLength) {
                    lineLength = i;
                }
            }
            j++;

            if (j>rows) {
                rows = j;
            }
        }
        lineLength++;

        for (int x=0;x<lineLength; x++) {
            for (int y=0; y<rows; y++) {
                int lowestAround = this.calculateLowestAround(board, x, y, lineLength, rows);
                if (board[x][y] < lowestAround) {
                    int basinSize = this.calculateBasinSize(board, x, y, lineLength, rows);
                    basinSizes.add(basinSize);
                }
            }
        }


        Collections.sort(basinSizes);
        Collections.reverse(basinSizes);

        long topThreeSizes = basinSizes.get(0) * basinSizes.get(1) * basinSizes.get(2);

        return topThreeSizes;
    }

    private int calculateBasinSize(int[][] board, int x, int y, int lineLength, int rows) {
        // starting from x,y work out until you hit a nine and count number of squares
        int basinSize = 1;

        board[x][y]=11;

        // up
        if (y > 0) {
            // we're not top line
            int up = board[x][y-1];
            if (up < 9) {
                basinSize += this.calculateBasinSize(board, x, y - 1, lineLength, rows);
            }
        }

        // down
        if (y < rows - 1) {
            int down = board[x][y+1];
            if (down < 9) {
                basinSize += this.calculateBasinSize(board, x, y+1, lineLength, rows);
            }
        }

        // left
        if (x > 0) {
            int left = board[x-1][y];
            if (left < 9) {
                basinSize += this.calculateBasinSize(board, x-1, y, lineLength, rows);
            }
        }

        // right
        if (x < lineLength - 1) {
            int right = board[x+1][y];
            if (right < 9) {
                basinSize += this.calculateBasinSize(board, x+1, y, lineLength, rows);
            }
        }

        return basinSize;
    }
}
