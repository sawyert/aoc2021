package aoc2021.day14;

import java.util.*;

public class RuleList {
    private List<Rule> rules = new ArrayList<>();

    public void addRule(String ruleString) {
        Rule rule = new Rule(ruleString);
        this.rules.add(rule);
    }

    public List<Pair> apply(List<Pair> pairs) {
        List<Pair> newPairs = new ArrayList<>();

        for (Pair pair : pairs) {
            Rule rule = this.findRule(pair);
            if (rule != null){
                this.put(newPairs, rule.getOutput1(), pair.getCount());
                this.put(newPairs, rule.getOutput2(), pair.getCount());
            } else  {
                this.put(newPairs, pair, pair.getCount());
            }
        }

        return newPairs;
    }

    private void put(List<Pair> pairs, Pair pair, Long value) {
        Long existingValue = pair.getCount();
        if (existingValue == null) {
            Optional<Pair> existingPair = pairs.stream().filter(p->p.getChars().equals(pair.getChars())).findFirst();
            if (existingPair.isPresent()) {
                existingPair.get().incrementBy(value);
            } else {
                pairs.add(new Pair(pair.getChars(), value));
            }
        } else {
            Optional<Pair> existingPair = pairs.stream().filter(p->p.getChars().equals(pair.getChars())).findFirst();
            if (existingPair.isPresent()) {
                existingPair.get().incrementBy(existingValue + value);
            } else {
                pairs.add(new Pair(pair.getChars(), existingValue + value));
            }
        }
    }

    private Rule findRule(Pair pair) {
        for (Rule rule : this.rules) {
            if (rule.getRulePair().equals(pair.getChars())) {
                return rule;
            }
        }
        return null;
    }
}
