package aoc2021.day10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day10 {
    private String[] input;

    public Day10(String[] testInput) {
        this.input = testInput;
    }

    public long execute1() {
        long score = 0;
        for (String s: this.input) {
            try {
                this.parseLine(s);
            }
            catch (WrongTrousersException ex) {
                score += ex.getScore();
            }
        }
        return score;
    }

    public void parseLine(String line) throws WrongTrousersException {
        Node prevNode = null;
        for (int i=0; i<line.length(); i++) {
            char charAt = line.charAt(i);
            switch (charAt){
                case '(':
                case '[':
                case '{':
                case '<':
                    Node node = new Node(charAt);
                    if (prevNode == null) {
                        prevNode = node;
                    } else {
                        prevNode.addChild(node);
                        prevNode = node;
                    }
                    break;
                case ')':
                case ']':
                case '}':
                case '>':
                    if (prevNode == null) {
                        throw new UnsupportedOperationException("prevnode null");
                    }
                    prevNode = prevNode.unwind(charAt);
                    break;
            }
        }
    }

    public long parseLinePart2(String line) throws WrongTrousersException {
        Node prevNode = null;
        for (int i=0; i<line.length(); i++) {
            char charAt = line.charAt(i);
            switch (charAt){
                case '(':
                case '[':
                case '{':
                case '<':
                    Node node = new Node(charAt);
                    if (prevNode == null) {
                        prevNode = node;
                    } else {
                        prevNode.addChild(node);
                        prevNode = node;
                    }
                    break;
                case ')':
                case ']':
                case '}':
                case '>':
                    if (prevNode == null) {
                        throw new UnsupportedOperationException("prevnode null");
                    }
                    prevNode = prevNode.unwind(charAt);
                    break;
            }
        }

        // we've run out of characters, generate the completeness chars
        System.out.println(line);
        String completeString = prevNode.completeString();
        System.out.println(completeString);
        System.out.println((line + completeString).length());

        long score=0;
        for (int i=0; i<completeString.length();i++){
            char c = completeString.charAt(i);
            score = score * 5;
            switch (c) {
                case ')':
                    score += 1;
                    break;
                case ']':
                    score += 2;
                    break;
                case '}':
                    score += 3;
                    break;
                case '>':
                    score += 4;
                    break;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        return score;
    }

   public long execute2() {
       List<Long> scores = new ArrayList<>();
       for (String s: this.input) {
           try {
               long score = this.parseLinePart2(s);
               System.out.println(score);
               scores.add(score);
           }
           catch (WrongTrousersException ex) {
               continue;
           }
       }

       Collections.sort(scores);

       return scores.get(scores.size() / 2);
    }
}
