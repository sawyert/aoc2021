package aoc2021.day11;

import aoc2021.day10.Node;
import aoc2021.day10.WrongTrousersException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day11 {
    private String[] input;
    private int[][] grid = new int[10][10];

    public Day11(String[] testInput) {
        this.input = testInput;
    }

    public long execute1() {
      int y = 0;
      for (String s : this.input) {
          for (int x=0;x<s.length();x++) {
            grid[y][x]=Character.getNumericValue(s.charAt(x));
          }
          y++;
        }

      long totalFlashes = 0;

        this.printGrid(0, 0);

      for (int i=0; i<100; i++) {
          this.incrementGrid();
          int flashes = this.flashGrid();
          totalFlashes += flashes;
          while (flashes > 0) {
              flashes = this.flashGrid();
              totalFlashes += flashes;
          }
          this.flashedToZero();

          this.printGrid(i+1, totalFlashes);
      }

      return totalFlashes;
    }

    private int flashGrid() {
        int flashes = 0;
        for (int x=0; x<10; x++) {
            for (int y=0; y<10; y++) {
                if (grid[y][x] > 9) {
                    this.incrementAdjacentByOne(x, y);
                    grid[y][x]=-100;
                    flashes += 1;
                }
            }
        }
        return flashes;
    }

    private void incrementAdjacentByOne(int x, int y) {
        int topLeftX = x-1;
        int topLeftY = y-1;
        this.increment(topLeftX, topLeftY);

        int leftX = x-1;
        int leftY = y;
        this.increment(leftX, leftY);

        int bottomLeftX = x-1;
        int bottomLeftY = y+1;
        this.increment(bottomLeftX, bottomLeftY);

        int aboveX = x;
        int aboveY = y-1;
        this.increment(aboveX, aboveY);

        int belowX = x;
        int belowY = y+1;
        this.increment(belowX, belowY);

        int topRightX = x+1;
        int topRightY = y-1;
        this.increment(topRightX, topRightY);

        int rightX = x+1;
        int rightY = y;
        this.increment(rightX, rightY);

        int bottomRightX = x+1;
        int bottomRightY = y+1;
        this.increment(bottomRightX, bottomRightY);
    }

    private void increment(int x, int y) {
        if (x>=0 && x<10 && y>=0 && y<10) {
            grid[y][x]+=1;
        }
    }

    private void incrementGrid() {
        for (int x=0; x<10; x++) {
            for (int y=0; y<10; y++) {
                grid[y][x] += 1;
            }
        }
    }

    private void printGrid(int iteration, long flashes) {
        System.out.println("Iteration " + iteration + ", flashes " + flashes);
        for (int x=0; x<10; x++) {
            for (int y=0; y<10; y++) {
                System.out.print(grid[y][x]);
            }
            System.out.println();
        }
        System.out.println();
    }


    private void flashedToZero() {
        for (int x=0; x<10; x++) {
            for (int y=0; y<10; y++) {
                if (grid[y][x] < 0) {
                    grid[y][x] = 0;
                }
            }
        }
    }


    public long execute2() {
        int y = 0;
        for (String s : this.input) {
            for (int x=0;x<s.length();x++) {
                grid[y][x]=Character.getNumericValue(s.charAt(x));
            }
            y++;
        }

        long totalFlashes = 0;

        this.printGrid(0, 0);

        for (int i=0; i<1000; i++) {
            this.incrementGrid();
            int flashes = this.flashGrid();
            if (this.gridAllZero()) {
                return i+1;
            }
            while (flashes > 0) {
                flashes = this.flashGrid();
                if (this.gridAllZero()) {
                    return i+1;
                }
            }
            this.flashedToZero();

            this.printGrid(i+1, totalFlashes);
        }

        return 0L;
    }

    private boolean gridAllZero() {
        for (int x=0; x<10; x++) {
            for (int y=0; y<10; y++) {
                if (grid[y][x] > 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
