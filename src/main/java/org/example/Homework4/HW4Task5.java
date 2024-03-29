package org.example.Homework4;

import org.example.Task;

import java.util.Scanner;

public class HW4Task5 implements Task {
    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);

        long n = scanner.nextLong();

        long upValue = 3;

        long x = 2;
        long y = 2;

        int index = 1;

        while (index < n) {
            index += upValue;
            index += 1;


        }


    }
}
