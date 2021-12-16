package aoc2021.day16;

public class Day16 {
    private String program;
    private StringBuffer binaryMessage = new StringBuffer();

    public Day16(String testInput) {
        this.program = testInput;

        for (int i=0; i<this.program.length(); i++) {
            int hexToInt = Integer.parseInt(Character.toString(this.program.charAt(i)), 16);
            String binary = (String.format("%04d", Integer.parseInt(Integer.toBinaryString(hexToInt))));
            binaryMessage.append(binary);
        }
    }

    public long execute1() {
        Packet packet = new Packet(binaryMessage.toString());

        return packet.getSumOfVersions();
    }

    public long execute2() {
        Packet packet = new Packet(binaryMessage.toString());

        return packet.getData();
    }
}
