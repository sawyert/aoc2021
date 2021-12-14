package aoc2021.day14;

public class Pair {
    private String pair;
    private long count;

    public Pair(String pair, Long size) {
        this.pair = pair;
        this.count = size;
    }

    public long getCount() {
        return this.count;
    }

    public String firstChar() {
        return "" + this.pair.charAt(0);
    }

    public String secondChar() {
        return "" + this.pair.charAt(1);
    }

    public String getChars() {
        return this.pair;
    }

    public void incrementBy(Long value) {
        this.count += value;
    }
}
