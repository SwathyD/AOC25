package org.example;

import java.io.BufferedReader;
import java.io.FileReader;

public class Day1 {
    public static void main(String[] args) {
        int count1 = 0, count2 = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/day1/input.txt"))) {
            String line;
            int dial = 50;
            int prev = 50;
            while ((line = br.readLine()) != null) {
                char dir = line.charAt(0);
                int value = Integer.parseInt(line.substring(1));
                if (dir == 'L') {
                    dial -= value;
                    if (dial == 0) count2++;
                    else if (dial < 0) {
                        count2 += Math.abs(dial / 100);
                        if (prev != 0) count2++;
                    }
                } else {
                    dial += value;
                    count2 += dial / 100;
                }
                dial = Math.floorMod(dial, 100);
                prev = dial;

                if (dial == 0) count1++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Part 1: " + count1);
        System.out.println("Part 2: " + count2);
    }
}
