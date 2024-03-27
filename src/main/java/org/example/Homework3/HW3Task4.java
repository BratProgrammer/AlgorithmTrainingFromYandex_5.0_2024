package org.example.Homework3;

import org.example.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class HW3Task4 implements Task {
    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);

        String[] firstLine = scanner.nextLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int k = Integer.parseInt(firstLine[1]);

        String[] numbers = scanner.nextLine().split(" ");
        boolean result = false;

        HashMap<Integer, Integer> numbersAndIndexes = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++) {
            int newNumber = Integer.parseInt(numbers[i]);

            if (numbersAndIndexes.containsKey(newNumber)) {
                if (i - numbersAndIndexes.get(newNumber) <= k) {
                    result = true;
                    break;
                }
            }
            numbersAndIndexes.put(newNumber, i);
        }

        if (result) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
