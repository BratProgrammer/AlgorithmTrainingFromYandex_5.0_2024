package org.example;

import org.example.Homework2.HM2Task2;
import org.example.Homework2.HW2Task1;
import org.example.Homework2.HW2Task3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        String[] inputValues = scanner.nextLine().split(" ");

        int maxLength = 0;
        int sumLength = 0;

        for (int i = 0; i < n; i++) {
            int length = Integer.parseInt(inputValues[i]);
            sumLength += length;
            maxLength = Math.max(length, maxLength);
        }

        if (sumLength - maxLength >= maxLength) {
            System.out.println(sumLength);
        } else {
            System.out.println(maxLength - (sumLength - maxLength));
        }
    }
}