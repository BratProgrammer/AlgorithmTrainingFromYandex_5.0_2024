package org.example;

import org.example.Homework2.HW2Task4;
import org.example.Homework2.HW2Task5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        ArrayList<Integer> indexesOfPositiveValueBerries = new ArrayList<Integer>();
        ArrayList<Integer> indexesOfZeroValueBerries = new ArrayList<Integer>();
        ArrayList<Integer> indexesOfNegativeValueBerries = new ArrayList<Integer>();
        ArrayList<Integer> profitsOfBerries = new ArrayList<Integer>();
        ArrayList<Integer> upValues = new ArrayList<Integer>();

        long height = 0;
        int indexOfEndProfitBerrie = 0;

        StringBuilder indexes = new StringBuilder();


        for (int i = 0; i < n; i++) {
            String[] inputValues = scanner.nextLine().split(" ");

            int upValue = Integer.parseInt(inputValues[0]);
            int downValue = Integer.parseInt(inputValues[1]);

            if (upValue > downValue) {
                indexesOfPositiveValueBerries.add(i + 1);
                height += upValue - downValue;
                indexes.append(" ").append(i + 1);
            } else if (upValue == downValue) {
                indexesOfZeroValueBerries.add(i + 1);
            } else {
                indexesOfNegativeValueBerries.add(i + 1);
            }

            profitsOfBerries.add(upValue - downValue);
            upValues.add(upValue);

        }

        long maxHeight = height;

        for (int i = 0; i < n; i++) {
            if (indexesOfPositiveValueBerries.contains(i + 1)) {
                if (maxHeight <= height + upValues.get(i) - profitsOfBerries.get(i)) {
                    maxHeight = height + upValues.get(i) - profitsOfBerries.get(i);
                    indexOfEndProfitBerrie = i + 1;
                }
            } else {
                if (maxHeight < height + upValues.get(i)) {
                    maxHeight = height + upValues.get(i);
                    indexOfEndProfitBerrie = i + 1;
                }
            }
        }

        String indexesStr = indexes.toString().replace(" " + indexOfEndProfitBerrie, " ") + " " + indexOfEndProfitBerrie;

        if (indexesOfNegativeValueBerries.contains(indexOfEndProfitBerrie)) {
            indexesOfNegativeValueBerries.remove((Integer) indexOfEndProfitBerrie);
        } else if (indexesOfZeroValueBerries.contains(indexOfEndProfitBerrie)) {
            indexesOfZeroValueBerries.remove((Integer) indexOfEndProfitBerrie);
        }

        for (int i : indexesOfZeroValueBerries) {
            indexesStr += " " + i;
        }

        for (int i : indexesOfNegativeValueBerries) {
            indexesStr += " " + i;
        }

        System.out.println(maxHeight);
        System.out.println(indexesStr.trim());
    }
}