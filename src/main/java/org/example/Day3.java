package org.example;

import java.io.BufferedReader;
import java.io.FileReader;

public class Day3 {
    public static void main(String[] args) {
        long result1 = 0, result2 = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/day3/input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                result1 += maxJoltageForLine(line, 2);
                result2 += maxJoltageForLine(line, 12);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Part 1: " + result1);
        System.out.println("Part 2: " + result2);
    }

    static long maxJoltageForLine(String s, int k) {
        int remove = s.length() - k;
        StringBuilder stack = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (remove > 0 &&
                    stack.length() > 0 &&
                    stack.charAt(stack.length() - 1) < c) {
                stack.deleteCharAt(stack.length() - 1);
                remove--;
            }
            stack.append(c);
        }

        // If removals remain, trim from the end
        stack.setLength(k);

        return Long.parseLong(stack.toString());
    }

}