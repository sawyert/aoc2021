package aoc2021.day17;

public class Day17 {
    private int minX;
    private int maxX;
    private int highestY;
    private int lowestY;

    public Day17(String testInput) {
        String toProcess = testInput.substring("target area:".length());
        String[] xyParts = toProcess.split(",");
        String xPart = xyParts[0].trim().substring(2).trim();
        String yPart = xyParts[1].trim().substring(2).trim();

        String[] xParts = xPart.split("\\.\\.");
        String[] yParts = yPart.split("\\.\\.");

        this.minX = Integer.parseInt(xParts[0]);
        this.maxX = Integer.parseInt(xParts[1]);

        this.lowestY = Integer.parseInt(yParts[0]);
        this.highestY = Integer.parseInt(yParts[1]);

        System.out.println("target X ranges from min " + this.minX + " to " + this.maxX);
        System.out.println("target Y ranges from min " + this.highestY + " to " + this.lowestY);
    }

    public long execute1() {
        Coordinates startPosition = new Coordinates(0, 0);
        int maxHeight = 0;

        int maxHeightOfExample = this.calculatePositions(startPosition, 7, 2);
        System.out.println(maxHeightOfExample);

        for (int velocityX=1;velocityX<1000;velocityX++) {
            for (int velocityY=1;velocityY<1000;velocityY++) {
                int maxHeightOfThis = this.calculatePositions(startPosition, velocityX, velocityY);
                if (maxHeightOfThis > maxHeight) {
                    maxHeight = maxHeightOfThis;
                }
            }
        }

        return maxHeight;
    }

    public long execute2() {
        Coordinates startPosition = new Coordinates(0, 0);
        long validTargetCount = 0;

        int maxHeightOfExample = this.calculatePositions(startPosition, 7, 2);
        System.out.println(maxHeightOfExample);

        for (int velocityX=1;velocityX<1000;velocityX++) {
            for (int velocityY=-1000;velocityY<1000;velocityY++) {
                int maxHeightOfThis = this.calculatePositions(startPosition, velocityX, velocityY);
                if (maxHeightOfThis > -9000) {
                    validTargetCount++;
                }
            }
        }

        return validTargetCount;
    }

    private int calculatePositions(Coordinates startPosition, int velocityX, int velocityY) {
        //System.out.println("Calculating positions for velocity " + velocityX + ", " + velocityY);
        int maxHeight = 0;
        Coordinates next = startPosition;
        int velx = velocityX;
        int vely = velocityY;
        int counter = 0;
        while(counter < 1000) {
            counter++;

            next = this.calculateNextPosition(next, velx, vely);
            // next.printPosition();

            if (next.y > maxHeight) {
                maxHeight = next.y;
            }

            if (this.inTarget(next)) {
                //System.out.println("+++ In Target!");
                return maxHeight;
            }
            if (this.exceedsTarget(next)) {
                //System.out.println("+++ Missed Target!");
                return -9999;
            }

            if (velx > 0) {
                velx -=1;
            } else if (velx < 0) {
                velx += 1;
            }

            vely--;
        }

        return -9998;
    }

    private boolean exceedsTarget(Coordinates position) {
        boolean exceedsTarget = position.x < this.maxX && position.y < this.lowestY;

        if (false) {
            if (position.x < this.maxX) {
                System.out.println("- x [" + position.x + "] less than [" + this.maxX + "]");
            }

            if (position.y < this.lowestY) {
                System.out.println("- y [" + position.y + "] less than [" + this.lowestY + "]");
            }
        }
        return exceedsTarget;
    }

    private boolean inTarget(Coordinates position) {
        return position.x >= this.minX
                && position.y <= this.highestY
                && position.x <= this.maxX
                && position.y >= this.lowestY;
    }

    private Coordinates calculateNextPosition(Coordinates current, int velx, int vely) {
        int newX = current.x + velx;
        int newY = current.y + vely;
        return new Coordinates(newX, newY);
    }
}
