package aoc2021.day13;

import aoc2021.day12.Cave;
import aoc2021.day12.LargeCave;
import aoc2021.day12.PathSoFar;
import aoc2021.day12.SmallCave;

import java.util.ArrayList;
import java.util.List;

public class Day13 {
    private static final int SIZE = 1500;
    private String[] input;
    private int[][] grid = new int[SIZE][SIZE];
    private List<String> folds = new ArrayList<>();

    public Day13(String[] testInput) {
        this.input = testInput;

        for (String s: this.input) {
            if (s.indexOf(",") > -1) {
                String[] xy = s.split(",");
                int x = Integer.parseInt(xy[0]);
                int y = Integer.parseInt(xy[1]);
                this.grid[y][x] = 1;
            }
            else if (s.indexOf("fold") > -1) {
                String instr = s.substring("fold along ".length());
                this.folds.add(instr.trim());
            }
        }

    }

   public long execute1() {
       String firstInstruction = this.folds.get(0);
       String[] instrSplit = firstInstruction.split("=");
       String direction = instrSplit[0];
       int location = Integer.parseInt(instrSplit[1]);

       switch(direction) {
           case "x":
               this.foldX(location);
               break;
           case "y":
               this.foldY(location);
               break;
           default:
               throw new UnsupportedOperationException();
       }

       long count = 0;
       for (int x=0; x<SIZE; x++) {
           for (int y=0; y<SIZE; y++) {
               if (this.grid[y][x] > 0) {
                   count += 1;
               }
            }
       }

       return count;
    }

    public long execute2() {
        for (String instruction: this.folds) {
            String[] instrSplit = instruction.split("=");
            String direction = instrSplit[0];
            int location = Integer.parseInt(instrSplit[1]);

            switch (direction) {
                case "x":
                    this.foldX(location);
                    break;
                case "y":
                    this.foldY(location);
                    break;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        for (int y=0; y<100; y++) {
            for (int x=0; x<100; x++) {
                if (this.grid[y][x] == 0) {
                    System.out.print(".");
                } else {
                    System.out.print("#");
                }
            }
            System.out.println();
        }

        return 0L;
    }

    private void foldX(int location) {
        for (int x=0; x<SIZE; x++) {
            for (int y=0; y<SIZE; y++) {
                if (x==location) {
                    this.grid[y][x] = 0;
                }
                if (x > location) {
                    int offset = x - location;
                    int newX = x - (offset * 2);
                    if (newX > -1) {
                        if (this.grid[y][newX] < 1) {
                            this.grid[y][newX] = this.grid[y][x];
                        }
                    }
                    this.grid[y][x] = 0;
                }
            }
        }
    }

    private void foldY(int location) {
        for (int y=0; y<SIZE; y++) {
            for (int x=0; x<SIZE; x++) {
                if (y==location) {
                    this.grid[y][x] = 0;
                }
                if (y > location) {
                    int offset = y - location;
                    int newY = y - (offset * 2);
                    if (newY > -1) {
                        if (this.grid[newY][x] < 1) {
                            this.grid[newY][x] = this.grid[y][x];
                        }
                    }
                    this.grid[y][x] = 0;
                }
            }
        }
    }
}
