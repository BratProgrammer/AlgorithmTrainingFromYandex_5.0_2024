package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        ArrayList<Integer> inputArray = new ArrayList<  >();
        ArrayList<String> answers = new ArrayList<>();

        int n;

        for (int i = 0; i < t; i++) {
            n = scanner.nextInt();
            for (int j = 0; j < n; j++) {
                inputArray.add(scanner.nextInt());
            }

            Collections.sort(inputArray);

            String lengthsOfSmallArraysStr = "";
            int countOfNewArrays = 0;
            int numberOfRawElements = inputArray.size();
            int index = 0;

            do {
                int item = inputArray.get(index);
                countOfNewArrays += 1;
                if (item <= numberOfRawElements) {
                    lengthsOfSmallArraysStr += " " + item;
                    numberOfRawElements -= item;
                    index += item;
                } else {
                    lengthsOfSmallArraysStr += " " + numberOfRawElements;
                    numberOfRawElements = 0;
                }
            } while (numberOfRawElements != 0);

            answers.add(Integer.toString(countOfNewArrays));
            answers.add(lengthsOfSmallArraysStr.trim());
            inputArray.clear();
        }

        answers.forEach(System.out::println);
    }
}