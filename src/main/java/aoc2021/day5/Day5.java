package aoc2021.day5;

public class Day5 {
    private String[] input;
    private static final int SIZE = 1000;
    private int[][] grid = new int[SIZE][SIZE];

    public Day5(String[] testInput) {
        this.input = testInput;
    }

    public long execute1() {
        for (String s: this.input) {
            String[] fromTo = s.split(" -> ");
            String from = fromTo[0];
            String to = fromTo[1];
            String[] fromXy = from.split(",");
            String[] toXy = to.split(",");
            int fromX = Integer.parseInt(fromXy[0]);
            int fromY = Integer.parseInt(fromXy[1]);
            int toX = Integer.parseInt(toXy[0]);
            int toY = Integer.parseInt(toXy[1]);

            System.out.println(s);

            if (fromX == toX) {
                int largerY = fromY;
                int smallerY = toY;
                if (fromY < toY) {
                    largerY = toY;
                    smallerY = fromY;
                }
                int counter = smallerY;
                while (counter <= largerY) {
                    this.grid[fromX][counter]++;
                    counter++;
                }
            }
            else if (fromY == toY) {
                int largerX = fromX;
                int smallerX = toX;
                if (fromX < toX) {
                    largerX = toX;
                    smallerX = fromX;
                }
                int counter = smallerX;
                while (counter <= largerX) {
                    this.grid[counter][fromY]++;
                    counter++;
                }
            } else
            {
                System.out.println("Skipping");
                continue;
            }
        }

        int counter = 0;
        for (int x=0; x<SIZE;x++){
            for (int y=0; y<SIZE;y++){
                if (this.grid[x][y] > 1) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public long execute2() {
        for (String s: this.input) {
            System.out.println(s);
            String[] fromTo = s.split(" -> ");
            String from = fromTo[0];
            String to = fromTo[1];
            String[] fromXy = from.split(",");
            String[] toXy = to.split(",");
            int fromX = Integer.parseInt(fromXy[0]);
            int fromY = Integer.parseInt(fromXy[1]);
            int toX = Integer.parseInt(toXy[0]);
            int toY = Integer.parseInt(toXy[1]);

            int directionY = 1;
            int directionX = 1;
            if (fromY > toY) {
                directionY = -1;
            }
            if (fromX > toX) {
                directionX = -1;
            }
            if (fromY == toY) {
                directionY = 0;
            }
            if (fromX == toX) {
                directionX = 0;
            }

            System.out.println("DirectionX = " + directionX);
            System.out.println("DirectionY = " + directionY);

            int currentY = fromY;
            int currentX = fromX;

            while (currentX != toX || currentY != toY) {
                System.out.println("  Marking " + currentX + " " + currentY);
                this.grid[currentX][currentY]++;
                currentX += directionX;
                currentY += directionY;
            }

            // last one still needs marking
            System.out.println("  Marking " + currentX + " " + currentY);
            this.grid[currentX][currentY]++;
        }

        int counter = 0;
        for (int x=0; x<SIZE;x++){
            for (int y=0; y<SIZE;y++){
                if (this.grid[x][y] > 1) {
                    counter++;
                }
            }
        }
        return counter;
    }
}
