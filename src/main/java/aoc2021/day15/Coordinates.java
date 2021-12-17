package aoc2021.day15;

public class Coordinates {
    public int x;
    public int y;

    public Coordinates(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void printPosition() {
        System.out.println("   " + this.x + "," + this.y);
    }

    public boolean equals(Coordinates other) {
        if (other.x == this.x && other.y == this.y) {
            return true;
        }
        return false;
    }
}
