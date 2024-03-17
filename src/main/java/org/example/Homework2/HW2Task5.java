package org.example.Homework2;

import org.example.Task;

import java.util.HashMap;
import java.util.Scanner;

public class HW2Task5 implements Task {
    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        HashMap<Integer, Integer> berriesProfit = new HashMap<>();
        HashMap<Integer, int[]> berries = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String[] inputValues = scanner.nextLine().split(" ");

            int profit = Integer.parseInt(inputValues[0]) - Integer.parseInt(inputValues[0]);

        }
    }
}
