package com.mdsujan.floatOps;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FloatOps {
    public static void main(String[] args) {
//        "Program to perform float ops with emphasis on the precision part.
//        Explore BigDecimal API
//        Ex:
//        1. Find the avg of a given list of integers round off to 2 decimal points"
        // list of integers
//        List<Integer> integers = createIntegersList();
        int[] integers = new int[]{11,12,11,10,13,15,10};
        System.out.println("Calculating the average of the integers\n round off to 2 decimal places...");
        int sum = 0;
        for (Integer number : integers) {
            sum += number;
        }
        System.out.println("sum : " + sum);
//        double avg = (double) sum/(double) integers.size();
        float avg = (float) sum / (float) integers.length;

        // rounding to 2 decimal places using BigDecimal
        // 1. convert value to a big decimal
        BigDecimal avgBigDecimal = new BigDecimal(avg);
        // 2. round the avg as per precision
        int precision = 2;
        BigDecimal roundedAvg = avgBigDecimal.setScale(precision, RoundingMode.HALF_UP);
        System.out.println("Rounded Average: " + roundedAvg);
//        System.out.println("Unrounded Average: " + avg);
    }

    private static List<Integer> createIntegersList() {
        List<Integer> integers = new ArrayList<>();
        System.out.println("How many integers you want to add to the list?");
        Scanner sc = new Scanner(System.in);
        int nums = sc.nextInt();
        System.out.println("Enter the integers to store one bye one");
        for (int i = 0; i < nums; i++) {
            integers.add(sc.nextInt());
        }
        return integers;
    }
}
