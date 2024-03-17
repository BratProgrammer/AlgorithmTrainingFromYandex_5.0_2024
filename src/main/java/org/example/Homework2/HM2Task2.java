package org.example.Homework2;

import org.example.Task;

import java.util.Scanner;

public class HM2Task2 implements Task {
    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
        String[] firstInputLine = scanner.nextLine().split(" ");
        int n = Integer.parseInt(firstInputLine[0]);
        int k = Integer.parseInt(firstInputLine[1]);
        String[] secondInputLine = scanner.nextLine().split(" ");
        int[] prices = new int[n];

        for (int i = 0; i < n; i++) {
            prices[i] = Integer.parseInt(secondInputLine[i]);
        }

        int maxProfit = 0;

        for (int i = 0; i < n - 1; i++) {
            int purchasePrice = prices[i];
            for (int j = i + 1; j <= Math.min(i + k, n - 1); j++) {
                maxProfit = Math.max(prices[j] - purchasePrice, maxProfit);
            }
        }

        System.out.println(maxProfit);
    }
}
