package aoc2021.day2;

public class Sub {

    private long horizontal = 0;
    private long depth = 0;
    private long aim = 0;

    public void move1(String command) {
        String[] split = command.split(" ");
        String direction = split[0];
        int distance = Integer.parseInt(split[1]);

        switch (direction) {
            case "forward":
                this.horizontal += distance;
                break;
            case "up" :
                this.depth -= distance;
                break;
            case "down":
                this.depth += distance;
                break;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public void move2(String command) {
        String[] split = command.split(" ");
        String direction = split[0];
        int distance = Integer.parseInt(split[1]);

        switch (direction) {
            case "forward":
                this.horizontal += distance;
                this.depth += this.aim * distance;
                break;
            case "up" :
                this.aim -= distance;
                break;
            case "down":
                this.aim += distance;
                break;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public long getHorizontal() {
        return this.horizontal;
    }

    public long getDepth() {
        return this.depth;
    }
}
