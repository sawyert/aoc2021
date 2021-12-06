package aoc2021.day6;

public class Fish {
    private int age;

    public Fish(int age){
        this.age = age;
    }

    public void timePasses() {
        this.age--;
    }

    public boolean isZero() {
        return this.age == 0;
    }

    public void resetTo7() {
        this.age = 7;
    }
}
