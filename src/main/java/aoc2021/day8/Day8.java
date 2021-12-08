package aoc2021.day8;

public class Day8 {
    private String[] input;

    public Day8(String[] testInput) {
        this.input = testInput;
    }

    public long execute1() {

        int counter = 0;
        for (String s: this.input) {
            String[] strings = s.split("\\|");
            String output = strings[1].trim();
            String[] outputs = output.split("\s+");

            for (String eachOutput: outputs) {
                switch (eachOutput.length()) {
                    case 2: // 1
                    case 3: // 7
                    case 4: // 4
                    case 7: // 8
                        counter++;
                        break;
                }
            }

        }

        return counter;
    }

    public long execute2() {
        long total = 0;
        for (String s: this.input) {
            String[] strings = s.split("\\|");
            String example = strings[0].trim();
            String output = strings[1].trim();
            String[] outputs = output.split("\s+");
            String[] examples = example.split("\s+");

            NumberList numberList = new NumberList();
            for (String ex : examples) {
                // just do simple to work out values
                numberList.addExampleSimple(ex);
            }

            // go through again and do other complex values we can now infer
            for (String ex : examples) {
                numberList.addExampleComplex(ex);
            }

            String digits = "";
            for (String out : outputs) {
                System.out.print(out);
                System.out.print(" ");
                digits += numberList.whatIs(out);
            }
            System.out.print(": ");
            System.out.println(digits);
            total += Integer.parseInt(digits);
        }

        return total;
    }
}
