package org.example.Homework1;

import org.example.Task;

import java.util.Scanner;

public class HW1Task8 implements Task {

    static double L;

    private static double getDistanceFromStart(double x) {
        return Math.min(x % L, L / 2 - (x - L / 2));
    }

    private static void printResult(double result) {
        System.out.println("Yes");
        System.out.println(result);
    }

    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
        String[] inputValues = scanner.nextLine().split(" ");

        L = Integer.parseInt(inputValues[0]);
        double x1 = Integer.parseInt(inputValues[1]);
        double v1 = Integer.parseInt(inputValues[2]);
        double x2 = Integer.parseInt(inputValues[3]);
        double v2 = Integer.parseInt(inputValues[4]);

        if (x1 != x2) {
            if (v1 != v2) {



            } else {
                System.out.println("NO");
            }
        } else {
            printResult(0);
        }




    }
}
