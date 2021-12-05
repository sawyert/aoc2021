package aoc2021.day4;

public class Cell {
    private int number = 0;
    private boolean called = false;

    public Cell(String s) {
        this.number = Integer.parseInt(s);
    }

    public void markNumber(String numberCalled) {
        if (Integer.parseInt(numberCalled) == this.number){
            this.called = true;
        }
    }

    public boolean isCalled() {
        return this.called;
    }

    public int getNumber() {
        return this.number;
    }
}
