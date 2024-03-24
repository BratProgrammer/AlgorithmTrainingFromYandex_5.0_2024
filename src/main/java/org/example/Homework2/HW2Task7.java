package org.example.Homework2;

import org.example.Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class HW2Task7 implements Task {
    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        ArrayList<Integer> inputArray = new ArrayList<  >();
        ArrayList<String> answers = new ArrayList<>();

        int n = 0;

        for (int i = 0; i < t; i++) {
            n = scanner.nextInt();
            for (int j = 0; j < n; j++) {
                inputArray.add(scanner.nextInt());
            }

            int countOfArrays = 0;
            int length = 0;
            int startIndex = 0;
            int index = 0;

            while (index < inputArray.size()) {
                if (length == 0) {
                    startIndex = index;
                    length += 1;
                } else {

                }
            }


        }




        answers.forEach(System.out::println);

    }
}
