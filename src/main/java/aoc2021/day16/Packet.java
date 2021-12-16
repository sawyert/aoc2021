package aoc2021.day16;

import java.util.ArrayList;
import java.util.List;

public class Packet {
    private final String binarySource;
    private int pointer = 0;

    private int version = 0;
    private int packetTypeId = 0;
    private List<Packet> subPackets = new ArrayList<>();
    private long data;

    public Packet(String source) {
        this.binarySource = source;

        this.readPacketVersion();
        this.readPacketTypeId();

        switch (this.packetTypeId) {
            case 4:
                this.readLiteralValues();
                break;
            default:
                this.readOperatorPacket();
                break;
        }
    }

    public long getData() {
        switch (this.packetTypeId) {
            case 0:
                return this.sumSubPackets();
            case 1:
                return this.multiplySubPackets();
            case 2:
                return this.minValueSubPackets();
            case 3:
                return this.maxValueSubPackets();
            case 4:
                return this.data;
            case 5:
                return this.firstGreaterThanSecond();
            case 6:
                return this.firstLessThanSecond();
            case 7:
                return this.firstEqualsSecond();
            default:
                throw new UnsupportedOperationException();
        }
    }

    private long firstEqualsSecond() {
        Packet sub1 = this.subPackets.get(0);
        Packet sub2 = this.subPackets.get(1);

        long data1 = sub1.getData();
        long data2 = sub2.getData();

        if (data1 == data2) {
            return 1L;
        }
        return 0L;
    }

    private long firstLessThanSecond() {
        Packet sub1 = this.subPackets.get(0);
        Packet sub2 = this.subPackets.get(1);

        if (sub1.getData() < sub2.getData()) {
            return 1L;
        }
        return 0L;
    }

    private long firstGreaterThanSecond() {
        Packet sub1 = this.subPackets.get(0);
        Packet sub2 = this.subPackets.get(1);

        if (sub1.getData() > sub2.getData()) {
            return 1L;
        }
        return 0L;
    }

    private long maxValueSubPackets() {
        long returnValue = 0L;
        for (Packet subPacket: this.subPackets) {
            if (subPacket.getData() > returnValue) {
                returnValue = subPacket.getData();
            }
        }
        return returnValue;
    }

    private long minValueSubPackets() {
        long returnValue = Long.MAX_VALUE;
        for (Packet subPacket: this.subPackets) {
            if (subPacket.getData() < returnValue) {
                returnValue = subPacket.getData();
            }
        }
        return returnValue;
    }

    private long multiplySubPackets() {
        long returnValue = 1L;
        for (Packet subPacket: this.subPackets) {
            returnValue *= subPacket.getData();
        }
        return returnValue;
    }

    private long sumSubPackets() {
        long returnValue = 0L;
        for (Packet subPacket: this.subPackets) {
            returnValue += subPacket.getData();
        }
        return returnValue;
    }

    public int getPointer() {
        return this.pointer;
    }

    private String readSource(int length) {
        StringBuffer returnValue = new StringBuffer();
        for (int i=0; i<length; i++) {
            returnValue.append(binarySource.substring(this.pointer, this.pointer+1));
            this.pointer++;
        }
        return returnValue.toString();
    }

    private void readPacketVersion() {
        String binary = this.readSource(3);
        this.version = Integer.parseInt(binary, 2);
    }

    private void readPacketTypeId() {
        String binary = this.readSource(3);
        this.packetTypeId = Integer.parseInt(binary, 2);
    }

    private void readLiteralValues() {
        String binary = this.readSource(5);
        StringBuffer binaryNumber = new StringBuffer();
        while (binary.startsWith("1")) {
            binaryNumber.append(binary.substring(1));
            binary = this.readSource(5);
        }
        
        // didn't start with 1, so last value
        binaryNumber.append(binary.substring(1));

        this.data = Long.parseLong(binaryNumber.toString(), 2);
    }

    private void readOperatorPacket() {
        String lengthTypeBit = this.readSource(1);
        switch(lengthTypeBit) {
            case "0":
                this.readTotalLength15();
                break;
            case "1":
                this.readCount11();
                break;
        }
    }

    private void readTotalLength15() {
        String subPacketsLengthBinary = this.readSource(15);
        int subPacketsLength = Integer.parseInt(subPacketsLengthBinary, 2);
        int finishPointerPosition = this.pointer + subPacketsLength;
        while (this.pointer < finishPointerPosition) {
            this.readSubPacket();
        }
    }

    private void readCount11() {
        String countOfSubPacketsBinary = this.readSource(11);
        int subPacketCount =  Integer.parseInt(countOfSubPacketsBinary, 2);

        while (subPacketCount > 0) {
            this.readSubPacket();
            subPacketCount--;
        }
    }

    private void readSubPacket() {
        String restOfString = this.binarySource.substring(this.pointer);
        Packet packet = new Packet(restOfString);
        this.subPackets.add(packet);
        this.pointer += packet.getPointer();
    }

    public long getSumOfVersions() {
        long versionSum = this.version;

        for (Packet packet: this.subPackets) {
            versionSum += packet.getSumOfVersions();
        }
        
        return versionSum;
    }
}
