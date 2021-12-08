package aoc2021.day8;

import java.util.Arrays;

public class NumberList {
    private String digit1;
    private String digit3;
    private String digit4;
    private String digit6;
    private String digit7;
    private String digit8;

    public void addExampleSimple(String s) {
        String sortedString = this.sort(s);

        switch (sortedString.length()) {
            case 2: // 1
                this.digit1 = sortedString;
                break;
            case 3: // 7
                this.digit7 = sortedString;
                break;
            case 4: // 4
                this.digit4 = sortedString;
                break;
            case 7: // 8
                this.digit8 = sortedString;
                break;
        }
    }

    public void addExampleComplex(String s) {
        String sortedString = this.sort(s);

        boolean includesFirstOneSegment = sortedString.indexOf(this.digit1.charAt(0)) > -1;
        boolean includesSecondOneSegment = sortedString.indexOf(this.digit1.charAt(1)) > -1;


        switch (sortedString.length()) {
            case 5: // 2, 3, 5

                if (includesFirstOneSegment && includesSecondOneSegment) {
                    this.digit3 = sortedString ; // it's a three - it includes both the 1 segments
                }

                break;
            case 6: // 0, 6, 9
                if (!(includesFirstOneSegment && includesSecondOneSegment)) {
                    this.digit6 = sortedString; // it's a six - it doesn't include both the 1 segments
                }
                break;
        }
    }


    public int whatIs(String s) {
        String sortedString = this.sort(s);

        if (sortedString.equals(this.digit1)) {
            return 1;
        }
        else if (sortedString.equals(this.digit4)) {
            return 4;
        }
        else if (sortedString.equals(this.digit7)) {
            return 7;
        }
        else if (sortedString.equals(this.digit8)) {
            return 8;
        }
        else if (sortedString.equals(this.digit6)) {
            return 6;
        }
        else if (sortedString.equals(this.digit3)) {
            return 3;
        }

        if (sortedString.length() == 5) {
            // it's a 2 or 5

            int matchesToSixCount = 0;
            if (digit6.indexOf(sortedString.charAt(0)) > -1) matchesToSixCount++;
            if (digit6.indexOf(sortedString.charAt(1)) > -1) matchesToSixCount++;
            if (digit6.indexOf(sortedString.charAt(2)) > -1) matchesToSixCount++;
            if (digit6.indexOf(sortedString.charAt(3)) > -1) matchesToSixCount++;
            if (digit6.indexOf(sortedString.charAt(4)) > -1) matchesToSixCount++;

            if (matchesToSixCount == 5) {
                return 5; // 5 is a subset of 6
            }
            return 2;
        }

        if (sortedString.length() == 6) {
            // it's a 0 or 9

            int matchesToFourCount = 0;
            if (sortedString.indexOf(this.digit4.charAt(0)) > -1) matchesToFourCount++;
            if (sortedString.indexOf(this.digit4.charAt(1)) > -1) matchesToFourCount++;
            if (sortedString.indexOf(this.digit4.charAt(2)) > -1) matchesToFourCount++;
            if (sortedString.indexOf(this.digit4.charAt(3)) > -1) matchesToFourCount++;

            if (matchesToFourCount == 4) {
                return 9; // it's a nine - it includes all of a 4
            }

            return 0;
        }

        throw new UnsupportedOperationException();
    }

    private String sort(String s){
        char charArray[] = s.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }


}

