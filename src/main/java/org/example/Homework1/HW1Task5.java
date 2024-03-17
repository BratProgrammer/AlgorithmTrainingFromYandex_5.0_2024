package org.example.Homework1;
import org.example.Task;

import java.util.Scanner;


public class HW1Task5 implements Task {

    public void start() {
        Scanner scanner = new Scanner(System.in);

        String[] inputString = scanner.nextLine().split(" ");



        long n = Integer.parseInt(inputString[0]);
        long k = Integer.parseInt(inputString[1]);
        int d = Integer.parseInt(inputString[2]);
        boolean isItPossible = false;

        for (int i = 0; i < 10; i++) {
            if ((n * 10 + i) % k == 0) {
                n = n * 10 + i;
                isItPossible = true;
                break;
            }
        }

        if (isItPossible) {
            System.out.println(Long.toString(n) + "0".repeat(Math.max(0, (d - 1))));
        } else {
            System.out.println(-1);
        }
    }

}
