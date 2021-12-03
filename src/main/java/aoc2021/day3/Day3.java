package aoc2021.day3;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day3 {
    private String[] input;
    private int lineLength = 0;

    public Day3(String[] testInput) {
        this.input = testInput;
    }

    public long execute1() {
        Map<Integer,Integer> oneCounts = new HashMap<>();
        Map<Integer,Integer> zeroCounts = new HashMap<>();


        for (String s : this.input) {
            for (int i=0; i<s.length(); i++) {
                lineLength = s.length();
                if (s.charAt(i) == '0') {
                    int existingCount = 0;
                    if (zeroCounts.get(i) != null) {
                        existingCount = zeroCounts.get(i);
                    }
                    zeroCounts.put(i, ++existingCount);
                }
                else {
                    int existingCount = 0;
                    if (oneCounts.get(i) != null) {
                        existingCount = oneCounts.get(i);
                    }
                    oneCounts.put(i, ++existingCount);
                }
            }
        }

        String gamma = "";
        String epsilon = "";
        for (int i=0; i<lineLength; i++) {
            if (zeroCounts.get(i) == null)  {
                break;
            }
            int zeroCount = zeroCounts.get(i);
            int oneCount = oneCounts.get(i);

            if (oneCount > zeroCount) {
                gamma += "1";
                epsilon += "0";
            }
            else {
                gamma += "0";
                epsilon += "1";
            }
        }

        System.out.println(gamma);
        System.out.println(epsilon);

        int gammaInt = Integer.parseInt(gamma, 2);
        int epsilonInt = Integer.parseInt(epsilon, 2);

        return gammaInt * epsilonInt;
    }

    public long execute2() {

        String oxygen = this.calculateOxygen();
        String co2 = this.calculateCo2();

        int oxygenInt = Integer.parseInt(oxygen, 2);
        int co2int = Integer.parseInt(co2, 2);

       int lifeSupportRating = oxygenInt * co2int;

       return lifeSupportRating;
    }

    private String calculateOxygen() {
        int maxLength = 0;
        List<String> values = new ArrayList<>();
        for (String s: this.input) {
            maxLength = s.length();
            values.add(s);
        }

        for (int i=0; i<maxLength; i++){
            String mostCommonAtThisPosition = this.mostCommonBit(i, values);
            values = this.filterListWith(i, mostCommonAtThisPosition, values);
            if (values.size() == 1) {
                break;
            }
        }

        return values.get(0);
    }

    private String calculateCo2() {
        int maxLength = 0;
        List<String> values = new ArrayList<>();
        for (String s: this.input) {
            maxLength = s.length();
            values.add(s);
        }

        for (int i=0; i<maxLength; i++){
            String leastCommonAtThisPosition = this.leastCommonBit(i, values);
            values = this.filterListWith(i, leastCommonAtThisPosition, values);
            if (values.size() == 1) {
                break;
            }
        }

        return values.get(0);
    }

    private List<String> filterListWith(int position, String charToFilterTo, List<String> values) {
        List<String> returnValue = new ArrayList<>();

        for (String s: values) {
            if (s.charAt(position) == charToFilterTo.toCharArray()[0]) {
                returnValue.add(s);
            }
        }

        return returnValue;
    }

    private String mostCommonBit(int position, List<String> values) {
        int oneCount = 0;
        int zeroCount = 0;
        for (String s: values) {
            char bit = s.charAt(position);
            if (bit == '0') {
                zeroCount++;
            }
            else if (bit == '1'){
                oneCount++;
            }
            else {
                throw new UnsupportedOperationException();
            }
        }

        if (oneCount >= zeroCount) {
            return "1";
        }
        return "0";
    }

    private String leastCommonBit(int position, List<String> values) {
        int oneCount = 0;
        int zeroCount = 0;
        for (String s: values) {
            char bit = s.charAt(position);
            if (bit == '0') {
                zeroCount++;
            }
            else if (bit == '1'){
                oneCount++;
            }
            else {
                throw new UnsupportedOperationException();
            }
        }

        if (zeroCount <= oneCount) {
            return "0";
        }
        return "1";
    }



}
