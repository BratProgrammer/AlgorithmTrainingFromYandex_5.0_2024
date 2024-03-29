package org.example.Homework4;

import org.example.Task;

import java.util.*;

public class HW4Task1 implements Task {
    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] numbers = new int[n];
        String[] numbersStr = scanner.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(numbersStr[i]);
        }

        int k = Integer.parseInt(scanner.nextLine());
        ArrayList<Integer> valuesL = new ArrayList<>();
        ArrayList<Integer> valuesR = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            String[] inputLAndR = scanner.nextLine().split(" ");
            valuesL.add(Integer.parseInt(inputLAndR[0]));
            valuesR.add(Integer.parseInt(inputLAndR[1]));
        }

        System.out.println("Done");

    }
}
