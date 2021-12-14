package aoc2021.day14;

public class Rule {
    private final String rulePair;
    private final String newPairOne;
    private final String newPairTwo;

    public Rule(String ruleString) {
        String[] ruleParts = ruleString.split("->");
        this.rulePair = ruleParts[0].trim();
        String insertChar = ruleParts[1].trim();
        this.newPairOne = this.rulePair.charAt(0) + insertChar;
        this.newPairTwo = insertChar + this.rulePair.charAt(1);
    }

    public Object getRulePair() {
        return this.rulePair;
    }

    public Pair getOutput1() {
        return new Pair(this.newPairOne, 0L);
    }

    public Pair getOutput2() {
        return new Pair(this.newPairTwo, 0L);
    }
}
