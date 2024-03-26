package org.example.Homework3;

import org.example.Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class HW3Task3 implements Task {
    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] countOfNumbersArray = new int[100001];

        String[] numbersStr = scanner.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            int index = Integer.parseInt(numbersStr[i]);
            countOfNumbersArray[index] = countOfNumbersArray[index] + 1;
        }

        int minCountToRemove = 100001;

        for (int i = 0; i < 100000; i++) {
            minCountToRemove = Math.min(minCountToRemove, n - (countOfNumbersArray[i] + countOfNumbersArray[i + 1]));
        }

        System.out.println(minCountToRemove);

    }
}
