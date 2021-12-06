package aoc2021.day6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day6 {
    private String[] input;

    public Day6(String[] testInput) {
        this.input = testInput;
    }

    public long execute1() {
        return this.execute(80);
    }

    public long execute2() {
        return this.execute(256);
    }

    public long executeSimple(int daysToRunFor) {
       List<Fish> fishList = new ArrayList<>();

       String[] fishAges = this.input[0].split(",");
        for (String s : fishAges) {
            fishList.add(new Fish(Integer.parseInt(s)));
        }

        int day = 0;
        while (day < daysToRunFor) {

            int fishToAdd = 0;
            for (Fish fish : fishList) {
                if (fish.isZero()) {
                    fishToAdd++;
                    fish.resetTo7();
                }

                fish.timePasses();
            }

            for (int i=0; i<fishToAdd; i++) {
                fishList.add(new Fish(8));
            }

            day++;
        }

        return fishList.size();
    }

    public long executeWithCounts(Map<Integer,Long> fishCounts, int daysToRunFor) {
        int day = 0;
        while (day < daysToRunFor) {

            Long fishToAdd = fishCounts.getOrDefault(0, 0L);
            if (fishToAdd == null) {
                fishToAdd = 0L;
            }

            Map<Integer,Long> newMap = new HashMap<>();
            newMap.put(0, fishCounts.get(1));
            newMap.put(1, fishCounts.get(2));
            newMap.put(2, fishCounts.get(3));
            newMap.put(3, fishCounts.get(4));
            newMap.put(4, fishCounts.get(5));
            newMap.put(5, fishCounts.get(6));
            Long old7 = fishCounts.getOrDefault(7, 0L);
            if (old7 == null) {
                old7 = 0L;
            }
            newMap.put(6, old7 + fishToAdd);
            newMap.put(7, fishCounts.get(8));
            newMap.put(8, fishToAdd);

            fishCounts = newMap;

            day++;
        }

        long totalFish = fishCounts.get(0) + fishCounts.get(1) + fishCounts.get(2) + fishCounts.get(3) + fishCounts.get(4) + fishCounts.get(5) + fishCounts.get(6) + fishCounts.get(7) + fishCounts.get(8);
        return totalFish;
    }

    public long execute(int daysToRunFor) {
        Map<Integer, Long> fishCounts = new HashMap<>();

        String[] fishAges = this.input[0].split(",");
        for (String s : fishAges) {
            int initialFishAge = Integer.parseInt(s);

            Long existingValue = fishCounts.get(initialFishAge);
            if (existingValue == null) {
                existingValue = 0L;
            }
            existingValue += 1;
            fishCounts.put(initialFishAge, existingValue);
        }

        long fishCount = this.executeWithCounts(fishCounts, daysToRunFor);

        return fishCount;
    }

}
