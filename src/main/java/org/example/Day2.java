package org.example;

import java.io.BufferedReader;
import java.io.FileReader;

public class Day2 {
    public static void main(String[] args) {
        long count1 = 0, count2 = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/day2/input.txt"))) {
            String input;
            while ((input = br.readLine()) != null) {
                String[] parts = input.split(",");
                for(String line : parts) {
                    long start = Long.parseLong(line.split("-")[0]);
                    long end = Long.parseLong(line.split("-")[1]);
                    for (long i = start; i <= end; i++) {
                        String curr = String.valueOf(i);
                        for(int j=0; j<=curr.length()/2; j++){
                            String regex = "("+curr.substring(0,j)+")+";
                            if(curr.matches(regex)) {count2+=i; break;}
                        }
                        if (curr.length() % 2 == 0) {
                            if (curr.substring(0, curr.length() / 2).equals(curr.substring(curr.length() / 2)))
                                count1+=i;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Part 1: " + count1);
        System.out.println("Part 2: " + count2);
    }

}
