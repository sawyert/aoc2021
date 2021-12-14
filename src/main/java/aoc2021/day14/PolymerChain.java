package aoc2021.day14;

import java.util.*;

public class PolymerChain {

    private List<Pair> pairs = new ArrayList<>();
    private Map<String, Long> counts = new HashMap<>();
    private long mostCommonElementCount;
    private long leastCommonElementCount;
    private String mostCommonElement;
    private String leastCommonElement;

    public PolymerChain(String startPoint) {
        for (int i=0; i<startPoint.length()-1; i++) {
            String pair = "" + startPoint.charAt(i) + startPoint.charAt(i+1);
            this.pairs.add(new Pair(pair, 1L));
        }
    }

    public void pairInsert(List<String> rules) {
        RuleList rulesList = new RuleList();
        for (String rule: rules) {
            rulesList.addRule(rule);
        }

        this.pairs = rulesList.apply(this.pairs);
    }

    public long length() {
        Long returnValue = 0L;
        for (Pair pair : this.pairs) {
            Long pairCount = pair.getCount();
            returnValue += (pairCount * 2);
        }
        returnValue += 1;
        return returnValue;
    }

    public void countElements(String firstChar) {
        this.counts = new HashMap<>();
        this.recordCount(firstChar, 1);
        for (Pair pair: this.pairs) {
            String char2 = "" + pair.secondChar();
            this.recordCount(char2, pair.getCount());
        }

        this.mostCommonElement = "";
        this.leastCommonElement = "";
        this.mostCommonElementCount = 0;
        this.leastCommonElementCount = Long.MAX_VALUE;

        for (Map.Entry<String,Long> eachCount: this.counts.entrySet()) {
            if (eachCount.getValue() > this.mostCommonElementCount){
                this.mostCommonElementCount = eachCount.getValue();
                this.mostCommonElement = eachCount.getKey();
            }

            if (eachCount.getValue() < this.leastCommonElementCount){
                this.leastCommonElementCount = eachCount.getValue();
                this.leastCommonElement = eachCount.getKey();
            }
        }

        System.out.println("Most Common = " + this.mostCommonElement + " at " + this.mostCommonElementCount);
        System.out.println("Least Common = " + this.leastCommonElement + " at " + this.leastCommonElementCount);
    }

    private void recordCount(String char1, long charCount) {
        Long count = this.counts.get(char1);
        if (count == null) {
            this.counts.put(char1, charCount);
        } else {
            this.counts.put(char1, count + charCount);
        }
    }

    public long getMostCommonElementCount() {
        return this.mostCommonElementCount;
    }

    public long getLeastCommonElementCount() {
        return this.leastCommonElementCount;
    }
}
